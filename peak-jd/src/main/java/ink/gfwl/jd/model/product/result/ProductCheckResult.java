package ink.gfwl.jd.model.product.result;

import java.io.Serializable;

/**
 * 商品可售性
 * @author jianpòlan
 * @version 1.0
 **/
public class ProductCheckResult implements Serializable {

    /**
     * 商品编号
     */
    private Long skuId;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 是否可售，1：是，0：否
     */
    private Integer saleState;
    /**
     * 是否可开专票，1：支持，0：不支持
     */
    private Integer isCanVAT;
    /**
     * 无理由退货类型：0,1,2,3,4,5,6,7,8
     * 0、3：不支持7天无理由退货；
     * 1、5、8或null：支持7天无理由退货；
     * 2：支持90天无理由退货；
     * 4、7：支持15天无理由退货；
     * 6：支持30天无理由退货；
     * （提示客户取到其他枚举值，无效）
     */
    private Integer noReasonToReturn;

    /**
     * 无理由退货文案类型：
     * null：文案空；
     * 0：文案空；
     * 1：支持7天无理由退货；
     * 2：支持7天无理由退货（拆封后不支持）；
     * 3：支持7天无理由退货（激活后不支持）；
     * 4：支持7天无理由退货（使用后不支持）；
     * 5：支持7天无理由退货（安装后不支持）；
     * 12：支持15天无理由退货；
     * 13：支持15天无理由退货（拆封后不支持）；
     * 14：支持15天无理由退货（激活后不支持）；
     * 15：支持15天无理由退货（使用后不支持）；
     * 16：支持15天无理由退货（安装后不支持）；
     * 22：支持30天无理由退货；
     * 23：支持30天无理由退货（安装后不支持）；
     * 24：支持30天无理由退货（拆封后不支持）；
     * 25：支持30天无理由退货（使用后不支持）；
     * 26：支持30天无理由退货（激活后不支持）；
     * （提示客户取到其他枚举值，无效）；
     */
    private Integer thwa;

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
     * Gets the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * <p>You can use getName() to get the value of name</p>
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of saleState
     *
     * @return the value of saleState
     */
    public Integer getSaleState() {
        return saleState;
    }

    /**
     * Sets the saleState
     * <p>You can use getSaleState() to get the value of saleState</p>
     *
     * @param saleState saleState
     */
    public void setSaleState(Integer saleState) {
        this.saleState = saleState;
    }

    /**
     * Gets the value of isCanVAT
     *
     * @return the value of isCanVAT
     */
    public Integer getIsCanVAT() {
        return isCanVAT;
    }

    /**
     * Sets the isCanVAT
     * <p>You can use getIsCanVAT() to get the value of isCanVAT</p>
     *
     * @param isCanVAT isCanVAT
     */
    public void setIsCanVAT(Integer isCanVAT) {
        this.isCanVAT = isCanVAT;
    }

    /**
     * Gets the value of noReasonToReturn
     *
     * @return the value of noReasonToReturn
     */
    public Integer getNoReasonToReturn() {
        return noReasonToReturn;
    }

    /**
     * Sets the noReasonToReturn
     * <p>You can use getNoReasonToReturn() to get the value of noReasonToReturn</p>
     *
     * @param noReasonToReturn noReasonToReturn
     */
    public void setNoReasonToReturn(Integer noReasonToReturn) {
        this.noReasonToReturn = noReasonToReturn;
    }

    /**
     * Gets the value of thwa
     *
     * @return the value of thwa
     */
    public Integer getThwa() {
        return thwa;
    }

    /**
     * Sets the thwa
     * <p>You can use getThwa() to get the value of thwa</p>
     *
     * @param thwa thwa
     */
    public void setThwa(Integer thwa) {
        this.thwa = thwa;
    }
}
