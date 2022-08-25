package com.wiseasy.pds.request;

import com.wiseasy.pds.response.TransactionRefundResponse;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/18/2022
 * Time: 3:23 PM
 */
class CashierTransRefundRequest extends  BaseRequest<TransactionRefundResponse>{
    String terminal_sn;
    String orig_merchant_order_no;
    String orig_trans_no;
    double refund_amount;
    String merchant_order_no;
    String description;

    @Override
    public String getRequestMethod() {
        return "cashier.trans.refund";
    }

    public void setTerminal_sn(String terminal_sn) {
        this.terminal_sn = terminal_sn;
    }

    public void setMerchant_order_no(String merchant_order_no) {
        this.merchant_order_no = merchant_order_no;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrig_merchant_order_no(String orig_merchant_order_no) {
        this.orig_merchant_order_no = orig_merchant_order_no;
    }

    public void setOrig_trans_no(String orig_trans_no) {
        this.orig_trans_no = orig_trans_no;
    }

    public void setRefund_amount(double refund_amount) {
        this.refund_amount = refund_amount;
    }
}
