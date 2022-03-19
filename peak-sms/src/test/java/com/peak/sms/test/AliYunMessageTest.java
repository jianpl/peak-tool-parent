package com.peak.sms.test;

import com.peak.sms.AliYunMessageUtil;
import com.peak.sms.model.AliYunSendRequest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author jianpòlan
 * @version 1.0
 **/
public class AliYunMessageTest {

    @Resource
    private AliYunMessageUtil aliYunMessageUtil;

    @Test
    public void testSendAliYun(){
        AliYunSendRequest aliYunSendRequest = new AliYunSendRequest();
        aliYunSendRequest.setParams(null); // 短信模板参数
        aliYunSendRequest.setPhone(""); // 手机号，格式参考官方文档
        aliYunSendRequest.setTemplateId(""); // 模板ID
        aliYunMessageUtil.sendMessage(aliYunSendRequest);
    }

}
