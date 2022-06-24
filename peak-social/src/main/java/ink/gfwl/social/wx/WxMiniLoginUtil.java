package ink.gfwl.social.wx;

import com.alibaba.fastjson.JSONObject;
import ink.gfwl.common.http.RestTemplateUtil;
import ink.gfwl.common.lang.ObjectUtils;
import ink.gfwl.social.properties.WxMiniProperties;
import ink.gfwl.social.base.LoginRequest;
import ink.gfwl.social.base.LoginResponse;
import ink.gfwl.social.exception.SocialException;
import ink.gfwl.social.wx.util.WXBizDataCrypt;
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

    /**
     * 解密获取手机号
     * @param encryptedData 包括敏感数据在内的完整用户信息的加密数据
     * @param iv 加密算法的初始向量
     * @param sessionKey 服务端获取
     * @param AppId 微信AppId
     * @return 手机号
     */
    public static String wxGetPhone(String encryptedData, String iv, String sessionKey, String AppId) {
        String result= decryptData(AppId, sessionKey, encryptedData,iv);
        try {
            JSONObject json = JSONObject.parseObject(result);
            if (ObjectUtils.isNotNull(json)) {
                return json.getJSONObject("userInfo").getString("purePhoneNumber");
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 获取微信AccessToken
     * <p>{
     * "access_token": "",
     * "expires_in":
     * }</p>
     * @return token
     */
    public JSONObject getToken(){
        //获取access_token
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential" + "&appid=" + wxMiniProperties.getWxAppId() + "&secret=" + wxMiniProperties.getWxAppSecret();
        String json = RestTemplateUtil.get(url, String.class);
        return JSONObject.parseObject(json);
    }

    private static String decryptData(String AppId, String sessionKey,String enkData, String iv){
        WXBizDataCrypt wxBizDataCrypt = new WXBizDataCrypt(AppId,sessionKey);
        return wxBizDataCrypt.decryptData(enkData, iv);
    }


}
