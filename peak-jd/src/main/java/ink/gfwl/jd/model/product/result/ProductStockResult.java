package ink.gfwl.jd.model.product.result;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品库存
 * @author jianpòlan
 * @version 1.0
 **/
public class ProductStockResult implements Serializable {

    private static final long serialVersionUID = 3412887207693803193L;
    /**
     * skuId
     */
    private Long skuId;

    /**
     * 入参时传入的区域码area。
     * 因京东目前是3、4级地址均支持，存在areaId在传入的3级地址后填充4级地址“_0“后返回的情况。
     */
    private String areaId;

    /**
     * 库存状态编号。
     * 参考枚举值：
     * 33,39,40,36,34,99
     */
    private BigDecimal stockStateId;

    /**
     * 库存状态描述。以下为stockStateId不同时，此字段不同的返回值：
     * 33 有货 现货-下单立即发货
     * 39 有货 在途-正在内部配货，预计2~6天到达本仓库
     * 40 有货 可配货-下单后从有货仓库配货
     * 36 预订
     * 34 无货
     * 99 无货开预定，此时desc返回的数值代表预计到货天数，并且该功能需要依赖合同上有无货开预定权限的用户，到货周期略长，谨慎采用该功能。
     */
    private String StockStateDesc;

    /**
     * 剩余数量。
     * 当此值为-1时，为未查询到。
     * StockStateDesc为33：
     * 入参的skuNums字段，skuId对应的num&gt;50，此字段为实际库存。
     * 入参的skuNums字段，skuId对应的50&gt;=num&lt;100，此字段为-1。
     * 入参的skuNums字段，skuId对应的num&gt;100，此字段等于num。(此种情况并未返回真实京东库存)
     */
    private Integer remainNum;

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
     * Gets the value of areaId
     *
     * @return the value of areaId
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * Sets the areaId
     * <p>You can use getAreaId() to get the value of areaId</p>
     *
     * @param areaId areaId
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * Gets the value of stockStateId
     *
     * @return the value of stockStateId
     */
    public BigDecimal getStockStateId() {
        return stockStateId;
    }

    /**
     * Sets the stockStateId
     * <p>You can use getStockStateId() to get the value of stockStateId</p>
     *
     * @param stockStateId stockStateId
     */
    public void setStockStateId(BigDecimal stockStateId) {
        this.stockStateId = stockStateId;
    }

    /**
     * Gets the value of StockStateDesc
     *
     * @return the value of StockStateDesc
     */
    public String getStockStateDesc() {
        return StockStateDesc;
    }

    /**
     * Sets the StockStateDesc
     * <p>You can use getStockStateDesc() to get the value of StockStateDesc</p>
     *
     * @param stockStateDesc StockStateDesc
     */
    public void setStockStateDesc(String stockStateDesc) {
        StockStateDesc = stockStateDesc;
    }

    /**
     * Gets the value of remainNum
     *
     * @return the value of remainNum
     */
    public Integer getRemainNum() {
        return remainNum;
    }

    /**
     * Sets the remainNum
     * <p>You can use getRemainNum() to get the value of remainNum</p>
     *
     * @param remainNum remainNum
     */
    public void setRemainNum(Integer remainNum) {
        this.remainNum = remainNum;
    }
}
