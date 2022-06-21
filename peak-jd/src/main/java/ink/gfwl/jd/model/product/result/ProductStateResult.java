package ink.gfwl.jd.model.product.result;

import java.io.Serializable;

/**
 * 商品上下架状态
 * @author jianpòlan
 * @version 1.0
 **/
public class ProductStateResult implements Serializable {

    private static final long serialVersionUID = -2607891817489448053L;
    /**
     * skuId
     */
    private Long sku;

    /**
     * 1：上架，0：下架
     */
    private Integer state;

    /**
     * Gets the value of sku
     *
     * @return the value of sku
     */
    public Long getSku() {
        return sku;
    }

    /**
     * Sets the sku
     * <p>You can use getSku() to get the value of sku</p>
     *
     * @param sku sku
     */
    public void setSku(Long sku) {
        this.sku = sku;
    }

    /**
     * Gets the value of state
     *
     * @return the value of state
     */
    public Integer getState() {
        return state;
    }

    /**
     * Sets the state
     * <p>You can use getState() to get the value of state</p>
     *
     * @param state state
     */
    public void setState(Integer state) {
        this.state = state;
    }
}
