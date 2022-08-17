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
}
