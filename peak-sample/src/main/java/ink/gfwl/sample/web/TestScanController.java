package ink.gfwl.sample.web;

import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.SocketIOClient;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import ink.gfwl.common.http.IpAddressUtil;
import ink.gfwl.sample.model.QrScanInfo;
import ink.gfwl.sample.util.QrCodeUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 测试登录
 * @author jianpòlan
 * @version 1.0
 **/
@RequestMapping("/api/scan")
@Controller
public class TestScanController {

    @Resource
    private final RedisTemplate<String, QrScanInfo> redisTemplate = new RedisTemplate<>();

    // PC获取二维码
    @GetMapping("/code")
    public void getLoginCode(HttpServletRequest request, HttpServletResponse response) throws WriterException, IOException {
        String id = "PEAK" + request.getParameter("t");
        QrScanInfo qrScanInfo = new QrScanInfo();
        qrScanInfo.setScanId(id);
        qrScanInfo.setIp(IpAddressUtil.getIpAddress(request));
        redisTemplate.opsForValue().set(id, qrScanInfo, 30, TimeUnit.SECONDS);
        BitMatrix bitMatrix = QrCodeUtil.genBitMatrix(id);
        BufferedImage bufferedImage = QrCodeUtil.writeToBufferImage(bitMatrix);
        ImageIO.write(bufferedImage, "png", response.getOutputStream());
    }

    // APP获取扫码详情
    @GetMapping("/code/{id}")
    @ResponseBody
    public QrScanInfo getScanInfo(@PathVariable String id){
        QrScanInfo qrScanInfo = redisTemplate.opsForValue().get(id);
        if(qrScanInfo != null){
            // 获取APP登录者的信息，返回给APP
            qrScanInfo.setProvince("成都市");
            SocketIOClient socketIOClient = AppScanSocket.clientMap.get(id);
            if(socketIOClient != null){
                socketIOClient.sendEvent("scanSuccess", true);
            }
        }
        // 为空则为已过期
        return qrScanInfo;
    }

    @PostMapping("/code/{id}")
    @ResponseBody
    public Boolean scanConfirm(@PathVariable String id){
        // 此处效验
        // 登录确认，SOCKET通知PC端。通知生成TOKEN
        SocketIOClient socketIOClient = AppScanSocket.clientMap.get(id);
        if(socketIOClient != null){
            JSONObject result = new JSONObject();
            result.put("token", "token, 哈哈哈");
            socketIOClient.sendEvent("confirm", result);
            AppScanSocket.clientMap.remove(id);
        }
        return true;
    }

}
