package ink.gfwl.captcha.model;

import java.io.Serializable;

/**
 * 助通国际短信
 * @author jianpòlan
 * @version 1.0
 **/
public class ZthyGsMessageRequest implements Serializable {

    /**
     * 国家代码+手机号。多个手机号码用逗号分隔。最多支持2000个号码
     */
    private String phone;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 定时时间。留空则表示立即发送，时间格式为：yyyy-MM-dd HH:mm:ss
     */
    private String sendTime = "";

    /**
     * 扩展号
     */
    private String ext = "";

    /**
     * 自定义参数,最大100字符
     */
    private String extend = "";

    /**
     * 短信类型 固定值：YZM（验证码） YX(营销)
     */
    private String type = "YZM";

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
     * Gets the value of sendTime
     *
     * @return the value of sendTime
     */
    public String getSendTime() {
        return sendTime;
    }

    /**
     * Sets the sendTime
     * <p>You can use getSendTime() to get the value of sendTime</p>
     *
     * @param sendTime sendTime
     */
    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * Gets the value of ext
     *
     * @return the value of ext
     */
    public String getExt() {
        return ext;
    }

    /**
     * Sets the ext
     * <p>You can use getExt() to get the value of ext</p>
     *
     * @param ext ext
     */
    public void setExt(String ext) {
        this.ext = ext;
    }

    /**
     * Gets the value of extend
     *
     * @return the value of extend
     */
    public String getExtend() {
        return extend;
    }

    /**
     * Sets the extend
     * <p>You can use getExtend() to get the value of extend</p>
     *
     * @param extend extend
     */
    public void setExtend(String extend) {
        this.extend = extend;
    }

    /**
     * Gets the value of type
     *
     * @return the value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type
     * <p>You can use getType() to get the value of type</p>
     *
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }
}
