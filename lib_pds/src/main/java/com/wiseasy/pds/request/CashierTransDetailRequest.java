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
}
