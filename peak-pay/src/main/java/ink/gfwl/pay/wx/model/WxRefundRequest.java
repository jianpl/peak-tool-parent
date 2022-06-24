package ink.gfwl.pay.wx.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 退款请求参数
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 **/
public class WxRefundRequest implements Serializable {

    private static final long serialVersionUID = -6957193919825328642L;
    private String body;

    /**
     * 商户订单号
     */
    private String tradeNo;

    /**
     * 商户系统内部的退款单号
     */
    private String outRefundNo;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 退款总金额
     */
    private BigDecimal amount;

    private String notifyUrl;

    /**
     * Gets the value of body
     *
     * @return the value of body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the body
     * <p>You can use getBody() to get the value of body</p>
     *
     * @param body body
     */
    public void setBody(String body) {
        this.body = body;
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
     * Gets the value of outRefundNo
     *
     * @return the value of outRefundNo
     */
    public String getOutRefundNo() {
        return outRefundNo;
    }

    /**
     * Sets the outRefundNo
     * <p>You can use getOutRefundNo() to get the value of outRefundNo</p>
     *
     * @param outRefundNo outRefundNo
     */
    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    /**
     * Gets the value of totalAmount
     *
     * @return the value of totalAmount
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the totalAmount
     * <p>You can use getTotalAmount() to get the value of totalAmount</p>
     *
     * @param totalAmount totalAmount
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Gets the value of amount
     *
     * @return the value of amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the amount
     * <p>You can use getAmount() to get the value of amount</p>
     *
     * @param amount amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Gets the value of notifyUrl
     *
     * @return the value of notifyUrl
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * Sets the notifyUrl
     * <p>You can use getNotifyUrl() to get the value of notifyUrl</p>
     *
     * @param notifyUrl notifyUrl
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
