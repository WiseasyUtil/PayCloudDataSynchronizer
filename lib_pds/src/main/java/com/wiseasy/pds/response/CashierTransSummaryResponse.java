package com.wiseasy.pds.response;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 12/8/2022
 * Time: 9:45 AM
 *
 * @author pupan
 */
public class CashierTransSummaryResponse extends BaseResponse {
    String settlement_currency;
    double purchase_amount;
    int purchase_num;
    double refund_amount;
    int refund_num;
    double fees_amount;
    double vat_amount;
    double receivable_amount;

    public void setSettlement_currency(String settlement_currency) {
        this.settlement_currency = settlement_currency;
    }

    public void setVat_amount(double vat_amount) {
        this.vat_amount = vat_amount;
    }

    public void setReceivable_amount(double receivable_amount) {
        this.receivable_amount = receivable_amount;
    }

    public void setRefund_amount(double refund_amount) {
        this.refund_amount = refund_amount;
    }

    public void setFees_amount(double fees_amount) {
        this.fees_amount = fees_amount;
    }

    public void setPurchase_amount(double purchase_amount) {
        this.purchase_amount = purchase_amount;
    }

    public void setPurchase_num(int purchase_num) {
        this.purchase_num = purchase_num;
    }

    public void setRefund_num(int refund_num) {
        this.refund_num = refund_num;
    }

    public String getSettlement_currency() {
        return settlement_currency;
    }

    public double getReceivable_amount() {
        return receivable_amount;
    }

    public double getRefund_amount() {
        return refund_amount;
    }

    public double getPurchase_amount() {
        return purchase_amount;
    }

    public int getPurchase_num() {
        return purchase_num;
    }

    public double getVat_amount() {
        return vat_amount;
    }

    public double getFees_amount() {
        return fees_amount;
    }

    public int getRefund_num() {
        return refund_num;
    }
}
