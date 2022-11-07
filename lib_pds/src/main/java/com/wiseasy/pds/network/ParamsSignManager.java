package com.wiseasy.pds.network;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wiseasy.pds.PdsBaseSign;
import com.wiseasy.pds.request.BaseRequest;
import com.wiseasy.pds.sign.DefaultParamSign;
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
    public static String appId;

    /**
     * device sn
     */
    public static String deviceSn;

    public static void init(String sn, String id) {
        deviceSn = sn;
        appId = id;
        SignHandler.sign = new DefaultParamSign();
    }

    public static void init(String sn, String id, PdsBaseSign sign) {
        deviceSn = sn;
        appId = id;
        SignHandler.sign = sign;
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
        if (!map.containsKey("app_id")) {
            map.put("app_id", appId);
        }
        map.put("format", "JSON");
        map.put("charset", "UTF-8");
        map.put("key_mode", "SK");
        map.put("version", "2.0");
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
        String signData = SignHandler.sign(params);
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
        String signData = SignHandler.sign(map);
        map.put("sign", signData);
        return new JSONObject(map);
    }

    /**
     * response params veify
     *
     * @return
     */
    public static boolean verifySign(JSONObject params) {
        return SignHandler.verifySign(params);
    }
}
