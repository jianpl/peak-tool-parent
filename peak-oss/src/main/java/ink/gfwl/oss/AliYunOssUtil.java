package ink.gfwl.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import ink.gfwl.oss.properties.AliYunOssProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 阿里云OSS工具
 * @author jianpòlan
 * @version 1.0
 * <p>url: <a href="https://github.com/jianpl/peak-tool-parent">github</a></p>
 **/
@Component
public class AliYunOssUtil {

    private final AliYunOssProperties aliYunOssProperties;

    /**
     * 获取阿里云OSS客户端对象
     */
    private OSSClient ossClient;

    public AliYunOssUtil(AliYunOssProperties aliYunOssProperties) {
        this.aliYunOssProperties = aliYunOssProperties;
    }


    /**
     * 获取阿里云OSS客户端对象
     */
    private OSSClient getOssClient(){
        if(ossClient == null){
            ossClient = new OSSClient(aliYunOssProperties.getEndPoint(), new DefaultCredentialProvider(aliYunOssProperties.getAccessKeyId() ,aliYunOssProperties.getAccessKeySecret()), null);
        }
        return ossClient;
    }
    /**
     * 是否使用随机文件名
     */
    private boolean randomFileName = false;

    /**
     * 是否设置自动文件名称
     * @param randomFileName true设置
     */
    public void setRandomFileName(boolean randomFileName) {
        this.randomFileName = randomFileName;
    }


    /**
     * 创建存储空间
     * @param bucketName 存储空间
     * @return bucketName
     */
    public String createBucketName(String bucketName) {
        OSSClient ossClient = getOssClient();
        // 存储空间
        if (!this.ossClient.doesBucketExist(bucketName)) {
            // 创建存储空间
            Bucket bucket = this.ossClient.createBucket(bucketName);
            return bucket.getName();
        }
        return bucketName;
    }

    /**
     * 删除存储空间buckName
     * @param bucketName 存储空间
     */
    public void deleteBucket(String bucketName) {
        OSSClient ossClient = getOssClient();
        ossClient.deleteBucket(bucketName);
    }

    /**
     * 创建模拟文件夹
     * @param bucketName 存储空间
     * @param folder 文件夹
     * @return 文件夹名
     */
    public String createFolder(String bucketName, String folder) {
        OSSClient ossClient = getOssClient();
        // 文件夹名
        // 判断文件夹是否存在，不存在则创建
        if (!ossClient.doesObjectExist(bucketName, folder)) {
            // 创建文件夹
            ossClient.putObject(bucketName, folder, new ByteArrayInputStream(new byte[0]));
            // 得到文件夹名
            OSSObject object = ossClient.getObject(bucketName, folder);
            return object.getKey();
        }
        return folder;
    }

    /**
     * 根据key删除OSS服务器上的文件
     * @param bucketName 存储空间
     * @param folder 文件夹名 如"folder/"
     * @param pathFileName bucketName + folder + filename
     */
    public void deleteFile(String bucketName, String folder, String pathFileName) {
        OSSClient ossClient = getOssClient();
        ossClient.deleteObject(bucketName, folder + pathFileName);
    }

    /**
     * 上传图片至OSS
     * @param file 上传文件（文件全路径如：/home/users/images/girl.jpg）
     * @param bucketName 存储空间
     * @param folder 文件夹名 如"images/"
     * @return bucketName + folder + 文件名
     */
    public String uploadByFile(File file, String bucketName, String folder) {
        try {
            // 以输入流的形式上传文件
            InputStream is = new FileInputStream(file);
            // 文件名
            String fileName = file.getName();
            String _fileName;
            //随机文件名
            if(randomFileName){
                _fileName = String.valueOf(System.currentTimeMillis());
                if(fileName.indexOf(".")>0){
                    _fileName += "." + fileName.substring(fileName.indexOf(".") + 1);
                }
            }else{
                _fileName = fileName;
            }
            // 文件大小
            long fileSize = file.length();
            return uploadByInputStream(is, _fileName, fileSize, bucketName, folder);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 上传图片至OSS
     * @param file 上传文件
     * @param bucketName 存储空间
     * @param folder 文件夹名 如"images/"
     * @return bucketName + folder + 文件名
     */
    public String uploadByMultipartFile(MultipartFile file, String bucketName, String folder) {
        try {
            // 以输入流的形式上传文件
            InputStream is = file.getInputStream();
            // 文件名
            String fileName = file.getOriginalFilename();
            String _fileName = fileName;
            //随机文件名
            if(randomFileName || fileName == null){
                _fileName = String.valueOf(System.currentTimeMillis());
                assert fileName != null;
                if(fileName.indexOf(".")>0){
                    _fileName += "." + fileName.substring(fileName.indexOf(".") + 1);
                }
            }
            // 文件大小
            long fileSize = file.getSize();
            return uploadByInputStream(is, _fileName, fileSize, bucketName, folder);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 上传图片至OSS
     * @param inputStream 文件流
     * @param bucketName 存储空间
     * @param folder 文件夹名 如"images/"
     * @param fileName 文件名称
     * @param fileSize 文件大小
     * @return String 唯一MD5数字签名
     */
    public String uploadByInputStream(InputStream inputStream,String fileName, long fileSize, String bucketName, String folder) {
        String resultStr = null;
        try {
            OSSClient ossClient = getOssClient();
            // 创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            // 上传的文件的长度
            metadata.setContentLength(inputStream.available());
            // 指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            // 指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            // 指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            // 如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(fileName));
            // 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）

            String _fileName;
            //随机文件名
            if(randomFileName){
                _fileName = String.valueOf(System.currentTimeMillis());
                if(fileName.indexOf(".")>0){
                    _fileName += "." + fileName.substring(fileName.indexOf(".") + 1);
                }
            }else{
                _fileName = fileName;
            }
            metadata.setContentDisposition("filename/filesize=" + _fileName + "/" + fileSize + "Byte.");
            // 上传文件 (上传文件流的形式)
            ossClient.putObject(bucketName, folder + _fileName, inputStream, metadata);
            // 解析结果
            resultStr = folder + _fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultStr;
    }

    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     * @param fileName 文件名
     * @return 文件的contentType
     */
    public static String getContentType(String fileName) {
        // 文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if (".png".equalsIgnoreCase(fileExtension)) {
            return "image/png";
        }
        if (".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        if (".mp4".equalsIgnoreCase(fileExtension)) {
            return "video/mp4";
        }
        if (".mp3".equalsIgnoreCase(fileExtension)) {
            return "audio/mp4";
        }
        if (".apk".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.android.package-archive";
        }
        if (".ipa".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.iphone";
        }
        if (".wmv".equalsIgnoreCase(fileExtension)) {
            return "video/x-ms-wmv";
        }
        if (".mpeg".equalsIgnoreCase(fileExtension) || ".mpg".equalsIgnoreCase(fileExtension)) {
            return "video/x-ms-wmv";
        }
        // 默认返回类型
        return "";
    }

}
