package ink.gfwl.jd.model.product.params;

import java.io.Serializable;

/**
 * 库存查询参数
 * @author jianpòlan
 * @version 1.0
 **/
public class ProductCostParam implements Serializable {

    private Integer province;
    private Integer city;
    private Integer county;
    private Integer town;

    /**
     * Sets the province
     * <p>You can use getProvince() to get the value of province</p>
     *
     * @param province province
     */
    public void setProvince(Integer province) {
        this.province = province;
    }

    /**
     * Sets the city
     * <p>You can use getCity() to get the value of city</p>
     *
     * @param city city
     */
    public void setCity(Integer city) {
        this.city = city;
    }

    /**
     * Sets the county
     * <p>You can use getCounty() to get the value of county</p>
     *
     * @param county county
     */
    public void setCounty(Integer county) {
        this.county = county;
    }

    /**
     * Sets the town
     * <p>You can use getTown() to get the value of town</p>
     *
     * @param town town
     */
    public void setTown(Integer town) {
        this.town = town;
    }

    public String getArea(){
        return String.format("%d_%d_%d_%d", province, city, county, town);
    }
}
