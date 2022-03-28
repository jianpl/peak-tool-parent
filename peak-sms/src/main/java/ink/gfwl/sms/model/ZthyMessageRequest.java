package ink.gfwl.sms.model;

import com.alibaba.fastjson.JSONObject;

/**
 * 助通模板发送参数
 * @author jianpòlan
 * @version 1.0
 **/
public class ZthyMessageRequest extends MessageSendRequest {

    /**
     * 模板ID
     */
    private String tpId;

    /**
     * 签名
     */
    private String signature;

    /**
     * 短信参数
     */
    private JSONObject param;
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
     * Gets the value of signature
     *
     * @return the value of signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets the signature
     * <p>You can use getSignature() to get the value of signature</p>
     *
     * @param signature signature
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * Gets the value of param
     *
     * @return the value of param
     */
    public JSONObject getParam() {
        return param;
    }

    /**
     * Sets the param
     * <p>You can use getParam() to get the value of param</p>
     *
     * @param param param
     */
    public void setParam(JSONObject param) {
        this.param = param;
    }
}
