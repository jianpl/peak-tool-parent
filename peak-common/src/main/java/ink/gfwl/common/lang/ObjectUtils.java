package ink.gfwl.common.lang;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 * Object工具类
 *
 * @author jianpòlan
 * @version 1.0
 */
public class ObjectUtils {

    /**
     * 是否非空
     *
     * @param object string、List
     * @return 非空为true
     */
    public static boolean isNotNull(Object object){
        boolean result = true;
        if(object != null){
            if(object instanceof Collection && ((Collection<?>)object).isEmpty()){
                result = false;
            }
            if(object instanceof Object[] && ((Object[])object).length <= 0){
                result = false;
            }
            if(object instanceof String && object.toString().isEmpty()){
                result = false;
            }
        }else{
            result = false;
        }
        return result;
    }

    /**
     * 是否非空
     *
     * @param object string、List
     * @return 空为true
     */
    public static boolean isNull(Object object){
        return !isNotNull(object);
    }

    /**
     * <p>length.</p>
     *
     * @param cs a {@link java.lang.CharSequence} object.
     * @return a int.
     */
    public static int length(CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }

    /**
     * <p>equals.</p>
     *
     * @param cs1 a {@link java.lang.CharSequence} object.
     * @param cs2 a {@link java.lang.CharSequence} object.
     * @return a boolean.
     */
    public static boolean equals(CharSequence cs1, CharSequence cs2) {
        if (cs1 == cs2) {
            return true;
        } else if (cs1 != null && cs2 != null) {
            if (cs1.length() != cs2.length()) {
                return false;
            } else if (cs1 instanceof String && cs2 instanceof String) {
                return cs1.equals(cs2);
            } else {
                int length = cs1.length();

                for(int i = 0; i < length; ++i) {
                    if (cs1.charAt(i) != cs2.charAt(i)) {
                        return false;
                    }
                }

                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * 是否相同
     * @param o1 对象1
     * @param o2 对象2
     * @return true想通
     */
    public static boolean equals(Object o1, Object o2){
        if (o1 == o2) {
            return true;
        } else if (o1 != null && o2 != null) {
            if (o1.equals(o2)) {
                return true;
            } else {
                return o1.getClass().isArray() && o2.getClass().isArray() && arrayEquals(o1, o2);
            }
        } else {
            return false;
        }
    }

    /**
     * 数组比较
     * @param o1 arr1
     * @param o2 arr2
     * @return 结果
     */
    private static boolean arrayEquals(Object o1, Object o2) {
        if (o1 instanceof Object[] && o2 instanceof Object[]) {
            return Arrays.equals((Object[]) o1, (Object[])o2);
        } else if (o1 instanceof boolean[] && o2 instanceof boolean[]) {
            return Arrays.equals((boolean[]) o1, (boolean[])o2);
        } else if (o1 instanceof byte[] && o2 instanceof byte[]) {
            return Arrays.equals((byte[]) o1, (byte[])o2);
        } else if (o1 instanceof char[] && o2 instanceof char[]) {
            return Arrays.equals((char[]) o1, (char[]) o2);
        } else if (o1 instanceof double[] && o2 instanceof double[]) {
            return Arrays.equals((double[]) o1, (double[]) o2);
        } else if (o1 instanceof float[] && o2 instanceof float[]) {
            return Arrays.equals((float[]) o1, (float[])o2);
        } else if (o1 instanceof int[] && o2 instanceof int[]) {
            return Arrays.equals((int[]) o1, (int[]) o2);
        } else if (o1 instanceof long[] && o2 instanceof long[]) {
            return Arrays.equals((long[]) o1, (long[])o2);
        } else {
            return o1 instanceof short[] && o2 instanceof short[] && Arrays.equals((short[]) o1, (short[]) o2);
        }
    }

    /**
     * <p>mapToXML.</p>
     * @param param a {@link java.util.Map} object.
     * @return a {@link java.lang.String} object.
     */
    public static String mapToXML(Map<String, String> param) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        param.forEach((k,v)->{
            sb.append("<").append(k).append(">");
            sb.append(v);
            sb.append("</").append(k).append(">");
        });
        sb.append("</xml>");
        return sb.toString();
    }
}
