package ink.gfwl.captcha;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ink.gfwl.common.http.RestTemplateUtil;
import ink.gfwl.common.lang.Affirm;
import ink.gfwl.common.lang.Md5Util;
import ink.gfwl.captcha.properties.ZthySmsProperties;
import ink.gfwl.captcha.base.Messages;
import ink.gfwl.captcha.exception.SmsException;
import ink.gfwl.captcha.model.MessageSendRequest;
import ink.gfwl.captcha.model.ZthyCustomMessageRequest;
import ink.gfwl.captcha.model.ZthyMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 助通短信发送
 * <p>禁止发送内容：
 * 所有发送内容的发送对象必须是会员或者是有订购关系用户
 * 营销内容提交必须要加格式：退订，退回，拒收；未加格式的系统自动发送不成功
 * 金融类（股票、证券、A货、原油期货贵金属、理财等）除车险其他一律不发
 * 黄赌毒（赛马，赌球，彩票，毒品等）、工商代办、代开发票、买卖黑车、注册会员（邀请会员），非法钓鱼信息一律不发
 * 房地产买卖类（多少钱一平，卖车位，商铺招租等）一律不发
 * 招商加盟类，盲发引流一律不发
 * 与运营商相关（营业厅，移动，联通，电信，大王卡，短信群发等）一律不发
 * 医疗保健、POS机相关、信用卡、人工或软件刷单做任务、法院传票、移民留学、面试招聘、减肥整形、私募股权企业培训、代写论文刊物、个人业务、海外置业投资、私服游戏等一律不发
 * 成人用品、办卡充值一律不发
 * 非会员类信息（注册、加会员，加群加微信、邀请好友）一律不发
 * 捐款献血类一律不发
 * 风水宗教，迷信色彩，涉黑涉暴、反党反共一律不发
 * 烟草类信息一律不发
 * 虚拟货币，区块链、人民币收藏，钱币买卖类一律不发
 * 皮草买卖、高仿A货类一律不发
 * 棋牌，赌博 内容不雅，带有威胁性质，违法违规等内容一律不发</p>
 * @author jianpòlan
 * @version 1.0
 **/
@Component
public class ZthyMessageUtil implements Messages {

    @Autowired(required = false)
    private ZthySmsProperties zthySmsProperties;

    /**
     * 短信发送
     * @param messageSendRequest 发送参数
     * @return 发送结果
     */
    @Override
    public String sendMessage(MessageSendRequest messageSendRequest) {
        Affirm.isNull(messageSendRequest, ()->new SmsException(500, "参数为空"));
        Affirm.isFalse(messageSendRequest instanceof ZthyMessageRequest, ()->new SmsException(501, "参数异常"));
        ZthyMessageRequest zthyMessageRequest = (ZthyMessageRequest)messageSendRequest;
        //请求入参
        JSONObject requestJson = new JSONObject();
        requestJson.put("username", zthySmsProperties.getUsername());
        long tKey = System.currentTimeMillis() / 1000;
        requestJson.put("tKey", tKey);
        requestJson.put("password", Md5Util.md5(Md5Util.md5(zthySmsProperties.getPassword()) + tKey));
        requestJson.put("tpId", zthyMessageRequest.getTpId());
        requestJson.put("signature", zthyMessageRequest.getSignature());
        requestJson.put("ext", "");
        requestJson.put("extend", "");
        JSONArray records = new JSONArray();
        JSONObject record = new JSONObject();
        record.put("mobile", zthyMessageRequest.getPhone());
        record.put("tpContent", zthyMessageRequest.getParam());
        records.add(record);
        requestJson.put("records", records);
        return RestTemplateUtil.postForBody("https://api.mix2.zthysms.com/v2/sendSmsTp", requestJson, String.class);
    }

    /**
     * 自定义内容发送
     * @param messageSendRequest 参数
     * @return 结果
     */
    public String sendCustomMessage(ZthyCustomMessageRequest messageSendRequest){
        String url = "https://api.mix2.zthysms.com/v2/sendSms";
        long tKey = System.currentTimeMillis() / 1000;
        JSONObject json = new JSONObject();
        //账号
        json.put("username", zthySmsProperties.getUsername());
        //密码
        json.put("password", Md5Util.md5(Md5Util.md5(zthySmsProperties.getPassword()) + tKey));
        //tKey
        json.put("tKey", tKey + "");
        //手机号
        json.put("mobile", messageSendRequest.getPhone());
        //内容
        json.put("content", messageSendRequest.getContent());
        return RestTemplateUtil.postForBody(url, json, String.class);
    }
}
