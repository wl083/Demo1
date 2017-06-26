package utils;

import java.util.List;

/**
 * 通用 Utils
 * Created by wl on 2017/6/26.
 */

public class CommonUtils {

    /**
     * adjust string:
     * if string is null,or string's length is 0,return false,
     * @param strMsg
     * @return
     */
    public static boolean stringIsUnEmpty(String strMsg){
        if (strMsg == null || strMsg.isEmpty())
            return false;
        return true;
    }

    /**
     * 判断 list 是否有值
     * @param list
     * @param <W>
     * @return
     */
    public static <W> boolean listIsUnEmpty(List<W> list){

        return  list == null ? false : !list.isEmpty();
    }

    /**
     * 返回 list 的 size
     * @param list
     * @param <W>
     * @return
     */
    public static <W> int getListSize(List<W> list){
        return list == null ? 0 : list.size();
    }


}
