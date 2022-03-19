package com.peak.sms.test;

import com.peak.sms.TencentMessageUtil;
import com.peak.sms.model.TencentMessageRequest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
public class TencentMessageTest {

    @Resource
    private TencentMessageUtil tencentMessageUtil;

    @Test
    public void testTencentSend(){
        TencentMessageRequest tencentMessageRequest = new TencentMessageRequest();
        tencentMessageRequest.setTemplateId(""); // 模板ID
        tencentMessageRequest.setTemplateParam(null); // 模板参数
        tencentMessageRequest.setPhone(""); // 手机号
        tencentMessageUtil.sendMessage(tencentMessageRequest);
    }
}
