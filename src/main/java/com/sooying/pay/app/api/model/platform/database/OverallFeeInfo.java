package com.sooying.pay.app.api.model.platform.database;

import org.apache.commons.lang.builder.ToStringStyle;

import com.bench.common.lang.ToStringBuilder;

/**
 * 大盘同步信息费
 * 
 * @Description OverallFeeInfo
 * @author liurh
 * @date 2018年6月21日
 */
public class OverallFeeInfo {
    // 日期
    private String statisDate;
    // 通道ID
    private int passagewayId;
    // 通道名称
    private String passagewayName;
    // 信息费
    private int fee;

    /**
     * @return the statisDate
     */
    public String getStatisDate() {
        return statisDate;
    }

    /**
     * @param statisDate
     *            the statisDate to set
     */
    public void setStatisDate(String statisDate) {
        this.statisDate = statisDate;
    }

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
     * @return the fee
     */
    public int getFee() {
        return fee;
    }

    /**
     * @param fee
     *            the fee to set
     */
    public void setFee(int fee) {
        this.fee = fee;
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
