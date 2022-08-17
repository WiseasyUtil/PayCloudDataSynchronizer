package com.wiseasy.pds.request;

import com.wiseasy.pds.response.BScanCPaymentResponse;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/16/2022
 * Time: 5:01 PM
 */
class CashierPayBarcodepayRequest extends BaseRequest<BScanCPaymentResponse> {
    String terminal_sn;
    String trans_no;
    String description;

    public String getDescription() {
        return description;
    }

    public String getTerminal_sn() {
        return terminal_sn;
    }

    public String getTrans_no() {
        return trans_no;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTerminal_sn(String terminal_sn) {
        this.terminal_sn = terminal_sn;
    }

    public void setTrans_no(String trans_no) {
        this.trans_no = trans_no;
    }
}
