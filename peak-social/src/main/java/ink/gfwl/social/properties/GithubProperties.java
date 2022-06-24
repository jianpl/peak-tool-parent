package ink.gfwl.social.properties;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * github登录参数
 * @author jianpòlan
 * @version 1.0
 **/
@ConfigurationProperties(
        prefix = "peak.social.github",
        ignoreInvalidFields = true
)
public class GithubProperties {

    /**
     * clientId
     */
    private String clientId;
    /**
     * clientSecret
     */
    private String clientSecret;
    /**
     * callback
     */
    private String callback;

    /**
     * Gets the value of clientId
     *
     * @return the value of clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Sets the clientId
     * <p>You can use getClientId() to get the value of clientId</p>
     *
     * @param clientId clientId
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * Gets the value of clientSecret
     *
     * @return the value of clientSecret
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * Sets the clientSecret
     * <p>You can use getClientSecret() to get the value of clientSecret</p>
     *
     * @param clientSecret clientSecret
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * Gets the value of callback
     *
     * @return the value of callback
     */
    public String getCallback() {
        return callback;
    }

    /**
     * Sets the callback
     * <p>You can use getCallback() to get the value of callback</p>
     *
     * @param callback callback
     */
    public void setCallback(String callback) {
        this.callback = callback;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
