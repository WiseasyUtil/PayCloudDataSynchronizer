package com.wiseasy.pds.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.wiseasy.pds.PdsClient;
import com.wiseasy.pds.PdsException;
import com.wiseasy.pds.db.TableRecord;
import com.wiseasy.pds.request.CashierPayBankcardTransCloseRequest;
import com.wiseasy.pds.request.CashierPayBankcardTransCompleteRequest;
import com.wiseasy.pds.request.CashierPayBankcardTransCreateRequest;
import com.wiseasy.pds.request.CashierPayBankcardTransLogUploadRequest;
import com.wiseasy.pds.request.CashierTransDetailRequest;
import com.wiseasy.pds.response.BaseResponse;
import com.wiseasy.pds.response.CashierPayBankCardTransCreateResponse;
import com.wiseasy.pds.response.DeviceInitResponse;
import com.wiseasy.pds.PdsResponseCallBack;
import com.wiseasy.pds.response.TransactionDetailQueryResponse;
import com.wiseasy.pds.util.TradeConstants;

import java.io.File;
import java.io.IOException;

/**
 * @author pupan
 */
public class MainActivity extends AppCompatActivity {
    String transNo;
    PdsClient mPdsClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deviceInit();
    }

    public void transDetail(View view) {
        CashierTransDetailRequest request = new CashierTransDetailRequest();
        request.setTrans_no("111111111111111111");
        request.setTerminal_sn("11111111111111111111111");
        mPdsClient.execute(request, new PdsResponseCallBack<TransactionDetailQueryResponse>() {
            @Override
            public void onError(String errorCode, String errorMsg) {
                Log.e("创建订单失败", errorMsg);
            }

            @Override
            public void onSuccess(TransactionDetailQueryResponse data) {
                Log.e("创建订单成功", data.getTrans_no());
            }
        });
    }

    public void transCreateOrder(View view) {
        String result = mPdsClient.doDataEncrypt("aaaaaaaaaaaaaaaa");
        String result1 = mPdsClient.doDataDecrypt(result);
        CashierPayBankcardTransCreateRequest request = new CashierPayBankcardTransCreateRequest();
        request.setPrice_currency("MMK");
        request.setOrder_amount(1.0);
        request.setApp_id("wzac09fb2b0ad16b28");
        request.setTrans_type(TradeConstants.TRADE_TYPE_CONSUME);
        request.setPay_method_id(TradeConstants.PAY_METHOD_VISA);
        mPdsClient.execute(request, new PdsResponseCallBack<CashierPayBankCardTransCreateResponse>() {
            @Override
            public void onError(String errorCode, String errorMsg) {
                Log.e("创建订单失败", errorMsg);
            }

            @Override
            public void onSuccess(CashierPayBankCardTransCreateResponse data) {
                transNo = data.getTrans_no();
                Log.e("创建订单成功", data.getTrans_no());
            }
        });
    }

    public void transComplete(View view) {
        if (null == transNo) {
            Toast.makeText(MainActivity.this, "完成订单失败，订单号为空", Toast.LENGTH_SHORT).show();
            return;
        }
        CashierPayBankcardTransCompleteRequest request = new CashierPayBankcardTransCompleteRequest();
        request.setTrans_no(transNo);
        request.setTrans_end_time("2022-07-07 20:28:28");
        mPdsClient.execute(request, new PdsResponseCallBack<BaseResponse>() {
            @Override
            public void onError(String errorCode, String errorMsg) {
                Log.e("完成订单失败", errorMsg);
                Toast.makeText(MainActivity.this, "完成订单失败" + errorMsg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(BaseResponse data) {
                Log.e("完成订单成功", data.toString());
                Toast.makeText(MainActivity.this, "完成订单成功" + data.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void transClose(View view) {
//        if (null == transNo) {
//            Toast.makeText(MainActivity.this, "关闭订单失败，订单号为空", Toast.LENGTH_SHORT).show();
//            return;
//        }
        CashierPayBankcardTransCompleteRequest request = new CashierPayBankcardTransCompleteRequest();
        request.setTrans_no("11111111");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aaaa", "1111");
        request.setBankcard_ext_params(jsonObject.toString());
        mPdsClient.execute(request, new PdsResponseCallBack<BaseResponse>() {
            @Override
            public void onError(String errorCode, String errorMsg) {
                Toast.makeText(MainActivity.this, "关闭订单失败" + errorMsg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(BaseResponse data) {
                Toast.makeText(MainActivity.this, "关闭订单成功", Toast.LENGTH_SHORT).show();
                transNo = null;
            }
        });
    }

    public void transLogUpload(View view) {
        if (null == transNo) {
            Toast.makeText(MainActivity.this, "订单号为空", Toast.LENGTH_SHORT).show();
            return;
        }
        CashierPayBankcardTransLogUploadRequest request = new CashierPayBankcardTransLogUploadRequest();
        request.setTrans_no(transNo);
        request.setLog_action(TradeConstants.PAY_LOG_ACTION_SEND_DATA_CHANNEL);
        request.setLog_status(TradeConstants.PAY_LOG_STATUS_SUCCESS);
        request.setLog_time("2022-07-07 20:28:28");
        request.setNet_link_type(TradeConstants.PAY_LOG_NET_LINK_TYPE_PHONE);
        request.setUpload_time("2022-07-07 20:28:28");
        try {
            mPdsClient.execute(this, TableRecord.RECORD_TYPE_LOG,request);
        } catch (PdsException e) {
            e.printStackTrace();
        }
    }

    public void upLoadFile(View view) {
        File file = getCacheDir();
        file = new File(file.getAbsolutePath() + "/123");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mPdsClient.fileUpLoad("100004484", file, new PdsResponseCallBack<String>() {
            @Override
            public void onError(String errorCode, String errorMsg) {
                Toast.makeText(MainActivity.this, "关闭订单失败" + errorMsg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(String data) {
                Toast.makeText(MainActivity.this, "关闭订单成功", Toast.LENGTH_SHORT).show();
                transNo = null;
            }
        });
    }

    public void deviceInit() {
        mPdsClient = new PdsClient(this, "https://gw.wisepaycloud.com/", "2122060266", "PP35272137000547", "wzac09fb2b0ad16b28",true,
                new PdsResponseCallBack<DeviceInitResponse>() {
                    @Override
                    public void onError(String errorCode, String errorMsg) {
                        Log.e("收到错误回调", errorMsg + errorCode);
                        Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(DeviceInitResponse data) {
                        Toast.makeText(MainActivity.this, data.toString(), Toast.LENGTH_SHORT).show();
                        findViewById(R.id.create_bank_card_order).setVisibility(View.VISIBLE);
                        findViewById(R.id.bank_card_trans_close).setVisibility(View.VISIBLE);
                        findViewById(R.id.bank_card_order_complete).setVisibility(View.VISIBLE);
                        findViewById(R.id.trans_log_upload).setVisibility(View.VISIBLE);
                        findViewById(R.id.upload_file).setVisibility(View.VISIBLE);
                        findViewById(R.id.trans_list).setVisibility(View.VISIBLE);
                        findViewById(R.id.trans_detail).setVisibility(View.VISIBLE);
                        Log.e("收到成功数据", data.toString());
                    }
                });
    }
}