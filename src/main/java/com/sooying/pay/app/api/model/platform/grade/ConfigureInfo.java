package com.sooying.pay.app.api.model.platform.grade;

import java.util.Date;

/**
 * 通道常量配置
 * 
 * @Description ConfigureInfo
 * @author liurh
 * @date 2018年7月3日
 */
public class ConfigureInfo {
    // 主键ID
    private long id;
    // 用户确认数
    private long userConfirmCount;
    // 被组合通道第二位权重系数
    private double combineSecondWeight;
    // 分级系数统计间隔时间(分钟)
    private long intervalMinute;
    // 顺延深度
    private long depth;
    // 创建时间
    private Date createTime;
    // 修改时间
    private Date modifyTime;

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
     * @return the userConfirmCount
     */
    public long getUserConfirmCount() {
        return userConfirmCount;
    }

    /**
     * @param userConfirmCount
     *            the userConfirmCount to set
     */
    public void setUserConfirmCount(long userConfirmCount) {
        this.userConfirmCount = userConfirmCount;
    }

    /**
     * @return the combineSecondWeight
     */
    public double getCombineSecondWeight() {
        return combineSecondWeight;
    }

    /**
     * @param combineSecondWeight
     *            the combineSecondWeight to set
     */
    public void setCombineSecondWeight(double combineSecondWeight) {
        this.combineSecondWeight = combineSecondWeight;
    }

    /**
     * @return the intervalMinute
     */
    public long getIntervalMinute() {
        return intervalMinute;
    }

    /**
     * @param intervalMinute
     *            the intervalMinute to set
     */
    public void setIntervalMinute(long intervalMinute) {
        this.intervalMinute = intervalMinute;
    }

    /**
     * @return the depth
     */
    public long getDepth() {
        return depth;
    }

    /**
     * @param depth
     *            the depth to set
     */
    public void setDepth(long depth) {
        this.depth = depth;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     *            the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     *            the modifyTime to set
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "ConfigureInfo [id=" + id + ", userConfirmCount=" + userConfirmCount + ", combineSecondWeight="
                + combineSecondWeight + ", intervalMinute=" + intervalMinute + ", depth=" + depth + ", createTime="
                + createTime + ", modifyTime=" + modifyTime + "]";
    }

}
