package ink.gfwl.jd.model.order.result.sub;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单包含的商品信息列表
 * @author jianpòlan
 * @version 1.0
 **/
public class BizSku implements Serializable {

    /**
     * Long	是	京东商品编号
     */
    private Long skuId;
    /**
     * 是	购买商品数量
     */
    private Integer num;
    /**
     * 是	商品分类编号
     */
    private Integer category;
    /**
     * 是	商品单价
     */
    private BigDecimal price;
    /**
     * 是	商品名称
     */
    private String name;
    /**
     * 是	商品税率
     */
    private BigDecimal tax;
    /**
     * 是	商品税额
     */
    private BigDecimal taxPrice;
    /**
     * 是	商品未税价
     */
    private BigDecimal nakedPrice;
    /**
     * 是	商品类型：0普通、1附件、2赠品
     */
    private Integer type;
    /**
     * 是	主商品skuid，如果本身是主商品，则oid为0
     */
    private Long oid;

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
     * Gets the value of num
     *
     * @return the value of num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * Sets the num
     * <p>You can use getNum() to get the value of num</p>
     *
     * @param num num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * Gets the value of category
     *
     * @return the value of category
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * Sets the category
     * <p>You can use getCategory() to get the value of category</p>
     *
     * @param category category
     */
    public void setCategory(Integer category) {
        this.category = category;
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

    /**
     * Gets the value of type
     *
     * @return the value of type
     */
    public Integer getType() {
        return type;
    }

    /**
     * Sets the type
     * <p>You can use getType() to get the value of type</p>
     *
     * @param type type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * Gets the value of oid
     *
     * @return the value of oid
     */
    public Long getOid() {
        return oid;
    }

    /**
     * Sets the oid
     * <p>You can use getOid() to get the value of oid</p>
     *
     * @param oid oid
     */
    public void setOid(Long oid) {
        this.oid = oid;
    }
}
