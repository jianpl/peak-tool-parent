package ink.gfwl.jd.common;

/**
 * 商品价格查询扩展参数
 * @author jianpòlan
 * @version 1.0
 **/
public enum ProductPriceExts {

    /**
     * 大客户默认价格(根据合同类型查询价格)
     */
    Price,
    /**
     * 市场价
     */
    marketPrice,
    /**
     * 税率。出参增加tax,taxPrice,nakedPrice 3个字段
     */
    containsTax,
    /**
     * 未税价。出参增加nakedPrice字段(加此入参时，出参price也是未税价，此时price= nakedPrice，
     * 那返回的price值无获取意义，拓展参数不建议加此字段)
     */
    nakedPrice

}
