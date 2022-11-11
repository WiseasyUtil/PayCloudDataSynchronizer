package com.wiseasy.pds.sign;

import com.wiseasy.pds.PdsBaseSign;
import com.wiseasy.pds.util.KeyStoreUtil;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 8/25/2022
 * Time: 4:53 PM
 *
 * @author pupan
 */
public class DefaultParamSign implements PdsBaseSign {
    public DefaultParamSign() {
    }

    @Override
    public String sign(String params) {
        return KeyStoreUtil.doMacEncrypt(params, KeyStoreUtil.MAC_ALIAS);
    }

    @Override
    public boolean verifySign(String params, String sign) {
        return true;
    }
}
