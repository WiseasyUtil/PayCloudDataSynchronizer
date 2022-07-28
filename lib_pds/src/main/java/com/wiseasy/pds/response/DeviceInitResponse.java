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
public class DeviceInitResponse extends BaseResponse{
    BaseInfo basic_info;
    List<PayInfo> pay_info;
    String aes_key_cipher;
    String aes_key_expire_time;
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
}

/**
 * 支付信息
 */
class PayInfo {
    String pay_scenario;
    List<PayMethodInfo> pay_method_list;
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
}
