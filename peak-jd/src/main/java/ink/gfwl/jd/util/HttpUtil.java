package ink.gfwl.jd.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 京东HTTP工具
 * @author jianpòlan
 * @version 1.0
 **/
public final class HttpUtil {

    /**
     * 执行HttpPost请求
     * @param url 请求路径
     * @param params 参数
     * @return 结果
     */
    public synchronized static String httpPost(String url, Map<String, Object> params){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost =   new HttpPost(url);
        CloseableHttpResponse response = null;
        String result = null;
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            if (null != params && params.size() > 0) {
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (key == null || value == null) {
                        continue;
                    }
                    NameValuePair pair = new BasicNameValuePair(key, String.valueOf(value));
                    nameValuePairs.add(pair);
                }
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
            httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
            // 执行请求
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                result = EntityUtils.toString(entity, ContentType.getOrDefault(entity).getCharset());
                EntityUtils.consume(entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpPost.releaseConnection();
        }
        return result;
    }

}
