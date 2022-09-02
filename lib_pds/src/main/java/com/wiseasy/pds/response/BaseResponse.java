package com.wiseasy.pds.response;

/**
 * @author hugo
 * @date 2022/6/15
 */
public class BaseResponse {

    /**
     * Status code, 0 means the request is successful, others means failure
     */
    private String code;

    /**
     * Error message
     */
    private String msg;

    /**
     * Interface serial number, used for error search and request record
     */
    private String psn;

    /**
     * signature
     */
    private String sign;

    /**
     * Determine whether the interface request is successful
     *
     * @return
     */
    public boolean isSuccess() {
        return "0".equals(code);
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setPsn(String psn) {
        this.psn = psn;
    }

    public String getSign() {
        return sign;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getPsn() {
        return psn;
    }
}
