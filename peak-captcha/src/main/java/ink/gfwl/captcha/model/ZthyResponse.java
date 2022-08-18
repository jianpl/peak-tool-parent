package ink.gfwl.captcha.model;

import java.io.Serializable;
import java.util.List;

/**
 * 助通结果
 * @author jianpòlan
 * @version 1.0
 **/
public class ZthyResponse implements Serializable {

    private static final long serialVersionUID = -1025891635915259963L;
    private Integer code;

    private String msg;

    private String tpId;

    private String msgId;

    private List<String> invalidList;

    /**
     * Gets the value of code
     *
     * @return the value of code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Sets the code
     * <p>You can use getCode() to get the value of code</p>
     *
     * @param code code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * Gets the value of msg
     *
     * @return the value of msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets the msg
     * <p>You can use getMsg() to get the value of msg</p>
     *
     * @param msg msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Gets the value of tpId
     *
     * @return the value of tpId
     */
    public String getTpId() {
        return tpId;
    }

    /**
     * Sets the tpId
     * <p>You can use getTpId() to get the value of tpId</p>
     *
     * @param tpId tpId
     */
    public void setTpId(String tpId) {
        this.tpId = tpId;
    }

    /**
     * Gets the value of msgId
     *
     * @return the value of msgId
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * Sets the msgId
     * <p>You can use getMsgId() to get the value of msgId</p>
     *
     * @param msgId msgId
     */
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    /**
     * Gets the value of invalidList
     *
     * @return the value of invalidList
     */
    public List<String> getInvalidList() {
        return invalidList;
    }

    /**
     * Sets the invalidList
     * <p>You can use getInvalidList() to get the value of invalidList</p>
     *
     * @param invalidList invalidList
     */
    public void setInvalidList(List<String> invalidList) {
        this.invalidList = invalidList;
    }

    /**
     * 判定是否发送成功
     * @return send success to true
     */
    public boolean isSuccess(){
        return this.code == 200;
    }
}
