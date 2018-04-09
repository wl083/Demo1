package ui.net_request;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.l.example.demo1.R;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import base.BaseActivity;

/**
 * Created by wl
 * On 2018/4/4
 * Describe:
 * 使用流程：
 *         1、创建 RequestQueue（请求队列）；
 *         2、创建 一个 Request(可以为 Request 的子类，如：StringRequest、JsonObjectRequest、ImageRequest) 请求；
 *         3、将 Request 请求添加进 RequestQueue 中。
 *         Note：
 *         1、使用 Post 方式请求时(以 StringRequest 为例)，需要使用 getParams() 方法返回请求参数，如：
 *          new StringRequest(int method, String url, Listener<String> listener,ErrorListener errorListener){
 *               @Override
 *               protected Map<String, String> getParams() throws AuthFailureError {
 *                   // the POST parameters:
 *                   return super.getParams();
 *               }
 *            此外，注意同中用法的 getPostBody() 等方法，类似用法的还有 Handler 的 handleMessage() 方法；
 *         2、一个完整的请求最好包括取消 请求，即：RequestQueue.cancelAll(Params);
 *
 *
 *
 *
 */

public class VolleyActivity extends BaseActivity {

    private final String TAG = "stone";
    private RequestQueue requestQueue;

    private TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        requestQueue = Volley.newRequestQueue(this);

        tvResult = ((TextView) findViewById(R.id.tv_volley_result));
    }

    public void stone(View view) {
        switch (view.getId()) {
            case R.id.btn_volley_string:
                StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://gank.io/api/data/Android/10/1", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String result = response;
                        tvResult.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvResult.setText(error.toString());
                    }
                });
                requestQueue.add(stringRequest);
                break;
            case R.id.btn_volley_string_post:
                StringRequest stringRequestPost = new StringRequest(Request.Method.POST, "http://httpbin.org/post", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tvResult.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvResult.setText(error.toString());
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String>  params = new HashMap<>();
                        // the POST parameters:
                        params.put("site", "code");
                        params.put("network", "tutsplus");
                        return params;
                    }
                };
                requestQueue.add(stringRequestPost);
                break;
            case R.id.btn_volley_json:
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET
                        , "http://gank.io/api/data/Android/10/1", null
                        , new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        tvResult.setText(response.toString());
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvResult.setText(error.toString());
                    }
                });

                requestQueue.add(jsonObjectRequest);
                break;
            case R.id.btn_volley_custom:

                break;

        }

    }
}
