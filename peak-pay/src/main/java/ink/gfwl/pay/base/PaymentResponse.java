package ink.gfwl.pay.base;

import java.io.Serializable;

/**
 * Pay result
 * @author jianpòlan
 * @version 1.0
 **/
public class PaymentResponse implements Serializable {

    private static final long serialVersionUID = -381524809205918740L;

    /**
     * 是否成功
     * IPA未成功结果，同步
     * WX,AliPay 为异步
     */
    private boolean success;

    /**
     * 下单信息, IPA支付为空
     */
    private String orderStr;

    /**
     * Sets the success
     * <p>You can use setSuccess() to get the value of success</p>
     * @param success success
     */
    public void setSuccess(boolean success){
        this.success = success;
    }

    /**
     * Gets the value of success
     * @return the value of success
     */
    public boolean getSuccess(){
        return success;
    }

    /**
     * Gets the value of orderStr
     * @return the value of orderStr
     */
    public String getOrderStr() {
        return orderStr;
    }

    /**
     * Sets the orderStr
     * <p>You can use getOrderStr() to get the value of orderStr</p>
     *
     * @param orderStr orderStr
     */
    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }
}
