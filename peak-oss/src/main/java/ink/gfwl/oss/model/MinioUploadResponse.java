package ink.gfwl.oss.model;

import io.minio.ObjectWriteResponse;
import okhttp3.Headers;

import java.io.Serializable;

/**
 * MinioUploadResponse
 * @author jianpòlan
 * @version 1.0
 **/
public class MinioUploadResponse extends ObjectWriteResponse implements Serializable {

    private static final long serialVersionUID = -3250635494553247978L;
    /**
     * 文件访问地址
     */
    private String path;

    public MinioUploadResponse() {
        super(null, null, null, null, null, null);
    }

    public MinioUploadResponse(Headers headers, String bucket, String region, String object, String etag, String versionId) {
        super(headers, bucket, region, object, etag, versionId);
    }

    /**
     * Gets the value of path
     *
     * @return the value of path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path
     * <p>You can use getPath() to get the value of path</p>
     *
     * @param path path
     */
    public void setPath(String path) {
        this.path = path;
    }
}
