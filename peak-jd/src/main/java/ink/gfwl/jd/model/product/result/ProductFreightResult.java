package ink.gfwl.jd.model.product.result;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 运费
 * @author jianpòlan
 * @version 1.0
 **/
public class ProductFreightResult implements Serializable {

    private static final long serialVersionUID = 6082085332200818227L;
    /**
     * 总运费
     */
    private BigDecimal freight;
    /**
     * 基础运费
     */
    private BigDecimal baseFreight;
    /**
     * 偏远地区加收运费
     */
    private BigDecimal remoteRegionFreight;
    /**
     * 需收取偏远运费的sku
     */
    private String remoteSku;
    /**
     * 续重运费
     */
    private BigDecimal conFreight;

    /**
     * Gets the value of freight
     *
     * @return the value of freight
     */
    public BigDecimal getFreight() {
        return freight;
    }

    /**
     * Sets the freight
     * <p>You can use getFreight() to get the value of freight</p>
     *
     * @param freight freight
     */
    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    /**
     * Gets the value of baseFreight
     *
     * @return the value of baseFreight
     */
    public BigDecimal getBaseFreight() {
        return baseFreight;
    }

    /**
     * Sets the baseFreight
     * <p>You can use getBaseFreight() to get the value of baseFreight</p>
     *
     * @param baseFreight baseFreight
     */
    public void setBaseFreight(BigDecimal baseFreight) {
        this.baseFreight = baseFreight;
    }

    /**
     * Gets the value of remoteRegionFreight
     *
     * @return the value of remoteRegionFreight
     */
    public BigDecimal getRemoteRegionFreight() {
        return remoteRegionFreight;
    }

    /**
     * Sets the remoteRegionFreight
     * <p>You can use getRemoteRegionFreight() to get the value of remoteRegionFreight</p>
     *
     * @param remoteRegionFreight remoteRegionFreight
     */
    public void setRemoteRegionFreight(BigDecimal remoteRegionFreight) {
        this.remoteRegionFreight = remoteRegionFreight;
    }

    /**
     * Gets the value of remoteSku
     *
     * @return the value of remoteSku
     */
    public String getRemoteSku() {
        return remoteSku;
    }

    /**
     * Sets the remoteSku
     * <p>You can use getRemoteSku() to get the value of remoteSku</p>
     *
     * @param remoteSku remoteSku
     */
    public void setRemoteSku(String remoteSku) {
        this.remoteSku = remoteSku;
    }

    /**
     * Gets the value of conFreight
     *
     * @return the value of conFreight
     */
    public BigDecimal getConFreight() {
        return conFreight;
    }

    /**
     * Sets the conFreight
     * <p>You can use getConFreight() to get the value of conFreight</p>
     *
     * @param conFreight conFreight
     */
    public void setConFreight(BigDecimal conFreight) {
        this.conFreight = conFreight;
    }
}
