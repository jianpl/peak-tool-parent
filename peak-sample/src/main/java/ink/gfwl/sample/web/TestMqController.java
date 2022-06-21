package ink.gfwl.sample.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get")
    public JSONObject sendMessage(){;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("nickName", "张三");
        return jsonObject;
    }

    @PostMapping("/post/body")
    public JSONObject postBody(@RequestBody JSONObject jsonObject){
        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("message", "request success.");
        result.put("data", jsonObject);
        return result;
    }
}
