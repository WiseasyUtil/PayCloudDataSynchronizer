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
    String price_currency;
    String store_no;
    double receivable_amount;
    double cashback_amount;
    double order_amount;
    double discount_bmoa;
    double total_fee;
    String app_id;
    String pay_channel_id;
    String institution_no;
    double refundable_amount;
    String trans_expire_time;
    double total_discount;
    String is_alipay_plus;
    String timezone;
    String description;
    String sub_pay_method_icon_url;
    double vat_rate;
    String sub_pay_method_id;

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setStore_no(String store_no) {
        this.store_no = store_no;
    }

    public void setInstitution_no(String institution_no) {
        this.institution_no = institution_no;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    @Override
    public void setSign(String sign) {
        super.setSign(sign);
    }

    @Override
    public void setCode(String code) {
        super.setCode(code);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCashback_amount(double cashback_amount) {
        this.cashback_amount = cashback_amount;
    }

    @Override
    public void setPsn(String psn) {
        super.setPsn(psn);
    }

    public void setDiscount_bmoa(double discount_bmoa) {
        this.discount_bmoa = discount_bmoa;
    }

    @Override
    public void setMsg(String msg) {
        super.setMsg(msg);
    }

    public void setReceivable_amount(double receivable_amount) {
        this.receivable_amount = receivable_amount;
    }

    public void setIs_alipay_plus(String is_alipay_plus) {
        this.is_alipay_plus = is_alipay_plus;
    }

    public void setPay_channel_id(String pay_channel_id) {
        this.pay_channel_id = pay_channel_id;
    }

    public void setRefundable_amount(double refundable_amount) {
        this.refundable_amount = refundable_amount;
    }

    public void setSub_pay_method_icon_url(String sub_pay_method_icon_url) {
        this.sub_pay_method_icon_url = sub_pay_method_icon_url;
    }

    public void setSub_pay_method_id(String sub_pay_method_id) {
        this.sub_pay_method_id = sub_pay_method_id;
    }

    public void setTotal_discount(double total_discount) {
        this.total_discount = total_discount;
    }

    public void setTotal_fee(double total_fee) {
        this.total_fee = total_fee;
    }

    public void setTrans_expire_time(String trans_expire_time) {
        this.trans_expire_time = trans_expire_time;
    }

    public void setVat_rate(double vat_rate) {
        this.vat_rate = vat_rate;
    }

    @Override
    public String getCode() {
        return super.getCode();
    }

    public String getStore_no() {
        return store_no;
    }

    public String getDescription() {
        return description;
    }

    public String getInstitution_no() {
        return institution_no;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getApp_id() {
        return app_id;
    }

    public double getOrder_amount() {
        return order_amount;
    }

    public double getCashback_amount() {
        return cashback_amount;
    }

    public String getPay_channel_id() {
        return pay_channel_id;
    }

    public double getDiscount_bmoa() {
        return discount_bmoa;
    }

    public double getReceivable_amount() {
        return receivable_amount;
    }

    public double getRefundable_amount() {
        return refundable_amount;
    }

    public String getIs_alipay_plus() {
        return is_alipay_plus;
    }

    public double getTotal_discount() {
        return total_discount;

    }

    public double getTotal_fee() {
        return total_fee;
    }

    public double getVat_rate() {
        return vat_rate;
    }

    public String getSub_pay_method_icon_url() {
        return sub_pay_method_icon_url;
    }

    public String getTrans_expire_time() {
        return trans_expire_time;
    }

    public String getSub_pay_method_id() {
        return sub_pay_method_id;
    }

    public void setOrder_amount(double order_amount) {
        this.order_amount = order_amount;
    }

    public void setPrice_currency(String price_currency) {
        this.price_currency = price_currency;
    }

    public String getPrice_currency() {
        return price_currency;
    }

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

    public void setTrans_no(String trans_no) {
        this.trans_no = trans_no;
    }

    public void setOrig_trans_no(String orig_trans_no) {
        this.orig_trans_no = orig_trans_no;

    }

    public void setPay_user_account_id(String pay_user_account_id) {
        this.pay_user_account_id = pay_user_account_id;
    }

    public void setPay_channel_trans_no(String pay_channel_trans_no) {
        this.pay_channel_trans_no = pay_channel_trans_no;
    }

    public void setPaid_amount(double paid_amount) {
        this.paid_amount = paid_amount;
    }

    public void setTrans_amount(double trans_amount) {
        this.trans_amount = trans_amount;
    }

    public void setDiscount_bpc(double discount_bpc) {
        this.discount_bpc = discount_bpc;
    }

    public void setDiscount_bmopc(double discount_bmopc) {
        this.discount_bmopc = discount_bmopc;
    }

    public void setTrans_status(int trans_status) {
        this.trans_status = trans_status;
    }

    public void setAcquirer_no(String acquirer_no) {
        this.acquirer_no = acquirer_no;
    }

    public void setTrans_type(int trans_type) {
        this.trans_type = trans_type;
    }

    public void setPay_scenario(String pay_scenario) {
        this.pay_scenario = pay_scenario;
    }

    public void setAuth_no(String auth_no) {
        this.auth_no = auth_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public void setPay_method_name(String pay_method_name) {
        this.pay_method_name = pay_method_name;
    }

    public void setPay_method_icon_url(String pay_method_icon_url) {
        this.pay_method_icon_url = pay_method_icon_url;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public void setCard_brand(String card_brand) {
        this.card_brand = card_brand;
    }

    public void setPay_method_id(String pay_method_id) {
        this.pay_method_id = pay_method_id;
    }

    public void setTrans_end_time(String trans_end_time) {
        this.trans_end_time = trans_end_time;
    }

    public void setBankcard_ext_params(String bankcard_ext_params) {
        this.bankcard_ext_params = bankcard_ext_params;
    }

    public void setCard_expire_date(String card_expire_date) {
        this.card_expire_date = card_expire_date;
    }

    public void setCard_issuers_no(String card_issuers_no) {
        this.card_issuers_no = card_issuers_no;
    }

    public void setCard_type(int card_type) {
        this.card_type = card_type;
    }

    public void setElectron_sign_url(String electron_sign_url) {
        this.electron_sign_url = electron_sign_url;
    }

    public void setPay_user_account_encrypt(String pay_user_account_encrypt) {
        this.pay_user_account_encrypt = pay_user_account_encrypt;
    }

    public void setRate_change_type(String rate_change_type) {
        this.rate_change_type = rate_change_type;
    }

    public void setRef_no(String ref_no) {
        this.ref_no = ref_no;
    }

    public void setRelated_trans_status(String related_trans_status) {
        this.related_trans_status = related_trans_status;
    }

    public void setSys_no(String sys_no) {
        this.sys_no = sys_no;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public void setVoucher_no(String voucher_no) {
        this.voucher_no = voucher_no;
    }
}
