package ink.gfwl.jd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 京东配置
 * @author jianpòlan
 * @version 1.0
 **/

@ConfigurationProperties(
        prefix = "peak.jd",
        ignoreInvalidFields = true
)
public class JdConfig {

    /**
     * clientId
     */
    private String clientId;

    /**
     * clientSecret
     */
    private String clientSecret;

    /**
     * username
     */
    private String username;

    /**
     * password
     */
    private String password;

    /**
     * 最大商品同步数量,每个栏目下同步数量
     * <p>maxProductNum > 0 同步指定数量</p>
     * <p>maxProductNum <= 0 同步全部</p>
     */
    private Integer maxProductNum = -1;

    /**
     * 商品图片前缀
     */
    private String imagePrefix;

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
     * Gets the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     * <p>You can use getUsername() to get the value of username</p>
     *
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     * <p>You can use getPassword() to get the value of password</p>
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the value of maxProductNum
     *
     * @return the value of maxProductNum
     */
    public Integer getMaxProductNum() {
        return maxProductNum;
    }

    /**
     * Sets the maxProductNum
     * <p>You can use getMaxProductNum() to get the value of maxProductNum</p>
     *
     * @param maxProductNum maxProductNum
     */
    public void setMaxProductNum(Integer maxProductNum) {
        this.maxProductNum = maxProductNum;
    }

    /**
     * Gets the value of imagePrefix
     *
     * @return the value of imagePrefix
     */
    public String getImagePrefix() {
        return imagePrefix;
    }

    /**
     * Sets the imagePrefix
     * <p>You can use getImagePrefix() to get the value of imagePrefix</p>
     *
     * @param imagePrefix imagePrefix
     */
    public void setImagePrefix(String imagePrefix) {
        this.imagePrefix = imagePrefix;
    }
}
