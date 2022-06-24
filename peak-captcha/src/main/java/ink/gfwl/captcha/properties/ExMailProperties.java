package ink.gfwl.captcha.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * 邮箱配置
 * @author jianpòlan
 * @version 1.0
 **/
@ConfigurationProperties(
        prefix = "peak.captcha.ex-mail",
        ignoreInvalidFields = true
)
public class ExMailProperties implements Serializable {

    private static final long serialVersionUID = -1205813170883366179L;
    /**
     * 邮件发送地址(账号)
     */
    private String from;

    /**
     * 密码
     */
    private String password;

    /**
     * 协议(smtp)
     */
    private String protocol;

    /**
     * 邮件服务器端口
     */
    private String port;

    /**
     * 服务器地址
     */
    private String host;

    /**
     * Gets the value of from
     *
     * @return the value of from
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets the from
     * <p>You can use getFrom() to get the value of from</p>
     *
     * @param from from
     */
    public void setFrom(String from) {
        this.from = from;
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
     * Gets the value of protocol
     *
     * @return the value of protocol
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * Sets the protocol
     * <p>You can use getProtocol() to get the value of protocol</p>
     *
     * @param protocol protocol
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Gets the value of port
     *
     * @return the value of port
     */
    public String getPort() {
        return port;
    }

    /**
     * Sets the port
     * <p>You can use getPort() to get the value of port</p>
     *
     * @param port port
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * Gets the value of host
     *
     * @return the value of host
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets the host
     * <p>You can use getHost() to get the value of host</p>
     *
     * @param host host
     */
    public void setHost(String host) {
        this.host = host;
    }
}
