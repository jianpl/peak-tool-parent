//package ink.gfwl.social.app;
//
//import com.corundumstudio.socketio.Configuration;
//import com.corundumstudio.socketio.SocketIOClient;
//import com.corundumstudio.socketio.SocketIOServer;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * PC长连接
// * @author jianpòlan
// * @version 1.0
// **/
//@Service
//public class AppScanSocket {
//
//    /**
//     * 用来存已连接的客户端
//     */
//    private static final Map<String, SocketIOClient> clientMap = new ConcurrentHashMap<>();
//
//    private SocketIOServer socketIOServer;
//
//    private final org.slf4j.Logger log = LoggerFactory.getLogger(AppScanSocket.class);
//
//    /**
//     * Spring IoC容器创建之后，在加载SocketIOServiceImpl Bean之后启动
//     */
//    @PostConstruct
//    private void autoStartup() {
//        start();
//    }
//
//    /**
//     * Spring IoC容器在销毁SocketIOServiceImpl Bean之前关闭,避免重启项目服务端口占用问题
//     */
//    @PreDestroy
//    private void autoStop()  {
//        stop();
//    }
//
//
//    private void start() {
//        Configuration config = new Configuration();
//        // 别加，不然部署生产环境会出现访问不了的现象
//        // config.setHostname("127.0.0.1");
//
//        config.setPort(9092);
//        config.setMaxFramePayloadLength(1024 * 1024);
//        config.setMaxHttpContentLength(1024 * 1024);
//        socketIOServer = new SocketIOServer(config);
//
//        socketIOServer.addConnectListener((SocketIOClient client) -> {
//            String clientInfo = client.getRemoteAddress().toString();
//            String clientIp = clientInfo.substring(1,clientInfo.indexOf(":"));//获取ip
//            log.info("链接用户：{}, {}", clientIp, client.getSessionId());
//            client.sendEvent("con", "123");
//        });
//
//        socketIOServer.addDisconnectListener(client -> {
//            String clientInfo = client.getRemoteAddress().toString();
//            String clientIp = clientInfo.substring(1,clientInfo.indexOf(":"));//获取ip
//            client.sendEvent("discon", "ip: " + clientIp);
//            log.info("socket.io断开链接");
//        });
//
//        socketIOServer.addEventListener("wakeup", String.class, (client, data, arg2) -> {
////            String clientInfo = client.getRemoteAddress().toString();
////            String clientIp = clientInfo.substring(1, clientInfo.indexOf(":"));
//            System.out.println("：客户端：************"+data);
//
//            client.sendEvent("con","测试下");
//        });
//
//        socketIOServer.start();
//        log.info("socket.io初始化服务完成");
//    }
//
//    public void stop() {
//        if (socketIOServer != null) {
//            socketIOServer.stop();
//            socketIOServer = null;
//        }
//        log.info("socket.io服务已关闭");
//    }
//
//}
