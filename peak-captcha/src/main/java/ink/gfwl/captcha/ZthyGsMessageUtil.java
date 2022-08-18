package ink.gfwl.captcha;

import com.alibaba.fastjson.JSONObject;
import ink.gfwl.captcha.model.ZthyGsMessageRequest;
import ink.gfwl.captcha.properties.ZthySmsProperties;
import ink.gfwl.common.http.RestTemplateUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 助通国际短信接口
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
public class ZthyGsMessageUtil {

    private final ZthySmsProperties zthySmsProperties;

    public ZthyGsMessageUtil(ZthySmsProperties zthySmsProperties) {
        this.zthySmsProperties = zthySmsProperties;
    }

    /**
     * 国际短信认证头
     * @return 结果
     */
    private Map<String, String> getAuthHeader(){
        String auth = zthySmsProperties.getUsername() + ":" + zthySmsProperties.getPassword();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
        String authHeader = "Basic " + new String(encodedAuth);
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", authHeader);
        return header;
    }

    /**
     * 发送短信：code=200,true
     * @param zthyGsMessageRequest 短信参数
     * @return 结果
     */
    public String sendGsMessage(ZthyGsMessageRequest zthyGsMessageRequest){
        String url = "https://api-gateway.zthysms.com/ims/v1/send";
        JSONObject json = new JSONObject();
        json.put("content", zthyGsMessageRequest.getContent());
        json.put("sendTime", zthyGsMessageRequest.getSendTime());
        json.put("phone", zthyGsMessageRequest.getPhone());
        json.put("ext", zthyGsMessageRequest.getExt());
        json.put("extend", zthyGsMessageRequest.getExtend());
        json.put("type", zthyGsMessageRequest.getType());
        return RestTemplateUtil.postForBody(url, json, getAuthHeader(), String.class);
    }

    /**
     * 获取余额
     * @return 结果
     */
    public String queryGsBalance(){
        String url = "https://api-gateway.zthysms.com/ims/v1/balance";
        return RestTemplateUtil.get(url, getAuthHeader(), String.class);
    }

}
