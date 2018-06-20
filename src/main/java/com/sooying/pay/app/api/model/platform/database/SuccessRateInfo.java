package com.sooying.pay.app.api.model.platform.database;

import java.math.BigDecimal;

/**
 * 代码成功率
 * 
 * @Description SuccessRateInfo
 * @author liurh
 * @date 2018年6月20日
 */
public class SuccessRateInfo {
    // 通道ID
    private int passagewayId;
    // 通道名称
    private String passagewayName;
    // 成功率
    private BigDecimal successRate;
    // 同步率
    private BigDecimal syncRate;
    // 请求用户
    private int requestCount;
    // 确认用户
    private int confirmCount;
    // 成功用户
    private int successCount;
    // 风控用户
    private int riskCount;
    // MR用户
    private int mrCount;

    /**
     * @return the passagewayId
     */
    public int getPassagewayId() {
        return passagewayId;
    }

    /**
     * @param passagewayId
     *            the passagewayId to set
     */
    public void setPassagewayId(int passagewayId) {
        this.passagewayId = passagewayId;
    }

    /**
     * @return the passagewayName
     */
    public String getPassagewayName() {
        return passagewayName;
    }

    /**
     * @param passagewayName
     *            the passagewayName to set
     */
    public void setPassagewayName(String passagewayName) {
        this.passagewayName = passagewayName;
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
     * @return the syncRate
     */
    public BigDecimal getSyncRate() {
        return syncRate;
    }

    /**
     * @param syncRate
     *            the syncRate to set
     */
    public void setSyncRate(BigDecimal syncRate) {
        this.syncRate = syncRate;
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
     * @return the riskCount
     */
    public int getRiskCount() {
        return riskCount;
    }

    /**
     * @param riskCount
     *            the riskCount to set
     */
    public void setRiskCount(int riskCount) {
        this.riskCount = riskCount;
    }

    /**
     * @return the mrCoun
     */
    public int getMrCount() {
        return mrCount;
    }

    /**
     * @param mrCoun
     *            the mrCoun to set
     */
    public void setMrCount(int mrCount) {
        this.mrCount = mrCount;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "SuccessRateInfo [passagewayId=" + passagewayId + ", passagewayName=" + passagewayName + ", successRate="
                + successRate + ", syncRate=" + syncRate + ", requestCount=" + requestCount + ", confirmCount="
                + confirmCount + ", successCount=" + successCount + ", riskCount=" + riskCount + ", mrCount=" + mrCount
                + "]";
    }

}
