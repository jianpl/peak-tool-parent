package ink.gfwl.jd.model.order.params;

import java.io.Serializable;

/**
 * 提交订单请求参数
 * @author jianpòlan
 * @version 1.0
 **/
public class OrderSubmitParam implements Serializable {

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
     * 否	邮编，最多20个字符
     */
    private String zip;
    /**
     * 否	座机号，最多20个字符
     */
    private String phone;

    /**
     * 是	手机号，最多20个字符
     */
    private String mobile;

    /**
     * 是	邮箱
     */
    private String email;

    /**
     * 否	备注（少于100字）
     */
    private String remark;

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
     * 否	发票抬头  (如果selectedInvoiceTitle=5则此字段必须) 需regCompanyName跟此字段传递一致
     */
    private String companyName;

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
     * 否   注意
     * 支付明细，
     * 当paymentType为20时候必须递此字段
     * flag为区分字段
     * 枚举：1 为个人，2为企业
     * paymentType为 支付类型
     * 枚举定义：
     * 17, "微信支付"
     * 101, "金采支付",
     * 4,“预存款”
     * payMoney为支付金额 details
     * 单位：元
     * [
     *     {
     *         "payMoney":20,
     *         "paymentType":"17",
     *         "flag":"1"
     *     },
     *     {
     *         "payMoney":80,
     *         "paymentType":"4",
     *         "flag":"2"
     *     }
     */
    private String payDetails;

    /**
     * 是	使用余额paymentType=4时，此值固定是1
     * 其他支付方式0
     */
    private Integer isUseBalance;

    /**
     * 是	是否预占库存，0是预占库存（需要调用确认订单接口），1是不预占库存，直接进入生产
     */
    private Integer submitState;

    /**
     * 否   增专票收票人姓名
     */
    private String invoiceName;

    /**
     * 是	收票人电话
     */
    private String invoicePhone;

    /**
     * 否	增专票收票人所在省(京东地址编码)
     * 选填
     */
    private Integer invoiceProvice;
    /**
     * 否	增专票收票人所在市(京东地址编码)
     * 选填。
     */
    private Integer invoiceCity;
    /**
     * 否	增专票收票人所在区/县(京东地址编码)
     * 选填。
     */
    private Integer invoiceCounty;
    /**
     * 否	增专票收票人所在地址当invoiceType =2时，选填。
     */
    private String invoiceAddress;
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
     * 否	专票资质注册地址
     * 选填。
     */
    private String regAddr;
    /**
     * 否	专票资质注册电话
     * 选填。
     */
    private String regPhone;
    /**
     * 否	专票资质注册银行
     * 选填。
     */
    private String regBank;
    /**
     * 否	专票资质银行账号
     * 选填。
     */
    private String regBankAccount;
    /**
     * 否	大家电配送日期：默认值为-1，0表示当天，1表示明天，2：表示后天; 如果为-1表示不使用大家电预约日历
     */
    private Integer reservingDate;
    /**
     * 否	大家电安装日期：默认按-1处理，0表示当天，1表示明天，2：表示后天
     */
    private Integer installDate;
    /**
     * 否	是否选择了安装，默认为true，选择了“暂缓安装”，此为必填项，必填值为false。
     */
    private String needInstall;
    /**
     * 否	中小件配送预约日期，格式：yyyy-MM-dd
     */
    private String promiseDate;
    /**
     * 否	中小件配送预约时间段，时间段如： 9:00-15:00
     */
    private String promiseTimeRange;
    /**
     * 否	中小件预约时间段的标记
     */
    private Integer promiseTimeRangeCode;
    /**
     * 否	家电配送预约日期，格式：yyyy-MM-dd
     */
    private String reservedDateStr;
    /**
     * 否	大家电配送预约时间段，如果：9:00-15:00
     */
    private String reservedTimeRange;
    /**
     * 否	循环日历, 客户传入最近一周可配送的时间段,客户入参:{"3": "09:00-10:00,12:00-19:00","4": "09:00-15:00"}
     */
    private String cycleCalendar;
    /**
     * 否	采购单号，长度范围[1-26]
     */
    private String poNo;
    /**
     * 否	节假日不可配送，默认值为false，表示节假日可以配送，为true表示节假日不配送
     */
    private String validHolidayVocation;
    /**
     * 否	第三方平台采购人账号
     */
    private String thrPurchaserAccount;
    /**
     * 否	第三方平台采购人姓名
     */
    private String thrPurchaserName;
    /**
     * 否	第三方采购人电话（手机号，固定电话区号+号码）
     */
    private String thrPurchaserPhone;

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
     * Gets the value of zip
     *
     * @return the value of zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the zip
     * <p>You can use getZip() to get the value of zip</p>
     *
     * @param zip zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Gets the value of phone
     *
     * @return the value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone
     * <p>You can use getPhone() to get the value of phone</p>
     *
     * @param phone phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
     * Gets the value of remark
     *
     * @return the value of remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the remark
     * <p>You can use getRemark() to get the value of remark</p>
     *
     * @param remark remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
     * Gets the value of companyName
     *
     * @return the value of companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the companyName
     * <p>You can use getCompanyName() to get the value of companyName</p>
     *
     * @param companyName companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
     * Gets the value of payDetails
     *
     * @return the value of payDetails
     */
    public String getPayDetails() {
        return payDetails;
    }

    /**
     * Sets the payDetails
     * <p>You can use getPayDetails() to get the value of payDetails</p>
     *
     * @param payDetails payDetails
     */
    public void setPayDetails(String payDetails) {
        this.payDetails = payDetails;
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
     * Gets the value of invoiceName
     *
     * @return the value of invoiceName
     */
    public String getInvoiceName() {
        return invoiceName;
    }

    /**
     * Sets the invoiceName
     * <p>You can use getInvoiceName() to get the value of invoiceName</p>
     *
     * @param invoiceName invoiceName
     */
    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
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
     * Gets the value of invoiceProvice
     *
     * @return the value of invoiceProvice
     */
    public Integer getInvoiceProvice() {
        return invoiceProvice;
    }

    /**
     * Sets the invoiceProvice
     * <p>You can use getInvoiceProvice() to get the value of invoiceProvice</p>
     *
     * @param invoiceProvice invoiceProvice
     */
    public void setInvoiceProvice(Integer invoiceProvice) {
        this.invoiceProvice = invoiceProvice;
    }

    /**
     * Gets the value of invoiceCity
     *
     * @return the value of invoiceCity
     */
    public Integer getInvoiceCity() {
        return invoiceCity;
    }

    /**
     * Sets the invoiceCity
     * <p>You can use getInvoiceCity() to get the value of invoiceCity</p>
     *
     * @param invoiceCity invoiceCity
     */
    public void setInvoiceCity(Integer invoiceCity) {
        this.invoiceCity = invoiceCity;
    }

    /**
     * Gets the value of invoiceCounty
     *
     * @return the value of invoiceCounty
     */
    public Integer getInvoiceCounty() {
        return invoiceCounty;
    }

    /**
     * Sets the invoiceCounty
     * <p>You can use getInvoiceCounty() to get the value of invoiceCounty</p>
     *
     * @param invoiceCounty invoiceCounty
     */
    public void setInvoiceCounty(Integer invoiceCounty) {
        this.invoiceCounty = invoiceCounty;
    }

    /**
     * Gets the value of invoiceAddress
     *
     * @return the value of invoiceAddress
     */
    public String getInvoiceAddress() {
        return invoiceAddress;
    }

    /**
     * Sets the invoiceAddress
     * <p>You can use getInvoiceAddress() to get the value of invoiceAddress</p>
     *
     * @param invoiceAddress invoiceAddress
     */
    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
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

    /**
     * Gets the value of regAddr
     *
     * @return the value of regAddr
     */
    public String getRegAddr() {
        return regAddr;
    }

    /**
     * Sets the regAddr
     * <p>You can use getRegAddr() to get the value of regAddr</p>
     *
     * @param regAddr regAddr
     */
    public void setRegAddr(String regAddr) {
        this.regAddr = regAddr;
    }

    /**
     * Gets the value of regPhone
     *
     * @return the value of regPhone
     */
    public String getRegPhone() {
        return regPhone;
    }

    /**
     * Sets the regPhone
     * <p>You can use getRegPhone() to get the value of regPhone</p>
     *
     * @param regPhone regPhone
     */
    public void setRegPhone(String regPhone) {
        this.regPhone = regPhone;
    }

    /**
     * Gets the value of regBank
     *
     * @return the value of regBank
     */
    public String getRegBank() {
        return regBank;
    }

    /**
     * Sets the regBank
     * <p>You can use getRegBank() to get the value of regBank</p>
     *
     * @param regBank regBank
     */
    public void setRegBank(String regBank) {
        this.regBank = regBank;
    }

    /**
     * Gets the value of regBankAccount
     *
     * @return the value of regBankAccount
     */
    public String getRegBankAccount() {
        return regBankAccount;
    }

    /**
     * Sets the regBankAccount
     * <p>You can use getRegBankAccount() to get the value of regBankAccount</p>
     *
     * @param regBankAccount regBankAccount
     */
    public void setRegBankAccount(String regBankAccount) {
        this.regBankAccount = regBankAccount;
    }

    /**
     * Gets the value of reservingDate
     *
     * @return the value of reservingDate
     */
    public Integer getReservingDate() {
        return reservingDate;
    }

    /**
     * Sets the reservingDate
     * <p>You can use getReservingDate() to get the value of reservingDate</p>
     *
     * @param reservingDate reservingDate
     */
    public void setReservingDate(Integer reservingDate) {
        this.reservingDate = reservingDate;
    }

    /**
     * Gets the value of installDate
     *
     * @return the value of installDate
     */
    public Integer getInstallDate() {
        return installDate;
    }

    /**
     * Sets the installDate
     * <p>You can use getInstallDate() to get the value of installDate</p>
     *
     * @param installDate installDate
     */
    public void setInstallDate(Integer installDate) {
        this.installDate = installDate;
    }

    /**
     * Gets the value of needInstall
     *
     * @return the value of needInstall
     */
    public String getNeedInstall() {
        return needInstall;
    }

    /**
     * Sets the needInstall
     * <p>You can use getNeedInstall() to get the value of needInstall</p>
     *
     * @param needInstall needInstall
     */
    public void setNeedInstall(String needInstall) {
        this.needInstall = needInstall;
    }

    /**
     * Gets the value of promiseDate
     *
     * @return the value of promiseDate
     */
    public String getPromiseDate() {
        return promiseDate;
    }

    /**
     * Sets the promiseDate
     * <p>You can use getPromiseDate() to get the value of promiseDate</p>
     *
     * @param promiseDate promiseDate
     */
    public void setPromiseDate(String promiseDate) {
        this.promiseDate = promiseDate;
    }

    /**
     * Gets the value of promiseTimeRange
     *
     * @return the value of promiseTimeRange
     */
    public String getPromiseTimeRange() {
        return promiseTimeRange;
    }

    /**
     * Sets the promiseTimeRange
     * <p>You can use getPromiseTimeRange() to get the value of promiseTimeRange</p>
     *
     * @param promiseTimeRange promiseTimeRange
     */
    public void setPromiseTimeRange(String promiseTimeRange) {
        this.promiseTimeRange = promiseTimeRange;
    }

    /**
     * Gets the value of promiseTimeRangeCode
     *
     * @return the value of promiseTimeRangeCode
     */
    public Integer getPromiseTimeRangeCode() {
        return promiseTimeRangeCode;
    }

    /**
     * Sets the promiseTimeRangeCode
     * <p>You can use getPromiseTimeRangeCode() to get the value of promiseTimeRangeCode</p>
     *
     * @param promiseTimeRangeCode promiseTimeRangeCode
     */
    public void setPromiseTimeRangeCode(Integer promiseTimeRangeCode) {
        this.promiseTimeRangeCode = promiseTimeRangeCode;
    }

    /**
     * Gets the value of reservedDateStr
     *
     * @return the value of reservedDateStr
     */
    public String getReservedDateStr() {
        return reservedDateStr;
    }

    /**
     * Sets the reservedDateStr
     * <p>You can use getReservedDateStr() to get the value of reservedDateStr</p>
     *
     * @param reservedDateStr reservedDateStr
     */
    public void setReservedDateStr(String reservedDateStr) {
        this.reservedDateStr = reservedDateStr;
    }

    /**
     * Gets the value of reservedTimeRange
     *
     * @return the value of reservedTimeRange
     */
    public String getReservedTimeRange() {
        return reservedTimeRange;
    }

    /**
     * Sets the reservedTimeRange
     * <p>You can use getReservedTimeRange() to get the value of reservedTimeRange</p>
     *
     * @param reservedTimeRange reservedTimeRange
     */
    public void setReservedTimeRange(String reservedTimeRange) {
        this.reservedTimeRange = reservedTimeRange;
    }

    /**
     * Gets the value of cycleCalendar
     *
     * @return the value of cycleCalendar
     */
    public String getCycleCalendar() {
        return cycleCalendar;
    }

    /**
     * Sets the cycleCalendar
     * <p>You can use getCycleCalendar() to get the value of cycleCalendar</p>
     *
     * @param cycleCalendar cycleCalendar
     */
    public void setCycleCalendar(String cycleCalendar) {
        this.cycleCalendar = cycleCalendar;
    }

    /**
     * Gets the value of poNo
     *
     * @return the value of poNo
     */
    public String getPoNo() {
        return poNo;
    }

    /**
     * Sets the poNo
     * <p>You can use getPoNo() to get the value of poNo</p>
     *
     * @param poNo poNo
     */
    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    /**
     * Gets the value of validHolidayVocation
     *
     * @return the value of validHolidayVocation
     */
    public String getValidHolidayVocation() {
        return validHolidayVocation;
    }

    /**
     * Sets the validHolidayVocation
     * <p>You can use getValidHolidayVocation() to get the value of validHolidayVocation</p>
     *
     * @param validHolidayVocation validHolidayVocation
     */
    public void setValidHolidayVocation(String validHolidayVocation) {
        this.validHolidayVocation = validHolidayVocation;
    }

    /**
     * Gets the value of thrPurchaserAccount
     *
     * @return the value of thrPurchaserAccount
     */
    public String getThrPurchaserAccount() {
        return thrPurchaserAccount;
    }

    /**
     * Sets the thrPurchaserAccount
     * <p>You can use getThrPurchaserAccount() to get the value of thrPurchaserAccount</p>
     *
     * @param thrPurchaserAccount thrPurchaserAccount
     */
    public void setThrPurchaserAccount(String thrPurchaserAccount) {
        this.thrPurchaserAccount = thrPurchaserAccount;
    }

    /**
     * Gets the value of thrPurchaserName
     *
     * @return the value of thrPurchaserName
     */
    public String getThrPurchaserName() {
        return thrPurchaserName;
    }

    /**
     * Sets the thrPurchaserName
     * <p>You can use getThrPurchaserName() to get the value of thrPurchaserName</p>
     *
     * @param thrPurchaserName thrPurchaserName
     */
    public void setThrPurchaserName(String thrPurchaserName) {
        this.thrPurchaserName = thrPurchaserName;
    }

    /**
     * Gets the value of thrPurchaserPhone
     *
     * @return the value of thrPurchaserPhone
     */
    public String getThrPurchaserPhone() {
        return thrPurchaserPhone;
    }

    /**
     * Sets the thrPurchaserPhone
     * <p>You can use getThrPurchaserPhone() to get the value of thrPurchaserPhone</p>
     *
     * @param thrPurchaserPhone thrPurchaserPhone
     */
    public void setThrPurchaserPhone(String thrPurchaserPhone) {
        this.thrPurchaserPhone = thrPurchaserPhone;
    }
}
