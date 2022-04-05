package ink.gfwl.jd.model.product.result;

import ink.gfwl.jd.model.product.base.ProductExtsProperties;

import java.io.Serializable;

/**
 * 京东商品(实物属性)
 * @author jianpòlan
 * @version 1.0
 **/
public class ProductMatterResult extends ProductExtsProperties implements Serializable {

    /**
     * 售卖单位（N）
     */
    private String saleUnit;
    /**
     * 重量（N）
     */
    private String weight;
    /**
     * 产地（N）
     */
    private String productArea;
    /**
     * 包装清单（Y）
     */
    private String wareQD;
    /**
     * 主图（Y）
     */
    private String imagePath;
    /**
     * 规格参数(N)
     */
    private String param;
    /**
     * 主站上下架状态 (1上架  0下架)(Y)
     */
    private String state;
    /**
     * 商品编号(Y)
     */
    private String sku;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * UPC码
     * 区分实物、图书、音像、三种场景
     */
    private String upc;
    /**
     * 分类
     * 示例"670;729;4837"
     */
    private String category;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品详情页大字段
     */
    private String introduction;

    /**
     * Gets the value of saleUnit
     *
     * @return the value of saleUnit
     */
    public String getSaleUnit() {
        return saleUnit;
    }

    /**
     * Sets the saleUnit
     * <p>You can use getSaleUnit() to get the value of saleUnit</p>
     *
     * @param saleUnit saleUnit
     */
    public void setSaleUnit(String saleUnit) {
        this.saleUnit = saleUnit;
    }

    /**
     * Gets the value of weight
     *
     * @return the value of weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Sets the weight
     * <p>You can use getWeight() to get the value of weight</p>
     *
     * @param weight weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * Gets the value of productArea
     *
     * @return the value of productArea
     */
    public String getProductArea() {
        return productArea;
    }

    /**
     * Sets the productArea
     * <p>You can use getProductArea() to get the value of productArea</p>
     *
     * @param productArea productArea
     */
    public void setProductArea(String productArea) {
        this.productArea = productArea;
    }

    /**
     * Gets the value of wareQD
     *
     * @return the value of wareQD
     */
    public String getWareQD() {
        return wareQD;
    }

    /**
     * Sets the wareQD
     * <p>You can use getWareQD() to get the value of wareQD</p>
     *
     * @param wareQD wareQD
     */
    public void setWareQD(String wareQD) {
        this.wareQD = wareQD;
    }

    /**
     * Gets the value of imagePath
     *
     * @return the value of imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Sets the imagePath
     * <p>You can use getImagePath() to get the value of imagePath</p>
     *
     * @param imagePath imagePath
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Gets the value of param
     *
     * @return the value of param
     */
    public String getParam() {
        return param;
    }

    /**
     * Sets the param
     * <p>You can use getParam() to get the value of param</p>
     *
     * @param param param
     */
    public void setParam(String param) {
        this.param = param;
    }

    /**
     * Gets the value of state
     *
     * @return the value of state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state
     * <p>You can use getState() to get the value of state</p>
     *
     * @param state state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the value of sku
     *
     * @return the value of sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * Sets the sku
     * <p>You can use getSku() to get the value of sku</p>
     *
     * @param sku sku
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Gets the value of brandName
     *
     * @return the value of brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Sets the brandName
     * <p>You can use getBrandName() to get the value of brandName</p>
     *
     * @param brandName brandName
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * Gets the value of upc
     *
     * @return the value of upc
     */
    public String getUpc() {
        return upc;
    }

    /**
     * Sets the upc
     * <p>You can use getUpc() to get the value of upc</p>
     *
     * @param upc upc
     */
    public void setUpc(String upc) {
        this.upc = upc;
    }

    /**
     * Gets the value of category
     *
     * @return the value of category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category
     * <p>You can use getCategory() to get the value of category</p>
     *
     * @param category category
     */
    public void setCategory(String category) {
        this.category = category;
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
     * Gets the value of introduction
     *
     * @return the value of introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * Sets the introduction
     * <p>You can use getIntroduction() to get the value of introduction</p>
     *
     * @param introduction introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
