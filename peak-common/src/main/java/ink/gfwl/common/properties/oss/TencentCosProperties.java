package ink.gfwl.common.properties.oss;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 腾讯云COS配置
 * @author jianpòlan
 * @version 1.0
 **/
@ConfigurationProperties(
        prefix = "peak.oss.tencent",
        ignoreInvalidFields = true
)
public class TencentCosProperties {

    /**
     * accessKey
     */
    private String accessKey;
    /**
     * secretKey
     */
    private String secretKey;
    /**
     * bucketName
     */
    private String bucketName;
    /**
     * appId
     */
    private String appId;
    /**
     * regionId
     */
    private String regionId;
    /**
     * tempFilePath
     */
    private String tempFilePath;

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

    /**
     * Gets the value of bucketName
     *
     * @return the value of bucketName
     */
    public String getBucketName() {
        return bucketName;
    }

    /**
     * Sets the bucketName
     * <p>You can use getBucketName() to get the value of bucketName</p>
     *
     * @param bucketName bucketName
     */
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
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
     * Gets the value of tempFilePath
     *
     * @return the value of tempFilePath
     */
    public String getTempFilePath() {
        return tempFilePath;
    }

    /**
     * Sets the tempFilePath
     * <p>You can use getTempFilePath() to get the value of tempFilePath</p>
     *
     * @param tempFilePath tempFilePath
     */
    public void setTempFilePath(String tempFilePath) {
        this.tempFilePath = tempFilePath;
    }
}
