package ink.gfwl.jd.model.product.result;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品卖价
 * @author jianpòlan
 * @version 1.0
 **/
public class ProductPriceResult implements Serializable {

    private static final long serialVersionUID = -2155993977178094662L;
    /**
     * skuId
     */
    private Long skuId;

    /**
     * 京东价。仅供参考。
     */
    private BigDecimal jdPrice;

    /**
     * 京东销售价
     */
    private BigDecimal price;

    /**
     * 入参中的queryExts中包含marketPrice时，输出此字段。
     * 京东的前台划线价。现在只有图书频道能露出，其他的因政策原因已不允许展示。
     * 仅供参考
     */
    private BigDecimal marketPrice;

    /**
     * 税率。
     * 当queryExts中包含containsTax时，出参中有此字段。
     * 例如：此值为16时，代表税率为“16%”
     */
    private BigDecimal tax;

    /**
     * 税额。
     * 当queryExts中包含containsTax时，出参中有此字段。
     */
    private BigDecimal taxPrice;

    /**
     * 未税价。（当queryExts中包含nakedPrice或containsTax时，出参中有此字段）
     * 供参考。
     */
    private BigDecimal nakedPrice;

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
     * Gets the value of jdPrice
     *
     * @return the value of jdPrice
     */
    public BigDecimal getJdPrice() {
        return jdPrice;
    }

    /**
     * Sets the jdPrice
     * <p>You can use getJdPrice() to get the value of jdPrice</p>
     *
     * @param jdPrice jdPrice
     */
    public void setJdPrice(BigDecimal jdPrice) {
        this.jdPrice = jdPrice;
    }

    /**
     * Gets the value of price
     *
     * @return the value of price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price
     * <p>You can use getPrice() to get the value of price</p>
     *
     * @param price price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Gets the value of marketPrice
     *
     * @return the value of marketPrice
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * Sets the marketPrice
     * <p>You can use getMarketPrice() to get the value of marketPrice</p>
     *
     * @param marketPrice marketPrice
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * Gets the value of tax
     *
     * @return the value of tax
     */
    public BigDecimal getTax() {
        return tax;
    }

    /**
     * Sets the tax
     * <p>You can use getTax() to get the value of tax</p>
     *
     * @param tax tax
     */
    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    /**
     * Gets the value of taxPrice
     *
     * @return the value of taxPrice
     */
    public BigDecimal getTaxPrice() {
        return taxPrice;
    }

    /**
     * Sets the taxPrice
     * <p>You can use getTaxPrice() to get the value of taxPrice</p>
     *
     * @param taxPrice taxPrice
     */
    public void setTaxPrice(BigDecimal taxPrice) {
        this.taxPrice = taxPrice;
    }

    /**
     * Gets the value of nakedPrice
     *
     * @return the value of nakedPrice
     */
    public BigDecimal getNakedPrice() {
        return nakedPrice;
    }

    /**
     * Sets the nakedPrice
     * <p>You can use getNakedPrice() to get the value of nakedPrice</p>
     *
     * @param nakedPrice nakedPrice
     */
    public void setNakedPrice(BigDecimal nakedPrice) {
        this.nakedPrice = nakedPrice;
    }
}
