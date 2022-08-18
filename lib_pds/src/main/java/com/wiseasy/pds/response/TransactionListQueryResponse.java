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

    public void setList(List<TransactionDetail> list) {
        this.list = list;
    }

    public void setTotal(int total) {
        this.total = total;
    }
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

    public String getTrans_end_time() {
        return trans_end_time;
    }

    public String getTrans_no() {
        return trans_no;
    }

    public double getTrans_amount() {
        return trans_amount;
    }

    public int getTrans_status() {
        return trans_status;
    }

    public String getCreated_time() {
        return created_time;
    }

    public String getPay_method_icon_url() {
        return pay_method_icon_url;
    }

    public String getPay_method_id() {
        return pay_method_id;
    }

    public double getOrder_amount() {
        return order_amount;
    }

    public int getTrans_type() {
        return trans_type;
    }

    public String getPay_method_name() {
        return pay_method_name;
    }

    public String getPay_scenario() {
        return pay_scenario;
    }
}
