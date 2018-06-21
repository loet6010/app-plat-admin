package com.sooying.pay.app.api.controller.database.dto;

import com.sooying.pay.app.api.base.BasePageDto;

/**
 * 数据库查询
 * 
 * @Description DatabaseInfoDto
 * @author liurh
 * @date 2018年6月19日
 */
public class DatabaseInfoDto extends BasePageDto {
    // 应用ID
    private String appId;
    // 通道ID
    private String passagewayId;
    // 运营商
    private String netType;
    // 省份
    private String province;

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
     *
     * @return
     */
    @Override
    public String toString() {
        return "DatabaseInfoDto [appId=" + appId + ", passagewayId=" + passagewayId + ", netType=" + netType
                + ", province=" + province + "]";
    }
}
