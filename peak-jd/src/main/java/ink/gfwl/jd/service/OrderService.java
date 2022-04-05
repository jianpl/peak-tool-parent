package ink.gfwl.jd.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ink.gfwl.jd.base.BaseQueryParam;
import ink.gfwl.jd.config.RequestURL;
import ink.gfwl.jd.model.order.OrderModel;
import ink.gfwl.jd.model.order.params.OrderSubmitParam;
import ink.gfwl.jd.model.order.result.OrderSubmitResult;
import ink.gfwl.jd.util.HttpUtil;
import ink.gfwl.jd.util.StrUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 订单
 * @author jianpòlan
 * @version 1.0
 **/
@Service
@SuppressWarnings("unchecked")
public class OrderService extends RequestURL {

    @Resource
    private BaseQueryParam baseQueryParam;

    /**
     * 提交订单
     * @param submitOrderParam 订单参数
     * @return 订单结果
     */
    public OrderModel<OrderSubmitResult> orderSubmit(OrderSubmitParam submitOrderParam){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        params.putAll(StrUtils.entityToMap(submitOrderParam));
        String rs = HttpUtil.httpPost(URL_ORDER_SUBMITORDER, params);
        return JSONObject.toJavaObject(JSON.parseObject(rs), OrderModel.class);
    }

    /**
     * 订单反查接口，根据第三方订单号反查京东的订单号。
     * @param thirdOrder 第三方订单号（非京东订单号）。
     * @return 京东订单号
     */
    public OrderModel<String> orderIdQueryByThirdId(String thirdOrder){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        params.put("thirdOrder", thirdOrder);
        String rs = HttpUtil.httpPost(URL_ORDER_QUERY_BY_THIRD, params);
        return JSONObject.toJavaObject(JSON.parseObject(rs), OrderModel.class);
    }



}
