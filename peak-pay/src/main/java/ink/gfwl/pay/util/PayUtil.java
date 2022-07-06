package ink.gfwl.pay.util;


import com.alibaba.fastjson.JSONObject;
import ink.gfwl.common.lang.ObjectUtils;
import ink.gfwl.pay.base.CallbackParams;
import ink.gfwl.pay.exception.PayException;
import ink.gfwl.util.security.Md5Utils;
import org.apache.commons.codec.digest.DigestUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 支付解析工具
 * @author jianpòlan
 * @version 1.0
 * @since 1.0
 **/
public class PayUtil {

    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static String sign(String text, String key, String input_charset) {
        text = text + "&key=" + key;
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }

    /**
     * string转byte[]
     * @param content 内容
     * @param charset 编码
     * @return content的byte[]数组
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

    /**
     * 验证char
     * @param ch char
     * @return true通过
     */
    private static boolean isValidChar(char ch) {
        if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
            return true;
        }
        return (ch >= 0x4e00 && ch <= 0x7fff) || (ch >= 0x8000 && ch <= 0x952f);
    }
    /**
     * 除去数组中的空值和签名参数
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {
        Map<String, String> result = new HashMap<>();
        if (sArray == null || sArray.size() <= 0) {
            return result;
        }
        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
                    || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }
    /**
      * 把数组所有元素排序
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params) {
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        StringBuilder prestr = new StringBuilder();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
                prestr.append(key).append("=").append(value);
            } else {
                prestr.append(key).append("=").append(value).append("&");
            }
        }
        return prestr.toString();
    }

    /**
     * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
     * @param strXml 解析内容
     * @return 解析结果
     * @exception Exception 异常
     */
    public static Map<String, String> doXMLParse(String strXml) throws Exception {
        if(null == strXml || "".equals(strXml)) {
            return null;
        }
        HashMap<String, String> m = new HashMap<>();
        InputStream in = String2InputStream(strXml);
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List<Element> list = root.getChildren();
        for (Element e : list) {
            String k = e.getName();
            String v;
            List<Element> children = e.getChildren();
            if (children.isEmpty()) {
                v = e.getTextNormalize();
            } else {
                v = getChildrenText(children);
            }
            m.put(k, v);
        }
        //关闭流
        in.close();
        return m;
    }

    /**
     * 获取子结点的xml
     * @return String
     */
    private static String getChildrenText(List<Element> children) {
        StringBuilder sb = new StringBuilder();
        if(!children.isEmpty()) {
            for (Element e : children) {
                List<Element> list = e.getChildren();
                sb.append("<").append(e.getName()).append(">");
                if (!list.isEmpty()) {
                    sb.append(getChildrenText(list));
                }
                sb.append(e.getTextNormalize());
                sb.append("</").append(e.getName()).append(">");
            }
        }

        return sb.toString();
    }

    /**
     * string转inputStream
     * @param str 转换值
     * @return inputStream
     */
    private static InputStream String2InputStream(String str) {
        return new ByteArrayInputStream(str.getBytes());
    }


    /**
     * 获取支付宝回调请求参数
     * @param request 回调请求
     * @return 参数解析结果
     */
    public static Map<String, String> alipayCallback(HttpServletRequest request){
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (String name : requestParams.keySet()) {
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        return params;
    }

    /**
     * 获取回调请求报文
     * @param request 回调请求
     * @return 请求参数内容
     */
    public static String getPostStr(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream is = request.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 获取回调参数
     * @param request 支付参数
     * @param apiKey apiKey
     * @return 结果
     */
    public static CallbackParams getCallback(HttpServletRequest request, String apiKey){
        try {
            String notifyXml = PayUtil.getPostStr(request);
            if(ObjectUtils.isNotNull(notifyXml)){
                Map<String, String> map = PayUtil.doXMLParse(notifyXml);
                //此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
                String returnCode = map.get("return_code");
                if ("SUCCESS".equals(returnCode)) {
                    //验证签名是否正确
                    Map<String, String> validParams = PayUtil.paraFilter(map);  //回调验签时需要去除sign和空值参数
                    String validStr = PayUtil.createLinkString(validParams);//把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
                    String sign = PayUtil.sign(validStr, apiKey, "utf-8").toUpperCase();//拼装生成服务器端验证的签名
                    // 因为微信回调会有八次之多,所以当第一次回调成功了,那么我们就不再执行逻辑了
                    //根据微信官网的介绍，此处不仅对回调的参数进行验签，还需要对返回的金额与系统订单的金额进行比对等
                    if (sign.equals(map.get("sign"))) {
                        //更多参数详见：https://pay.weixin.qq.com/wiki/doc/api/app/app_sl.php?chapter=9_7&index=3
                        //商户订单号
                        String trade_no = validParams.get("out_trade_no");
                        //微信支付订单号
                        String out_trade_no = validParams.get("transaction_id");
                        //业务结果 SUCCESS/FAIL
                        String result_code = validParams.get("result_code");
                        CallbackParams callbackParams = new CallbackParams();
                        callbackParams.setOutTradeNo(out_trade_no);
                        callbackParams.setTradeNo(trade_no);
                        callbackParams.setTradeStatus("SUCCESS".equals(result_code));
                        callbackParams.setCallback(JSONObject.toJSONString(validParams));
                        return callbackParams;
                    } else {
                        throw new PayException(106);
                    }
                }else{
                    throw new PayException(105);
                }
            }else{
                throw new PayException(105);
            }
        }catch (Exception e){
            throw new PayException(105);
        }
    }

    public static String getSignature(HashMap<String, String> data, String apiKey) {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[0]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if ("sign".equals(k)) {
                continue;
            }
            if (data.get(k).trim().length() > 0){
                sb.append(k).append("=").append(data.get(k).trim()).append("&");
            }
        }
        sb.append("key=").append(apiKey);
        return Md5Utils.md5(sb.toString(), true);
    }

    public static String httpsRequest(String requestUrl, String outputStr) {
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod("POST");
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes(StandardCharsets.UTF_8));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader =new BufferedReader(inputStreamReader);
            String str = bufferedReader.readLine();
            StringBuilder buffer = new StringBuilder();
            while (ObjectUtils.isNotNull(str)) {
                buffer.append(str);
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            conn.disconnect();
            return buffer.toString();
        } catch (Exception ce) {
            ce.printStackTrace();
        }
        return "";
    }
}


