package ink.gfwl.oss.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 阿里云OSS配置
 * @author jianpòlan
 * @version 1.0
 **/
@ConfigurationProperties(
        prefix = "peak.oss.ali",
        ignoreInvalidFields = true
)
public class AliYunOssProperties {

    /**
     * endPoint
     */
    private String endPoint;
    /**
     * accessKeyId
     */
    private String accessKeyId;
    /**
     * accessKeySecret
     */
    private String accessKeySecret;

    /**
     * Gets the value of endPoint
     *
     * @return the value of endPoint
     */
    public String getEndPoint() {
        return endPoint;
    }

    /**
     * Sets the endPoint
     * <p>You can use getEndPoint() to get the value of endPoint</p>
     *
     * @param endPoint endPoint
     */
    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
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
}
