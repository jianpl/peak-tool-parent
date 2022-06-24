package ink.gfwl.pay.base;

import java.io.Serializable;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
public class CallbackParams implements Serializable {

    /**
     * 商家内部订单号
     */
    private String tradeNo;

    /**
     * 支付方订单号
     */
    private String outTradeNo;

    /**
     * 支付状态
     */
    private boolean tradeStatus;

    /**
     * 回调参数
     */
    private String callback;

    /**
     * Gets the value of tradeStatus
     *
     * @return the value of tradeStatus
     */
    public boolean getTradeStatus(){
        return tradeStatus;
    }

    /**
     * Sets the tradeStatus
     * <p>You can use getTradeStatus() to get the value of tradeStatus</p>
     *
     * @param tradeStatus tradeStatus
     */
    public void setTradeStatus(boolean tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    /**
     * Gets the value of tradeNo
     *
     * @return the value of tradeNo
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * Sets the tradeNo
     * <p>You can use getTradeNo() to get the value of tradeNo</p>
     *
     * @param tradeNo tradeNo
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    /**
     * Gets the value of outTradeNo
     *
     * @return the value of outTradeNo
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * Sets the outTradeNo
     * <p>You can use getOutTradeNo() to get the value of outTradeNo</p>
     *
     * @param outTradeNo outTradeNo
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    /**
     * Gets the value of callback
     *
     * @return the value of callback
     */
    public String getCallback() {
        return callback;
    }

    /**
     * Sets the callback
     * <p>You can use getCallback() to get the value of callback</p>
     *
     * @param callback callback
     */
    public void setCallback(String callback) {
        this.callback = callback;
    }
}
