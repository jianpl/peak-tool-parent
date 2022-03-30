package ink.gfwl.social.wx;

import com.alibaba.fastjson.JSONObject;
import ink.gfwl.social.exception.SocialException;
import ink.gfwl.social.base.LoginRequest;
import ink.gfwl.social.base.LoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 微信APP登录
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class WxAppLoginUtil {

    @Value("${peak.social.wx.wxAppId}")
    private String wxAppId;
    @Value("${peak.social.wx.wxAppSecret}")
    private String wxAppSecret;

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * 登录
     * @param request 登录参数 {@link LoginRequest}
     * @return 登录结果 {@link LoginResponse}
     */
    public LoginResponse login(LoginRequest request) {
        try {
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+wxAppId+"&secret="+wxAppSecret+"&js_code="+request.getLoginCode()+"&grant_type=authorization_code";
            String object = restTemplate.getForObject(url, String.class);
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
