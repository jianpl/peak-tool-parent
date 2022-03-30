- [JAVA 常用工具](#java-常用工具)
  - [使用说明](#使用说明)
  - [子包说明：](#子包说明)
  - [打赏](#打赏)
  - [版本号](#版本号)
    - [1.0.1](#101)
    - [1.0.0](#100)

# JAVA 常用工具

## 使用说明
>
> ```xml
> <!-- oss -->
> <dependency>
>   <groupId>ink.gfwl</groupId>
>   <artifactId>peak-oss</artifactId>
>   <version>${lastVersion}</version>
> </dependency>
> <!-- 支付 -->
> <dependency>
>   <groupId>ink.gfwl</groupId>
>   <artifactId>peak-pay</artifactId>
>   <version>${lastVersion}</version>
> </dependency>
> <!-- 短信 -->
> <dependency>
>   <groupId>ink.gfwl</groupId>
>   <artifactId>peak-sms</artifactId>
>   <version>${lastVersion}</version>
> </dependency>
> <!-- 社交登录 -->
> <dependency>
>   <groupId>ink.gfwl</groupId>
>   <artifactId>peak-social</artifactId>
>   <version>${lastVersion}</version>
> </dependency>


## 子包说明：
>
> 1. ink.gfwl.common 公共资源，下方工具第三方接口api秘钥信息
> 2. ink.gfwl.oss 对象存储
>> 阿里云
> 
>> 腾讯云
> 3. ink.gfwl.pay 支付
> 4. ink.gfwl.sms 短信
>> 阿里云
> 
>> 腾讯云
> 
>> 助通
> 5. ink.gfwl.socia 社交登录
>> 支付宝(APP)
> 
>> 苹果(APP)
>
>> Github(网页)
>
>> 微信(小程序、APP、网页扫码)
>
> 5. peak-sample 为示例代码（看看就行，别当真）



> 说明：下方功能开发已完成，正在进行代码迁移优化，后续会陆续更新到GITHUB，且GITHUB作为唯一开源仓库，使用过程中若出现问题欢迎提交issues！
>
> Issues提交地址：https://github.com/jianpl/peak-tool-parent/issues/new
>
> GIT地址：https://github.com/jianpl/peak-tool-parent.git
>


------
## 打赏
<p style="width: 100%;display: flex;justify-content: center">如果对您有用的话还希望赞赏一下</p>

<img src="img/admire.png" alt="admire" style="zoom: 50%;" />

## 版本号

### 1.0.1
更新时间：撸代码中，github已提交

更新：
1. OSS 

    1.1 阿里云
   
    1.2 腾讯云对象存储
   
2. 社交登录
    
    2.1 APP支付宝登录

    2.2 APP Apple登录

    2.3 Github网页授权

    2.4 微信小程序、APP微信登录、微信扫码登录(网页)

### 1.0.0
更新时间：2022-03-21

更新短信相关接口