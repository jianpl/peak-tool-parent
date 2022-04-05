package ink.gfwl.jd.model.product.base;

import java.io.Serializable;

/**
 * 商品扩展参数
 * <p>若查询商品详情未传扩展，则下列中无值</p>
 * @author jianpòlan
 * @version 1.0
 */
public class ProductExtsProperties implements Serializable {

    /**
     * 中国法分类（仅限图书商品使用）
     */
    private String ChinaCatalog;
    /**
     * 商品最低起购量（若要起到下单有限制，需要联系运营有邮件配置）
     */
    private String LowestBuy;
    /**
     * 容量单位转换（例如：油品单位桶转升）
     */
    private String capacity;
    /**
     * 获取客户侧分类编号，需要京东运营维护京东SKU与客户分类编号的映射
     */
    private String contractSkuExt;
    /**
     * 商品池扩展字段
     */
    private String contractSkuPoolExt;
    /**
     * 是否节能环保商品
     */
    private String isEnergySaving;
    /**
     * 是否厂直商品
     */
    private String isFactoryShip;
    /**
     * 是否京东配送
     */
    private String isJDLogistics;
    /**
     * 是否自营
     */
    private String isSelf;
    /**
     * 移动端商品详情大字段
     */
    private String nappintroduction;
    /**
     * PC端商品详情大字段
     */
    private String nintroduction;
    /**
     * SPU名称
     */
    private String pName;
    /**
     * 获取结构化商品属性数据(同京东官网样式)
     */
    private String paramDetailJson;
    /**
     * 转商详接口出参param为json格式(只解析原出参param)
     */
    private String paramJson;
    /**
     * 图书产品特色
     */
    private String productFeatures;
    /**
     * 规格参数
     */
    private String seoModel;
    /**
     * 京东侧模拟SPU号
     */
    private String spuId;
    /**
     * 京东侧税收分类编码
     */
    private String taxCode;
    /**
     * 商品税率
     */
    private String taxInfo;
    /**
     * 商品69条码
     */
    private String upc69;
    /**
     * 质保信息
     */
    private String wserve;
    /**
     * 微信小程序商品详情大字段，仅提供图片地址，需要客户添加显示逻辑
     */
    private String wxintroduction;

    /**
     * Gets the value of ChinaCatalog
     *
     * @return the value of ChinaCatalog
     */
    public String getChinaCatalog() {
        return ChinaCatalog;
    }

    /**
     * Sets the ChinaCatalog
     * <p>You can use getChinaCatalog() to get the value of ChinaCatalog</p>
     *
     * @param chinaCatalog ChinaCatalog
     */
    public void setChinaCatalog(String chinaCatalog) {
        ChinaCatalog = chinaCatalog;
    }

    /**
     * Gets the value of LowestBuy
     *
     * @return the value of LowestBuy
     */
    public String getLowestBuy() {
        return LowestBuy;
    }

    /**
     * Sets the LowestBuy
     * <p>You can use getLowestBuy() to get the value of LowestBuy</p>
     *
     * @param lowestBuy LowestBuy
     */
    public void setLowestBuy(String lowestBuy) {
        LowestBuy = lowestBuy;
    }

    /**
     * Gets the value of capacity
     *
     * @return the value of capacity
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * Sets the capacity
     * <p>You can use getCapacity() to get the value of capacity</p>
     *
     * @param capacity capacity
     */
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets the value of contractSkuExt
     *
     * @return the value of contractSkuExt
     */
    public String getContractSkuExt() {
        return contractSkuExt;
    }

    /**
     * Sets the contractSkuExt
     * <p>You can use getContractSkuExt() to get the value of contractSkuExt</p>
     *
     * @param contractSkuExt contractSkuExt
     */
    public void setContractSkuExt(String contractSkuExt) {
        this.contractSkuExt = contractSkuExt;
    }

    /**
     * Gets the value of contractSkuPoolExt
     *
     * @return the value of contractSkuPoolExt
     */
    public String getContractSkuPoolExt() {
        return contractSkuPoolExt;
    }

    /**
     * Sets the contractSkuPoolExt
     * <p>You can use getContractSkuPoolExt() to get the value of contractSkuPoolExt</p>
     *
     * @param contractSkuPoolExt contractSkuPoolExt
     */
    public void setContractSkuPoolExt(String contractSkuPoolExt) {
        this.contractSkuPoolExt = contractSkuPoolExt;
    }

    /**
     * Gets the value of isEnergySaving
     *
     * @return the value of isEnergySaving
     */
    public String getIsEnergySaving() {
        return isEnergySaving;
    }

    /**
     * Sets the isEnergySaving
     * <p>You can use getIsEnergySaving() to get the value of isEnergySaving</p>
     *
     * @param isEnergySaving isEnergySaving
     */
    public void setIsEnergySaving(String isEnergySaving) {
        this.isEnergySaving = isEnergySaving;
    }

    /**
     * Gets the value of isFactoryShip
     *
     * @return the value of isFactoryShip
     */
    public String getIsFactoryShip() {
        return isFactoryShip;
    }

    /**
     * Sets the isFactoryShip
     * <p>You can use getIsFactoryShip() to get the value of isFactoryShip</p>
     *
     * @param isFactoryShip isFactoryShip
     */
    public void setIsFactoryShip(String isFactoryShip) {
        this.isFactoryShip = isFactoryShip;
    }

    /**
     * Gets the value of isJDLogistics
     *
     * @return the value of isJDLogistics
     */
    public String getIsJDLogistics() {
        return isJDLogistics;
    }

    /**
     * Sets the isJDLogistics
     * <p>You can use getIsJDLogistics() to get the value of isJDLogistics</p>
     *
     * @param isJDLogistics isJDLogistics
     */
    public void setIsJDLogistics(String isJDLogistics) {
        this.isJDLogistics = isJDLogistics;
    }

    /**
     * Gets the value of isSelf
     *
     * @return the value of isSelf
     */
    public String getIsSelf() {
        return isSelf;
    }

    /**
     * Sets the isSelf
     * <p>You can use getIsSelf() to get the value of isSelf</p>
     *
     * @param isSelf isSelf
     */
    public void setIsSelf(String isSelf) {
        this.isSelf = isSelf;
    }

    /**
     * Gets the value of nappintroduction
     *
     * @return the value of nappintroduction
     */
    public String getNappintroduction() {
        return nappintroduction;
    }

    /**
     * Sets the nappintroduction
     * <p>You can use getNappintroduction() to get the value of nappintroduction</p>
     *
     * @param nappintroduction nappintroduction
     */
    public void setNappintroduction(String nappintroduction) {
        this.nappintroduction = nappintroduction;
    }

    /**
     * Gets the value of nintroduction
     *
     * @return the value of nintroduction
     */
    public String getNintroduction() {
        return nintroduction;
    }

    /**
     * Sets the nintroduction
     * <p>You can use getNintroduction() to get the value of nintroduction</p>
     *
     * @param nintroduction nintroduction
     */
    public void setNintroduction(String nintroduction) {
        this.nintroduction = nintroduction;
    }

    /**
     * Gets the value of pName
     *
     * @return the value of pName
     */
    public String getpName() {
        return pName;
    }

    /**
     * Sets the pName
     * <p>You can use getpName() to get the value of pName</p>
     *
     * @param pName pName
     */
    public void setpName(String pName) {
        this.pName = pName;
    }

    /**
     * Gets the value of paramDetailJson
     *
     * @return the value of paramDetailJson
     */
    public String getParamDetailJson() {
        return paramDetailJson;
    }

    /**
     * Sets the paramDetailJson
     * <p>You can use getParamDetailJson() to get the value of paramDetailJson</p>
     *
     * @param paramDetailJson paramDetailJson
     */
    public void setParamDetailJson(String paramDetailJson) {
        this.paramDetailJson = paramDetailJson;
    }

    /**
     * Gets the value of paramJson
     *
     * @return the value of paramJson
     */
    public String getParamJson() {
        return paramJson;
    }

    /**
     * Sets the paramJson
     * <p>You can use getParamJson() to get the value of paramJson</p>
     *
     * @param paramJson paramJson
     */
    public void setParamJson(String paramJson) {
        this.paramJson = paramJson;
    }

    /**
     * Gets the value of productFeatures
     *
     * @return the value of productFeatures
     */
    public String getProductFeatures() {
        return productFeatures;
    }

    /**
     * Sets the productFeatures
     * <p>You can use getProductFeatures() to get the value of productFeatures</p>
     *
     * @param productFeatures productFeatures
     */
    public void setProductFeatures(String productFeatures) {
        this.productFeatures = productFeatures;
    }

    /**
     * Gets the value of seoModel
     *
     * @return the value of seoModel
     */
    public String getSeoModel() {
        return seoModel;
    }

    /**
     * Sets the seoModel
     * <p>You can use getSeoModel() to get the value of seoModel</p>
     *
     * @param seoModel seoModel
     */
    public void setSeoModel(String seoModel) {
        this.seoModel = seoModel;
    }

    /**
     * Gets the value of spuId
     *
     * @return the value of spuId
     */
    public String getSpuId() {
        return spuId;
    }

    /**
     * Sets the spuId
     * <p>You can use getSpuId() to get the value of spuId</p>
     *
     * @param spuId spuId
     */
    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    /**
     * Gets the value of taxCode
     *
     * @return the value of taxCode
     */
    public String getTaxCode() {
        return taxCode;
    }

    /**
     * Sets the taxCode
     * <p>You can use getTaxCode() to get the value of taxCode</p>
     *
     * @param taxCode taxCode
     */
    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    /**
     * Gets the value of taxInfo
     *
     * @return the value of taxInfo
     */
    public String getTaxInfo() {
        return taxInfo;
    }

    /**
     * Sets the taxInfo
     * <p>You can use getTaxInfo() to get the value of taxInfo</p>
     *
     * @param taxInfo taxInfo
     */
    public void setTaxInfo(String taxInfo) {
        this.taxInfo = taxInfo;
    }

    /**
     * Gets the value of upc69
     *
     * @return the value of upc69
     */
    public String getUpc69() {
        return upc69;
    }

    /**
     * Sets the upc69
     * <p>You can use getUpc69() to get the value of upc69</p>
     *
     * @param upc69 upc69
     */
    public void setUpc69(String upc69) {
        this.upc69 = upc69;
    }

    /**
     * Gets the value of wserve
     *
     * @return the value of wserve
     */
    public String getWserve() {
        return wserve;
    }

    /**
     * Sets the wserve
     * <p>You can use getWserve() to get the value of wserve</p>
     *
     * @param wserve wserve
     */
    public void setWserve(String wserve) {
        this.wserve = wserve;
    }

    /**
     * Gets the value of wxintroduction
     *
     * @return the value of wxintroduction
     */
    public String getWxintroduction() {
        return wxintroduction;
    }

    /**
     * Sets the wxintroduction
     * <p>You can use getWxintroduction() to get the value of wxintroduction</p>
     *
     * @param wxintroduction wxintroduction
     */
    public void setWxintroduction(String wxintroduction) {
        this.wxintroduction = wxintroduction;
    }
}
