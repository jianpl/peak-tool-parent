package ink.gfwl.jd.service;

import ink.gfwl.jd.common.ProductExts;
import ink.gfwl.jd.common.ProductPriceExts;
import ink.gfwl.jd.model.product.ProductAllModel;
import ink.gfwl.jd.model.product.ProductModel;
import ink.gfwl.jd.model.product.result.ProductMatterResult;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 简单接口
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class ProductSampleService {

    @Resource
    private ProductService productService;

    /**
     * 获取商品详情，图片、价格、库存
     * @param sku sku
     * @param productExts 详情扩展
     * @param priceExts 价格扩展
     * @return 结果
     */
    public ProductAllModel queryProductAllDetails(String sku, List<ProductExts> productExts, List<ProductPriceExts> priceExts){
        ProductAllModel productAllModel = new ProductAllModel();
        ProductModel<ProductMatterResult> productMatterResultProductModel = productService.queryProductDetail(sku, productExts);
        ProductMatterResult matterResult = productMatterResultProductModel.getResult();
        BeanUtils.copyProperties(matterResult, productAllModel);
        productAllModel.setImageResult(productService.queryProductImage(sku).getResult());
        productAllModel.setPriceResult(productService.queryProductPrice(sku, priceExts).getResult());
        productAllModel.setStateResult(productService.queryProductState(sku).getResult());
        return productAllModel;
    }

}
