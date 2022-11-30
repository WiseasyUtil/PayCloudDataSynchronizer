package com.wiseasy.pds.request;

import com.alibaba.fastjson.JSONArray;
import com.wiseasy.pds.response.BaseResponse;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 11/30/2022
 * Time: 10:08 AM
 *
 * @author pupan
 */
public class CashierTransBillSendRequest extends BaseRequest<BaseResponse> {
    String app_identity;
    String trans_no;
    String channel_type;
    String channel_user;
    JSONArray channels;
    String accept_language;

    @Override
    public String getRequestMethod() {
        return "cashier.trans.bill.send";
    }

    public void setTrans_no(String trans_no) {
        this.trans_no = trans_no;
    }

    public void setAccept_language(String accept_language) {
        this.accept_language = accept_language;
    }

    public void setApp_identity(String app_identity) {
        this.app_identity = app_identity;
    }

    public void setChannel_type(String channel_type) {
        this.channel_type = channel_type;
    }

    public void setChannel_user(String channel_user) {
        this.channel_user = channel_user;
    }

    public void setChannels(JSONArray channels) {
        this.channels = channels;
    }

    public String getChannel_user() {
        return channel_user;
    }

    public String getTrans_no() {
        return trans_no;
    }

    public JSONArray getChannels() {
        return channels;
    }

    public String getAccept_language() {
        return accept_language;
    }

    public String getApp_identity() {
        return app_identity;
    }

    public String getChannel_type() {
        return channel_type;
    }
}
