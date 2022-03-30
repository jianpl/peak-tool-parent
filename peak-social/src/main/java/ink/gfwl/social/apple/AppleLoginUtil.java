package ink.gfwl.social.apple;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.internal.util.codec.Base64;
import ink.gfwl.social.exception.SocialException;
import ink.gfwl.social.base.LoginRequest;
import ink.gfwl.social.base.LoginResponse;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * 苹果登录
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class AppleLoginUtil {

    /**
     * 苹果登录
     * @param request 登录参数 {@link LoginRequest}
     * @return 登录结果 {@link LoginResponse}
     */
    public LoginResponse login(LoginRequest request) {
        try {
            JSONObject jsonObject = parserIdentityToken(request.getLoginCode());
            return new LoginResponse(jsonObject.getString("sub"), jsonObject.toJSONString());
        }catch (Exception e){
            throw new SocialException(-1, e.getMessage());
        }
    }

    /**
     * 对前端传来的JWT字符串identityToken的第二部分进行解码
     * 主要获取其中的aud和sub，aud大概对应ios前端的包名，sub大概对应当前用户的授权的openID
     * @return  {"aud":"com.xkj.****","sub":"000***.8da764d3f9e34d2183e8da08a1057***.0***","c_hash":"UsKAuEoI-****","email_verified":"true","auth_time":1574673481,"iss":"https://appleid.apple.com","exp":1574674081,"iat":1574673481,"email":"****@qq.com"}
     */
    public JSONObject parserIdentityToken(String identityToken){
        String[] arr = identityToken.split("\\.");
        String decode = new String (Base64.decodeBase64(getBytesUtf8(arr[1])));
        String substring = decode.substring(0, decode.indexOf("}")+1);
        return JSONObject.parseObject(substring);
    }

    private byte[] getBytesUtf8(String string) {
        return string == null ? null : string.getBytes(StandardCharsets.UTF_8);
    }

}
