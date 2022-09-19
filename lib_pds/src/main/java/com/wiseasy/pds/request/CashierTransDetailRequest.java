package com.wiseasy.pds.request;

import com.wiseasy.pds.response.TransactionDetailQueryResponse;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/17/2022
 * Time: 5:07 PM
 *
 * @author pupan
 */
public class CashierTransDetailRequest extends BaseRequest<TransactionDetailQueryResponse> {
    String terminal_sn;
    String trans_no;
    String app_id;
    String midapp_id;
    String merchant_order_no;

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_id() {
        return app_id;
    }

    public String getMidapp_id() {
        return midapp_id;
    }

    public String getMerchant_order_no() {
        return merchant_order_no;
    }

    public void setMidapp_id(String midapp_id) {
        this.midapp_id = midapp_id;
    }

    public void setMerchant_order_no(String merchant_order_no) {
        this.merchant_order_no = merchant_order_no;
    }

    @Override
    public String getRequestMethod() {
        return "cashier.trans.detail";
    }

    public String getTrans_no() {
        return trans_no;
    }

    public String getTerminal_sn() {
        return terminal_sn;
    }

    public void setTrans_no(String trans_no) {
        this.trans_no = trans_no;
    }

    public void setTerminal_sn(String terminal_sn) {
        this.terminal_sn = terminal_sn;
    }
}
