package com.wiseasy.pds.response;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/17/2022
 * Time: 4:21 PM
 */
public class TransactionDetailQueryResponse extends BaseResponse {
    String trans_no;
    String orig_trans_no;
    String related_trans_status;
    String ref_no;
    String voucher_no;
    String batch_no;
    String auth_no;
    String sys_no;
    String pay_channel_trans_no;
    double paid_amount;
    double discount_bmopc;
    double discount_bpc;
    String electron_sign_url;
    String pay_user_account_id;
    int card_type;
    String card_brand;
    String card_issuers_no;
    String acquirer_no;
    String rate_change_type;
    String bankcard_ext_params;
    String pay_user_account_encrypt;
    String card_expire_date;
    double trans_amount;
    int trans_status;
    int trans_type;
    String pay_method_id;
    String pay_method_name;
    String pay_method_icon_url;
    String pay_scenario;
    String created_time;
    String trans_end_time;
    String update_time;

    public String getTrans_no() {
        return trans_no;
    }

    public String getPay_user_account_id() {
        return pay_user_account_id;
    }

    public String getPay_method_name() {
        return pay_method_name;
    }

    public String getPay_scenario() {
        return pay_scenario;
    }

    public int getTrans_type() {
        return trans_type;
    }

    public String getPay_method_id() {
        return pay_method_id;
    }

    public int getTrans_status() {
        return trans_status;
    }

    public String getPay_channel_trans_no() {
        return pay_channel_trans_no;
    }

    public double getPaid_amount() {
        return paid_amount;
    }

    public double getTrans_amount() {
        return trans_amount;
    }

    public double getDiscount_bpc() {
        return discount_bpc;
    }

    public String getPay_method_icon_url() {
        return pay_method_icon_url;
    }

    public double getDiscount_bmopc() {
        return discount_bmopc;
    }

    public String getCreated_time() {
        return created_time;
    }

    public int getCard_type() {
        return card_type;
    }

    public String getBankcard_ext_params() {
        return bankcard_ext_params;
    }

    public String getTrans_end_time() {
        return trans_end_time;
    }

    public String getAcquirer_no() {
        return acquirer_no;
    }

    public String getAuth_no() {
        return auth_no;
    }

    public String getBatch_no() {
        return batch_no;
    }

    @Override
    public String getSign() {
        return super.getSign();
    }

    public String getCard_brand() {
        return card_brand;
    }

    public String getCard_issuers_no() {
        return card_issuers_no;
    }

    public String getCard_expire_date() {
        return card_expire_date;
    }

    @Override
    public String getPsn() {
        return super.getPsn();
    }

    @Override
    public String getMsg() {
        return super.getMsg();
    }

    public String getElectron_sign_url() {
        return electron_sign_url;
    }

    public String getOrig_trans_no() {
        return orig_trans_no;
    }

    public String getPay_user_account_encrypt() {
        return pay_user_account_encrypt;
    }

    public String getRate_change_type() {
        return rate_change_type;
    }

    public String getRef_no() {
        return ref_no;
    }

    public String getRelated_trans_status() {
        return related_trans_status;
    }

    public String getSys_no() {
        return sys_no;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public String getVoucher_no() {
        return voucher_no;
    }
}
