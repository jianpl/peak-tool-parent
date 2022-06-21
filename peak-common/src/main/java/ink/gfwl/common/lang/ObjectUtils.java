package ink.gfwl.common.lang;

import java.util.ArrayList;
import java.util.Collection;

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

    public static void main(String[] args) {
        System.out.println(isNull(new ArrayList<>()));
    }

}
