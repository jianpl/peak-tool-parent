package ink.gfwl.jd.model.product.result;

import java.io.Serializable;
import java.util.List;

/**
 * @author jianpòlan
 * @version 1.0
 **/
public class ProductSkuPageResult implements Serializable {

    private static final long serialVersionUID = -4437439293370451037L;
    /**
     * 剩余页数,如果=0，表示该池子已查完
     */
    private int remainPage;

    /**
     * skuId集合
     */
    private List<Long> skus;

    /**
     * 在下一次查询时使用（偏移量）
     */
    private long offset;

    public int getRemainPage() {
        return remainPage;
    }

    public void setRemainPage(int remainPage) {
        this.remainPage = remainPage;
    }

    public List<Long> getSkus() {
        return skus;
    }

    public void setSkus(List<Long> skus) {
        this.skus = skus;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }
}
