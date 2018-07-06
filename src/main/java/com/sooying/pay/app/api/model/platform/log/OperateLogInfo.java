package com.sooying.pay.app.api.model.platform.log;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringStyle;

import com.bench.common.lang.ToStringBuilder;

/**
 * 操作日志
 * 
 * @Description OperateLogInfo
 * @author liurh
 * @date 2018年6月23日
 */
public class OperateLogInfo {
    // 主键ID
    private long id;
    // 操作者
    private String operator;
    // 创建时间
    private Date createTime;
    // 项目名称
    private String projectName;
    // 平台名称
    private String platformName;
    // 操作途径，现在只记录触发的action类的类名+方法名
    private String channel;
    // 类型，目前有删除、更新、插入、路径
    private String type;
    // 内容，用json进行记录
    private String content;
    // 登陆该平台的电脑的ip
    private String loginIP;
    // 触发该日志的点（完整类名+方法名）
    private String triggerPoint;
    // 备注
    private String remark;

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
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator
     *            the operator to set
     */
    public void setOperator(String operator) {
        this.operator = operator;
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
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName
     *            the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return the platformName
     */
    public String getPlatformName() {
        return platformName;
    }

    /**
     * @param platformName
     *            the platformName to set
     */
    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    /**
     * @return the channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     * @param channel
     *            the channel to set
     */
    public void setChannel(String channel) {
        this.channel = channel;
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
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     *            the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the loginIP
     */
    public String getLoginIP() {
        return loginIP;
    }

    /**
     * @param loginIP
     *            the loginIP to set
     */
    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    /**
     * @return the triggerPoint
     */
    public String getTriggerPoint() {
        return triggerPoint;
    }

    /**
     * @param triggerPoint
     *            the triggerPoint to set
     */
    public void setTriggerPoint(String triggerPoint) {
        this.triggerPoint = triggerPoint;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     *            the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
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