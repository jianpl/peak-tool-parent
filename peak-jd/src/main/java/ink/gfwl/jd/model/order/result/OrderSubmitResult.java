package ink.gfwl.jd.model.order.result;

import ink.gfwl.jd.model.order.result.sub.BizSku;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 提交订单结果
 * @author jianpòlan
 * @version 1.0
 **/
public class OrderSubmitResult implements Serializable {

    /**
     * 京东订单号
     */
    private Long jdOrderId;
    /**
     * 运费
     */
    private BigDecimal freight;
    /**
     * 订单总金额（不包含运费）
     */
    private BigDecimal orderPrice;
    /**
     * 订单未税金额
     */
    private BigDecimal orderNakedPrice;
    /**
     * 订单税额
     */
    private BigDecimal orderTaxPrice;

    /**
     * 订单包含的商品信息列表
     */
    private List<BizSku> sku;

    /**
     * Gets the value of jdOrderId
     *
     * @return the value of jdOrderId
     */
    public Long getJdOrderId() {
        return jdOrderId;
    }

    /**
     * Sets the jdOrderId
     * <p>You can use getJdOrderId() to get the value of jdOrderId</p>
     *
     * @param jdOrderId jdOrderId
     */
    public void setJdOrderId(Long jdOrderId) {
        this.jdOrderId = jdOrderId;
    }

    /**
     * Gets the value of freight
     *
     * @return the value of freight
     */
    public BigDecimal getFreight() {
        return freight;
    }

    /**
     * Sets the freight
     * <p>You can use getFreight() to get the value of freight</p>
     *
     * @param freight freight
     */
    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    /**
     * Gets the value of orderPrice
     *
     * @return the value of orderPrice
     */
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    /**
     * Sets the orderPrice
     * <p>You can use getOrderPrice() to get the value of orderPrice</p>
     *
     * @param orderPrice orderPrice
     */
    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * Gets the value of orderNakedPrice
     *
     * @return the value of orderNakedPrice
     */
    public BigDecimal getOrderNakedPrice() {
        return orderNakedPrice;
    }

    /**
     * Sets the orderNakedPrice
     * <p>You can use getOrderNakedPrice() to get the value of orderNakedPrice</p>
     *
     * @param orderNakedPrice orderNakedPrice
     */
    public void setOrderNakedPrice(BigDecimal orderNakedPrice) {
        this.orderNakedPrice = orderNakedPrice;
    }

    /**
     * Gets the value of orderTaxPrice
     *
     * @return the value of orderTaxPrice
     */
    public BigDecimal getOrderTaxPrice() {
        return orderTaxPrice;
    }

    /**
     * Sets the orderTaxPrice
     * <p>You can use getOrderTaxPrice() to get the value of orderTaxPrice</p>
     *
     * @param orderTaxPrice orderTaxPrice
     */
    public void setOrderTaxPrice(BigDecimal orderTaxPrice) {
        this.orderTaxPrice = orderTaxPrice;
    }

    /**
     * Gets the value of sku
     *
     * @return the value of sku
     */
    public List<BizSku> getSku() {
        return sku;
    }

    /**
     * Sets the sku
     * <p>You can use getSku() to get the value of sku</p>
     *
     * @param sku sku
     */
    public void setSku(List<BizSku> sku) {
        this.sku = sku;
    }
}
