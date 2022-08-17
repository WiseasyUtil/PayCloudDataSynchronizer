package com.wiseasy.pds.request;

import com.wiseasy.pds.response.OtpCodePayResponse;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/16/2022
 * Time: 5:53 PM
 */
class CashierPayOtpcodepayRequest extends BaseRequest<OtpCodePayResponse> {
    String terminal_sn;
    String pay_method_id;
    String phone;
    String otp_code;
    String otp_code_type;
    String price_currency;
    String order_amount;
    String merchant_order_no;
    String description;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTerminal_sn(String terminal_sn) {
        this.terminal_sn = terminal_sn;
    }

    public void setPay_method_id(String pay_method_id) {
        this.pay_method_id = pay_method_id;
    }

    public void setPrice_currency(String price_currency) {
        this.price_currency = price_currency;
    }

    public void setOrder_amount(String order_amount) {
        this.order_amount = order_amount;
    }

    public void setMerchant_order_no(String merchant_order_no) {
        this.merchant_order_no = merchant_order_no;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOtp_code(String otp_code) {
        this.otp_code = otp_code;
    }

    public void setOtp_code_type(String otp_code_type) {
        this.otp_code_type = otp_code_type;
    }

    public String getPhone() {
        return phone;
    }

    public String getTerminal_sn() {
        return terminal_sn;
    }

    public String getPay_method_id() {
        return pay_method_id;
    }

    public String getPrice_currency() {
        return price_currency;
    }

    public String getMerchant_order_no() {
        return merchant_order_no;
    }

    public String getDescription() {
        return description;
    }

    public String getOrder_amount() {
        return order_amount;
    }

    public String getOtp_code() {
        return otp_code;
    }

    public String getOtp_code_type() {
        return otp_code_type;
    }
}
