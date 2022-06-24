package ink.gfwl.common.lang;

import java.util.function.Supplier;

/**
 * 断言
 *
 * @author jianpòlan
 * @version 1.0.1
 * <p>url: https://github.com/jianpl/peak-tool-parent</p>
 */
public class Affirm {

    /**
     * object为空抛出异常
     *
     * @param object 值
     * @param errorSupplier 异常
     * @param <X> 异常
     * @throws X 异常
     */
    public static <X extends Throwable> void isNull(Object object, Supplier<X> errorSupplier) throws X {
        if (null == object) {
            throw errorSupplier.get();
        }
    }

    /**
     * object不为空抛出异常
     *
     * @param object 值
     * @param errorSupplier 异常
     * @param <X> 异常
     * @throws X 异常
     */
    public static <X extends Throwable> void notNull(Object object, Supplier<X> errorSupplier) throws X {
        if (null != object) {
            throw errorSupplier.get();
        }
    }

    /**
     * 为true抛出异常
     *
     * @param expression 值
     * @param errorSupplier 异常
     * @param <X> 异常
     * @throws X 异常
     */
    public static <X extends Throwable> void isTrue(boolean expression, Supplier<X> errorSupplier) throws X {
        if (expression) {
            throw errorSupplier.get();
        }
    }

    /**
     * 为false抛出异常
     *
     * @param expression 值
     * @param errorSupplier 异常
     * @param <X> 异常
     * @throws X 异常
     */
    public static <X extends Throwable> void isFalse(boolean expression, Supplier<X> errorSupplier) throws X {
        if (!expression) {
            throw errorSupplier.get();
        }
    }

}
