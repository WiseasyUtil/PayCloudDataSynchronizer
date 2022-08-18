package com.wiseasy.pds.request;

import com.wiseasy.pds.response.TransactionDetailQueryResponse;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/17/2022
 * Time: 5:07 PM
 */
class CashierTransDetailRequest extends BaseRequest<TransactionDetailQueryResponse> {
    String terminal_sn;
    String trans_no;

    public void setTrans_no(String trans_no) {
        this.trans_no = trans_no;
    }

    public void setTerminal_sn(String terminal_sn) {
        this.terminal_sn = terminal_sn;
    }
}
