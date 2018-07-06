package com.sooying.pay.app.api.model.platform.popup;

import org.apache.commons.lang.builder.ToStringStyle;

import com.bench.common.lang.ToStringBuilder;

/**
 * 二次确认弹窗
 * 
 * @Description PopUpInfo
 * @author liurh
 * @date 2018年6月13日
 */
public class PopUpInfo {
    // 主键ID
    private long id;
    // 通道ID
    private String passagewayId;
    // 运营商
    private String netType;
    // 渠道号
    private String channelNo;
    // 省份
    private String province;
    // 规则格式
    private String popUpRule;
    // 通道ID存在状态
    private String pluginStatus;
    // APPID
    private String appId;
    // 优先级
    private String priority;
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
     * @return the channelNo
     */
    public String getChannelNo() {
        return channelNo;
    }

    /**
     * @param channelNo
     *            the channelNo to set
     */
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

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
     * @return the popUpRule
     */
    public String getPopUpRule() {
        return popUpRule;
    }

    /**
     * @param popUpRule
     *            the popUpRule to set
     */
    public void setPopUpRule(String popUpRule) {
        this.popUpRule = popUpRule;
    }

    /**
     * @return the pluginStatus
     */
    public String getPluginStatus() {
        return pluginStatus;
    }

    /**
     * @param pluginStatus
     *            the pluginStatus to set
     */
    public void setPluginStatus(String pluginStatus) {
        this.pluginStatus = pluginStatus;
    }

    /**
     * @return the appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId
     *            the appId to set
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * @return the priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * @param priority
     *            the priority to set
     */
    public void setPriority(String priority) {
        this.priority = priority;
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
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
