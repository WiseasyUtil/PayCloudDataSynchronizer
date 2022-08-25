package com.wiseasy.pds;

import java.util.Map;

/**
 * Base Sign
 * User: pupan
 * Date: 8/25/2022
 * Time: 4:36 PM
 * @author pupan
 */
public interface PdsBaseSign {

    /**
     * Signature function
     *
     * @param params     Parameters to be signed
     * @return 签名字符串
     */
    String sign(String params);

    /**
     * verifySign
     *
     * @param params    Parameters to be verified
     * @param sign sign
     * @return
     */
    boolean  verifySign(String params,String sign);
}
