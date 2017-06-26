package utils;

import com.alibaba.fastjson.JSON;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * 封装Json解析，主要使用FastJson
 * Created by wl on 2017/6/23.
 */

public class JsonUtils {

    /**
     * @param array
     * @param w
     * @param <W>
     * @return  获取list<W>
     */
    public static <W> List<W> getListBeansFromJson(JSONArray array, Class<W> w){
        try{
            if (array != null){
                List<W> listBean = JSON.parseArray(array.toString(), w);
                return  listBean;
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return  null;
    }

    /**
     *
     * @param strJson
     * @param w
     * @param <W>
     * @return
     */
    public static <W> List<W> getListBeansFromJson(String strJson,Class<W> w){
        try{
            if (!strIsEmpty("strJson")){
                List<W> listBeans = JSON.parseArray(strJson,w);
                return  listBeans;
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }

    /**
     *
     * @param strJson
     * @param w
     * @param <W>
     * @return
     */
    public static <W> W getBeanFromJson(String strJson,Class<W> w){
        try{
            if (!strIsEmpty(strJson)){
                W bean = JSON.parseObject(strJson.trim(),w);
                return bean;
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
    public static <W> W getBeanFromJson(JSONObject object,Class<W> w){
        try{
            if (object != null && !strIsEmpty(object.toString().trim())){
                W bean = JSON.parseObject(object.toString(),w);
                return  bean;
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }

    /**
     * @param str
     * @return 返回 string 是否有值
     */
    private static boolean strIsEmpty(String str){
        if (str == null || str.isEmpty()){
            return true;
        }
        return  false;
    }
}
