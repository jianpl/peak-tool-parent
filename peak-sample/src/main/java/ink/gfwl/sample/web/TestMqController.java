package ink.gfwl.sample.web;

import ink.gfwl.captcha.GraphCaptchaUtil;
import ink.gfwl.captcha.model.GraphResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
@RestController
@RequestMapping("/api/http")
@CrossOrigin
public class TestMqController {

    @Resource
    private GraphCaptchaUtil graphCaptchaUtil;


    @GetMapping("/captcha")
    public void captcha(HttpServletResponse response) throws IOException {
        GraphResult graphImage = graphCaptchaUtil.getGraphImage();
        System.out.println(graphImage.getCode());
        ImageIO.write(graphImage.getImage(), "png", response.getOutputStream());
    }
}
