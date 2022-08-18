package com.wiseasy.pds.response;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/16/2022
 * Time: 4:10 PM
 * @author pupan
 */
public class CScanBPaymentResponse extends BaseResponse {
    String trans_no;
    String qrcode_url;

    public void setTrans_no(String trans_no) {
        this.trans_no = trans_no;
    }

    public void setQrcode_url(String qrcode_url) {
        this.qrcode_url = qrcode_url;
    }

    public String getQrcode_url() {
        return qrcode_url;
    }

    public String getTrans_no() {
        return trans_no;
    }
}
