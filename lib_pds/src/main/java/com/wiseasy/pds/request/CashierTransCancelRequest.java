package com.wiseasy.pds.request;

import com.wiseasy.pds.response.BaseResponse;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/17/2022
 * Time: 5:11 PM
 */
class CashierTransCancelRequest extends BaseRequest<BaseResponse>{
    String terminal_sn;
    String merchant_order_no;
    String trans_no;

    @Override
    public String getRequestMethod() {
        return "cashier.trans.cancel";
    }

    public String getTerminal_sn() {
        return terminal_sn;
    }

    public void setTerminal_sn(String terminal_sn) {
        this.terminal_sn = terminal_sn;
    }

    public void setMerchant_order_no(String merchant_order_no) {
        this.merchant_order_no = merchant_order_no;
    }

    public void setTrans_no(String trans_no) {
        this.trans_no = trans_no;
    }

    public String getMerchant_order_no() {
        return merchant_order_no;
    }

    public String getTrans_no() {
        return trans_no;
    }

}
