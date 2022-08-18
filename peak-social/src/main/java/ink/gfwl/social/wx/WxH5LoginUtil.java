package ink.gfwl.social.wx;

import com.alibaba.fastjson.JSONObject;
import ink.gfwl.common.http.RestTemplateUtil;
import ink.gfwl.common.lang.Affirm;
import ink.gfwl.social.base.LoginRequest;
import ink.gfwl.social.base.LoginResponse;
import ink.gfwl.social.exception.SocialException;
import ink.gfwl.social.properties.WxH5Properties;
import ink.gfwl.social.wx.model.LangEnum;
import ink.gfwl.social.wx.model.WxUserInfo;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 公众号H5微信登录
 * @author jianpòlan
 * @version 1.0
 * <p>
 *     url：<a href="https://developers.weixin.qq.com/doc/oplatform/Website_App/WeChat_Login/Wechat_Login.html">官方文档</a>
 * </p>
 **/
@Component
public class WxH5LoginUtil {

    private final WxH5Properties wxH5Properties;

    public WxH5LoginUtil(WxH5Properties wxH5Properties) {
        this.wxH5Properties = wxH5Properties;
    }

    /**
     * 登录
     * @param request 登录参数
     * @return 登录结果 {@link LoginResponse}
     */
    public LoginResponse login(LoginRequest request){
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
        String object = RestTemplateUtil.get(String.format(url, wxH5Properties.getWxAppId(), wxH5Properties.getWxAppSecret(), request.getLoginCode()), String.class);
        Affirm.isNull(object, ()->new SocialException(-1, "error"));
        JSONObject jsonObject = JSONObject.parseObject(object);
        String accessToken = jsonObject.getString("access_token");
        LoginResponse loginResponse = new LoginResponse(jsonObject.getString("openid"),
                jsonObject.containsKey("unionid") ? jsonObject.getString("unionid") : null,
                jsonObject.toJSONString());
        loginResponse.setToken(accessToken);
        return loginResponse;
    }

    /**
     * 网页登录地址
     * @return 网页跳转登录地址
     */
    public String getLoginUrl() {
        try {
            String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
            return String.format(url, wxH5Properties.getWxAppId(), URLEncoder.encode(wxH5Properties.getCallback(), StandardCharsets.UTF_8.name()));
        }catch (UnsupportedEncodingException e){
            return null;
        }
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
