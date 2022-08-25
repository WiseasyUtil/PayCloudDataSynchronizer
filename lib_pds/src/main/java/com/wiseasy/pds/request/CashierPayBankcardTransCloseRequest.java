package com.wiseasy.pds.request;

import com.wiseasy.pds.response.BaseResponse;

/**
 * bank card close request data
 * User: pupan
 * Date: 2022/7/7
 * Time: 16:54
 *
 * @author pupan
 */
public class CashierPayBankcardTransCloseRequest extends BaseRequest<BaseResponse> {
    String trans_no;
    String description;

    public String getTrans_no() {
        return trans_no;
    }

    public String getDescription() {
        return description;
    }

    public void setTrans_no(String trans_no) {
        this.trans_no = trans_no;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getRequestMethod() {
        return "cashier.pay.bankcard.trans.close";
    }
}
