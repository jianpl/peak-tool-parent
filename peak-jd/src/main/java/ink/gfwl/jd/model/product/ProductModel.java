package ink.gfwl.jd.model.product;

import ink.gfwl.jd.base.BaseModel;

/**
 * 产品基类
 * @author jianpòlan
 * @version 1.0
 **/
public class ProductModel<T> extends BaseModel {

    private static final long serialVersionUID = 3807875064352246945L;
    private T result;

    /**
     * Gets the value of result
     *
     * @return the value of result
     */
    public T getResult() {
        return result;
    }

    /**
     * Sets the result
     * <p>You can use getResult() to get the value of result</p>
     *
     * @param result result
     */
    public void setResult(T result) {
        this.result = result;
    }
}
