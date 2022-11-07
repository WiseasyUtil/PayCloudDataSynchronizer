package com.wiseasy.pds;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wiseasy.pds.db.DbHelper;
import com.wiseasy.pds.db.TableRecord;
import com.wiseasy.pds.request.BaseRequest;
import com.wiseasy.pds.response.BaseResponse;
import com.wiseasy.pds.response.DeviceInitResponse;
import com.wiseasy.pds.network.ParamsSignManager;
import com.wiseasy.pds.network.RetrofitClient;
import com.wiseasy.pds.response.InitResponse;
import com.wiseasy.pds.service.UploadService;
import com.wiseasy.pds.sign.Base64;
import com.wiseasy.pds.sign.RSA;
import com.wiseasy.pds.util.AndroidKeyStore;
import com.wiseasy.pds.util.ErrorStatus;
import com.wiseasy.pds.util.RSA2Coder;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

/**
 * PayCloud Data Service SDK
 * User: pupan
 * Date: 2022/6/28
 * Time: 14:46
 *
 * @author pupan
 */
public class PdsClient {
    private String INPUT_CHARSET = "UTF-8";

    /**
     * database
     */
    private SQLiteDatabase db;

    public PdsClient(Context context, String url, String appVersion, String deviceSn, String appId, boolean isQueryPayInfo, PdsResponseCallBack callBack) {
        //network init
        RetrofitClient.init(url);
        //database init
        initDatabase(context);
        //device init
        deviceSignIn(context, appVersion, appId, deviceSn, callBack);
    }

    private void deviceSignIn(Context context, String appVersion, String appId, String deviceSn, PdsResponseCallBack callBack) {
        String privatekey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDabieRArJADElzxVWzP8vqpVu0NZFMGiVQrwPCGL3AfprKADrfrc9U0Q8zx5EjlbX2ywLJ9200XLoNEC6t6hhXTncRM9R58QDlscM5CeNtv0+40R9PrnW/xyrARpOm1rGPbO6OxYjwB3dHnQTJAeyyRBaaz+C/ZoHfpdQzi/I4iTg/V/d3G2qKAfRhE4RiK7AUWqzIm41KMnM1sKZ+CqVC//6kT+k5X0whB7QIB0PbokXXRClKywTAqC8q+dc9TKdW7T1yNISKl6/lwslICkpINnGtGNIUFeuHqfODwkrTl6GQjzB2yvJFSd6HQ8Y3Q+Bgs//CMqKqWBMloi3Gdv8lAgMBAAECggEBAMQiCzcjg6kNH1tsAyL8Ev90UZ7ERt5dz8neDPLZQnE5fYYKpNK6gCP5wLvO491fDdA3xB5UJOPSq2EVecTCIe8rTrDMqGqCZDrb3p816Nhf45bheEsVLTfx/8o81VIHD9LojmD2sJpPKeTM8kIHj2EW0HFcXcOfqNiIT72lWO83ZlyPvWuyHEmgYjZLB6haQ+cn9zpV9RMJli40ytL/lAnvpYidG9c+/ItbJCKd//lsBadV8oLhAtxZNcnxSEvASGm16huIO5Nk211c8FomXvf1S026BdMIRSPfrErqn3br5GnAadj+X30I3c4GqqkQ0XEcJE0kvLduUS1xYnZT0gECgYEA+V58uhWP8xO/NP+OIGjgZALKZ3IuwhleVgpYyETnLJr9obg2t5S6tlkzUNVr1al+jVfLi5JO0E2RJzsUMLH5fGdUqXeZZE24QR0o4u4Vkx76n9jlC1qdQYpzlRliUXfrRXC/ISZrVSh6jlIkqgQ8b8u3vaCnWUoERfUUkiFXgaUCgYEA4D0PUACruVN7V0NcEC+hF4mOtjeJjBO+gnP767W9zjO17CUWo2n/bIIVTemzUuncIwM5mU0xPOeoylUUXfShE21X4/GMF0g/MRrGvlrL9jDMMfBwOsAKMm8862nqBPL9xyfGQ8fdl0btcsMaeEPgJEHEQosGV9lP+Zkjx47OD4ECgYBCu3hhS9fj0sr+Yc0k+yvhV6XWnQXKR4OpPseXgGjk1O0+089AvXphxeknnpVm7h7BsFb2GMcikz9e4j568YW0Nuq/FxRjdTDzq9v/LntzjXzAPgi9Sxh+K5DWu55F8vNw98UOF/vtJBH3+B97p/qMaFXZVx6xlE8kcXt5x5ZlSQKBgHtvoTo85ErENaU3ozoVveujATg1IjZFuB0/k3GRPcaAmKhBUlDqTHyCrw+QkfIWYeO0JsTIxU3th/C5HNkLjI+RJUyI7sDyODbjsnuep6ACBKWI4X61r+dLbJF6YCQRTrmOn4k4QDbCCHugArYpRv0uZsbqmLdLHMcdEaEMb0oBAoGBAM8+3azMPpvQc4gffv4GTAAt+JsE3NzE8FHHLCdSfklyOafDqwQBuwwv/AdhlvHcq6D9pJRL9WKbucbwSRutq6OJaCG7cGWruFecvl1oJf6MiTGG2kVy25ibfiVrhYGCdVnridg3J1QtED0WlXnGtyJMvPlbbYpP6BXPgsfEEbdw";
        String a = "ytpd3UXFZ2HbAIcLTAalpohgmChET07HwbmDmCkQvw+3hIvadoomr/M8cgIGdXd0uHxZxjKTo8FfTDZ0YMAVqQ3X3N7vueCavyxr9Dk3Ew7h2rAgQOkLfYmoLL1xdecoIlTBfk+OLl1HuNIa+abswk498CbVvIrBcsLSTIwGCB2+c+EMFunULEaPIWHlRRqpGZQc7HRVZBVcO4pCoPp4Rbw9NgfZQNF3NgXqbGvSvN/dYMvvKCKSBLrExOZmQ0uIKmrnXvQV4oL76QVzxrI59ctgEYLRlYLuBuRuMJqyftX+JI6Bc6l0uo/jzKyGJSDebZSE770LSXtnNlHvYWIAIw==";
        byte[] bytes = new byte[0];
        try {
            bytes = RSA2Coder.decryptByPrivateKey(Base64.decode(a), privatekey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e("结果",new String(bytes));
        ParamsSignManager.init(deviceSn, appId);
        Map<String, Object> map = new HashMap<>();
        map.put("method", "cashier.init");
        map.put("app_id", appId);
        map.put("app_version", appVersion);
        map.put("version", "2.0");
        map.put("format", "JSON");
        map.put("charset", "UTF-8");
        map.put("terminal_sn", deviceSn);
        map.put("timestamp", "" + System.currentTimeMillis());
        RetrofitClient.sendCommonRequest(new JSONObject(map), InitResponse.class, new PdsResponseCallBack<InitResponse>() {
            @Override
            public void onError(String errorCode, String errorMsg) {

            }

            @Override
            public void onSuccess(InitResponse data) {
                try {
                    String rsaKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2m4nkQKyQAxJc8VVsz/L6qVbtDWRTBolUK8Dwhi9wH6aygA6363PVNEPM8eRI5W19ssCyfdtNFy6DRAureoYV053ETPUefEA5bHDOQnjbb9PuNEfT651v8cqwEaTptaxj2zujsWI8Ad3R50EyQHsskQWms/gv2aB36XUM4vyOIk4P1f3dxtqigH0YROEYiuwFFqsyJuNSjJzNbCmfgqlQv/+pE/pOV9MIQe0CAdD26JF10QpSssEwKgvKvnXPUynVu09cjSEipev5cLJSApKSDZxrRjSFBXrh6nzg8JK05ehkI8wdsryRUneh0PGN0PgYLP/wjKiqlgTJaItxnb/JQIDAQAB";
                    AndroidKeyStore.init(context);
                    String dataKey = AndroidKeyStore.data_key;
                    String macKey = AndroidKeyStore.mac_key;
                    Log.e("数据密钥", dataKey);
                    Log.e("mac密钥", macKey);
                    Map<String, Object> map = new HashMap<>();
                    map.put("method", "cashier.signin");
                    map.put("mac_key_cipher", Base64.encode(RSA2Coder.encryptByPublicKey(Base64.decode(dataKey), rsaKey)));
                    map.put("data_key_cipher", Base64.encode(RSA2Coder.encryptByPublicKey(Base64.decode(macKey), rsaKey)));
                    map.put("app_id", appId);
                    map.put("version", "2.0");
                    map.put("format", "JSON");
                    map.put("charset", "UTF-8");
                    map.put("terminal_sn", deviceSn);
                    map.put("timestamp", "" + System.currentTimeMillis());
                    RetrofitClient.sendCommonRequest(new JSONObject(map), DeviceInitResponse.class, callBack);
                } catch (Exception e) {
                    callBack.onError(e.getMessage(), e.getMessage());
                }
            }
        });
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
