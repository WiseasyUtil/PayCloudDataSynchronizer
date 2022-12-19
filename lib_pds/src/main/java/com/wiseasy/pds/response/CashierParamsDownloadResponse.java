package com.wiseasy.pds.response;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 12/15/2022
 * Time: 11:31 AM
 *
 * @author pupan
 */
public class CashierParamsDownloadResponse extends BaseResponse{
    String params_value;
    String params_version;

    public void setParams_value(String params_value) {
        this.params_value = params_value;
    }

    public void setParams_version(String params_version) {
        this.params_version = params_version;
    }

    public String getParams_value() {
        return params_value;
    }

    public String getParams_version() {
        return params_version;
    }
}


