package ink.gfwl.social.properties;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * APP微信登录参数
 * @author jianpòlan
 * @version 1.0
 **/
@ConfigurationProperties(
        prefix = "peak.social.wx",
        ignoreInvalidFields = true
)
public class WxAppProperties {

    /**
     * wxAppId
     */
    private String wxAppId;

    /**
     * wxAppSecret
     */
    private String wxAppSecret;

    /**
     * Gets the value of wxAppId
     *
     * @return the value of wxAppId
     */
    public String getWxAppId() {
        return wxAppId;
    }

    /**
     * Sets the wxAppId
     * <p>You can use getWxAppId() to get the value of wxAppId</p>
     *
     * @param wxAppId wxAppId
     */
    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    /**
     * Gets the value of wxAppSecret
     *
     * @return the value of wxAppSecret
     */
    public String getWxAppSecret() {
        return wxAppSecret;
    }

    /**
     * Sets the wxAppSecret
     * <p>You can use getWxAppSecret() to get the value of wxAppSecret</p>
     *
     * @param wxAppSecret wxAppSecret
     */
    public void setWxAppSecret(String wxAppSecret) {
        this.wxAppSecret = wxAppSecret;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
