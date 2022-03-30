package ink.gfwl.social.wx;

import com.alibaba.fastjson.JSONObject;
import ink.gfwl.social.exception.SocialException;
import ink.gfwl.social.base.LoginRequest;
import ink.gfwl.social.base.LoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 微信网页扫码登录
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class WxWebScanLoginUtil {

    @Value("${peak.social.wxWeb.wxWebAppId}")
    private String wxWebAppId;
    @Value("${peak.social.wxWeb.wxWebAppSecret}")
    private String wxWebAppSecret;

    private final RestTemplate restTemplate = new RestTemplate();

    private final String REQ_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+wxWebAppId+"&secret="+wxWebAppSecret+"&code=%s&grant_type=authorization_code";

    private final String REF_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+wxWebAppId+"&grant_type=authorization_code&refresh_token=%s";

    /**
     * <p>微信扫码登录<br>
     * 文档地址: <a href="https://developers.weixin.qq.com/doc/oplatform/Website_App/WeChat_Login/Wechat_Login.html">文档地址</a>
     * </p>
     * @param request 登录参数 {@link LoginRequest}
     * @return 登录结果 {@link LoginResponse}
     */
    public LoginResponse login(LoginRequest request){
        String reqUrl = String.format(REQ_TOKEN_URL, request.getLoginCode());
        try {
            String object = restTemplate.getForObject(reqUrl, String.class);
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

    /**
     * 刷新
     * @param refreshToken 登录返回的refreshToken
     * @return 返回值，例：
     * {@code
    {
    "access_token":"ACCESS_TOKEN",
    "expires_in":7200,
    "refresh_token":"REFRESH_TOKEN","openid":"OPENID",
    "scope":"SCOPE"
    }
     * }
     */
    public JSONObject refreshToken(String refreshToken){
        String reqUrl = String.format(REF_TOKEN_URL, refreshToken);
        String object = restTemplate.getForObject(reqUrl, String.class);
        if(object == null){
            throw new SocialException(-1, "error");
        }
        return JSONObject.parseObject(object);
    }

    /**
     * 获取用户信息
     * @param accessToken token
     * @param openId openid
     * @return 用户信息
     */
    public String getUserInfo(String accessToken, String openId){
        String REQ_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s";
        return restTemplate.getForObject(String.format(REQ_USER_INFO, accessToken, openId), String.class);
    }
}
