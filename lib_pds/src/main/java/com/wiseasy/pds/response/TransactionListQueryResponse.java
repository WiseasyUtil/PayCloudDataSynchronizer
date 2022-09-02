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

    public int getTotal() {
        return total;
    }

    public List<TransactionDetail> getList() {
        return list;
    }

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

    public void setTrans_status(int trans_status) {
        this.trans_status = trans_status;
    }

    public void setTrans_no(String trans_no) {
        this.trans_no = trans_no;
    }

    public void setTrans_amount(double trans_amount) {
        this.trans_amount = trans_amount;
    }

    public void setTrans_end_time(String trans_end_time) {
        this.trans_end_time = trans_end_time;
    }

    public void setOrder_amount(double order_amount) {
        this.order_amount = order_amount;
    }

    public void setPay_method_id(String pay_method_id) {
        this.pay_method_id = pay_method_id;
    }

    public void setTrans_type(int trans_type) {
        this.trans_type = trans_type;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public void setPay_method_icon_url(String pay_method_icon_url) {
        this.pay_method_icon_url = pay_method_icon_url;
    }

    public void setPay_method_name(String pay_method_name) {
        this.pay_method_name = pay_method_name;
    }

    public void setPay_scenario(String pay_scenario) {
        this.pay_scenario = pay_scenario;
    }
}
