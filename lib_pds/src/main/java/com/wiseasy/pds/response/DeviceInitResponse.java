package com.wiseasy.pds.response;

import org.json.JSONObject;

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
    BaseInfo basic_info;
    List<PayInfo> pay_info;
    String aes_key_cipher;
    String aes_key_expire_time;

    public List<PayInfo> getPay_info() {
        return pay_info;
    }

    public void setBasic_info(BaseInfo basic_info) {
        this.basic_info = basic_info;
    }

    public String getAes_key_cipher() {
        return aes_key_cipher;
    }

    public String getAes_key_expire_time() {
        return aes_key_expire_time;
    }

    public BaseInfo getBasic_info() {
        return basic_info;
    }
}

/**
 * 基础配置信息
 */
class BaseInfo {
    String country;
    String merchant_no;
    String institution_no;
    String city;
    String store_no;
    String timezone;
    String merchant_name;
    String language;
    int merchant_status;
    List<String> store_photos;
    String institution_name;
    String address_detail;
    String country_no;
    String country_code;
    JSONObject configuration_parameters;
    String country_code2;
    String supported_settlement_currencies;
    String store_name;
    String supported_price_currencies;
    String app_id;
    String terminal_sn;

    public int getMerchant_status() {
        return merchant_status;
    }

    public JSONObject getConfiguration_parameters() {
        return configuration_parameters;
    }

    public List<String> getStore_photos() {
        return store_photos;
    }

    public String getAddress_detail() {
        return address_detail;
    }

    public String getSupported_price_currencies() {
        return supported_price_currencies;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getCountry_code2() {
        return country_code2;
    }

    public String getCountry_no() {
        return country_no;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public String getApp_id() {
        return app_id;
    }

    public String getTerminal_sn() {
        return terminal_sn;
    }

    public String getInstitution_no() {
        return institution_no;
    }

    public String getLanguage() {
        return language;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public String getMerchant_no() {
        return merchant_no;
    }

    public String getStore_name() {
        return store_name;
    }

    public String getStore_no() {
        return store_no;
    }

    public String getSupported_settlement_currencies() {
        return supported_settlement_currencies;
    }

    public String getTimezone() {
        return timezone;
    }
}

/**
 * 支付信息
 */
class PayInfo {
    String pay_scenario;
    List<PayMethodInfo> pay_method_list;

    public String getPay_scenario() {
        return pay_scenario;
    }

    public List<PayMethodInfo> getPay_method_list() {
        return pay_method_list;
    }
}

/**
 * 支付方式信息
 */
class PayMethodInfo {
    String icon_url;
    String pay_channel_id;
    String is_alipay_plus;
    String pay_method_id;
    String supported_price_currencies;
    String pay_method_configuration;
    int sort;
    String pay_method_name;
    String supported_trans_type;

    public String getPay_method_id() {
        return pay_method_id;
    }

    public String getPay_method_name() {
        return pay_method_name;
    }

    public int getSort() {
        return sort;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public String getIs_alipay_plus() {
        return is_alipay_plus;
    }

    public String getPay_channel_id() {
        return pay_channel_id;
    }

    public String getPay_method_configuration() {
        return pay_method_configuration;
    }

    public String getSupported_price_currencies() {
        return supported_price_currencies;
    }

    public String getSupported_trans_type() {
        return supported_trans_type;
    }
}
