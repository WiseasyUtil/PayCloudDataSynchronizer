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

    public void setBasic_info(BaseInfo basic_info) {
        this.basic_info = basic_info;
    }

    public void setAes_key_cipher(String aes_key_cipher) {
        this.aes_key_cipher = aes_key_cipher;

    }

    public void setAes_key_expire_time(String aes_key_expire_time) {
        this.aes_key_expire_time = aes_key_expire_time;
    }

    public void setPay_info(String pay_info) {
        this.pay_info = pay_info;
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

        public void setTerminal_sn(String terminal_sn) {
            this.terminal_sn = terminal_sn;
        }

        public void setAddress_detail(String address_detail) {
            this.address_detail = address_detail;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setConfiguration_parameters(JSONObject configuration_parameters) {
            this.configuration_parameters = configuration_parameters;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public void setCountry_code2(String country_code2) {
            this.country_code2 = country_code2;
        }

        public void setCountry_no(String country_no) {
            this.country_no = country_no;
        }

        public void setInstitution_name(String institution_name) {
            this.institution_name = institution_name;
        }

        public void setInstitution_no(String institution_no) {
            this.institution_no = institution_no;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public void setMerchant_name(String merchant_name) {
            this.merchant_name = merchant_name;
        }

        public void setMerchant_no(String merchant_no) {
            this.merchant_no = merchant_no;
        }

        public void setMerchant_status(int merchant_status) {
            this.merchant_status = merchant_status;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public void setStore_no(String store_no) {
            this.store_no = store_no;
        }

        public void setStore_photos(List<String> store_photos) {
            this.store_photos = store_photos;
        }

        public void setSupported_price_currencies(String supported_price_currencies) {
            this.supported_price_currencies = supported_price_currencies;
        }

        public void setSupported_settlement_currencies(String supported_settlement_currencies) {
            this.supported_settlement_currencies = supported_settlement_currencies;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }
    }

}

