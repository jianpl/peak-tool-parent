# 根据接口文档，可以编写满足需求的bash文件，实现自动部署功能。
# 一种实现案例(依赖:openssl,unzip)：
# 主要参数说明：
# ORDER_ID：证书ID
# TYPE：证书ID类型。参见证书下载接口，建议auto。
# API_TOKEN：接口凭证，在后台获取。
# API_USER：账户名。注册的邮箱或者手机号。

#!/usr/bin/env bash
export PATH=$PATH:/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:~/bin
# 参数配置 开始
ORDER_ID='*****' # 证书ID
TYPE='auto' # 证书ID类型。参见证书下载接口，建议auto。需要有独立通道
API_TOKEN='**************' # 接口凭证，在后台获取
API_USER='**************' # 账户名。注册的邮箱或者手机号
# 证书路径包含文件名称
FILE_CERT='/www/server/panel/vhost/cert/fullchain.pem'
FILE_CERT_KEY='/www/server/panel/vhost/cert/privkey.pem'
# nginx 重启命令
COMAND_RELOAD='nginx -s reload'
# 参数配置 结束

# 以下内容根据需求修改
# 证书到期前13天内才会更新
isexpire=`openssl x509 -in ${FILE_CERT} -noout -enddate -checkend 9123200`
if echo "${isexpire}" | grep  " not " ; then
    echo "Certificate will not expire."
    exit 1
fi

API_URL='https://api.osfipin.com/letsencrypt/api'
URL_ORDER_DOWN="${API_URL}/order/down"
HEADER_AUTHOR="Authorization: Bearer ${API_TOKEN}:${API_USER}"
ZIP_FILE="${ORDER_ID}.$RANDOM"
curl ${URL_ORDER_DOWN} -H "${HEADER_AUTHOR}" -G -d "id=${ORDER_ID}" -d "type=${TYPE}" -o ${ZIP_FILE}.zip

if [ ! -s "${ZIP_FILE}.zip" ]; then
    echo "download error."
    exit 1
fi

size=`du -b ${ZIP_FILE}.zip | awk '{print $1}'`
if [[ ${size} -lt 500 ]]; then
    echo "download file error."
    cat ${ZIP_FILE}.zip
    unlink ${ZIP_FILE}.zip
    exit 1
fi


# 解压 移动文件
mkdir -p ${ZIP_FILE}
unzip ${ZIP_FILE}.zip -d ${ZIP_FILE}
/bin/cp ${ZIP_FILE}/fullchain.crt ${FILE_CERT}
/bin/cp ${ZIP_FILE}/private.pem ${FILE_CERT_KEY}
# 删除 打完收工
unlink ${ZIP_FILE}.zip
rm -rf ${ZIP_FILE}

`${COMAND_RELOAD}`