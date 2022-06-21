package ink.gfwl.jd.model.order.params;

import java.io.Serializable;

/**
 * 下单必填参数
 * @author jianpòlan
 * @version 1.0
 **/
public class OrderBaseRequireParam implements Serializable {

    /**
     * 是	第三方的订单单号，必须在100字符以内
     */
    private String thirdOrder;

    /**
     * 是	下单商品信息
     * Json数组类型的字符串，参数格式：[{"skuId":商品编号, "num":商品数量, "price":10,"bNeedGift":false, "yanbao":[{"skuId":商品编号}]}]
     * (最高支持100种商品)
     */
    private String sku;

    /**
     * 是	收货人姓名
     */
    private String name;

    /**
     * 是	一级地址编码：收货人省份地址编码
     */
    private Integer province;

    /**
     * 是	二级地址编码：收货人市级地址编码
     */
    private Integer city;

    /**
     * 是	三级地址编码：收货人县（区）级地址编码
     */
    private Integer county;

    /**
     * 是	四级地址编码：收货人乡镇地址编码(如果该地区有四级地址，则必须传递四级地址，没有四级地址则传0)
     */
    private Integer town;

    /**
     * 是	收货人详细地址，最多100个字符
     */
    private String address;

    /**
     * 是	手机号，最多20个字符
     */
    private String mobile;

    /**
     * 是	邮箱
     */
    private String email;

    /**
     * 是	开票方式(2为集中开票，4 订单完成后开票)
     */
    private Integer invoiceState;

    /**
     * 是	发票类型（2增值税专用发票；3 电子票）
     * 当发票类型为2时，开票方式只支持2集中开票
     */
    private Integer invoiceType;

    /**
     * 是	发票类型：4：个人，5：单位
     */
    private String selectedInvoiceTitle;

    /**
     * 是	1:明细，100：大类
     * 备注:若增值税专用发票则只能选1 明细
     */
    private String invoiceContent;

    /**
     * 是   支付方式枚举值
     * 1：货到付款
     * 4：预存款
     * 5：公司转账
     * 101：京东金采
     * 102：商城金采(一般不适用，仅限确认开通商城账期的特殊情况使用，请与业务确认后使用)
     * 20为混合支付
     */
    private Integer paymentType;

    /**
     * 是	使用余额paymentType=4时，此值固定是1
     * 其他支付方式0
     */
    private Integer isUseBalance;

    /**
     * 是	是否预占库存，0是预占库存（需要调用确认订单接口），1是不预占库存，直接进入生产
     */
    private Integer submitState;

    private String invoicePhone;

    /**
     * 是	专票资质公司名称
     * 该字段必填。
     */
    private String regCompanyName;
    /**
     * 是	专票资质纳税人识别号
     * 该字段必填。
     */
    private String regCode;

    /**
     * Gets the value of thirdOrder
     *
     * @return the value of thirdOrder
     */
    public String getThirdOrder() {
        return thirdOrder;
    }

    /**
     * Sets the thirdOrder
     * <p>You can use getThirdOrder() to get the value of thirdOrder</p>
     *
     * @param thirdOrder thirdOrder
     */
    public void setThirdOrder(String thirdOrder) {
        this.thirdOrder = thirdOrder;
    }

    /**
     * Gets the value of sku
     *
     * @return the value of sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * Sets the sku
     * <p>You can use getSku() to get the value of sku</p>
     *
     * @param sku sku
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Gets the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * <p>You can use getName() to get the value of name</p>
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of province
     *
     * @return the value of province
     */
    public Integer getProvince() {
        return province;
    }

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
     * Gets the value of city
     *
     * @return the value of city
     */
    public Integer getCity() {
        return city;
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
     * Gets the value of county
     *
     * @return the value of county
     */
    public Integer getCounty() {
        return county;
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
     * Gets the value of town
     *
     * @return the value of town
     */
    public Integer getTown() {
        return town;
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

    /**
     * Gets the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address
     * <p>You can use getAddress() to get the value of address</p>
     *
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the value of mobile
     *
     * @return the value of mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the mobile
     * <p>You can use getMobile() to get the value of mobile</p>
     *
     * @param mobile mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email
     * <p>You can use getEmail() to get the value of email</p>
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the value of invoiceState
     *
     * @return the value of invoiceState
     */
    public Integer getInvoiceState() {
        return invoiceState;
    }

    /**
     * Sets the invoiceState
     * <p>You can use getInvoiceState() to get the value of invoiceState</p>
     *
     * @param invoiceState invoiceState
     */
    public void setInvoiceState(Integer invoiceState) {
        this.invoiceState = invoiceState;
    }

    /**
     * Gets the value of invoiceType
     *
     * @return the value of invoiceType
     */
    public Integer getInvoiceType() {
        return invoiceType;
    }

    /**
     * Sets the invoiceType
     * <p>You can use getInvoiceType() to get the value of invoiceType</p>
     *
     * @param invoiceType invoiceType
     */
    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    /**
     * Gets the value of selectedInvoiceTitle
     *
     * @return the value of selectedInvoiceTitle
     */
    public String getSelectedInvoiceTitle() {
        return selectedInvoiceTitle;
    }

    /**
     * Sets the selectedInvoiceTitle
     * <p>You can use getSelectedInvoiceTitle() to get the value of selectedInvoiceTitle</p>
     *
     * @param selectedInvoiceTitle selectedInvoiceTitle
     */
    public void setSelectedInvoiceTitle(String selectedInvoiceTitle) {
        this.selectedInvoiceTitle = selectedInvoiceTitle;
    }

    /**
     * Gets the value of invoiceContent
     *
     * @return the value of invoiceContent
     */
    public String getInvoiceContent() {
        return invoiceContent;
    }

    /**
     * Sets the invoiceContent
     * <p>You can use getInvoiceContent() to get the value of invoiceContent</p>
     *
     * @param invoiceContent invoiceContent
     */
    public void setInvoiceContent(String invoiceContent) {
        this.invoiceContent = invoiceContent;
    }

    /**
     * Gets the value of paymentType
     *
     * @return the value of paymentType
     */
    public Integer getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the paymentType
     * <p>You can use getPaymentType() to get the value of paymentType</p>
     *
     * @param paymentType paymentType
     */
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * Gets the value of isUseBalance
     *
     * @return the value of isUseBalance
     */
    public Integer getIsUseBalance() {
        return isUseBalance;
    }

    /**
     * Sets the isUseBalance
     * <p>You can use getIsUseBalance() to get the value of isUseBalance</p>
     *
     * @param isUseBalance isUseBalance
     */
    public void setIsUseBalance(Integer isUseBalance) {
        this.isUseBalance = isUseBalance;
    }

    /**
     * Gets the value of submitState
     *
     * @return the value of submitState
     */
    public Integer getSubmitState() {
        return submitState;
    }

    /**
     * Sets the submitState
     * <p>You can use getSubmitState() to get the value of submitState</p>
     *
     * @param submitState submitState
     */
    public void setSubmitState(Integer submitState) {
        this.submitState = submitState;
    }

    /**
     * Gets the value of invoicePhone
     *
     * @return the value of invoicePhone
     */
    public String getInvoicePhone() {
        return invoicePhone;
    }

    /**
     * Sets the invoicePhone
     * <p>You can use getInvoicePhone() to get the value of invoicePhone</p>
     *
     * @param invoicePhone invoicePhone
     */
    public void setInvoicePhone(String invoicePhone) {
        this.invoicePhone = invoicePhone;
    }

    /**
     * Gets the value of regCompanyName
     *
     * @return the value of regCompanyName
     */
    public String getRegCompanyName() {
        return regCompanyName;
    }

    /**
     * Sets the regCompanyName
     * <p>You can use getRegCompanyName() to get the value of regCompanyName</p>
     *
     * @param regCompanyName regCompanyName
     */
    public void setRegCompanyName(String regCompanyName) {
        this.regCompanyName = regCompanyName;
    }

    /**
     * Gets the value of regCode
     *
     * @return the value of regCode
     */
    public String getRegCode() {
        return regCode;
    }

    /**
     * Sets the regCode
     * <p>You can use getRegCode() to get the value of regCode</p>
     *
     * @param regCode regCode
     */
    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }
}
