package com.wiseasy.pds.response;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 11/7/2022
 * Time: 12:59 PM
 * @author pupan
 */
public class InitResponse extends BaseResponse {
    boolean enable_user_signin;
    String public_key;

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }

    public void setEnable_user_signin(boolean enable_user_signin) {
        this.enable_user_signin = enable_user_signin;
    }

    public boolean getEnable_user_signin() {
        return enable_user_signin;
    }
}
