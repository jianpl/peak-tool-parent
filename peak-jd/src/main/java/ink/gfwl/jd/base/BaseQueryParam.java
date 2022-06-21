package ink.gfwl.jd.base;

import ink.gfwl.jd.util.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 公共请求参数
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class BaseQueryParam {

    @Resource
    private TokenUtils tokenUtils;

    public Map<String, Object> getBaseQueryParam(){
        Map<String, Object> params = new HashMap<>();
        params.put("token", tokenUtils.getTokenStr());
        return params;
    }

}
