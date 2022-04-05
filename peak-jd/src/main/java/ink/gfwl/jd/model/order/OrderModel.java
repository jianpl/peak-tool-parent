package ink.gfwl.jd.model.order;

import ink.gfwl.jd.base.BaseModel;

/**
 * 订单基类
 * @author jianpòlan
 * @version 1.0
 **/
public class OrderModel<T> extends BaseModel {

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
