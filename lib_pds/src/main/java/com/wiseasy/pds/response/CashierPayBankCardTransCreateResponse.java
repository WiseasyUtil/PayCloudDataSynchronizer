package com.wiseasy.pds.response;

/**
 * create trans response
 * User: pupan
 * Date: 2022/7/6
 * Time: 11:26
 *
 * @author pupan
 */
public class CashierPayBankCardTransCreateResponse extends BaseResponse {
    String trans_no;

    public String getTrans_no() {
        return trans_no;
    }

    public void setTrans_no(String trans_no) {
        this.trans_no = trans_no;
    }
}
