package ink.gfwl.pay.ali.model;

import java.math.BigDecimal;

/**
 * 退款请求参数
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 **/
public class RefundRequest {

    /**
     * 需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
     */
    private BigDecimal amount;

    /**
     * 订单支付时传入的商户订单号，商家自定义且保证商家系统中唯一。与支付宝交易号 trade_no 不能同时为空。
     */
    private String tradeNo;

    /**
     * 支付宝交易号，和商户订单号 out_trade_no 不能同时为空。
     */
    private String outTradeNo;

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
}
