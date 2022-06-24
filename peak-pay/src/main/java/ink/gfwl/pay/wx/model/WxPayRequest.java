package ink.gfwl.pay.wx.model;

import java.math.BigDecimal;

/**
 * 微信支付参数
 * @author jianpòlan
 * @version 1.0
 **/
public class WxPayRequest {

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * 付款项目
     */
    private String body;

    /**
     * 内部订单号
     */
    private String tradeNo;

    /**
     * 回调地址
     */
    private String notifyUrl;

    /**
     * 产品ID
     */
    private String productId;

    /**
     * 付款金额
     */
    private BigDecimal amount;

    /**
     * openId 小程序用户
     */
    private String openId;

    /**
     * Gets the value of ipAddress
     *
     * @return the value of ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Sets the ipAddress
     * <p>You can use getIpAddress() to get the value of ipAddress</p>
     *
     * @param ipAddress ipAddress
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

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

    /**
     * Gets the value of productId
     *
     * @return the value of productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Sets the productId
     * <p>You can use getProductId() to get the value of productId</p>
     *
     * @param productId productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
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
     * Gets the value of openId
     *
     * @return the value of openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * Sets the openId
     * <p>You can use getOpenId() to get the value of openId</p>
     *
     * @param openId openId
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
