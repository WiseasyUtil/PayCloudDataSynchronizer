package com.wiseasy.pds;

/**
 * exception
 * User: pupan
 * Date: 2022/7/6
 * Time: 14:47
 *
 * @author pupan
 */

public class PdsException extends Exception {
    private int errCode;
    private String errMsg;

    public PdsException(int errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }
}
