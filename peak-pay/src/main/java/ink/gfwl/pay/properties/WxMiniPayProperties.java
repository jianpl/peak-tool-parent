package ink.gfwl.pay.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * WX
 * @author jianpòlan
 * @version 1.0
 **/
@ConfigurationProperties(
        prefix = "peak.pay.wx-mini",
        ignoreInvalidFields = true
)
public class WxMiniPayProperties {

    /**
     * 微信APPID
     */
    private String appId;
    /**
     * 微信APIKEY
     */
    private String apiKey;
    /**
     * 微信支付地址
     */
    private String payUrl;
    /**
     * 微信支付商户ID
     */
    private String mchId;

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
     * Gets the value of apiKey
     *
     * @return the value of apiKey
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the apiKey
     * <p>You can use getApiKey() to get the value of apiKey</p>
     *
     * @param apiKey apiKey
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Gets the value of payUrl
     *
     * @return the value of payUrl
     */
    public String getPayUrl() {
        return payUrl;
    }

    /**
     * Sets the payUrl
     * <p>You can use getPayUrl() to get the value of payUrl</p>
     *
     * @param payUrl payUrl
     */
    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    /**
     * Gets the value of mchId
     *
     * @return the value of mchId
     */
    public String getMchId() {
        return mchId;
    }

    /**
     * Sets the mchId
     * <p>You can use getMchId() to get the value of mchId</p>
     *
     * @param mchId mchId
     */
    public void setMchId(String mchId) {
        this.mchId = mchId;
    }
}
