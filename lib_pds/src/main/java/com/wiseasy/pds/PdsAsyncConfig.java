package com.wiseasy.pds;

/**
 * 数据异步上传缓存配置
 * User: pupan
 * Date: 2022/6/28
 * Time: 14:33
 */
class PdsAsyncConfig {
    /**
     * 缓存数据发送超时时间，如果缓存超时，则立即上传
     */
    private String packetTimeOut;

    /**
     * 最大缓存数据条数
     */
    private String dataMaxCount;

    /**
     * 数据最大重传次数，超过次数舍弃
     */
    private String dataMaxReUpLoadCount;

    /**
     * 数据最大重传时间，超过时间未重传成功则舍弃
     */
    private String dataMaxReUploadTime;

    /**
     * 网络连接超时时间
     */
    private String connectTimeoutSec;

    public void setConnectTimeoutSec(String connectTimeoutSec) {
        this.connectTimeoutSec = connectTimeoutSec;
    }

    public String getConnectTimeoutSec() {
        return connectTimeoutSec;
    }

    public void setDataMaxCount(String dataMaxCount) {
        this.dataMaxCount = dataMaxCount;
    }

    public void setDataMaxReUpLoadCount(String dataMaxReUpLoadCount) {
        this.dataMaxReUpLoadCount = dataMaxReUpLoadCount;
    }

    public void setDataMaxReUploadTime(String dataMaxReUploadTime) {
        this.dataMaxReUploadTime = dataMaxReUploadTime;
    }

    public void setPacketTimeOut(String packetTimeOut) {
        this.packetTimeOut = packetTimeOut;
    }

    public String getDataMaxCount() {
        return dataMaxCount;
    }

    public String getDataMaxReUpLoadCount() {
        return dataMaxReUpLoadCount;
    }

    public String getDataMaxReUploadTime() {
        return dataMaxReUploadTime;
    }

    public String getPacketTimeOut() {
        return packetTimeOut;
    }
}
