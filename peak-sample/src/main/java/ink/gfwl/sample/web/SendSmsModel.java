package ink.gfwl.sample.web;

import java.io.Serializable;

/**
 * 短信参数实体
 * @author jianpòlan
 * @version 1.0
 **/
public class SendSmsModel implements Serializable {

    // 类型：1注册，2登录，3修改密码
    private Integer type;

    private String phone;

    private String content;

    /**
     * Gets the value of phone
     *
     * @return the value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone
     * <p>You can use getPhone() to get the value of phone</p>
     *
     * @param phone phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the value of content
     *
     * @return the value of content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content
     * <p>You can use getContent() to get the value of content</p>
     *
     * @param content content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the value of type
     *
     * @return the value of type
     */
    public Integer getType() {
        return type;
    }

    /**
     * Sets the type
     * <p>You can use getType() to get the value of type</p>
     *
     * @param type type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    public SendSmsModel(Integer type, String phone, String content) {
        this.type = type;
        this.phone = phone;
        this.content = content;
    }

    public SendSmsModel() {
    }
}
