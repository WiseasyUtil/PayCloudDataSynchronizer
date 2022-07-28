package com.wiseasy.pds.network;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wiseasy.pds.request.BaseRequest;
import com.wiseasy.pds.response.BaseResponse;
import com.wiseasy.pds.sign.SignHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.request params sign
 * 2.verify response params
 * User: pupan
 * Date: 2022/6/28
 * Time: 17:57
 *
 * @author pupan
 */
public class ParamsSignManager {
    /**
     * app id
     */
    private static String appId;

    /**
     * rsa private key
     */
    private static String privateKey;

    /**
     * rsa public key
     */
    private static String publicKey;

    /**
     * device sn
     */
    private static String deviceSn;

    public static void init(String sn, String id, String key, String pubKey) {
        deviceSn = sn;
        appId = id;
        privateKey = key;
        publicKey = pubKey;
    }

    /**
     * app public params
     *
     * @param map
     */
    private static void addPublicParams(Map<String, Object> map) {
        if (null == map) {
            map = new HashMap<>();
        }
        map.put("terminal_sn", deviceSn);
        map.put("app_id", appId);
        map.put("format", "JSON");
        map.put("charset", "UTF-8");
        map.put("sign_type", "RSA2");
        map.put("version", "1.0");
        map.put("timestamp", "" + System.currentTimeMillis());
    }

    /**
     * request params sign
     *
     * @param request
     * @return
     */
    public static JSONObject signParams(BaseRequest request) {
        JSONObject params = JSONObject.parseObject(JSON.toJSONString(request));
        addPublicParams(params);
        params.put("method", request.getRequestMethod());
        String signData = SignHandler.sign(privateKey, params);
        params.put("sign", signData);
        return params;
    }

    /**
     * request params sign
     *
     * @param map
     * @return
     */
    public static JSONObject signParams(Map<String, Object> map) {
        if (null == map) {
            return new JSONObject();
        }
        addPublicParams(map);
        String signData = SignHandler.sign(privateKey, map);
        map.put("sign", signData);
        return new JSONObject(map);
    }

    /**
     * response params veify
     *
     * @param responseData
     * @return
     */
    public static boolean verifySign(JSONObject params) {
        return SignHandler.verifySign(publicKey, params);
    }
}
