package ink.gfwl.test;

import com.alibaba.fastjson.JSONObject;
import ink.gfwl.jd.JdApplication;
import ink.gfwl.jd.common.ProductStyleExts;
import ink.gfwl.jd.model.address.AddressModel;
import ink.gfwl.jd.model.product.ProductModel;
import ink.gfwl.jd.model.token.TokenModel;
import ink.gfwl.jd.service.AddressService;
import ink.gfwl.jd.service.ProductService;
import ink.gfwl.jd.util.TokenUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
@SpringBootTest(classes = JdApplication.class)
public class JdTest {
    @Resource
    private TokenUtils tokenUtils;
    @Resource
    private AddressService addressService;
    @Resource
    private ProductService productService;

    @Test
    public void testToken(){
        TokenModel token1 = tokenUtils.getToken();
        System.out.println(JSONObject.toJSONString(token1));
        TokenModel token2 = tokenUtils.getToken();
        System.out.println(JSONObject.toJSONString(token2));

    }

    @Test
    public void addressTest(){
        AddressModel address = addressService.getAddress(1, 0);
        System.out.println(JSONObject.toJSONString(address));
    }

    @Test
    public void productTest(){
        // 商品栏目
//        ProductNumberModel productNumberModel = productService.queryProductNumber();
//        for (ProductNumberResult productNumberResult : productNumberModel.getResult()) {
//            // 栏目商品标号
//            ProductSkuPageModel productSkuPageModel = productService.queryProductGoods(1, 10, 0);
//            List<Long> skus = productSkuPageModel.getResult().getSkus();
//            for (Long aLong : skus) {
//                Object o = productService.queryProductDetail(String.valueOf(aLong));
//                System.out.println(o);
//                System.out.println("--------");
//            }
//        }
//        List<ProductExts> arr = new ArrayList<>();
//        arr.add(ProductExts.nappintroduction);
//        arr.add(ProductExts.nintroduction);
//        arr.add(ProductExts.wxintroduction);
//        ProductMatterModel productMatterModel = productService.queryProductDetail("102215", arr);
        List<ProductStyleExts> styleExts = new ArrayList<>();
//        styleExts.add(ProductStyleExts.appStyleContent);
        styleExts.add(ProductStyleExts.appStyleUrl);
//        styleExts.add(ProductStyleExts.pcStyleContent);
        styleExts.add(ProductStyleExts.pcStyleUrl);
//        ProductMatterStyleModel productMatterStyleModel = productService.queryProductDetailStyle("102215", styleExts);
//        System.out.println(JSONObject.toJSONString(productMatterStyleModel));
    }

//    @Resource(name = "peakRedis")
//    private RedisTemplate<String, Integer> redisTemplateInt;
//
//    @Resource(name = "peakRedis")
//    private RedisTemplate<String, String> redisTemplateStr;

//    public static void main(String[] args) {
//        List<ProductExts> arr = new ArrayList<>();
//        arr.add(ProductExts.ChinaCatalog);
//        arr.add(ProductExts.capacity);
//        arr.add(ProductExts.nappintroduction);
//        arr.add(ProductExts.nintroduction);
//        arr.add(ProductExts.wxintroduction);
//        System.out.println(StrUtils.enumArrConvertStr(arr));
//    }

    @Test
    public void queryProductStateTest(){
        ProductModel<List<ProductNumberResult>> listProductModel = productService.queryProductNumber();

        System.out.println(JSONObject.toJSONString(listProductModel));
//        ProductModel<ProductStateResult> productStateResultProductModel = productService.queryProductState("102215");
//        System.out.println(JSONObject.toJSONString(productStateResultProductModel));
    }

}
