package ink.gfwl.pay.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
@ConfigurationProperties(
        prefix = "peak.pay.ali",
        ignoreInvalidFields = true
)
public class AliPayProperties implements Serializable {

    private static final long serialVersionUID = -391609486516311453L;
    /**
     * 支付宝APPID
     */
    private String appId;

    /**
     * 支付宝公钥
     */
    private String pubicKey;

    /**
     * 支付宝私钥
     */
    private String privateKey;

    /**
     * 支付宝网关
     */
    private String getWay;

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
     * Gets the value of pubicKey
     *
     * @return the value of pubicKey
     */
    public String getPubicKey() {
        return pubicKey;
    }

    /**
     * Sets the pubicKey
     * <p>You can use getPubicKey() to get the value of pubicKey</p>
     *
     * @param pubicKey pubicKey
     */
    public void setPubicKey(String pubicKey) {
        this.pubicKey = pubicKey;
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
}
