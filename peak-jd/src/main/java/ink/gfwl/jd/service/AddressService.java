package ink.gfwl.jd.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ink.gfwl.jd.base.BaseQueryParam;
import ink.gfwl.jd.config.RequestURL;
import ink.gfwl.jd.model.address.AddressCastModel;
import ink.gfwl.jd.model.address.AddressCheckModel;
import ink.gfwl.jd.model.address.AddressModel;
import ink.gfwl.jd.model.address.result.AddressCastResult;
import ink.gfwl.jd.util.HttpUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 地址API
 * @author jianpòlan
 * @version 1.0
 **/
@Service
public class AddressService extends RequestURL {


    @Resource
    private BaseQueryParam baseQueryParam;

    /**
     * 查询地址
     * @param level <p>1，2，3，4；对应几级地址</p>
     *              <p>level=1, id为空</p>
     * @param id 父级ID
     * @return 地址列表
     */
    public AddressModel getAddress(int level, Integer id){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        String url = "";
        switch (level){
            case 1:
                url = URL_ADDRESS_PROVINCE;
                break;
            case 2:
                params.put("id", String.valueOf(id));
                url = URL_ADDRESS_CITY;
                break;
            case 3:
                params.put("id", String.valueOf(id));
                url = URL_ADDRESS_COUNTRY;
                break;
            case 4:
                params.put("id", String.valueOf(id));
                url = URL_ADDRESS_TOWN;
                break;
            default: //默认一级

        }
        String rs = HttpUtil.httpPost(url, params);
        return JSONObject.toJavaObject(JSON.parseObject(rs), AddressModel.class);
    }

    /**
     * 验证地址有效性
     * @param provinceId 一级地址
     * @param cityId 二级地址
     * @param countyId 三级地址
     * @param townId 四级地址（若三级地址下无四级地址传0）
     * @return AddressCheckModel
     */
    public AddressCheckModel checkAddress(Integer provinceId, Integer cityId, Integer countyId, Integer townId){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        params.put("provinceId", provinceId);
        params.put("cityId", cityId);
        params.put("countyId", countyId);
        params.put("townId", townId);
        String rs = HttpUtil.httpPost(URL_ADDRESS_CHECK, params);
        return JSONObject.toJavaObject(JSON.parseObject(rs), AddressCheckModel.class);
    }

    /**
     * 地址转换为京东地址
     * @param address 地址
     * @return 京东地址
     */
    public AddressCastModel addressCastJdAddress(String address){
        Map<String, Object> params = baseQueryParam.getBaseQueryParam();
        params.put("address", address);
        String rs = HttpUtil.httpPost(URL_ADDRESS_CAST, params);
        return JSONObject.toJavaObject(JSON.parseObject(rs), AddressCastModel.class);
    }

    /**
     * 验证地址是否能用
     * @param address 地址
     * @return 结果:true正确，false错误
     */
    public boolean simpleAddressCheck(String address){
        AddressCastModel addressCastModel = addressCastJdAddress(address);
        if("0000".equals(addressCastModel.getResultCode())){
            AddressCastResult result = addressCastModel.getResult();
            AddressCheckModel addressCheckModel = checkAddress(result.getProvinceId(),
                    result.getCityId(),
                    result.getCountyId(),
                    result.getTownId() == null ? 0 : result.getTownId());
            return addressCheckModel.getResult().isSuccess();
        }
        return false;
    }
}
