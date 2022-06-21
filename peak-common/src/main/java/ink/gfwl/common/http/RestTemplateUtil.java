package ink.gfwl.common.http;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * RestTemplate工具类
 * @author jianpòlan
 * @version 1.0
 **/
public class RestTemplateUtil {

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    /**
     * 获取默认header
     * <p>Content-Type: application/json</p>
     * @return HttpHeaders
     */
    public static HttpHeaders getDefaultHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    /**
     * POST请求
     * @param url 请求地址
     * @param body body参数
     * @param responseType 返回类型
     * @param <T> 返回类型泛型
     * @return 结果
     */
    public static <T> T postForBody(String url, JSONObject body, Class<T> responseType){
        return postForBody(url, body, null, responseType);
    }

    /**
     * POST请求
     * @param url 请求地址
     * @param body body参数
     * @param header header
     * @param responseType 返回类型
     * @param <T> 返回类型泛型
     * @return 结果
     */
    public static <T> T postForBody(String url, JSONObject body, Map<String, String> header, Class<T> responseType){
        HttpHeaders applicationJSONHeader = getDefaultHeader();
        if(header != null){
            header.forEach(applicationJSONHeader::set);
        }
        HttpEntity<String> request = new HttpEntity<>(body.toJSONString(), applicationJSONHeader);
        return REST_TEMPLATE.postForEntity(url, request, responseType).getBody();
    }

    /**
     * get请求
     * @param url 请求地址
     * @param responseType 返回类型
     * @param <T> 返回类型泛型
     * @return 结果
     */
    public static <T> T get(String url, Class<T> responseType){
        return get(url, null, responseType);
    }

    /**
     * get请求
     * @param url 请求地址
     * @param responseType 返回类型
     * @param <T> 返回类型泛型
     * @return 结果
     */
    public static <T> T get(String url, Map<String, String> header, Class<T> responseType){
        HttpHeaders headers = getDefaultHeader();
        if(header != null){
            header.forEach(headers::set);
        }
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        return REST_TEMPLATE.exchange(url, HttpMethod.GET, httpEntity, responseType).getBody();
    }

}
