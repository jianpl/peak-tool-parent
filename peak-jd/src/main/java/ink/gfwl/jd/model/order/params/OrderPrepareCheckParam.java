package ink.gfwl.jd.model.order.params;

import java.io.Serializable;

/**
 * 下单检查
 * @author jianpòlan
 * @version 1.0
 **/
public class OrderPrepareCheckParam implements Serializable {

    private String skuId;

    private String num;

    /**
     * Gets the value of skuId
     *
     * @return the value of skuId
     */
    public String getSkuId() {
        return skuId;
    }

    /**
     * Sets the skuId
     * <p>You can use getSkuId() to get the value of skuId</p>
     *
     * @param skuId skuId
     */
    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    /**
     * Gets the value of num
     *
     * @return the value of num
     */
    public String getNum() {
        return num;
    }

    /**
     * Sets the num
     * <p>You can use getNumber() to get the value of num</p>
     *
     * @param num num
     */
    public void setNum(String num) {
        this.num = num;
    }
}
