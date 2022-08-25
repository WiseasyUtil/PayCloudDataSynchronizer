package com.wiseasy.pds.sign;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.wiseasy.pds.PdsBaseSign;

import java.util.*;

/**
 * @author pupan
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: Signature verification processing
 */
public class SignHandler {

    public static PdsBaseSign sign;

    /**
     * Signature function
     *
     * @param params     Parameters to be signed
     * @return 签名字符串
     */
    public static String sign(Map<String, Object> params) {
        String sign = signWithRSA(params);
        return sign;
    }

    /**
     * verifySign
     *
     * @param params    Parameters to be verified
     * @return
     */
    public static boolean verifySign(Map<String, Object> params) {
        String sign = (String) params.get("sign");
        return verifySignWithRSA(params, sign);
    }

    private static String signWithRSA(Map<String, Object> sParaTemp) {
        // Remove empty values and 'sign' parameters in the array
        Map<String, Object> sPara = paraFilter(sParaTemp);

        // All elements of the array are spliced into a string according to the pattern of "key=value" with "&" characters
        // and sorted according to the parameter key
        String prestr = createLinkString(sPara);
        Log.e("待签名字符串", prestr);
        // Sign
        String mysign = sign.sign(prestr);
        return mysign;
    }

    private static boolean verifySignWithRSA(Map<String, Object> sParaTemp, String result) {
        // Remove empty values and 'sign' parameters in the array
        Map<String, Object> sPara = paraFilter(sParaTemp);

        // All elements of the array are spliced into a string according to the pattern of "key=value" with "&" characters
        // and sorted according to the parameter key
        String prestr = createLinkString(sPara);

        // Verify signature
        return sign.verifySign(prestr,result);
    }

    /**
     * Remove empty values and 'sign' parameters in the array
     *
     * @param sArray Parameters to be signed
     * @return
     */
    private static Map<String, Object> paraFilter(Map<String, Object> sArray) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (sArray == null || sArray.size() <= 0) {
            return result;
        }
        JSONObject sJAray = new JSONObject(sArray);
        for (String key : sJAray.keySet()) {
            String value = sJAray.getString(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }

    /**
     * All elements of the array are spliced into a string according to the pattern of "key=value" with "&" characters
     * and sorted according to the parameter key
     *
     * @param params Parameter groups that need to be sorted and participate in character splicing
     * @return
     */
    private static String createLinkString(Map<String, Object> params) {
        JSONObject jparams = new JSONObject(params);
        List<String> keys = new ArrayList<String>(jparams.keySet());
        Collections.sort(keys);

        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = jparams.getString(key);

            if (i == keys.size() - 1) {
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }

}
