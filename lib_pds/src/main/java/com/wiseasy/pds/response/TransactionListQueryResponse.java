package com.wiseasy.pds.response;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/16/2022
 * Time: 5:55 PM
 *
 * @author pupan
 */
public class TransactionListQueryResponse extends BaseResponse {
    int total;
    List<JSONObject> list;

    public int getTotal() {
        return total;
    }

    public List<JSONObject> getList() {
        return list;
    }

    public void setList(List<JSONObject> list) {
        this.list = list;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
