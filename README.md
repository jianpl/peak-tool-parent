[TOC]



# JAVA 常用工具



> 说明：下方功能开发已完成，正在进行代码迁移优化，后续会陆续更新到GITHUB，且GITHUB作为唯一开源仓库，使用过程中若出现问题欢迎提交issues！
>
> Issues提交地址：https://github.com/jianpl/peak-tool-parent/issues/new
>
> GIT地址：https://github.com/jianpl/peak-tool-parent.git
>
> QQ交流群: https://jq.qq.com/?_wv=1027&k=OEVvMhWs
>
> 没及时更新可以进去催更




## 1. 目录结构描述

peak-parent-tool
├── peak-common  --  基础模块
├── peak-oss --  对象存储模块
├── peak-pay -- 支付模块
├── peak-sms -- 短信模块(阿里云、腾讯云已更)
├── peak-social -- 社交模块
LICENSE -- README.md
pom.xml -- pom.xml
README.md -- readme

## 2. 模块介绍

### 2.1 peak-common

基础模块，常用的功能

### 2.2 peak-oss

#### 	2.2.1 阿里云对象存储

#### 	2.2.2 腾讯云对象存储

### 2.3 peak-pay

#### 	2.3.1 微信支付

#### 	2.3.2 支付宝支付

#### 	2.3.3 Apple 内购

### 2.4 peak-sms

```java
// 调用示例 阿里云
@Resource
private AliYunMessageUtil aliYunMessageUtil;

@Test
public void testSendAliYun(){
    AliYunSendRequest aliYunSendRequest = new AliYunSendRequest();
    aliYunSendRequest.setPhone(""); // 手机号，格式参考官方文档
    aliYunSendRequest.setTemplateId(""); // 模板ID
    aliYunSendRequest.setParams(null); // 短信模板参数
    aliYunMessageUtil.sendMessage(aliYunSendRequest);
}

// 调用示例 腾讯云
@Resource
private TencentMessageUtil tencentMessageUtil;

@Test
public void testTencentSend(){
    TencentMessageRequest tencentMessageRequest = new TencentMessageRequest();
    tencentMessageRequest.setPhone(""); // 手机号，格式参考官方文档
    tencentMessageRequest.setTemplateId(""); // 模板ID
    tencentMessageRequest.setTemplateParam(null); // 短信模板参数
    tencentMessageUtil.sendMessage(tencentMessageRequest);
}
```



#### 	2.4.1 阿里云

```yaml
# 配置文件
peak:
  sms:
    ali:
      regionId: 地区
      accessKeyId: accessKeyId
      accessKeySecret: accessKeySecret
      signName: 签名
```



#### 	2.4.2 腾讯云

```yaml
# 配置文件
peak:
  sms:
    tencent:
      secretId: secretId
      secretKey: secretKey
      sdkAppId: appId
      signName: 签名
```



### 2.5 peak-social

#### 	2.5.1 微信登录 

#### 	2.5.2 支付宝登录

#### 	2.5.3 Apple登录







------

<p style="width: 100%;display: flex;justify-content: center">如果对您有用的话还希望赞赏一下</p>

<img src="img/admire.png" alt="admire" style="zoom: 50%;" />