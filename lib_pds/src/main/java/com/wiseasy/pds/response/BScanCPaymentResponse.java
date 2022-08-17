package com.wiseasy.pds.response;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/16/2022
 * Time: 3:33 PM
 * @author pupan
 */
public class BScanCPaymentResponse extends  BaseResponse{
    String trans_no;
    int  trans_status;
    String pay_channel_trans_no;
    String pay_user_account_id;
    double trans_amount;
    double trans_fee_c;
    double vat_amount;
    double paid_amount;
    double discount_bmopc;
    double discount_bpc;
    String trans_end_time;
    String  exchange_rate;

}
