package com.wiseasy.pds.response;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/16/2022
 * Time: 4:58 PM
 */
public class CashierPayResponse extends BaseResponse {
    String trans_no;
    double trans_status;
    String trans_end_time;
    String pay_scenario;
    double trans_fee_m;
    String description;
    double trans_fee_c;
    double receivable_amount;
    double discount_bpc;
    double cashback_amount;
    double vat_amount;
    double discount_bmoa;
    double order_amount;
    String app_id;
    String price_currency;
    String terminal_sn;
    double trans_type;
    String merchant_no;
    String create_time;
    String institution_no;
    String pay_method_id;
    double trans_amount;
    String settlement_currency;
    String sub_pay_method_id;
    double paid_amount;
    double discount_bmopc;
    String trans_expire_time;

    public String getPrice_currency() {
        return price_currency;
    }

    public String getDescription() {
        return description;
    }

    public String getTerminal_sn() {
        return terminal_sn;
    }

    public String getApp_id() {
        return app_id;
    }

    public String getInstitution_no() {
        return institution_no;
    }

    public String getPay_scenario() {
        return pay_scenario;
    }

    public String getTrans_end_time() {
        return trans_end_time;
    }

    public String getSub_pay_method_id() {
        return sub_pay_method_id;
    }

    public double getCashback_amount() {
        return cashback_amount;
    }

    public String getMerchant_no() {
        return merchant_no;
    }

    public double getTrans_type() {
        return trans_type;
    }

    public double getDiscount_bmoa() {
        return discount_bmoa;
    }

    public double getDiscount_bpc() {
        return discount_bpc;
    }

    public String getPay_method_id() {
        return pay_method_id;
    }

    public double getOrder_amount() {
        return order_amount;
    }

    public String getTrans_expire_time() {
        return trans_expire_time;
    }

    public double getReceivable_amount() {
        return receivable_amount;
    }

    public double getDiscount_bmopc() {
        return discount_bmopc;
    }

    public double getTrans_fee_c() {
        return trans_fee_c;
    }

    public double getPaid_amount() {
        return paid_amount;
    }

    public String getCreate_time() {
        return create_time;
    }

    public double getTrans_amount() {
        return trans_amount;
    }

    public String getSettlement_currency() {
        return settlement_currency;
    }

    public double getTrans_fee_m() {
        return trans_fee_m;
    }

    public double getVat_amount() {
        return vat_amount;
    }

    public void setPrice_currency(String price_currency) {
        this.price_currency = price_currency;
    }

    public void setOrder_amount(int order_amount) {
        this.order_amount = order_amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTerminal_sn(String terminal_sn) {
        this.terminal_sn = terminal_sn;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public void setInstitution_no(String institution_no) {
        this.institution_no = institution_no;
    }

    public void setTrans_expire_time(String trans_expire_time) {
        this.trans_expire_time = trans_expire_time;
    }

    public void setSub_pay_method_id(String sub_pay_method_id) {
        this.sub_pay_method_id = sub_pay_method_id;
    }

    public void setReceivable_amount(int receivable_amount) {
        this.receivable_amount = receivable_amount;
    }

    public void setDiscount_bmoa(int discount_bmoa) {
        this.discount_bmoa = discount_bmoa;
    }

    public void setCashback_amount(int cashback_amount) {
        this.cashback_amount = cashback_amount;
    }

    public void setPay_scenario(String pay_scenario) {
        this.pay_scenario = pay_scenario;
    }

    public void setMerchant_no(String merchant_no) {
        this.merchant_no = merchant_no;
    }

    public void setTrans_end_time(String trans_end_time) {
        this.trans_end_time = trans_end_time;
    }

    public void setPay_method_id(String pay_method_id) {
        this.pay_method_id = pay_method_id;
    }

    public void setTrans_type(int trans_type) {
        this.trans_type = trans_type;
    }

    public void setDiscount_bpc(int discount_bpc) {
        this.discount_bpc = discount_bpc;
    }

    public void setDiscount_bmopc(int discount_bmopc) {
        this.discount_bmopc = discount_bmopc;
    }

    public void setTrans_amount(int trans_amount) {
        this.trans_amount = trans_amount;
    }

    public void setPaid_amount(int paid_amount) {
        this.paid_amount = paid_amount;
    }

    public void setVat_amount(int vat_amount) {
        this.vat_amount = vat_amount;
    }

    public void setTrans_fee_c(int trans_fee_c) {
        this.trans_fee_c = trans_fee_c;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setSettlement_currency(String settlement_currency) {
        this.settlement_currency = settlement_currency;
    }

    public void setTrans_fee_m(int trans_fee_m) {
        this.trans_fee_m = trans_fee_m;
    }

    public double getTrans_status() {
        return trans_status;
    }

    public String getTrans_no() {
        return trans_no;
    }

    public void setTrans_status(int trans_status) {
        this.trans_status = trans_status;
    }

    public void setTrans_no(String trans_no) {
        this.trans_no = trans_no;
    }
}
