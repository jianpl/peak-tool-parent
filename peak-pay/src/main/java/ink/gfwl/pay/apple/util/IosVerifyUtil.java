package ink.gfwl.pay.apple.util;

import sun.net.www.protocol.https.DefaultHostnameVerifier;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.Locale;

/**
 * 苹果支付验证工具
 */
public class IosVerifyUtil {

    //购买凭证验证地址
    static String appleCertificateUrl = "https://buy.itunes.apple.com/verifyReceipt";
    //测试的购买凭证验证地址
    static String appleCertificateUrlTest = "https://sandbox.itunes.apple.com/verifyReceipt";

    private static class TrustAnyTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) { }
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) { }
        @Override
        public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[] {};}
    }

    /**
     * 苹果服务器验证
     * @param receipt 账单
     * @param type 环境：0沙盒 1线上
     * @return null 或返回结果 沙盒 https://sandbox.itunes.apple.com/verifyReceipt
     */
    public static String buyAppVerify(String receipt,int type) {
        String url = type == 0 ? appleCertificateUrlTest : appleCertificateUrl;
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
            URL console = new URL(url);
            HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
            conn.setSSLSocketFactory(sc.getSocketFactory());
            conn.setHostnameVerifier(new DefaultHostnameVerifier());
            conn.setRequestMethod("POST");
            conn.setRequestProperty("content-type", "text/json");
            conn.setRequestProperty("Proxy-Connection", "Keep-Alive");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            BufferedOutputStream hurlBufOus = new BufferedOutputStream(conn.getOutputStream());
            String str = String.format(Locale.CHINA, "{\"receipt-data\":\"%s\"}", receipt);//拼成固定的格式传给平台
            hurlBufOus.write(str.getBytes());
            hurlBufOus.flush();
            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception ex) {
            System.out.println("苹果服务器异常");
            ex.printStackTrace();
        }
        return null;
    }
}
