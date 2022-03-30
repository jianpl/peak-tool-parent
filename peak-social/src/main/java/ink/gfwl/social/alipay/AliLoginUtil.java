package ink.gfwl.social.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import ink.gfwl.social.exception.SocialException;
import ink.gfwl.social.base.LoginRequest;
import ink.gfwl.social.base.LoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 支付宝登录
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 */
@Component
public class AliLoginUtil {

    @Value("${peak.social.ali.getWay}")
    private String getWay;
    @Value("${peak.social.ali.appId}")
    private String appId;
    @Value("${peak.social.ali.privateKey}")
    private String privateKey;
    @Value("${peak.social.ali.publicKey}")
    private String publicKey;

    /**
     * 支付宝登录
     * @param request 登录参数 {@link LoginRequest}
     * @return 登录结果 {@link LoginResponse}
     */
    public LoginResponse login(LoginRequest request) {
        try {
            AlipayUserInfoShareResponse response = loginByCode(request.getLoginCode());
            return new LoginResponse(response.getUserId(), JSONObject.toJSONString(response));
        }catch (Exception e){
            throw new SocialException(-1, e.getMessage());
        }
    }

    private AlipayUserInfoShareResponse loginByCode(String authCode) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(getWay,appId,privateKey,"json","UTF-8",publicKey,"RSA2");
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setCode(authCode);
        request.setGrantType("authorization_code");
        //code 换取token
        AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request);
        String accessToken = oauthTokenResponse.getAccessToken();
        //根据token获取用户头像、昵称等信息
        return alipayClient.execute(new AlipayUserInfoShareRequest(), accessToken);
    }

}
