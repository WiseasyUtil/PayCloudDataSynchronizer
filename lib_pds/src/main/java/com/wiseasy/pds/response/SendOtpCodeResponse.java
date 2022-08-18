package com.wiseasy.pds.response;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/16/2022
 * Time: 4:15 PM
 */
public class SendOtpCodeResponse extends BaseResponse{
    String trans_no;
    int trans_status;
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

    @Override
    public void setSign(String sign) {
        super.setSign(sign);
    }

    public void setVat_amount(double vat_amount) {
        this.vat_amount = vat_amount;
    }

    public void setTrans_status(int trans_status) {
        this.trans_status = trans_status;
    }

    @Override
    public void setPsn(String psn) {
        super.setPsn(psn);
    }

    public void setTrans_no(String trans_no) {
        this.trans_no = trans_no;
    }

    public void setTrans_fee_c(double trans_fee_c) {
        this.trans_fee_c = trans_fee_c;
    }

    @Override
    public void setMsg(String msg) {
        super.setMsg(msg);
    }

    public void setTrans_amount(double trans_amount) {
        this.trans_amount = trans_amount;
    }

    public void setPay_user_account_id(String pay_user_account_id) {
        this.pay_user_account_id = pay_user_account_id;
    }

    public void setPay_channel_trans_no(String pay_channel_trans_no) {
        this.pay_channel_trans_no = pay_channel_trans_no;
    }

    @Override
    public void setCode(int code) {
        super.setCode(code);
    }

    public void setPaid_amount(double paid_amount) {
        this.paid_amount = paid_amount;
    }

    public void setExchange_rate(String exchange_rate) {
        this.exchange_rate = exchange_rate;
    }

    public void setDiscount_bpc(double discount_bpc) {
        this.discount_bpc = discount_bpc;
    }

    public void setDiscount_bmopc(double discount_bmopc) {
        this.discount_bmopc = discount_bmopc;
    }

    public void setTrans_end_time(String trans_end_time) {
        this.trans_end_time = trans_end_time;
    }

    public String getTrans_end_time() {
        return trans_end_time;
    }

    @Override
    public String getSign() {
        return super.getSign();
    }

    @Override
    public String getPsn() {
        return super.getPsn();
    }

    public String getTrans_no() {
        return trans_no;
    }

    @Override
    public String getMsg() {
        return super.getMsg();
    }

    @Override
    public int getCode() {
        return super.getCode();
    }

    public String getPay_user_account_id() {
        return pay_user_account_id;
    }

    public String getPay_channel_trans_no() {
        return pay_channel_trans_no;
    }

    public String getExchange_rate() {
        return exchange_rate;
    }

    public double getVat_amount() {
        return vat_amount;
    }

    public double getTrans_fee_c() {
        return trans_fee_c;
    }

    public double getTrans_amount() {
        return trans_amount;
    }

    public double getPaid_amount() {
        return paid_amount;
    }

    public double getDiscount_bpc() {
        return discount_bpc;
    }

    public int getTrans_status() {
        return trans_status;
    }

    public double getDiscount_bmopc() {
        return discount_bmopc;
    }
}
