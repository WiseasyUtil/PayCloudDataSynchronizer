package com.wiseasy.pds.request;

import com.wiseasy.pds.response.CashierParamsDownloadResponse;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 12/15/2022
 * Time: 11:33 AM
 * @author pupan
 */
public class CashierParamsDownloadRequest extends BaseRequest<CashierParamsDownloadResponse>{
    String params_type;

    public void setParams_type(String params_type) {
        this.params_type = params_type;
    }

    public String getParams_type() {
        return params_type;
    }

    @Override
    public String getRequestMethod() {
        return "cashier.params.download";
    }
}
