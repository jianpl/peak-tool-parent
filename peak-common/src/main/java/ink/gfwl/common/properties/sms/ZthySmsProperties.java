package ink.gfwl.common.properties.sms;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 助通短信配置
 * @author jianpòlan
 * @version 1.0
 * <a href='https://doc.zthysms.com/web/#/1/4'>助通接口文档</a>
 **/
@ConfigurationProperties(
        prefix = "peak.sms.zthy",
        ignoreInvalidFields = true
)
public class ZthySmsProperties {

    /**
     * 用户名
     */
    private String username;

    /**
     * 接口密码
     */
    private String password;

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
}
