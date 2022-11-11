package com.wiseasy.pds.network;

import com.alibaba.fastjson.JSONObject;
import com.wiseasy.pds.response.BaseResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * @author hugo
 * @date 2022/6/15
 */
public interface RetrofitApi {

    /**
     * 发送请求
     *
     * @param body
     * @return
     */
    @POST("api/cashier/entry")
    Call<JSONObject> sendRequest(@Header("x-auth-token") String contentRange, @Body RequestBody body);

    /**
     * 发送请求
     *
     * @param body
     * @return
     */
    @POST("api/cashier/file/upload")
    Call<JSONObject> sendFileRequest(@Header("x-auth-token") String contentRange,@Body RequestBody body);
}
