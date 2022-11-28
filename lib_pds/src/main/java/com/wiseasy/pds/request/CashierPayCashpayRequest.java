package com.wiseasy.pds.request;

import com.wiseasy.pds.response.CashierPayResponse;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 11/28/2022
 * Time: 10:15 AM
 * @author pupan
 */
public class CashierPayCashpayRequest extends BaseRequest<CashierPayResponse> {

    String price_currency;
    String order_amount;
    String merchant_order_no;
    String description;

    @Override
    public String getRequestMethod() {
        return "cashier.pay.cashpay";
    }

    public void setMerchant_order_no(String merchant_order_no) {
        this.merchant_order_no = merchant_order_no;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrder_amount(String order_amount) {
        this.order_amount = order_amount;
    }

    public void setPrice_currency(String price_currency) {
        this.price_currency = price_currency;
    }

    public String getMerchant_order_no() {
        return merchant_order_no;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice_currency() {
        return price_currency;
    }

    public String getOrder_amount() {
        return order_amount;
    }

}
