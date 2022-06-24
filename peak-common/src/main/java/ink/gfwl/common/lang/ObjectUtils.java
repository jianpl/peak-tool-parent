package ink.gfwl.common.lang;

import java.util.Collection;
import java.util.Map;

/**
 * Object工具类
 * @author jianpòlan
 * @version 1.0
 **/
public class ObjectUtils {

    /**
     * 是否非空
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
     * @param object string、List
     * @return 空为true
     */
    public static boolean isNull(Object object){
        return !isNotNull(object);
    }

    public static int length(CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }

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
