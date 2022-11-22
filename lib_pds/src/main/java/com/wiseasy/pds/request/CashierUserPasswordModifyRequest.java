package com.wiseasy.pds.request;

import com.wiseasy.pds.response.BaseResponse;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 11/22/2022
 * Time: 5:18 PM
 *
 * @author pupan
 */
public class CashierUserPasswordModifyRequest extends BaseRequest<BaseResponse> {
    String old_password;
    String new_password;

    public String getNew_password() {
        return new_password;
    }

    public String getOld_password() {
        return old_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    @Override
    public String getRequestMethod() {
        return "cashier.user.password.modify";
    }
}
