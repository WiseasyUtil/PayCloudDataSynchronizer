package com.wiseasy.pds.request;

import com.wiseasy.pds.response.BaseResponse;

import java.io.File;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 2022/7/28
 * Time: 14:14
 *
 * @author pupan
 */
public class CashierPayBankcardTransSettleUploadRequest extends BaseRequest<BaseResponse> {
    String terminal_sn;
    String file;
    String settle_file_key;

    @Override
    public String getRequestMethod() {
        return "cashier.pay.bankcard.trans.settle.upload";
    }

    public void setSettle_file_key(String settle_file_key) {
        this.settle_file_key = settle_file_key;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setTerminal_sn(String terminal_sn) {
        this.terminal_sn = terminal_sn;
    }

    public String getSettle_file_key() {
        return settle_file_key;
    }

    public String getTerminal_sn() {
        return terminal_sn;
    }
}
