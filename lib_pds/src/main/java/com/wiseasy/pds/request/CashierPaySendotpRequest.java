package com.wiseasy.pds.request;

import com.wiseasy.pds.response.SendOtpCodeResponse;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/16/2022
 * Time: 5:47 PM
 * @author pupan
 */
public class CashierPaySendotpRequest extends BaseRequest<SendOtpCodeResponse> {
    String terminal_sn;
    String pay_method_id;
    String phone;

    @Override
    public String getRequestMethod() {
        return "cashier.pay.sendotp";
    }

    public void setPay_method_id(String pay_method_id) {
        this.pay_method_id = pay_method_id;
    }

    public void setTerminal_sn(String terminal_sn) {
        this.terminal_sn = terminal_sn;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPay_method_id() {
        return pay_method_id;
    }

    public String getTerminal_sn() {
        return terminal_sn;
    }

    public String getPhone() {
        return phone;
    }
}
