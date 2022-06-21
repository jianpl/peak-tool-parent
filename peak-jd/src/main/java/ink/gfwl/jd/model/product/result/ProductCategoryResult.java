package ink.gfwl.jd.model.product.result;

import java.io.Serializable;

/**
 * 分类
 * @author jianpòlan
 * @version 1.0
 **/
public class ProductCategoryResult implements Serializable {

    private static final long serialVersionUID = 98764719753426108L;
    /**
     * 分类ID
     */
    private Integer catId;

    /**
     * 父分类ID
     */
    private Integer parentId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 0：一级分类；1：二级分类；2：三级分类；
     */
    private Integer catClass;

    /**
     * 1：有效；0：无效；
     */
    private Integer state;

    /**
     * Gets the value of catId
     *
     * @return the value of catId
     */
    public Integer getCatId() {
        return catId;
    }

    /**
     * Sets the catId
     * <p>You can use getCatId() to get the value of catId</p>
     *
     * @param catId catId
     */
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    /**
     * Gets the value of parentId
     *
     * @return the value of parentId
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * Sets the parentId
     * <p>You can use getParentId() to get the value of parentId</p>
     *
     * @param parentId parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
     * Gets the value of catClass
     *
     * @return the value of catClass
     */
    public Integer getCatClass() {
        return catClass;
    }

    /**
     * Sets the catClass
     * <p>You can use getCatClass() to get the value of catClass</p>
     *
     * @param catClass catClass
     */
    public void setCatClass(Integer catClass) {
        this.catClass = catClass;
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
