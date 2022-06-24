package ink.gfwl.pay.apple.model;

import java.io.Serializable;

/**
 * 支付参数
 * @author jianpòlan
 * @version 1.0
 **/
public class ApplePaymentRequest implements Serializable {

    private static final long serialVersionUID = -2093985512776697620L;
    /**
     * 苹果支付receiptData(苹果传递receiptData和productId)
     */
    private String receiptData;

    /**
     * 产品ID
     */
    private String productId;

    public ApplePaymentRequest() {
    }

    public ApplePaymentRequest(String receiptData, String productId) {
        this.receiptData = receiptData;
        this.productId = productId;
    }

    /**
     * Gets the value of receiptData
     *
     * @return the value of receiptData
     */
    public String getReceiptData() {
        return receiptData;
    }

    /**
     * Sets the receiptData
     * <p>You can use getReceiptData() to get the value of receiptData</p>
     *
     * @param receiptData receiptData
     */
    public void setReceiptData(String receiptData) {
        this.receiptData = receiptData;
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
}
