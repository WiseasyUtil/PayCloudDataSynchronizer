package com.wiseasy.pds.response;

import com.alibaba.fastjson.JSONArray;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 12/8/2022
 * Time: 9:45 AM
 *
 * @author pupan
 */
public class CashierTransSummaryResponse extends BaseResponse {
    JSONArray summary;

    public JSONArray getSummary() {
        return summary;
    }

    public void setSummary(JSONArray summary) {
        this.summary = summary;
    }
}
