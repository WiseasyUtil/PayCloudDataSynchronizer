package com.wiseasy.pds.request;

import com.wiseasy.pds.response.BaseResponse;

import org.json.JSONObject;

/**
 * bankcard trans complete requeset
 * User: pupan
 * Date: 2022/7/7
 * Time: 16:56
 * @author pupan
 */
public class CashierPayBankcardTransCompleteRequest extends BaseRequest<BaseResponse>{
    String trans_no;
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

    @Override
    public String getRequestMethod() {
        return "cashier.pay.bankcard.trans.complete";
    }

    public String getTrans_no() {
        return trans_no;
    }

    public void setTrans_no(String transNo) {
        this.trans_no = transNo;
    }

    public String getAuth_no() {
        return auth_no;
    }

    public String getElectron_sign_url() {
        return electron_sign_url;
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

    public void setBankcard_ext_params(JSONObject bankcard_ext_params) {
        this.bankcard_ext_params = bankcard_ext_params;
    }

    public void setElectron_sign_url(String electron_sign_url) {
        this.electron_sign_url = electron_sign_url;
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

    public void setRate_change_type(String rate_change_type) {
        this.rate_change_type = rate_change_type;
    }

    public void setRef_no(String ref_no) {
        this.ref_no = ref_no;
    }

    public void setSys_no(String sys_no) {
        this.sys_no = sys_no;
    }

    public void setTrans_end_time(String trans_end_time) {
        this.trans_end_time = trans_end_time;
    }

    public void setVoucher_no(String voucher_no) {
        this.voucher_no = voucher_no;
    }
}
