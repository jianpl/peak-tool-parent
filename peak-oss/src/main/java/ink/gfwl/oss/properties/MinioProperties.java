package ink.gfwl.oss.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Minio配置
 * @author jianpòlan
 * @version 1.0.3
 **/
@ConfigurationProperties(
        prefix = "peak.oss.minio",
        ignoreInvalidFields = true
)
public class MinioProperties {

    /**
     * endpoint
     */
    private String endpoint;

    /**
     * 用户名
     */
    private String accessKey;

    /**
     * 密码
     */
    private String secretKey;

    /**
     * Gets the value of endpoint
     *
     * @return the value of endpoint
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Sets the endpoint
     * <p>You can use getEndpoint() to get the value of endpoint</p>
     *
     * @param endpoint endpoint
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Gets the value of accessKey
     *
     * @return the value of accessKey
     */
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * Sets the accessKey
     * <p>You can use getAccessKey() to get the value of accessKey</p>
     *
     * @param accessKey accessKey
     */
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
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
}
