package ink.gfwl.oss;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import ink.gfwl.oss.properties.TencentCosProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * 腾讯云对象存储
 * @author jianpòlan
 * @version 1.0
 * <p>https://github.com/tencentyun/cos-java-sdk-v5/tree/master/src/main/java/com/qcloud/cos/demo</p>
 **/
@Service
public class TencentCosUtil {

    @Autowired
    private TencentCosProperties tencentCosProperties;

    /**
     * 初始化CosClient相关配置， appid、accessKey、secretKey、region
     * @return COSClient
     */
    public COSClient getCosClient() {
        return new COSClient(new BasicCOSCredentials(tencentCosProperties.getAccessKey(), tencentCosProperties.getSecretKey()), new ClientConfig(new Region(tencentCosProperties.getRegionId())));
    }

    /**
     * 上传文件
     * @param file file
     * @param fileName fileName
     * @return tag
     */
    public String uploadFile(File file, String fileName) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(tencentCosProperties.getBucketName() +"-"+ tencentCosProperties.getAppId(), fileName, file);
        // 设置存储类型, 默认是标准(Standard), 低频(standard_ia),一般为标准的
        putObjectRequest.setStorageClass(StorageClass.Standard);
        COSClient cc = getCosClient();
        try {
            PutObjectResult putObjectResult = cc.putObject(putObjectRequest);
            return putObjectResult.getETag();
        } catch (CosClientException e) {
            e.printStackTrace();
        }
        // 关闭客户端
        cc.shutdown();
        return null;
    }

    /**
     * 下载文件,本地有相同名称的文件则会直接返回（使用完记得删除本地缓存）
     * @param bucketName bucketName
     * @param fileName fileName
     * @return file
     */
    public File downLoadFile(String bucketName, String fileName){
        return downLoadFile(bucketName, fileName, false);
    }

    /**
     * 下载文件（使用完记得删除本地缓存）
     * @param bucketName bucketName
     * @param fileName fileName
     * @param override 是否下载覆盖
     * @return file
     */
    public File downLoadFile(String bucketName, String fileName, boolean override) {
        File downFile = new File(tencentCosProperties.getTempFilePath() + File.separator + fileName);
        // 已存在则直接返回
        if(downFile.exists() && downFile.length() > 0 && !override){
            return downFile;
        }
        if(downFile.exists() && override){
            downFile.deleteOnExit();
        }
        COSClient cc = getCosClient();
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName +"-"+ tencentCosProperties.getAppId(), fileName);
        cc.getObject(getObjectRequest, downFile);
        cc.shutdown();
        return downFile;
    }

    /**
     * 删除文件
     * @param bucketName bucketName
     * @param fileName fileName
     */
    public void deleteFile(String bucketName, String fileName) {
        COSClient cc = getCosClient();
        try {
            cc.deleteObject(bucketName +"-"+ tencentCosProperties.getAppId(), fileName);
        } catch (CosClientException e) {
            e.printStackTrace();
        } finally {
            cc.shutdown();
        }
    }

    /**
     * 删除桶
     * @param bucketName bucketName
     */
    public void deleteBucket(String bucketName){
        COSClient cc = getCosClient();
        try {
            cc.deleteBucket(bucketName +"-"+ tencentCosProperties.getAppId());
        } catch (CosClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断桶是否存在
     * @param bucketName bucketName
     * @return 结果
     * @throws CosClientException CosClientException
     * @throws CosServiceException CosServiceException
     */
    public boolean doesBucketExist(String bucketName) throws CosClientException, CosServiceException {
        COSClient cc = getCosClient();
        return cc.doesBucketExist(bucketName +"-"+ tencentCosProperties.getAppId());
    }

    /**
     * 查看桶文件
     * @param bucketName bucketName
     * @return ObjectListing
     * @throws CosClientException CosClientException
     * @throws CosServiceException CosServiceException
     */
    public ObjectListing listObjects(String bucketName) throws CosClientException, CosServiceException {
        COSClient cc = getCosClient();
        // 获取 bucket 下成员（设置 delimiter）
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
        listObjectsRequest.setBucketName(bucketName +"-"+ tencentCosProperties.getAppId());
        // 设置 list 的 prefix, 表示 list 出来的文件 key 都是以这个 prefix 开始
        listObjectsRequest.setPrefix("");
        // 设置 delimiter 为/, 即获取的是直接成员，不包含目录下的递归子成员
        listObjectsRequest.setDelimiter("/");
        // 设置 marker, (marker 由上一次 list 获取到, 或者第一次 list marker 为空)
        listObjectsRequest.setMarker("");
        // 设置最多 list 100 个成员,（如果不设置, 默认为 1000 个，最大允许一次 list 1000 个 key）
        listObjectsRequest.setMaxKeys(1000);
        return cc.listObjects(listObjectsRequest);
    }

    /**
     *查询一个 Bucket 所在的 Region。
     * @param bucketName bucketName
     * @return region
     * @throws CosClientException CosClientException
     * @throws CosServiceException CosServiceException
     */
    public String getBucketLocation(String bucketName) throws CosClientException , CosServiceException{
        COSClient cosClient = getCosClient();
        // bucket 的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        return cosClient.getBucketLocation(bucketName +"-"+ tencentCosProperties.getAppId());
    }

}
