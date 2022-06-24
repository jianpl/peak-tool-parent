package ink.gfwl.captcha.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * aliyun sms config
 * @author jianpòlan
 * @version 1.0
 **/
@ConfigurationProperties(
        prefix = "peak.captcha.ali",
        ignoreInvalidFields = true
)
public class AliSmsProperties {

    /**
     * regionId
     */
    private String regionId;

    /**
     * accessKeyId
     */
    private String accessKeyId;

    /**
     * accessKeySecret
     */
    private String accessKeySecret;

    /**
     * signName
     */
    private String signName;

    /**
     * Gets the value of regionId
     *
     * @return the value of regionId
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * Sets the regionId
     * <p>You can use getRegionId() to get the value of regionId</p>
     *
     * @param regionId regionId
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     * Gets the value of accessKeyId
     *
     * @return the value of accessKeyId
     */
    public String getAccessKeyId() {
        return accessKeyId;
    }

    /**
     * Sets the accessKeyId
     * <p>You can use getAccessKeyId() to get the value of accessKeyId</p>
     *
     * @param accessKeyId accessKeyId
     */
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    /**
     * Gets the value of accessKeySecret
     *
     * @return the value of accessKeySecret
     */
    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    /**
     * Sets the accessKeySecret
     * <p>You can use getAccessKeySecret() to get the value of accessKeySecret</p>
     *
     * @param accessKeySecret accessKeySecret
     */
    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
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
