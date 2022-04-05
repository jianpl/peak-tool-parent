package ink.gfwl.jd.model.product.result;

import java.io.Serializable;

/**
 * 商品图片
 * @author jianpòlan
 * @version 1.0
 **/
public class ProductImageResult implements Serializable {

    /**
     * 编号
     */
    private Long id;
    /**
     * sku编号
     */
    private Long skuId;
    /**
     * 图片路径 如3.3商品详情页面返回的图片地址一致。
     */
    private String path;
    /**
     * 创建日期
     */
    private String created;
    /**
     * 更新时间
     */
    private String modified;
    /**
     * 0:不可用;1:可用
     */
    private Integer yn;
    /**
     * 是否主图 1：是 0：否
     */
    private Integer isPrimary;
    /**
     * 排序
     */
    private Integer orderSort;
    /**
     * 位置
     */
    private Integer position;
    /**
     * 类型（0方图  1长图【服装】）
     */
    private Integer type;
    /**
     * 特征
     */
    private String features;

    /**
     * Gets the value of id
     *
     * @return the value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id
     * <p>You can use getId() to get the value of id</p>
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * Gets the value of path
     *
     * @return the value of path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path
     * <p>You can use getPath() to get the value of path</p>
     *
     * @param path path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets the value of created
     *
     * @return the value of created
     */
    public String getCreated() {
        return created;
    }

    /**
     * Sets the created
     * <p>You can use getCreated() to get the value of created</p>
     *
     * @param created created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * Gets the value of modified
     *
     * @return the value of modified
     */
    public String getModified() {
        return modified;
    }

    /**
     * Sets the modified
     * <p>You can use getModified() to get the value of modified</p>
     *
     * @param modified modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     * Gets the value of yn
     *
     * @return the value of yn
     */
    public Integer getYn() {
        return yn;
    }

    /**
     * Sets the yn
     * <p>You can use getYn() to get the value of yn</p>
     *
     * @param yn yn
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }

    /**
     * Gets the value of isPrimary
     *
     * @return the value of isPrimary
     */
    public Integer getIsPrimary() {
        return isPrimary;
    }

    /**
     * Sets the isPrimary
     * <p>You can use getIsPrimary() to get the value of isPrimary</p>
     *
     * @param isPrimary isPrimary
     */
    public void setIsPrimary(Integer isPrimary) {
        this.isPrimary = isPrimary;
    }

    /**
     * Gets the value of orderSort
     *
     * @return the value of orderSort
     */
    public Integer getOrderSort() {
        return orderSort;
    }

    /**
     * Sets the orderSort
     * <p>You can use getOrderSort() to get the value of orderSort</p>
     *
     * @param orderSort orderSort
     */
    public void setOrderSort(Integer orderSort) {
        this.orderSort = orderSort;
    }

    /**
     * Gets the value of position
     *
     * @return the value of position
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * Sets the position
     * <p>You can use getPosition() to get the value of position</p>
     *
     * @param position position
     */
    public void setPosition(Integer position) {
        this.position = position;
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
     * Gets the value of features
     *
     * @return the value of features
     */
    public String getFeatures() {
        return features;
    }

    /**
     * Sets the features
     * <p>You can use getFeatures() to get the value of features</p>
     *
     * @param features features
     */
    public void setFeatures(String features) {
        this.features = features;
    }
}
