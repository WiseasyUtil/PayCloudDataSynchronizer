package com.wiseasy.pds;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.alibaba.fastjson.JSONObject;
import com.wiseasy.pds.db.DbHelper;
import com.wiseasy.pds.db.TableRecord;
import com.wiseasy.pds.request.BaseRequest;
import com.wiseasy.pds.response.DeviceInitResponse;
import com.wiseasy.pds.network.ParamsSignManager;
import com.wiseasy.pds.network.RetrofitClient;
import com.wiseasy.pds.service.UploadService;
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

    public PdsClient(Context context, String url, String deviceSn, String appId, String privateKey, String publicKey, boolean isQueryPayInfo, PdsResponseCallBack callBack) {
        //network init
        RetrofitClient.init(url);
        //database init
        initDatabase(context);
        //device init
        initDevice(deviceSn, appId, privateKey, publicKey, isQueryPayInfo, callBack);
    }

    public PdsClient(Context context, String url, String deviceSn, String appId, PdsBaseSign sign, boolean isQueryPayInfo, PdsResponseCallBack callBack) {
        //network init
        RetrofitClient.init(url);
        //database init
        initDatabase(context);
        //device init
        initDevice(deviceSn, appId, sign, isQueryPayInfo, callBack);
    }

    /**
     * init
     *
     * @param deviceSn   device sn
     * @param appId      app id
     * @param privateKey request sign private key
     * @param publicKey  response sign public key
     * @param callBack   callback
     */
    private void initDevice(String deviceSn, String appId, String privateKey, String publicKey, boolean isQueryPayInfo, PdsResponseCallBack callBack) {
        ParamsSignManager.init(deviceSn, appId, privateKey, publicKey);
        Map<String, Object> map = new HashMap<>();
        map.put("method", "cashier.basis.device.init");
        map.put("query_pay_info", isQueryPayInfo);
        JSONObject params = ParamsSignManager.signParams(map);
        RetrofitClient.sendCommonRequest(params, DeviceInitResponse.class, callBack);
    }

    /**
     * init
     *
     * @param deviceSn device sn
     * @param appId    app id
     * @param sign     sign method
     * @param callBack callback
     */
    private void initDevice(String deviceSn, String appId, PdsBaseSign sign, boolean isQueryPayInfo, PdsResponseCallBack callBack) {
        ParamsSignManager.init(deviceSn, appId, sign);
        Map<String, Object> map = new HashMap<>();
        map.put("method", "cashier.basis.device.init");
        map.put("query_pay_info", isQueryPayInfo);
        JSONObject params = ParamsSignManager.signParams(map);
        RetrofitClient.sendCommonRequest(params, DeviceInitResponse.class, callBack);
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
     * @param institutionNo institution no
     * @param file          file
     * @param callBack
     */
    public void fileUpLoad(String institutionNo, File file, PdsResponseCallBack callBack) {
        if (!checkInit(callBack)) {
            return;
        }
        RetrofitClient.sendFileUploadRequest(institutionNo, file, callBack);
    }

    /**
     * async call the internal handler function of the gateway API
     *
     * @param request
     */
    public void execute(Context context, BaseRequest request) throws PdsException {
        checkInit();
        TableRecord.insert(db, TableRecord.RECORD_TYPE_COMPLETE_TRANSACTION, ParamsSignManager.signParams(request).toJSONString());
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
            callBack.onError(ErrorStatus.INIT_ERROR, "you must call init() first!!");
            return false;
        }
        return true;
    }
}
