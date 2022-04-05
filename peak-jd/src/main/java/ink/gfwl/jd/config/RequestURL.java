package ink.gfwl.jd.config;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
public class RequestURL {

    protected final String REDIS_TOKEN_KEY = "peak:jd:token";

    //接口地址
    protected final String URL_BASE = "https://bizapi.jd.com";

    // 获取token
    protected final String URL_ACCESS_TOKEN = URL_BASE + "/oauth2/access_token";

    // 刷新token
    protected final String URL_REFRESH_TOKEN = URL_BASE + "/oauth2/refresh_token";

    //一级地址
    protected final String URL_ADDRESS_PROVINCE = URL_BASE + "/api/area/getProvince";
    //二级地址
    protected final String URL_ADDRESS_CITY = URL_BASE + "/api/area/getCity";
    // 三级地址
    protected final String URL_ADDRESS_COUNTRY = URL_BASE + "/api/area/getCounty";
    // 四级地址
    protected final String URL_ADDRESS_TOWN = URL_BASE + "/api/area/getTown";
    // 检查地址有效性
    protected final String URL_ADDRESS_CHECK = URL_BASE + "/api/area/checkArea";
    // 地址转换
    protected final String URL_ADDRESS_CAST = URL_BASE + "/api/area/getJDAddressFromAddress";
    // 查询商品池编号
    protected final String URL_PRODUCT_NUM = URL_BASE + "/api/product/getPageNum";
    // 查询池内商品编号
    protected final String URL_PRODUCT_SKU_PAGE = URL_BASE + "/api/product/querySkuByPage";
    // 查询商品详情
    protected final String URL_PRODUCT_DETAIL = URL_BASE + "/api/product/getDetail";
    // 查询商品详情装吧样式
    protected final String URL_PRODUCT_DETAIL_STYLE = URL_BASE + "/api/product/getDetailStyle";
    // 查询商品图片
    protected final String URL_PRODUCT_IMAGE = URL_BASE + "/api/product/skuImage";
    // 查询商品可售性
    protected final String URL_PRODUCT_CHECK = URL_BASE + "/api/product/check";
    // 查询商品地区限制
    protected final String URL_PRODUCT_AREA_LIMIT = URL_BASE + "/api/product/checkAreaLimit";
    // 查询分类信息
    protected final String URL_PRODUCT_CATEGORY = URL_BASE + "/api/product/getCategory";
    // 查询商品卖价
    protected final String URL_PRODUCT_SELL_PRICE = URL_BASE + "/api/price/getSellPrice";
    // 查询商品库存
    protected final String URL_PRODUCT_STOCK = URL_BASE + "/api/stock/getNewStockById";
    // 查询运费
    protected final String URL_PRODUCT_FREIGHT = URL_BASE + "/api/order/getFreight";
    // 提交订单
    protected final String URL_ORDER_SUBMITORDER = URL_BASE + "/api/order/submitOrder";
    // 反查订单
    protected final String URL_ORDER_QUERY_BY_THIRD = URL_BASE + "/api/order/selectJdOrderIdByThirdOrder";
}
