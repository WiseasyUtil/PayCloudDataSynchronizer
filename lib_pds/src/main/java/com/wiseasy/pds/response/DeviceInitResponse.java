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
    String pay_info;
    String aes_key_cipher;
    String aes_key_expire_time;

    public String getPay_info() {
        return pay_info;
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

    /**
     * 基础配置信息
     */
    public class BaseInfo {
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

}

