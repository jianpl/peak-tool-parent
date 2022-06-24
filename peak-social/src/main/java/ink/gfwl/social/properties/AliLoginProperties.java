package ink.gfwl.social.properties;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * App支付宝登录参数
 * @author jianpòlan
 * @version 1.0
 **/
@ConfigurationProperties(
        prefix = "peak.social.ali",
        ignoreInvalidFields = true
)
public class AliLoginProperties {

    /**
     * getWay
     */
    private String getWay;
    /**
     * appId
     */
    private String appId;
    /**
     * privateKey
     */
    private String privateKey;
    /**
     * publicKey
     */
    private String publicKey;

    /**
     * Gets the value of getWay
     *
     * @return the value of getWay
     */
    public String getGetWay() {
        return getWay;
    }

    /**
     * Sets the getWay
     * <p>You can use getGetWay() to get the value of getWay</p>
     *
     * @param getWay getWay
     */
    public void setGetWay(String getWay) {
        this.getWay = getWay;
    }

    /**
     * Gets the value of appId
     *
     * @return the value of appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Sets the appId
     * <p>You can use getAppId() to get the value of appId</p>
     *
     * @param appId appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * Gets the value of privateKey
     *
     * @return the value of privateKey
     */
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * Sets the privateKey
     * <p>You can use getPrivateKey() to get the value of privateKey</p>
     *
     * @param privateKey privateKey
     */
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * Gets the value of publicKey
     *
     * @return the value of publicKey
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * Sets the publicKey
     * <p>You can use getPublicKey() to get the value of publicKey</p>
     *
     * @param publicKey publicKey
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
