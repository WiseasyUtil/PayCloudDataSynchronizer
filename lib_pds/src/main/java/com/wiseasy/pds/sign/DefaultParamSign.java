package com.wiseasy.pds.sign;

import com.wiseasy.pds.PdsBaseSign;

import java.util.Map;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/25/2022
 * Time: 4:53 PM
 * @author pupan
 */
public class DefaultParamSign implements PdsBaseSign {
    private String INPUT_CHARSET = "UTF-8";
    private String privateKey;
    private String publicKey;

    public DefaultParamSign(String privateKey,String publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    @Override
    public String sign(String params) {
        return RSA.sign(params, privateKey, INPUT_CHARSET);
    }

    @Override
    public boolean verifySign(String params,String sign) {
        return RSA.verify(params, sign, publicKey, INPUT_CHARSET);
    }
}
