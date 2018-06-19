package com.sooying.pay.app.api.model.platform.database;

import java.math.BigDecimal;

/**
 * 大盘数据
 * 
 * @Description OverallDataInfo
 * @author liurh
 * @date 2018年6月19日
 */
public class OverallDataInfo {
    // 应用ID
    private int appId;
    // 启动表激活用户
    private int startActiveCount;
    // 启动表请求用户
    private int startRequestCount;
    // 请求用户
    private int requestCount;
    // 确认用户
    private int confirmCount;
    // 成功用户
    private int successCount;
    // 无通道用户
    private int noPassagewayCount;
    // 成功率
    private BigDecimal successRate;
    // 无卡用户
    private int noCardCount;
    // 无通道占比
    private BigDecimal noPassagewayRate;
    // 风控占比
    private BigDecimal riskRate;
    // 成功arpu值
    private BigDecimal successArpu;

    /**
     * @return the appId
     */
    public int getAppId() {
        return appId;
    }

    /**
     * @param appId
     *            the appId to set
     */
    public void setAppId(int appId) {
        this.appId = appId;
    }

    /**
     * @return the startActiveCount
     */
    public int getStartActiveCount() {
        return startActiveCount;
    }

    /**
     * @param startActiveCount
     *            the startActiveCount to set
     */
    public void setStartActiveCount(int startActiveCount) {
        this.startActiveCount = startActiveCount;
    }

    /**
     * @return the startRequestCount
     */
    public int getStartRequestCount() {
        return startRequestCount;
    }

    /**
     * @param startRequestCount
     *            the startRequestCount to set
     */
    public void setStartRequestCount(int startRequestCount) {
        this.startRequestCount = startRequestCount;
    }

    /**
     * @return the requestCount
     */
    public int getRequestCount() {
        return requestCount;
    }

    /**
     * @param requestCount
     *            the requestCount to set
     */
    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }

    /**
     * @return the confirmCount
     */
    public int getConfirmCount() {
        return confirmCount;
    }

    /**
     * @param confirmCount
     *            the confirmCount to set
     */
    public void setConfirmCount(int confirmCount) {
        this.confirmCount = confirmCount;
    }

    /**
     * @return the successCount
     */
    public int getSuccessCount() {
        return successCount;
    }

    /**
     * @param successCount
     *            the successCount to set
     */
    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    /**
     * @return the noPassagewayCount
     */
    public int getNoPassagewayCount() {
        return noPassagewayCount;
    }

    /**
     * @param noPassagewayCount
     *            the noPassagewayCount to set
     */
    public void setNoPassagewayCount(int noPassagewayCount) {
        this.noPassagewayCount = noPassagewayCount;
    }

    /**
     * @return the successRate
     */
    public BigDecimal getSuccessRate() {
        return successRate;
    }

    /**
     * @param successRate
     *            the successRate to set
     */
    public void setSuccessRate(BigDecimal successRate) {
        this.successRate = successRate;
    }

    /**
     * @return the noCardCount
     */
    public int getNoCardCount() {
        return noCardCount;
    }

    /**
     * @param noCardCount
     *            the noCardCount to set
     */
    public void setNoCardCount(int noCardCount) {
        this.noCardCount = noCardCount;
    }

    /**
     * @return the noPassagewayRate
     */
    public BigDecimal getNoPassagewayRate() {
        return noPassagewayRate;
    }

    /**
     * @param noPassagewayRate
     *            the noPassagewayRate to set
     */
    public void setNoPassagewayRate(BigDecimal noPassagewayRate) {
        this.noPassagewayRate = noPassagewayRate;
    }

    /**
     * @return the riskRate
     */
    public BigDecimal getRiskRate() {
        return riskRate;
    }

    /**
     * @param riskRate
     *            the riskRate to set
     */
    public void setRiskRate(BigDecimal riskRate) {
        this.riskRate = riskRate;
    }

    /**
     * @return the successArpu
     */
    public BigDecimal getSuccessArpu() {
        return successArpu;
    }

    /**
     * @param successArpu
     *            the successArpu to set
     */
    public void setSuccessArpu(BigDecimal successArpu) {
        this.successArpu = successArpu;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "OverallDataInfo [appId=" + appId + ", startActiveCount=" + startActiveCount + ", startRequestCount="
                + startRequestCount + ", requestCount=" + requestCount + ", confirmCount=" + confirmCount
                + ", successCount=" + successCount + ", noPassagewayCount=" + noPassagewayCount + ", successRate="
                + successRate + ", noCardCount=" + noCardCount + ", noPassagewayRate=" + noPassagewayRate
                + ", riskRate=" + riskRate + ", successArpu=" + successArpu + "]";
    }

}
