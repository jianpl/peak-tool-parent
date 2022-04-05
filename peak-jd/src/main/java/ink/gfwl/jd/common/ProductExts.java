package ink.gfwl.jd.common;

/**
 * 商品维度扩展字段
 * <div>商品维度扩展字段，当入参输入某个扩展字段后，出参会返回该字段对应的出参。可以根据需要选用。</div>
 * @author jianpòlan
 * @version 1.0
 **/
@SuppressWarnings("ALL")
public enum ProductExts {

    /**
     * 中国法分类（仅限图书商品使用）
     */
    ChinaCatalog,
    /**
     * 商品最低起购量（若要起到下单有限制，需要联系运营有邮件配置）
     */
    LowestBuy,
    /**
     * 容量单位转换（例如：油品单位桶转升）
     */
    capacity,
    /**
     * 获取客户侧分类编号，需要京东运营维护京东SKU与客户分类编号的映射
     */
    contractSkuExt,
    /**
     * 商品池扩展字段
     */
    contractSkuPoolExt,
    /**
     * 是否节能环保商品
     */
    isEnergySaving,
    /**
     * 是否厂直商品
     */
    isFactoryShip,
    /**
     * 是否京东配送
     */
    isJDLogistics,
    /**
     * 是否自营
     */
    isSelf,
    /**
     * 移动端商品详情大字段
     */
    nappintroduction,
    /**
     * PC端商品详情大字段
     */
    nintroduction,
    /**
     * SPU名称
     */
    pName,
    /**
     * 获取结构化商品属性数据(同京东官网样式)
     */
    paramDetailJson,
    /**
     * 转商详接口出参param为json格式(只解析原出参param)
     */
    paramJson,
    /**
     * 图书产品特色
     */
    productFeatures,
    /**
     * 规格参数
     */
    seoModel, 
    /**
     * 京东侧模拟SPU号
     */
    spuId,
    /**
     * 京东侧税收分类编码
     */
    taxCode,
    /**
     * 商品税率
     */
    taxInfo,
    /**
     * 商品69条码
     */
    upc69,
    /**
     * 质保信息
     */
    wserve,
    /**
     * 微信小程序商品详情大字段，仅提供图片地址，需要客户添加显示逻辑
     */
    wxintroduction;


}
