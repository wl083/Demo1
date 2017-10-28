package utils;

import java.util.List;

/**
 * 通用 Utils
 * Created by wl on 2017/6/26.
 */

public class CommonUtils {


    private static long lastClickTime;
//    /**
//     * 有些方法中会添加此方法，功能未知
//     */
//    private CommonUtils() {
//        throw new UnsupportedOperationException("u can't instantiate me...");
//    }

    /**
     * adjust string:
     * if string is null,or string's length is 0,return true,
     * @param strMsg
     * @return
     */
    public static boolean stringIsEmpty(CharSequence strMsg){
        if (strMsg == null || strMsg.length() == 0)
            return true;
        return false;
    }
    public static boolean stringTrimIsEmpty(String strMsg){
        if (strMsg == null || strMsg.trim().length() == 0)
            return true;
        return false;
    }
    /**
     * 判断两字符串是否相等
     *
     * @param a 待校验字符串a
     * @param b 待校验字符串b
     * @return {@code true}: 相等<br>{@code false}: 不相等
     */
    public static boolean stringIsEquals(CharSequence a, CharSequence b) {
        if (a == b) return true;
        int length;
        if (a != null && b != null && (length = a.length()) == b.length()) {
            if (a instanceof String && b instanceof String) {
                return a.equals(b);
            } else {
                for (int i = 0; i < length; i++) {
                    if (a.charAt(i) != b.charAt(i)) return false;
                }
                return true;
            }
        }
        return false;
    }



    /**
     * 判断 list 是否有值
     * @param list
     * @param <W>
     * @return
     */
    public static <W> boolean listIsEmpty(List<W> list){
        return  list == null ? true : list.isEmpty();
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

    /**
     * 判断是否为连击          * 如果是返回 true
     *
     * @return boolean
     */
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

}
