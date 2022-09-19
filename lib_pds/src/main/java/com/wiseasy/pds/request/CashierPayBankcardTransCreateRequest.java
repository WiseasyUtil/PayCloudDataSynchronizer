package com.wiseasy.pds.request;

import com.wiseasy.pds.response.CashierPayBankCardTransCreateResponse;

import org.json.JSONObject;

/**
 * bankcard trans params
 * User: pupan
 * Date: 2022/7/1
 * Time: 15:04
 *
 * @author pupan
 */
public class CashierPayBankcardTransCreateRequest extends BaseRequest<CashierPayBankCardTransCreateResponse> {
    String trans_no;
    String price_currency;
    Double order_amount;
    String cashback_amount;
    String trans_type;
    String description;
    String pay_method_id;
    String orig_trans_no;
    String orig_merchant_order_no;
    String midapp_id;
    String merchant_order_no;
    String call_midapp_mode;
    String app_id;
    String os_type;
    String longitude;
    String latitude;
    String timestamp;
    String term_ip;
    JSONObject env_params;
    String trans_end_time;
    String ref_no;
    String voucher_no;
    String batch_no;
    String auth_no;
    String sys_no;
    String electron_sign_url;
    String pay_user_account_id;
    String pay_user_account_encrypt;
    String pay_user_account_name;
    String card_expire_date;
    String card_type;
    String card_brand;
    String card_issuers_no;
    String acquirer_no;
    String rate_change_type;
    JSONObject bankcard_ext_params;

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_id() {
        return app_id;
    }

    @Override
    public String getRequestMethod() {
        return "cashier.pay.bankcard.trans.create";
    }

    public void setOrig_merchant_order_no(String orig_merchant_order_no) {
        this.orig_merchant_order_no = orig_merchant_order_no;

    }

    public void setMerchant_order_no(String merchant_order_no) {
        this.merchant_order_no = merchant_order_no;
    }

    public void setCall_midapp_mode(String call_midapp_mode) {
        this.call_midapp_mode = call_midapp_mode;
    }

    public void setMidapp_id(String midapp_id) {
        this.midapp_id = midapp_id;
    }

    public void setOs_type(String os_type) {
        this.os_type = os_type;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getOrig_merchant_order_no() {
        return orig_merchant_order_no;
    }

    public String getMerchant_order_no() {
        return merchant_order_no;
    }

    public String getCall_midapp_mode() {
        return call_midapp_mode;
    }

    public JSONObject getBankcard_ext_params() {
        return bankcard_ext_params;
    }

    public String getMidapp_id() {
        return midapp_id;
    }

    public String getOs_type() {
        return os_type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getTrans_no() {
        return trans_no;
    }

    public void setTrans_no(String transNo) {
        this.trans_no = transNo;
    }

    public String getTrans_type() {
        return trans_type;
    }

    public String getCashback_amount() {
        return cashback_amount;
    }

    public Double getOrder_amount() {
        return order_amount;
    }

    public JSONObject getEnv_params() {
        return env_params;
    }

    public String getDescription() {
        return description;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getBatch_no() {
        return batch_no;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getOrig_trans_no() {
        return orig_trans_no;
    }

    public String getAuth_no() {
        return auth_no;
    }

    public String getElectron_sign_url() {
        return electron_sign_url;
    }

    public String getPay_method_id() {
        return pay_method_id;
    }

    public String getPrice_currency() {
        return price_currency;
    }

    public String getPay_user_account_id() {
        return pay_user_account_id;
    }

    public String getRef_no() {
        return ref_no;
    }

    public String getSys_no() {
        return sys_no;
    }

    public String getTerm_ip() {
        return term_ip;
    }

    public String getCard_type() {
        return card_type;
    }

    public String getTrans_end_time() {
        return trans_end_time;
    }

    public String getCard_expire_date() {
        return card_expire_date;
    }

    public String getAcquirer_no() {
        return acquirer_no;
    }

    public String getCard_brand() {
        return card_brand;
    }

    public String getPay_user_account_encrypt() {
        return pay_user_account_encrypt;
    }

    public String getPay_user_account_name() {
        return pay_user_account_name;
    }

    public String getVoucher_no() {
        return voucher_no;
    }

    public String getCard_issuers_no() {
        return card_issuers_no;
    }

    public String getRate_change_type() {
        return rate_change_type;
    }

    public void setTrans_type(String trans_type) {
        this.trans_type = trans_type;
    }

    public void setAuth_no(String auth_no) {
        this.auth_no = auth_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public void setCard_brand(String card_brand) {
        this.card_brand = card_brand;
    }

    public void setCard_expire_date(String card_expire_date) {
        this.card_expire_date = card_expire_date;
    }

    public void setAcquirer_no(String acquirer_no) {
        this.acquirer_no = acquirer_no;
    }

    public void setCard_issuers_no(String card_issuers_no) {
        this.card_issuers_no = card_issuers_no;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public void setCashback_amount(String cashback_amount) {
        this.cashback_amount = cashback_amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBankcard_ext_params(JSONObject bankcard_ext_params) {
        this.bankcard_ext_params = bankcard_ext_params;
    }

    public void setElectron_sign_url(String electron_sign_url) {
        this.electron_sign_url = electron_sign_url;
    }

    public void setEnv_params(JSONObject env_params) {
        this.env_params = env_params;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setOrder_amount(Double order_amount) {
        this.order_amount = order_amount;
    }

    public void setOrig_trans_no(String orig_trans_no) {
        this.orig_trans_no = orig_trans_no;
    }

    public void setPay_method_id(String pay_method_id) {
        this.pay_method_id = pay_method_id;
    }

    public void setPay_user_account_encrypt(String pay_user_account_encrypt) {
        this.pay_user_account_encrypt = pay_user_account_encrypt;
    }

    public void setPay_user_account_id(String pay_user_account_id) {
        this.pay_user_account_id = pay_user_account_id;
    }

    public void setPay_user_account_name(String pay_user_account_name) {
        this.pay_user_account_name = pay_user_account_name;
    }

    public void setPrice_currency(String price_currency) {
        this.price_currency = price_currency;
    }

    public void setRate_change_type(String rate_change_type) {
        this.rate_change_type = rate_change_type;
    }

    public void setRef_no(String ref_no) {
        this.ref_no = ref_no;
    }

    public void setSys_no(String sys_no) {
        this.sys_no = sys_no;
    }

    public void setTerm_ip(String term_ip) {
        this.term_ip = term_ip;
    }

    public void setTrans_end_time(String trans_end_time) {
        this.trans_end_time = trans_end_time;
    }

    public void setVoucher_no(String voucher_no) {
        this.voucher_no = voucher_no;
    }
}
