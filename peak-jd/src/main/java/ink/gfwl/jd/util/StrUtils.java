package ink.gfwl.jd.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * 参数组装工具
 * @author jianpòlan
 * @version 1.0
 **/
public final class StrUtils {

    public static synchronized String enumArrConvertStr(List<? extends Enum> exts){
        if(exts == null || exts.size() == 0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < exts.size(); i++) {
            if(i != 0){
                result.append(",");
            }
            result.append(exts.get(i).name());
        }
        return result.toString();
    }

    public static synchronized Map<String, Object> entityToMap(Object entity){
        return JSONObject.toJavaObject(JSON.parseObject(JSONObject.toJSONString(entity)), Map.class);
    }
}
