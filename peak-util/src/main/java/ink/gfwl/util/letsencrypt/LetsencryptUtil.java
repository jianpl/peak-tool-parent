package ink.gfwl.util.letsencrypt;

import com.alibaba.fastjson.JSONObject;
import ink.gfwl.common.http.RestTemplateUtil;
import ink.gfwl.util.letsencrypt.base.ConstsProperty;
import org.springframework.stereotype.Component;

/**
 * 来此加密证书操作
 * @author jianpòlan
 * @version 1.0
 **/
@Component
public class LetsencryptUtil extends ConstsProperty {

    /**
     * 证书列表
     * @return 证书列表
     */
    public JSONObject certList(){
        JSONObject jsonObject = null;
        do {
            String result = RestTemplateUtil.get(CERT_LIST, getAuthHeader(), String.class);
            if(result == null){
                break;
            }
            jsonObject = JSONObject.parseObject(result);
            if(jsonObject.getInteger("c") != 20){
                break;
            }
            jsonObject = jsonObject.getJSONObject("v");
        }while (false);
        return jsonObject;
    }

}
