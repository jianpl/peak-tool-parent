package ink.gfwl.pay.wx.model;

import java.io.Serializable;

/**
 * 接收统一下单调用微信接口返回的参数
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 */
public class OrderReturnInfo implements Serializable {
    private static final long serialVersionUID = -9160310478031713240L;
    /**
     * 返回CODE
     */
    private String return_code;
    /**
     * 返回消息
     */
    private String return_msg;
    /**
     * 结果CODE
     */
    private String result_code;
    /**
     * APPID
     */
    private String appid;
    /**
     * 商户ID
     */
    private String mch_id;
    /**
     * 随机串
     */
    private String nonce_str;
    /**
     * 签名
     */
    private String sign;
    /**
     * 预支付ID
     */
    private String prepay_id;
    /**
     * 交易类型
     */
    private String trade_type;
    /**
     * 错误编码
     */
    private String err_code;

    /**
     * Gets the value of return_code
     *
     * @return the value of return_code
     */
    public String getReturn_code() {
        return return_code;
    }

    /**
     * Sets the return_code
     * <p>You can use getReturn_code() to get the value of return_code</p>
     *
     * @param return_code return_code
     */
    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    /**
     * Gets the value of return_msg
     *
     * @return the value of return_msg
     */
    public String getReturn_msg() {
        return return_msg;
    }

    /**
     * Sets the return_msg
     * <p>You can use getReturn_msg() to get the value of return_msg</p>
     *
     * @param return_msg return_msg
     */
    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    /**
     * Gets the value of result_code
     *
     * @return the value of result_code
     */
    public String getResult_code() {
        return result_code;
    }

    /**
     * Sets the result_code
     * <p>You can use getResult_code() to get the value of result_code</p>
     *
     * @param result_code result_code
     */
    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    /**
     * Gets the value of appid
     *
     * @return the value of appid
     */
    public String getAppid() {
        return appid;
    }

    /**
     * Sets the appid
     * <p>You can use getAppid() to get the value of appid</p>
     *
     * @param appid appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * Gets the value of mch_id
     *
     * @return the value of mch_id
     */
    public String getMch_id() {
        return mch_id;
    }

    /**
     * Sets the mch_id
     * <p>You can use getMch_id() to get the value of mch_id</p>
     *
     * @param mch_id mch_id
     */
    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    /**
     * Gets the value of nonce_str
     *
     * @return the value of nonce_str
     */
    public String getNonce_str() {
        return nonce_str;
    }

    /**
     * Sets the nonce_str
     * <p>You can use getNonce_str() to get the value of nonce_str</p>
     *
     * @param nonce_str nonce_str
     */
    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    /**
     * Gets the value of sign
     *
     * @return the value of sign
     */
    public String getSign() {
        return sign;
    }

    /**
     * Sets the sign
     * <p>You can use getSign() to get the value of sign</p>
     *
     * @param sign sign
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * Gets the value of prepay_id
     *
     * @return the value of prepay_id
     */
    public String getPrepay_id() {
        return prepay_id;
    }

    /**
     * Sets the prepay_id
     * <p>You can use getPrepay_id() to get the value of prepay_id</p>
     *
     * @param prepay_id prepay_id
     */
    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }

    /**
     * Gets the value of trade_type
     *
     * @return the value of trade_type
     */
    public String getTrade_type() {
        return trade_type;
    }

    /**
     * Sets the trade_type
     * <p>You can use getTrade_type() to get the value of trade_type</p>
     *
     * @param trade_type trade_type
     */
    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    /**
     * Gets the value of err_code
     *
     * @return the value of err_code
     */
    public String getErr_code() {
        return err_code;
    }

    /**
     * Sets the err_code
     * <p>You can use getErr_code() to get the value of err_code</p>
     *
     * @param err_code err_code
     */
    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }
}

