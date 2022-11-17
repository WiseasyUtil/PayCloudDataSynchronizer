package com.wiseasy.pds;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wiseasy.pds.db.DbHelper;
import com.wiseasy.pds.db.TableRecord;
import com.wiseasy.pds.request.BaseRequest;
import com.wiseasy.pds.network.ParamsSignManager;
import com.wiseasy.pds.network.RetrofitClient;
import com.wiseasy.pds.response.DeviceSignInResponse;
import com.wiseasy.pds.response.InitResponse;
import com.wiseasy.pds.security.Base64;
import com.wiseasy.pds.security.RSA2Coder;
import com.wiseasy.pds.service.UploadService;
import com.wiseasy.pds.util.KeyStoreUtil;
import com.wiseasy.pds.util.ErrorStatus;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * PayCloud Data Service SDK
 * User: pupan
 * Date: 2022/6/28
 * Time: 14:46
 *
 * @author pupan
 */
public class PdsClient {
    /**
     * database
     */
    private SQLiteDatabase db;

    public PdsClient(Context context, String url, String appVersion, String deviceSn, String appId, PdsResponseCallBack callBack) {
        //network init
        RetrofitClient.init(url);
        //database init
        initDatabase(context);
        //key init
        KeyStoreUtil.init(context);
        // init
        init(appVersion, appId, deviceSn, callBack);
    }

    private void init(String appVersion, String appId, String deviceSn, PdsResponseCallBack callBack) {
        ParamsSignManager.init(deviceSn, appId);
        Map<String, Object> map = new HashMap<>();
        map.put("method", "cashier.init");
        map.put("app_id", appId);
        map.put("app_version", appVersion);
        map.put("version", "2.0");
        map.put("terminal_sn", deviceSn);
        map.put("timestamp", "" + System.currentTimeMillis());
        RetrofitClient.sendCommonRequest(new JSONObject(map), InitResponse.class, callBack);
    }

    public void signIn(String userName, String password, boolean isQueryPayInfo, PdsResponseCallBack callBack) {
        try {
            String dataKey = KeyStoreUtil.data_key;
            String macKey = KeyStoreUtil.mac_key;
            Log.e("数据密钥", dataKey);
            Log.e("mac密钥", macKey);
            Map<String, Object> map = new HashMap<>();
            map.put("method", "cashier.signin");
            map.put("mac_key_cipher", Base64.encodeToString(RSA2Coder.encryptByPublicKey(macKey.getBytes(), RSA2Coder.PUBLIC_BASE_KEY)));
            map.put("data_key_cipher", Base64.encodeToString(RSA2Coder.encryptByPublicKey(dataKey.getBytes(), RSA2Coder.PUBLIC_BASE_KEY)));
            map.put("app_id", ParamsSignManager.appId);
            map.put("version", "2.0");
            if (!userName.isEmpty()) {
                map.put("username", userName);
            }
            if (!password.isEmpty()) {
                map.put("password", password);
            }
            map.put("terminal_sn", ParamsSignManager.deviceSn);
            map.put("query_pay_info", isQueryPayInfo);
            map.put("timestamp", "" + System.currentTimeMillis());
            RetrofitClient.sendCommonRequest(new JSONObject(map), DeviceSignInResponse.class, callBack);
        } catch (Exception e) {
            callBack.onError(e.getMessage(), e.getMessage());
        }
    }

    /**
     * 敏感数据加密
     *
     * @param data
     * @return
     */
    public String doDataEncrypt(String data) {
        return KeyStoreUtil.doEncrypt(data);
    }

    /**
     * 敏感数据解密
     *
     * @param data
     * @return
     */
    public String doDataDecrypt(String data) {
        return KeyStoreUtil.doDecrypt(data);
    }


    /**
     * dataBase init
     *
     * @param context
     */
    private void initDatabase(Context context) {
        DbHelper dbHelper = new DbHelper(context, "pds.db", null, 1);
        db = dbHelper.getWritableDatabase();
    }

    /**
     * sync call the internal handler function of the gateway API
     *
     * @param request
     * @param callBack
     */
    public void execute(BaseRequest request, PdsResponseCallBack callBack) {
        if (!checkInit(callBack)) {
            return;
        }
        JSONObject params = ParamsSignManager.signParams(request);
        RetrofitClient.sendCommonRequest(params, request.getResponseClass(), callBack);
    }

    /**
     * file upload
     *
     * @param terminalSn terminal no
     * @param file       file
     * @param callBack
     */
    public void fileUpLoad(String terminalSn, File file, PdsResponseCallBack callBack) {
        if (!checkInit(callBack)) {
            return;
        }
        RetrofitClient.sendFileUploadRequest(terminalSn, file, callBack);
    }

    /**
     * async call the internal handler function of the gateway API
     *
     * @param type    data type  TableRecord.RECORD_TYPE_COMPLETE_TRANSACTION,TableRecord.RECORD_TYPE_CLOSE_TRANSACTION,TableRecord.RECORD_TYPE_LOG
     * @param request
     */
    public void execute(Context context, int type, BaseRequest request) throws PdsException {
        checkInit();
        TableRecord.insert(db, type, ParamsSignManager.signParams(request).toJSONString());
        UploadService.setUpLoad(false);
        UploadService.start(context);
    }

    /**
     * get async data count
     *
     * @return
     */
    public int getAsyncDataCount() {
        if (null == db) {
            return 0;
        }
        JSONArray completeCount = TableRecord.query(db, TableRecord.RECORD_TYPE_COMPLETE_TRANSACTION);
        JSONArray closeCount = TableRecord.query(db, TableRecord.RECORD_TYPE_CLOSE_TRANSACTION);
        return completeCount.size() + closeCount.size();
    }

    /**
     * get all async data count
     *
     * @return
     */
    public int getAllAsyncDataCount() {
        if (null == db) {
            return 0;
        }
        JSONArray completeCount = TableRecord.query(db, TableRecord.RECORD_TYPE_COMPLETE_TRANSACTION);
        JSONArray closeCount = TableRecord.query(db, TableRecord.RECORD_TYPE_CLOSE_TRANSACTION);
        JSONArray logCount = TableRecord.query(db, TableRecord.RECORD_TYPE_LOG);
        return completeCount.size() + closeCount.size() + logCount.size();
    }

    /**
     * start async upload service
     *
     * @param context
     */
    public void startAsyncService(Context context) {
        UploadService.start(context);
    }

    /**
     * checkout init
     */
    private void checkInit() throws PdsException {
        if (!RetrofitClient.getIsInit()) {
            throw new PdsException(ErrorStatus.INIT_ERROR, "you must call init() first!!");
        }
    }

    /**
     * checkout init
     */
    private boolean checkInit(PdsResponseCallBack callBack) {
        if (!RetrofitClient.getIsInit()) {
            callBack.onError("" + ErrorStatus.INIT_ERROR, "you must call init() first!!");
            return false;
        }
        return true;
    }
}