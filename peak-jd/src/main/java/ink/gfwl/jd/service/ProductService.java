package ink.gfwl.jd.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ink.gfwl.jd.base.BaseQueryParam;
import ink.gfwl.jd.common.ProductCheckExts;
import ink.gfwl.jd.common.ProductExts;
import ink.gfwl.jd.common.ProductPriceExts;
import ink.gfwl.jd.common.ProductStyleExts;
import ink.gfwl.jd.config.RequestURL;
import ink.gfwl.jd.model.product.ProductModel;
import ink.gfwl.jd.model.product.result.*;
import ink.gfwl.jd.util.HttpUtil;
import ink.gfwl.jd.util.StrUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 商品
 * @author jianpòlan
 * @version 1.0
 **/
@Service
@SuppressWarnings("unchecked")
public class ProductService extends RequestURL {

    @Resource
    private BaseQueryParam baseQueryParam;

    /**
     * 1.查询商品池编号(分类栏目编号)
     * @return 商品池编号
     */
    public ProductModel<List<ProductNumberResult>> queryProductNumber(){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        String rs = HttpUtil.httpPost(URL_PRODUCT_NUM, params);
        return JSONObject.toJavaObject(JSON.parseObject(rs), ProductModel.class);
    }

    /**
     * 2.查询池内商品编号
     * @param pageNum 商品池编码
     * @param pageSize 每页大小，默认20，最大1000。建议 50 ~200
     * @param offset 偏移量，池id的首次查询传0，相同池id的后续请求赋值为上一次查询返回的偏移量
     */
    public ProductModel<ProductSkuPageResult> queryProductGoods(Integer pageNum, Integer pageSize, long offset){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);
        params.put("offset", offset);
        String rs = HttpUtil.httpPost(URL_PRODUCT_SKU_PAGE, params);
        return JSONObject.toJavaObject(JSON.parseObject(rs), ProductModel.class);
    }

    /**
     * 3.获取商品详情
     * @param sku 商品sku
     * @return 商品信息
     */
    public ProductModel<ProductMatterResult> queryProductDetail(String sku){
        return queryProductDetail(sku, null);
    }

    /**
     * 4.获取商品详情
     * @param sku 商品sku
     * @param productExts {@link ProductExts}
     * @return 商品信息
     */
    public ProductModel<ProductMatterResult> queryProductDetail(String sku, List<ProductExts> productExts){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        params.put("sku", sku);
        if(productExts != null){
            params.put("queryExts", StrUtils.enumArrConvertStr(productExts));
        }
        String rs = HttpUtil.httpPost(URL_PRODUCT_DETAIL, params);
        return JSONObject.toJavaObject(JSONObject.parseObject(rs), ProductModel.class);
    }

    /**
     * 5.查询商品详情装吧样式
     * @param sku 商品sku
     * @return 商品信息
     */
    public ProductModel<ProductMatterStyleResult> queryProductDetailStyle(String sku){
        return queryProductDetailStyle(sku, null);
    }

    /**
     * 6.查询商品详情装吧样式
     * @param sku 商品sku
     * @param styleExts {@link ProductStyleExts}
     * @return 商品信息
     */
    public ProductModel<ProductMatterStyleResult> queryProductDetailStyle(String sku, List<ProductStyleExts> styleExts){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        params.put("sku", sku);
        if(styleExts != null){
            params.put("queryExts", StrUtils.enumArrConvertStr(styleExts));
        }
        String rs = HttpUtil.httpPost(URL_PRODUCT_DETAIL_STYLE, params);
        return JSONObject.toJavaObject(JSONObject.parseObject(rs), ProductModel.class);
    }

    /**
     * 查询商品图片
     * @param sku 商品sku
     * @return 商品图片
     */
    public ProductModel<ProductImageResult> queryProductImage(String sku){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        params.put("sku", sku);
        String rs = HttpUtil.httpPost(URL_PRODUCT_IMAGE, params);
        return JSONObject.toJavaObject(JSONObject.parseObject(rs), ProductModel.class);
    }

    /**
     * 查询商品上下架状态
     * @param sku skuId
     * @return 上下架状态
     */
    public ProductModel<ProductStateResult> queryProductState(String sku){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        params.put("sku", sku);
        String rs = HttpUtil.httpPost(URL_PRODUCT_IMAGE, params);
        return JSONObject.toJavaObject(JSONObject.parseObject(rs), ProductModel.class);
    }

    /**
     * 4.6 验证商品可售性
     * @param skuIds 商品编号，支持批量，以，分隔  (最高支持100个商品)
     * @param queryExts 扩展参数：英文逗号间隔输入
     * @return 结果
     */
    public ProductModel<ProductCheckResult> queryProductCheck(String skuIds, List<ProductCheckExts> queryExts){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        params.put("skuIds", skuIds);
        if(queryExts != null){
            params.put("queryExts", StrUtils.enumArrConvertStr(queryExts));
        }
        String rs = HttpUtil.httpPost(URL_PRODUCT_CHECK, params);
        return JSONObject.toJavaObject(JSONObject.parseObject(rs), ProductModel.class);
    }

    /**
     * 4.7 查询商品区域购买限制
     * @param skuIds 商品编号，支持批量，以’,’分隔  (最高支持100个商品)
     * @param province 京东一级地址编号
     * @param city 京东二级地址编号
     * @param county 京东三级地址编号
     * @param town 京东四级地址编号
     * @return 结果
     */
    public ProductModel<ProductAreaLimitResult> queryProductAreaLimit(String skuIds, String province, String city,String county,String town){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        params.put("skuIds", skuIds);
        params.put("province", province);
        params.put("city", city);
        params.put("county", county);
        params.put("town", town);
        String rs = HttpUtil.httpPost(URL_PRODUCT_AREA_LIMIT, params);
        return JSONObject.toJavaObject(JSONObject.parseObject(rs), ProductModel.class);
    }

    /**
     * 查询分类信息
     * @param cid 分类id（可通过商品详情接口查询）
     * @return 分类结果
     */
    public ProductModel<ProductCategoryResult> queryProductCategory(String cid){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        params.put("cid", cid);
        String rs = HttpUtil.httpPost(URL_PRODUCT_CATEGORY, params);
        return JSONObject.toJavaObject(JSONObject.parseObject(rs), ProductModel.class);
    }

    /**
     * 5.1 查询商品售卖价
     * @param sku sku编号
     * @param queryExts 扩展查询
     * @return 结果
     */
    public ProductModel<ProductPriceResult> queryProductPrice(String sku, List<ProductPriceExts> queryExts){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        params.put("sku", sku);
        if(queryExts != null){
            params.put("queryExts", StrUtils.enumArrConvertStr(queryExts));
        }
        String rs = HttpUtil.httpPost(URL_PRODUCT_SELL_PRICE, params);
        return JSONObject.toJavaObject(JSONObject.parseObject(rs), ProductModel.class);
    }

    /**
     * 6.1 查询商品库存
     * @param skuNums 商品和数量  [{skuId: 569172,num:101}]。
     * “{skuId: 569172,num:10}”为1条记录，此参数最多传入100条记录。
     * @param area 格式：13_1000_4277_0 (分别代表1、2、3、4级地址)
     * @return 结果
     */
    public ProductModel<ProductStockResult> queryProductStock(String skuNums, String area){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        params.put("skuNums", skuNums);
        params.put("area", area);
        String rs = HttpUtil.httpPost(URL_PRODUCT_STOCK, params);
        return JSONObject.toJavaObject(JSONObject.parseObject(rs), ProductModel.class);
    }

    /**
     * 查询运费
     * @param sku [{“skuId”:商品编号1,”num”:商品数量1},{“skuId”:商品编号2,”num”:商品数量2}] （最多支持50种商品）
     * @param province 一级地址
     * @param city 二级地址
     * @param county 三级地址
     * @param town 四级地址  (如果该地区有四级地址，则必须传递四级地址，没有四级地址则传0)
     * @param paymentType 京东支付方式
     * @return 价格
     */
    public ProductModel<ProductFreightResult> queryProductFreight(String sku, int province, int city, int county, int town, int paymentType){
        return queryProductFreight(sku, province, city, county, town, paymentType, false);
    }

    /**
     * 查询运费
     * @param sku [{“skuId”:商品编号1,”num”:商品数量1},{“skuId”:商品编号2,”num”:商品数量2}] （最多支持50种商品）
     * @param province 一级地址
     * @param city 二级地址
     * @param county 三级地址
     * @param town 四级地址  (如果该地区有四级地址，则必须传递四级地址，没有四级地址则传0)
     * @param paymentType 京东支付方式
     * @param conFreight 是否查询续重运费
     * @return 价格
     */
    public ProductModel<ProductFreightResult> queryProductFreight(String sku, int province, int city, int county, int town, int paymentType, boolean conFreight){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        params.put("sku", sku);
        params.put("province", province);
        params.put("city", city);
        params.put("county", county);
        params.put("town", town);
        params.put("paymentType", paymentType);
        if(conFreight){
            params.put("queryExts", "conFreight");
        }
        String rs = HttpUtil.httpPost(URL_PRODUCT_FREIGHT, params);
        return JSONObject.toJavaObject(JSONObject.parseObject(rs), ProductModel.class);
    }



}
