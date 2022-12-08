package com.wiseasy.pds.request;

import com.wiseasy.pds.response.CashierTransSummaryResponse;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 12/8/2022
 * Time: 9:51 AM
 *
 * @author pupan
 */
public class CashierTransSummaryRequest extends BaseRequest<CashierTransSummaryResponse> {
    String price_currency;
    String settlement_currency;
    String time_start;
    String time_end;

    public void setSettlement_currency(String settlement_currency) {
        this.settlement_currency = settlement_currency;
    }

    public void setPrice_currency(String price_currency) {
        this.price_currency = price_currency;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getSettlement_currency() {
        return settlement_currency;
    }

    public String getPrice_currency() {
        return price_currency;
    }

    public String getTime_end() {
        return time_end;
    }

    public String getTime_start() {
        return time_start;
    }
}
