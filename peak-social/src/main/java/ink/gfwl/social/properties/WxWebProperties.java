package ink.gfwl.social.properties;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 网页微信扫码
 * @author jianpòlan
 * @version 1.0
 **/
@ConfigurationProperties(
        prefix = "peak.social.wx-web",
        ignoreInvalidFields = true
)
public class WxWebProperties {

    /**
     * wxWebAppId
     */
    private String wxWebAppId;

    /**
     * wxWebAppSecret
     */
    private String wxWebAppSecret;

    /**
     * Gets the value of wxWebAppId
     *
     * @return the value of wxWebAppId
     */
    public String getWxWebAppId() {
        return wxWebAppId;
    }

    /**
     * Sets the wxWebAppId
     * <p>You can use getWxWebAppId() to get the value of wxWebAppId</p>
     *
     * @param wxWebAppId wxWebAppId
     */
    public void setWxWebAppId(String wxWebAppId) {
        this.wxWebAppId = wxWebAppId;
    }

    /**
     * Gets the value of wxWebAppSecret
     *
     * @return the value of wxWebAppSecret
     */
    public String getWxWebAppSecret() {
        return wxWebAppSecret;
    }

    /**
     * Sets the wxWebAppSecret
     * <p>You can use getWxWebAppSecret() to get the value of wxWebAppSecret</p>
     *
     * @param wxWebAppSecret wxWebAppSecret
     */
    public void setWxWebAppSecret(String wxWebAppSecret) {
        this.wxWebAppSecret = wxWebAppSecret;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
