package ink.gfwl.jd.model.product.result;

import java.io.Serializable;

/**
 * 商品地址限制
 * @author jianpòlan
 * @version 1.0
 **/
public class ProductAreaLimitResult implements Serializable {

    private static final long serialVersionUID = 2152596814392127383L;
    /**
     * 商品编码
     */
    private Long skuId;

    /**
     * true 或空值代表区域受限 false 区域不受限
     */
    private Boolean isAreaRestrict;

    /**
     * Gets the value of skuId
     *
     * @return the value of skuId
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * Sets the skuId
     * <p>You can use getSkuId() to get the value of skuId</p>
     *
     * @param skuId skuId
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    /**
     * Gets the value of isAreaRestrict
     *
     * @return the value of isAreaRestrict
     */
    public Boolean getAreaRestrict() {
        return isAreaRestrict;
    }

    /**
     * Sets the isAreaRestrict
     * <p>You can use getAreaRestrict() to get the value of isAreaRestrict</p>
     *
     * @param areaRestrict isAreaRestrict
     */
    public void setAreaRestrict(Boolean areaRestrict) {
        isAreaRestrict = areaRestrict;
    }
}
