package ui.net_request;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

/**
 * Created by wl
 * On 2018/4/4
 * Describe:
 */

public class CustomVolleyRequest<T> extends Request<T>{
//    public CustomVolleyRequest(String url, Response.ErrorListener listener) {
//        super(url, listener);
//    }

    public CustomVolleyRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    @Override
    protected void deliverResponse(T response) {

    }
}
