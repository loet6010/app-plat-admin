package com.sooying.pay.app.api.controller.rule.dto;

import com.sooying.pay.app.api.base.BasePageDto;

/**
 * 通道过滤规则dto
 * 
 * @Description RuleInfoDto
 * @author liurh
 * @date 2018年6月11日
 */
public class RuleInfoDto extends BasePageDto {
    // 主键ID
    private String id;
    // 通道ID
    private String passagewayId;
    // 类型
    private String type;
    // 规则值
    private String ruleValue;
    // 规则生效时间
    private String startTime;
    // 激活状态
    private String status;
    // 日限量
    private String dayLimited;
    // 月限量
    private String monthLimited;
    // 屏蔽时间
    private String shieldDate;
    // 开放地区
    private String shieldArea;
    // 省份日限量
    private String provinceDayLimited;
    // 省份月限量
    private String provinceMonthLimited;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the ruleValue
     */
    public String getRuleValue() {
        return ruleValue;
    }

    /**
     * @param ruleValue
     *            the ruleValue to set
     */
    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     *            the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
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
     * @return the dayLimited
     */
    public String getDayLimited() {
        return dayLimited;
    }

    /**
     * @param dayLimited
     *            the dayLimited to set
     */
    public void setDayLimited(String dayLimited) {
        this.dayLimited = dayLimited;
    }

    /**
     * @return the monthLimited
     */
    public String getMonthLimited() {
        return monthLimited;
    }

    /**
     * @param monthLimited
     *            the monthLimited to set
     */
    public void setMonthLimited(String monthLimited) {
        this.monthLimited = monthLimited;
    }

    /**
     * @return the shieldDate
     */
    public String getShieldDate() {
        return shieldDate;
    }

    /**
     * @param shieldDate
     *            the shieldDate to set
     */
    public void setShieldDate(String shieldDate) {
        this.shieldDate = shieldDate;
    }

    /**
     * @return the shieldArea
     */
    public String getShieldArea() {
        return shieldArea;
    }

    /**
     * @param shieldArea
     *            the shieldArea to set
     */
    public void setShieldArea(String shieldArea) {
        this.shieldArea = shieldArea;
    }

    /**
     * @return the provinceDayLimited
     */
    public String getProvinceDayLimited() {
        return provinceDayLimited;
    }

    /**
     * @param provinceDayLimited
     *            the provinceDayLimited to set
     */
    public void setProvinceDayLimited(String provinceDayLimited) {
        this.provinceDayLimited = provinceDayLimited;
    }

    /**
     * @return the provinceMonthLimited
     */
    public String getProvinceMonthLimited() {
        return provinceMonthLimited;
    }

    /**
     * @param provinceMonthLimited
     *            the provinceMonthLimited to set
     */
    public void setProvinceMonthLimited(String provinceMonthLimited) {
        this.provinceMonthLimited = provinceMonthLimited;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        super.toString();
        return "RuleInfoDto [id=" + id + ", passagewayId=" + passagewayId + ", type=" + type + ", ruleValue="
                + ruleValue + ", startTime=" + startTime + ", status=" + status + ", dayLimited=" + dayLimited
                + ", monthLimited=" + monthLimited + ", shieldDate=" + shieldDate + ", shieldArea=" + shieldArea
                + ", provinceDayLimited=" + provinceDayLimited + ", provinceMonthLimited=" + provinceMonthLimited + "]";
    }

}
