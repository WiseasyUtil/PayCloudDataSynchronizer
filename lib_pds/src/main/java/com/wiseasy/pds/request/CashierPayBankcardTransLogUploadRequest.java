package com.wiseasy.pds.request;

import com.wiseasy.pds.response.BaseResponse;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 2022/7/4
 * Time: 17:41
 *
 * @author pupan
 */
public class CashierPayBankcardTransLogUploadRequest extends BaseRequest<BaseResponse>{
    String trans_no;
    String log_action;
    String log_desc;
    String log_status;
    String log_time;
    String upload_time;
    String log_pack;
    String net_link_type;

    public String getUpload_time() {
        return upload_time;
    }

    public String getNet_link_type() {
        return net_link_type;
    }

    @Override
    public String getRequestMethod() {
        return "cashier.pay.bankcard.trans.log.upload";
    }

    public String getTrans_no() {
        return trans_no;
    }

    public String getLog_action() {
        return log_action;
    }

    public String getLog_desc() {
        return log_desc;
    }

    public String getLog_pack() {
        return log_pack;
    }

    public String getLog_status() {
        return log_status;
    }

    public String getLog_time() {
        return log_time;
    }

    public void setTrans_no(String trans_no) {
        this.trans_no = trans_no;
    }

    public void setLog_action(String log_action) {
        this.log_action = log_action;
    }

    public void setLog_desc(String log_desc) {
        this.log_desc = log_desc;
    }

    public void setLog_pack(String log_pack) {
        this.log_pack = log_pack;
    }

    public void setLog_status(String log_status) {
        this.log_status = log_status;
    }

    public void setLog_time(String log_time) {
        this.log_time = log_time;
    }

    public void setNet_link_type(String net_link_type) {
        this.net_link_type = net_link_type;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }
}
