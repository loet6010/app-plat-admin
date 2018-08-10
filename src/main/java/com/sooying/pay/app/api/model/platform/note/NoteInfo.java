package com.sooying.pay.app.api.model.platform.note;

import org.apache.commons.lang.builder.ToStringStyle;

import com.bench.common.lang.ToStringBuilder;

/**
 * 短信明细
 * 
 * @Description NoteInfo
 * @author liurh
 * @date 2018年6月5日
 */
public class NoteInfo {
    // 主键ID
    private long id;
    // 通道ID
    private String passagewayId;
    // 通道名称
    private String passagewayName;
    // 代码类型
    private String codeType;
    // 运营商
    private String netOperator;
    // 资费
    private String price;
    // 日请求限制类型
    private int limitType;
    // 日请求限制次数
    private int limitTimes;
    // 日请求限制金额
    private int limitDayFee;
    // 月请求限制金额
    private int limitMonthFee;
    // 请求间隔
    private int requestInterval;
    // 基地ID
    private String baseId;
    // 基地名称
    private String baseName;
    // 资费组ID
    private String feeGroupId;
    // 资费组名称
    private String feeGroupName;
    // 激活状态
    private String status;
    // SDK激活状态
    private String sdkStatus;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the passagewayId
     */
    public String getPassagewayId() {
        return passagewayId;
    }

    /**
     * @param passagewayId
     *            the passagewayId to set
     */
    public void setPassagewayId(String passagewayId) {
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
     * @return the codeType
     */
    public String getCodeType() {
        return codeType;
    }

    /**
     * @param codeType
     *            the codeType to set
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    /**
     * @return the netOperator
     */
    public String getNetOperator() {
        return netOperator;
    }

    /**
     * @param netOperator
     *            the netOperator to set
     */
    public void setNetOperator(String netOperator) {
        this.netOperator = netOperator;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the limitType
     */
    public int getLimitType() {
        return limitType;
    }

    /**
     * @param limitType
     *            the limitType to set
     */
    public void setLimitType(int limitType) {
        this.limitType = limitType;
    }

    /**
     * @return the limitTimes
     */
    public int getLimitTimes() {
        return limitTimes;
    }

    /**
     * @param limitTimes
     *            the limitTimes to set
     */
    public void setLimitTimes(int limitTimes) {
        this.limitTimes = limitTimes;
    }

    /**
     * @return the limitDayFee
     */
    public int getLimitDayFee() {
        return limitDayFee;
    }

    /**
     * @param limitDayFee
     *            the limitDayFee to set
     */
    public void setLimitDayFee(int limitDayFee) {
        this.limitDayFee = limitDayFee;
    }

    /**
     * @return the limitMonthFee
     */
    public int getLimitMonthFee() {
        return limitMonthFee;
    }

    /**
     * @param limitMonthFee
     *            the limitMonthFee to set
     */
    public void setLimitMonthFee(int limitMonthFee) {
        this.limitMonthFee = limitMonthFee;
    }

    /**
     * @return the requestInterval
     */
    public int getRequestInterval() {
        return requestInterval;
    }

    /**
     * @param requestInterval
     *            the requestInterval to set
     */
    public void setRequestInterval(int requestInterval) {
        this.requestInterval = requestInterval;
    }

    /**
     * @return the baseId
     */
    public String getBaseId() {
        return baseId;
    }

    /**
     * @param baseId
     *            the baseId to set
     */
    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    /**
     * @return the baseName
     */
    public String getBaseName() {
        return baseName;
    }

    /**
     * @param baseName
     *            the baseName to set
     */
    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    /**
     * @return the feeGroupId
     */
    public String getFeeGroupId() {
        return feeGroupId;
    }

    /**
     * @param feeGroupId
     *            the feeGroupId to set
     */
    public void setFeeGroupId(String feeGroupId) {
        this.feeGroupId = feeGroupId;
    }

    /**
     * @return the feeGroupName
     */
    public String getFeeGroupName() {
        return feeGroupName;
    }

    /**
     * @param feeGroupName
     *            the feeGroupName to set
     */
    public void setFeeGroupName(String feeGroupName) {
        this.feeGroupName = feeGroupName;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the sdkStatus
     */
    public String getSdkStatus() {
        return sdkStatus;
    }

    /**
     * @param sdkStatus
     *            the sdkStatus to set
     */
    public void setSdkStatus(String sdkStatus) {
        this.sdkStatus = sdkStatus;
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
