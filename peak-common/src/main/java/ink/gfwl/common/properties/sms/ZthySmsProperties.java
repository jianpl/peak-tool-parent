package ink.gfwl.common.properties.sms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 助通短信配置
 * @author jianpòlan
 * @version 1.0
 * <a href='https://doc.zthysms.com/web/#/1/4'>助通接口文档</a>
 **/
@Component
public class ZthySmsProperties {

    /**
     * 用户名
     */
    @Value("${peak.sms.zthy.username}")
    private String username;

    /**
     * 接口密码
     */
    @Value("${peak.sms.zthy.password}")
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
