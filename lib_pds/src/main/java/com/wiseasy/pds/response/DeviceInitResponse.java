package com.wiseasy.pds.response;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * initial response data
 * User: pupan
 * Date: 2022/7/1
 * Time: 9:40
 *
 * @author pupan
 */
public class DeviceInitResponse extends BaseResponse {
    JSONObject basic_info;
    List<JSONObject> pay_info;
    String aes_key_cipher;
    String aes_key_expire_time;

    public List<JSONObject> getPay_info() {
        return pay_info;
    }

    public String getAes_key_cipher() {
        return aes_key_cipher;
    }

    public String getAes_key_expire_time() {
        return aes_key_expire_time;
    }

    public JSONObject getBasic_info() {
        return basic_info;
    }

    public void setBasic_info(JSONObject basic_info) {
        this.basic_info = basic_info;
    }

    public void setAes_key_cipher(String aes_key_cipher) {
        this.aes_key_cipher = aes_key_cipher;

    }

    public void setAes_key_expire_time(String aes_key_expire_time) {
        this.aes_key_expire_time = aes_key_expire_time;
    }

    public void setPay_info(List<JSONObject> pay_info) {
        this.pay_info = pay_info;
    }
}

