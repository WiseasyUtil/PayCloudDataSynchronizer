package com.wiseasy.pds.request;

import com.wiseasy.pds.response.BScanCPaymentResponse;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/16/2022
 * Time: 5:01 PM
 * @author pupan
 */
public class CashierPayBarcodepayRequest extends BaseRequest<BScanCPaymentResponse> {
    String terminal_sn;
    String auth_code;
    String pay_method_id;
    String merchant_order_no;
    String price_currency;
    double order_amount;
    String description;

    @Override
    public String getRequestMethod() {
        return "cashier.pay.barcodepay";
    }

    public String getMerchant_order_no() {
        return merchant_order_no;
    }

    public String getPay_method_id() {
        return pay_method_id;
    }

    public String getPrice_currency() {
        return price_currency;
    }

    public double getOrder_amount() {
        return order_amount;
    }

    public String getAuth_code() {
        return auth_code;
    }

    public void setMerchant_order_no(String merchant_order_no) {
        this.merchant_order_no = merchant_order_no;
    }

    public void setPay_method_id(String pay_method_id) {
        this.pay_method_id = pay_method_id;
    }

    public void setPrice_currency(String price_currency) {
        this.price_currency = price_currency;
    }

    public void setOrder_amount(double order_amount) {
        this.order_amount = order_amount;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    public String getDescription() {
        return description;
    }

    public String getTerminal_sn() {
        return terminal_sn;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setTerminal_sn(String terminal_sn) {
        this.terminal_sn = terminal_sn;
    }

}
