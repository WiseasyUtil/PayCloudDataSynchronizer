package com.wiseasy.pds.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.wiseasy.pds.PdsClient;
import com.wiseasy.pds.PdsException;
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
        CashierPayBankcardTransCreateRequest request = new CashierPayBankcardTransCreateRequest();
        request.setPrice_currency("MMK");
        request.setOrder_amount(1.0);
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
        if (null == transNo) {
            Toast.makeText(MainActivity.this, "关闭订单失败，订单号为空", Toast.LENGTH_SHORT).show();
            return;
        }
        CashierPayBankcardTransCloseRequest request = new CashierPayBankcardTransCloseRequest();
        request.setTrans_no(transNo);
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
            mPdsClient.execute(this, request);
        } catch (PdsException e) {
            e.printStackTrace();
        }
    }

    public void upLoadFile(View view) {
//        PdsClient.getBankCardTransactionService().uploadSettlement(null, "1111111", new PdsResponseCallBack<JSONObject>() {
//            @Override
//            public void onError(String errorMsg, String errorCode) {
//
//            }
//
//            @Override
//            public void onSuccess(ResponseData<String> responseData, JSONObject data) {
//
//            }
//        });
    }

    public void deviceInit() {
        mPdsClient = new PdsClient(this, "https://gw.wisepaycloud.com/", "PP35272137000547", "wzac09fb2b0ad16b28", "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", true,
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