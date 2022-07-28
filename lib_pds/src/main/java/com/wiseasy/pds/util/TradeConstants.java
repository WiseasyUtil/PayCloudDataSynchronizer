package com.wiseasy.pds.util;

/**
 * common data type
 * User: pupan
 * Date: 2022/6/30
 * Time: 10:48
 *
 * @author pupan
 */
public class TradeConstants {

    //trans type
    /**
     * consume type
     */
    public static final String TRADE_TYPE_CONSUME = "1";

    /**
     * revocation type
     */
    public static final String TRADE_TYPE_CONSUME_REVOCATION = "2";

    /**
     * refund type
     */
    public static final String TRADE_TYPE_RETURN_GOODS_OR_REFUND = "3";

    /**
     * preAuth type
     */
    public static final String TRADE_TYPE_PRE_AUTHORIZATION = "4";

    /**
     * preAuth cancel type
     */
    public static final String TRADE_TYPE_PRE_AUTHORIZATION_REVOCATION = "5";

    /**
     * preAuth complete type
     */
    public static final String TRADE_TYPE_PRE_AUTHORIZATION_COMPLETE = "6";

    /**
     * preAuth complete revocation
     */
    public static final String TRADE_TYPE_PRE_AUTHORIZATION_COMPLETE_REVOCATION = "7";

    /**
     * preAuth complete refund
     */
    public static final String TRADE_TYPE_PRE_AUTHORIZATION_COMPLETE_REFUND = "8";

    /**
     * cashback type
     */
    public static final String TRADE_TYPE_PRE_CASH_BACK = "11";

    //pay method
    /**
     * pay method visa
     */
    public static final String PAY_METHOD_VISA = "Visa";

    /**
     * pay method master card
     */
    public static final String PAY_METHOD_MASTER_CARD = "MasterCard";

    /**
     * pay method amex
     */
    public static final String PAY_METHOD_AMEX = "Amex";

    /**
     * pay method discover
     */
    public static final String PAY_METHOD_DISCOVER = "Discover";

    /**
     * pay method discover
     */
    public static final String PAY_METHOD_JCB = "JCB";

    /**
     * pay method DinnersClub
     */
    public static final String PAY_METHOD_DINNERS_CLUB = "DinnersClub";

    /**
     * send data to channel
     */
    public static final String PAY_LOG_ACTION_SEND_DATA_CHANNEL = "5";

    /**
     * response channel data
     */
    public static final String PAY_LOG_ACTION_RESPONSE_CHANNEL_DATA = "6";

    /**
     * action other
     */
    public static final String PAY_LOG_ACTION_OTHER = "99";

    /**
     * log status success
     */
    public static final String PAY_LOG_STATUS_SUCCESS = "1";

    /**
     * log status fail
     */
    public static final String PAY_LOG_STATUS_FAIL = "2";

    /**
     * log status time out
     */
    public static final String PAY_LOG_STATUS_TIME_OUT = "3";

    /**
     * phone net type
     */
    public static final String PAY_LOG_NET_LINK_TYPE_PHONE = "101";

    /**
     * wifi net type
     */
    public static final String PAY_LOG_NET_LINK_TYPE_WIFI = "401";

    /**
     * wlan net type
     */
    public static final String PAY_LOG_NET_LINK_TYPE_WLAN = "501";


}
