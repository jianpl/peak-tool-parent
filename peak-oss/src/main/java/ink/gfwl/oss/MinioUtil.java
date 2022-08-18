package ink.gfwl.oss;

import ink.gfwl.oss.properties.MinioProperties;
import io.minio.*;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * MinioUtil
 * @author jianpòlan
 * @version 1.0
 **/
@Component
public class MinioUtil {

    private final MinioProperties minioProperties;

    public MinioClient minioClient;

    /**
     * 获取 MinioClient
     * @param minioProperties MinioProperties
     */
    public MinioUtil(MinioProperties minioProperties){
        this.minioProperties = minioProperties;
        try {
            this.minioClient = MinioClient.builder()
                            .endpoint(this.minioProperties.getEndpoint())
                            .credentials(this.minioProperties.getAccessKey(), this.minioProperties.getSecretKey())
                            .build();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建bucket
     * @param bucketName bucket名称
     * @throws Exception exception
     */
    public void createBucket(String bucketName) throws Exception {
        if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())){
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            // 设置公开可读
            String DEFAULT_BUCKET_POLICY = "{\"Version\":\"2012-10-17\",\"Statement\":[{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:GetBucketLocation\",\"s3:ListBucket\"],\"Resource\":[\"arn:aws:s3:::%s\"]},{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:GetObject\"],\"Resource\":[\"arn:aws:s3:::%s/*\"]}]}";
            minioClient.setBucketPolicy(
                    SetBucketPolicyArgs.builder()
                            .config(String.format(DEFAULT_BUCKET_POLICY, bucketName, bucketName))
                            .build()
            );
        }
    }

    /**
     * getBucketPolicy
     * @param bucketName bucket名称
     * @return BucketPolicy
     */
    public String getBucketPolicy(String bucketName){
        try {
            return minioClient.getBucketPolicy(GetBucketPolicyArgs.builder().bucket(bucketName).build());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 上传文件
     * @param file 文件
     * @param bucketName bucketName
     * @return 文件路径
     */
    public String uploadFile(String bucketName, MultipartFile file) {
        // 判断上传文件是否为空
        if (null == file || 0 == file.getSize()) {
            return null;
        }
        InputStream inputStream = null;
        try {
            // 判断存储桶是否存在
            createBucket(bucketName);
            // 文件名
            String originalFilename = file.getOriginalFilename();
            if(originalFilename == null){
                originalFilename = file.getName();
            }
            // 新的文件名 = 存储桶名称_时间戳.后缀名
            String fileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
            // 开始上传
            inputStream = file.getInputStream();
            String contentType = MediaTypeFactory.getMediaType(fileName).orElse(MediaType.APPLICATION_OCTET_STREAM).toString();
            minioClient.putObject(
                    PutObjectArgs
                            .builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .contentType(contentType)
                            .stream(inputStream, file.getSize(), 5 * 1024 * 1024)
                            .build()
            );
            return minioProperties.getEndpoint() + "/" + bucketName + "/" + fileName;
        }  catch (Exception e) {
            throw new RuntimeException();
        }finally {
            try {
                if(inputStream != null){
                    inputStream.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 上传文件
     * @param bucketName bucketName
     * @param file file
     * @return 文件路径
     */
    public String uploadFile(String bucketName, File file){
        // 判断上传文件是否为空
        if (null == file || !file.exists()) {
            return null;
        }
        InputStream inputStream = null;
        try {
            // 判断存储桶是否存在
            createBucket(bucketName);
            // 文件名
            String originalFilename = file.getName();
            // 新的文件名 = 存储桶名称_时间戳.后缀名
            String fileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
            // 开始上传
            inputStream = Files.newInputStream(file.toPath());
            String contentType = MediaTypeFactory.getMediaType(fileName).orElse(MediaType.APPLICATION_OCTET_STREAM).toString();
            minioClient.putObject(
                    PutObjectArgs
                            .builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .contentType(contentType)
                            .stream(inputStream, file.length(), 5 * 1024 * 1024)
                            .build()
            );
            return minioProperties.getEndpoint() + "/" + bucketName + "/" + fileName;
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(inputStream != null){
                    inputStream.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
