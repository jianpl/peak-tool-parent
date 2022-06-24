package ink.gfwl.pay.ali.model;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Alipay request param
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class AlipayRequest implements Serializable {

    private static final long serialVersionUID = 5667123453989717878L;
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
    private String callbackUrl;

    /**
     * 付款金额
     */
    private BigDecimal amount;

    /**
     * 其他参数
     */
    private Object otherParams;

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
     * Gets the value of callbackUrl
     *
     * @return the value of callbackUrl
     */
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * Sets the callbackUrl
     * <p>You can use getCallbackUrl() to get the value of callbackUrl</p>
     *
     * @param callbackUrl callbackUrl
     */
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
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
     * Gets the value of otherParams
     *
     * @return the value of otherParams
     */
    public Object getOtherParams() {
        return otherParams;
    }

    /**
     * Sets the otherParams
     * <p>You can use getOtherParams() to get the value of otherParams</p>
     *
     * @param otherParams otherParams
     */
    public void setOtherParams(Object otherParams) {
        this.otherParams = otherParams;
    }
}
