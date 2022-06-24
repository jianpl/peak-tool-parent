package ink.gfwl.social.wx;

import com.alibaba.fastjson.JSONObject;
import ink.gfwl.common.http.RestTemplateUtil;
import ink.gfwl.common.lang.Affirm;
import ink.gfwl.social.properties.WxWebProperties;
import ink.gfwl.social.base.LoginRequest;
import ink.gfwl.social.base.LoginResponse;
import ink.gfwl.social.exception.SocialException;
import ink.gfwl.social.wx.model.LangEnum;
import ink.gfwl.social.wx.model.WxUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * 微信网页扫码登录
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class WxWebScanLoginUtil {

    @Autowired(required = false)
    private WxWebProperties webProperties;

    /**
     * <p>微信扫码登录<br>
     * 文档地址: <a href="https://developers.weixin.qq.com/doc/oplatform/Website_App/WeChat_Login/Wechat_Login.html">文档地址</a>
     * </p>
     * @param request 登录参数 {@link LoginRequest}
     * @return 登录结果 {@link LoginResponse}
     */
    public LoginResponse login(LoginRequest request){
        String REQ_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+webProperties.getWxWebAppId()+"&secret="+webProperties.getWxWebAppSecret()+"&code=%s&grant_type=authorization_code";
        String reqUrl = String.format(REQ_TOKEN_URL, request.getLoginCode());
        try {
            String object = RestTemplateUtil.get(reqUrl, String.class);
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
        String REF_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+webProperties.getWxWebAppId()+"&grant_type=authorization_code&refresh_token=%s";
        String reqUrl = String.format(REF_TOKEN_URL, refreshToken);
        String object = RestTemplateUtil.get(reqUrl, String.class);
        if(object == null){
            throw new SocialException(-1, "error");
        }
        return JSONObject.parseObject(object);
    }

    /**
     * 获取用户信息
     * @param accessToken token
     * @param openId openid
     * @param lang 国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为en
     * @return 用户信息
     */
    public WxUserInfo getUserInfo(String accessToken, String openId, LangEnum lang){
        String REQ_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=%s";
        String result = RestTemplateUtil.get(String.format(REQ_USER_INFO, accessToken, openId, lang.getValue()), String.class);
        result = new String(result.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Affirm.isNull(result, ()->new SocialException(-2, "get userinfo error"));
        return JSONObject.parseObject(result, WxUserInfo.class);
    }

    /**
     * 获取用户信息(国家地区语言版本默认为en)
     * @param accessToken token
     * @param openId openid
     * @return 用户信息
     */
    public WxUserInfo getUserInfo(String accessToken, String openId){
        return getUserInfo(accessToken, openId, LangEnum.EN);
    }
}
