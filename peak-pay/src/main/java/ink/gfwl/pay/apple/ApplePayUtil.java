package ink.gfwl.pay.apple;

import com.alibaba.fastjson.JSONObject;
import ink.gfwl.common.lang.Affirm;
import ink.gfwl.common.lang.ObjectUtils;
import ink.gfwl.pay.apple.model.ApplePaymentRequest;
import ink.gfwl.pay.apple.util.IosVerifyUtil;
import ink.gfwl.pay.base.PaymentResponse;
import ink.gfwl.pay.exception.PayException;
import org.springframework.stereotype.Service;

/**
 * Apple pay
 * @author jianpòlan
 * @version 1.0
 * <p>url: https://github.com/jianpl/peak-tool-parent/peak-pay</p>
 **/
@Service
public class ApplePayUtil{

    /**
     * 支付处理
     * @param applePaymentRequest {@link ink.gfwl.pay.apple.model.ApplePaymentRequest}
     * @return PaymentResponse
     */
    public PaymentResponse prepare(ApplePaymentRequest applePaymentRequest){
        Affirm.isNull(applePaymentRequest, ()->new PayException(100));
        Affirm.isNull(applePaymentRequest.getReceiptData(), ()->new PayException(101));
        Affirm.isNull(applePaymentRequest.getProductId(), ()->new PayException(102));
        try {
            String verifyResult = IosVerifyUtil.buyAppVerify(applePaymentRequest.getReceiptData(), 1);
            JSONObject appleReturn = JSONObject.parseObject(verifyResult);
            String states = appleReturn.getString("status");
            //沙箱
            if ("21007".equals(states)) {
                verifyResult = IosVerifyUtil.buyAppVerify(applePaymentRequest.getReceiptData(), 0);
                appleReturn = JSONObject.parseObject(verifyResult);
                states = appleReturn.getString("status");
            }
            if (states.equals("0")) {
                String receipt = appleReturn.getString("receipt");
                JSONObject returnJson = JSONObject.parseObject(receipt);
                String product_id = returnJson.getString("product_id");
                if (ObjectUtils.isNotNull(product_id)) {
                    //交易列表包含当前交易，则认为交易成功
                    if (product_id.equalsIgnoreCase(applePaymentRequest.getProductId())) {
                        PaymentResponse response = new PaymentResponse();
                        response.setSuccess(true);
                        return response;
                    }
                    throw new PayException(103);
                }
                throw new PayException(103);
            } else {
                throw new PayException(104);
            }
        }catch (Exception e){
            throw new PayException(104, e.getMessage());
        }
    }



}
