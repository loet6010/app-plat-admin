package com.sooying.pay.app.api.model.platform.database;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringStyle;

import com.bench.common.lang.ToStringBuilder;

/**
 * 代码分省份成功率
 * 
 * @Description ProvinceSuccessRateInfo
 * @author liurh
 * @date 2018年6月21日
 */
public class ProvinceSuccessRateInfo {
    // 省份
    private String province;
    // 运营商
    private String netType;
    // 成功率
    private BigDecimal successRate;
    // 请求用户
    private int requestCount;
    // 确认用户
    private int confirmCount;
    // 成功用户
    private int successCount;
    // 风控用户
    private int riskCount;

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     *            the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the netType
     */
    public String getNetType() {
        return netType;
    }

    /**
     * @param netType
     *            the netType to set
     */
    public void setNetType(String netType) {
        this.netType = netType;
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
     *
     * @return
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
