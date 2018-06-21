package com.sooying.pay.app.api.model.platform.rule;

/**
 * 通道过滤规则
 * 
 * @Description RuleInfo
 * @author liurh
 * @date 2018年6月5日
 */
public class RuleInfo {
    // 主键ID
    private long id;
    // 通道ID
    private String passagewayId;
    // 代码类型
    private String codeType;
    // 规则类型
    private String ruleType;
    // 规则内容
    private String ruleValue;
    // 规则生效时间
    private String startTime;
    // 激活状态
    private String status;

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
     * @return the ruleType
     */
    public String getRuleType() {
        return ruleType;
    }

    /**
     * @param ruleType
     *            the ruleType to set
     */
    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
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
     *
     * @return
     */
    @Override
    public String toString() {
        return "RuleInfo [id=" + id + ", passagewayId=" + passagewayId + ", codeType=" + codeType + ", ruleType="
                + ruleType + ", ruleValue=" + ruleValue + ", startTime=" + startTime + ", status=" + status + "]";
    }

}
