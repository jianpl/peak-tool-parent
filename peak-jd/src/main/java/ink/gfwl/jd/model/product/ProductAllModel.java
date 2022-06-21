package ink.gfwl.jd.model.product;

import ink.gfwl.jd.model.product.result.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 京东所有属性
 * @author jianpòlan
 * @version 1.0
 **/
public class ProductAllModel extends ProductMatterResult implements Serializable {

    private static final long serialVersionUID = 895363726391116827L;
    /**
     * 商品图片
     */
    private Map<Long, List<ProductImageResult>> imageResult;

    /**
     * 商品价格
     */
    private List<ProductPriceResult> priceResult;

    /**
     * 商品状态
     */
    private ProductStateResult stateResult;

    /**
     * Gets the value of imageResult
     *
     * @return the value of imageResult
     */
    public Map<Long, List<ProductImageResult>> getImageResult() {
        return imageResult;
    }

    /**
     * Sets the imageResult
     * <p>You can use getImageResult() to get the value of imageResult</p>
     *
     * @param imageResult imageResult
     */
    public void setImageResult(Map<Long, List<ProductImageResult>> imageResult) {
        this.imageResult = imageResult;
    }

    /**
     * Gets the value of priceResult
     *
     * @return the value of priceResult
     */
    public List<ProductPriceResult> getPriceResult() {
        return priceResult;
    }

    /**
     * Sets the priceResult
     * <p>You can use getPriceResult() to get the value of priceResult</p>
     *
     * @param priceResult priceResult
     */
    public void setPriceResult(List<ProductPriceResult> priceResult) {
        this.priceResult = priceResult;
    }

    /**
     * Gets the value of stateResult
     *
     * @return the value of stateResult
     */
    public ProductStateResult getStateResult() {
        return stateResult;
    }

    /**
     * Sets the stateResult
     * <p>You can use getStateResult() to get the value of stateResult</p>
     *
     * @param stateResult stateResult
     */
    public void setStateResult(ProductStateResult stateResult) {
        this.stateResult = stateResult;
    }

}
