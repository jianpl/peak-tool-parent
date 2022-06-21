package ink.gfwl.social.wx;

import com.alibaba.fastjson.JSONObject;
import ink.gfwl.common.http.RestTemplateUtil;
import ink.gfwl.common.properties.social.WxMiniProperties;
import ink.gfwl.social.base.LoginRequest;
import ink.gfwl.social.base.LoginResponse;
import ink.gfwl.social.exception.SocialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信小程序登录
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class WxMiniLoginUtil {

    @Autowired(required = false)
    private WxMiniProperties wxMiniProperties;
    /**
     * 微信小程序登录
     * @param request 登录参数 {@link LoginRequest}
     * @return 登录结果 {@link LoginResponse}
     */
    public LoginResponse login(LoginRequest request) {
        try {
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+wxMiniProperties.getWxAppId()+"&secret="+wxMiniProperties.getWxAppSecret()+"&js_code="+request.getLoginCode()+"&grant_type=authorization_code";
            String object = RestTemplateUtil.get(url, String.class);
            if(object == null){
                throw new SocialException(-1, "error");
            }
            JSONObject jsonObject = JSONObject.parseObject(object);
            String accessToken = jsonObject.getString("access_token");
            LoginResponse loginResponse = new LoginResponse(jsonObject.getString("openid"), jsonObject.containsKey("unionid") ? jsonObject.getString("unionid") : null, jsonObject.toJSONString());
            loginResponse.setToken(accessToken);
            return loginResponse;
        }catch (Exception e){
            throw new SocialException(-1, e.getMessage());
        }
    }
}
