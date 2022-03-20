package ink.gfwl.common.properties.sms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * tencent cloud sms config
 * @author jianpòlan
 * @version 1.0
 **/
@Component
public class TencentSmsProperties {

    /**
     * secretId
     */
    @Value("${peak.sms.tencent.secretId}")
    private String secretId;
    /**
     * secretKey
     */
    @Value("${peak.sms.tencent.secretKey}")
    private String secretKey;
    /**
     * sdkAppId
     */
    @Value("${peak.sms.tencent.sdkAppId}")
    private String sdkAppId;
    /**
     * signName
     */
    @Value("${peak.sms.tencent.signName}")
    private String signName;

    /**
     * Gets the value of secretId
     *
     * @return the value of secretId
     */
    public String getSecretId() {
        return secretId;
    }

    /**
     * Sets the secretId
     * <p>You can use getSecretId() to get the value of secretId</p>
     *
     * @param secretId secretId
     */
    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    /**
     * Gets the value of secretKey
     *
     * @return the value of secretKey
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * Sets the secretKey
     * <p>You can use getSecretKey() to get the value of secretKey</p>
     *
     * @param secretKey secretKey
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * Gets the value of sdkAppId
     *
     * @return the value of sdkAppId
     */
    public String getSdkAppId() {
        return sdkAppId;
    }

    /**
     * Sets the sdkAppId
     * <p>You can use getSdkAppId() to get the value of sdkAppId</p>
     *
     * @param sdkAppId sdkAppId
     */
    public void setSdkAppId(String sdkAppId) {
        this.sdkAppId = sdkAppId;
    }

    /**
     * Gets the value of signName
     *
     * @return the value of signName
     */
    public String getSignName() {
        return signName;
    }

    /**
     * Sets the signName
     * <p>You can use getSignName() to get the value of signName</p>
     *
     * @param signName signName
     */
    public void setSignName(String signName) {
        this.signName = signName;
    }
}
