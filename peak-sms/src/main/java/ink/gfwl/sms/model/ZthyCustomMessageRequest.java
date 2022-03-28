package ink.gfwl.sms.model;

/**
 * 助通短信内容（自定义内容）
 * @author jianpòlan
 * @version 1.0
 **/
public class ZthyCustomMessageRequest extends MessageSendRequest{

    /**
     * 短信内容
     */
    private String content;


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
}
