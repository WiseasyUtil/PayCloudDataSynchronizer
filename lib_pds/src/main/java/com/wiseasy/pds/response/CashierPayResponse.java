package com.wiseasy.pds.response;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/16/2022
 * Time: 4:58 PM
 */
public class CashierPayResponse extends BaseResponse {
    String trans_no;
    int trans_status;

    public int getTrans_status() {
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
