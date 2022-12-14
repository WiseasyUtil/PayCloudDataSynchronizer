package com.wiseasy.pds.request;

import com.wiseasy.pds.response.TransactionListQueryResponse;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 2022/7/5
 * Time: 15:13
 */
public class CashierTransListRequest extends BaseRequest<TransactionListQueryResponse> {
    String terminal_sn;
    String price_currency;
    int trans_type;
    int page_num;
    int page_size;
    String app_id;
    String store_no;
    String trans_end_time_min;
    String trans_end_time_max;
    String trans_keywords;
    String pay_method_id;

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public void setStore_no(String store_no) {
        this.store_no = store_no;
    }

    public void setTrans_end_time_min(String trans_end_time_min) {
        this.trans_end_time_min = trans_end_time_min;
    }

    public void setTrans_end_time_max(String trans_end_time_max) {
        this.trans_end_time_max = trans_end_time_max;
    }

    public String getTrans_end_time_min() {
        return trans_end_time_min;
    }

    public String getTrans_end_time_max() {
        return trans_end_time_max;
    }

    public String getApp_id() {
        return app_id;
    }

    public String getStore_no() {
        return store_no;
    }

    @Override
    public String getRequestMethod() {
        return "cashier.trans.list";
    }

    public void setPrice_currency(String price_currency) {
        this.price_currency = price_currency;
    }

    public void setPay_method_id(String pay_method_id) {
        this.pay_method_id = pay_method_id;
    }

    public void setTerminal_sn(String terminal_sn) {
        this.terminal_sn = terminal_sn;
    }

    public void setPage_num(int page_num) {
        this.page_num = page_num;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public void setTrans_keywords(String trans_keywords) {
        this.trans_keywords = trans_keywords;
    }

    public void setTrans_type(int trans_type) {
        this.trans_type = trans_type;
    }

    public String getPrice_currency() {
        return price_currency;
    }

    public String getPay_method_id() {
        return pay_method_id;
    }

    public String getTerminal_sn() {
        return terminal_sn;
    }

    public int getPage_size() {
        return page_size;
    }

    public int getPage_num() {
        return page_num;
    }

    public int getTrans_type() {
        return trans_type;
    }

    public String getTrans_keywords() {
        return trans_keywords;
    }
}
