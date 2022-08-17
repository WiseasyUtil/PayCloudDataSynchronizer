package com.wiseasy.pds.response;

import java.util.List;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/16/2022
 * Time: 5:55 PM
 * @author pupan
 */
public class TransactionListQueryResponse extends BaseResponse {
    int total;
    List<TransactionDetail> list;
}

class TransactionDetail {
    String trans_no;
    double trans_amount;
    double order_amount;
    int trans_status;
    int trans_type;
    String pay_method_id;
    String pay_method_name;
    String pay_method_icon_url;
    String pay_scenario;
    String created_time;
    String trans_end_time;
}
