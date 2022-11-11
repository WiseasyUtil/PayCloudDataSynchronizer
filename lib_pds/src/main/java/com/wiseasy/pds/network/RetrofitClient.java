package com.wiseasy.pds.network;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wiseasy.pds.PdsResponseCallBack;
import com.wiseasy.pds.response.BaseResponse;
import com.wiseasy.pds.sign.SignHandler;
import com.wiseasy.pds.util.KeyStoreUtil;
import com.wiseasy.pds.util.ErrorStatus;
import com.wiseasy.pds.util.ExceptionHandler;
import com.wiseasy.pds.util.FileMd5;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * @author hugo
 * @date 2022/6/15
 */
public class RetrofitClient {
    private static RetrofitApi api;

    private static String url;
    /**
     * is init
     */
    private static Boolean isInit = false;

    public static String token = "";

    public static Boolean getIsInit() {
        return isInit;
    }

    public static RetrofitApi init(String serviceUrl) {
        url = serviceUrl;
        if (null == api) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(new ResponseParamsCheckInterceptor())
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
            OkHttpClient okHttpClient = builder.build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(okHttpClient)
                    .addConverterFactory(FastJsonConverterFactory.create())
                    .build();
            api = retrofit.create(RetrofitApi.class);
        }
        return api;
    }

    public static RetrofitApi init() {
        if (null == api) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
            OkHttpClient okHttpClient = builder.build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(okHttpClient)
                    .addConverterFactory(FastJsonConverterFactory.create())
                    .build();
            api = retrofit.create(RetrofitApi.class);
        }
        return api;
    }

    public static void sendFileUploadRequest(String terminalSn, File file, PdsResponseCallBack callBack) {
        JSONObject jsonObject = new JSONObject();
        String hash = FileMd5.getFileMD5(file);
        String time = "" + System.currentTimeMillis();
        jsonObject.put("terminal_sn", terminalSn);
        jsonObject.put("file_data_hash", hash);
        jsonObject.put("app_id", ParamsSignManager.appId);
        jsonObject.put("key_mode", "SK");
        jsonObject.put("version", "2.0");
        jsonObject.put("timestamp", time);
        String signData = SignHandler.sign(jsonObject);
        jsonObject.put("sign", signData);
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addPart(createJsonRequestBody(jsonObject))
                .addFormDataPart("terminal_sn", terminalSn)
                .addFormDataPart("app_id", ParamsSignManager.appId)
                .addFormDataPart("key_mode", "SK")
                .addFormDataPart("version", "2.0")
                .addFormDataPart("sign", signData)
                .addFormDataPart("timestamp", time)
                .addFormDataPart("file_data_hash", hash)
                .addFormDataPart("file_data", file.getName(), createFileRequestBody(file))
                .build();
        getApi().sendFileRequest(token,body).enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                if (!response.isSuccessful()) {
                    callBack.onError("" + ErrorStatus.API_ERROR, response.message());
                    return;
                }
                JSONObject result = response.body();
                if (response.isSuccessful() && result.containsKey("file_key")) {
                    callBack.onSuccess(result.getString("file_key"));
                } else {
                    callBack.onError(result.getString("code"), result.getString("msg"));
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                callBack.onError("" + ExceptionHandler.getErrorCode(), ExceptionHandler.handleException(t));
            }
        });
    }

    public static void sendCommonRequest(JSONObject params, Class dataClass, PdsResponseCallBack callBack) {
        getApi().sendRequest(token, RetrofitClient.createJsonRequestBody(params)).enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                if (!response.isSuccessful()) {
                    callBack.onError("" + ErrorStatus.API_ERROR, response.message());
                    return;
                }
                JSONObject result = response.body();
                BaseResponse baseResponse = (BaseResponse) JSON.toJavaObject(result, dataClass);
                if (baseResponse.isSuccess()) {
                    if (params.getString("method").equals("cashier.signin")) {
                        isInit = true;
                    }
                    callBack.onSuccess(baseResponse);
                } else {
                    if (baseResponse.getCode().equals("SYS001")) {
                        KeyStoreUtil.removeAllKey();
                    }
                    callBack.onError(baseResponse.getCode(), baseResponse.getMsg());
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                if (params.getString("method").equals("cashier.signin")) {
                    isInit = true;
                }
                callBack.onError("" + ExceptionHandler.getErrorCode(), ExceptionHandler.handleException(t));
            }
        });
    }

    public static RetrofitApi getApi() {
        return init();
    }

    public static RequestBody createJsonRequestBody(JSONObject data) {
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), data.toJSONString());
    }

    public static RequestBody createFileRequestBody(File file) {
        return RequestBody.create(MediaType.parse("image/*"), file);
    }

    /**
     * response interceptor
     */
    static class ResponseParamsCheckInterceptor implements Interceptor {

        private final String TAG = ResponseParamsCheckInterceptor.class.getSimpleName();

        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Charset UTF8 = Charset.forName("UTF-8");
            Request request = chain.request();
            RequestBody requestBody = request.body();
            String reqBody = null;
            if (requestBody != null) {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);

                Charset charset = UTF8;
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    charset = contentType.charset(UTF8);
                }
                reqBody = buffer.readString(charset);
            }
            okhttp3.Response response = chain.proceed(request);
            ResponseBody responseBody = response.body();
            String respBody = null;
            if (responseBody != null) {
                BufferedSource source = responseBody.source();
                source.request(Long.MAX_VALUE);
                Buffer buffer = source.buffer();

                Charset charset = UTF8;
                MediaType contentType = responseBody.contentType();
                if (contentType != null) {
                    try {
                        charset = contentType.charset(UTF8);
                    } catch (UnsupportedCharsetException e) {
                        e.printStackTrace();
                    }
                }
                respBody = buffer.clone().readString(charset);
            }
            Log.d(TAG, String.format("收到响应\n%s %s\n请求url：%s\n请求body：%s\n响应body：%s",
                    response.code(), response.message(), response.request().url(), reqBody, respBody));
            JSONObject data = JSONObject.parseObject(respBody);
            boolean sign = true;
            if (!sign) {
                JSONObject errJson = new JSONObject();
                errJson.put("code", ErrorStatus.SIGN_ERROR);
                errJson.put("msg", "response sign error");
                ResponseBody myBody = ResponseBody.create(MediaType.get("text/plain"), errJson.toJSONString());
                return response.newBuilder().body(myBody).build();
            } else {
                JSONObject result = JSONObject.parseObject(respBody);
                Object responseData = result.get("data");
                if (null != responseData) {
                    String dataStr = result.getString("data");
                    result.putAll(JSONObject.parseObject(dataStr));
                }
                result.remove("data");
                if (result.containsKey("auth_token")&&!"".equals(result.getString("auth_token"))) {
                    token = result.getString("auth_token");
                }
                ResponseBody myBody = ResponseBody.create(MediaType.get("text/plain"), result.toJSONString());
                return response.newBuilder().body(myBody).build();
            }
        }
    }
}
