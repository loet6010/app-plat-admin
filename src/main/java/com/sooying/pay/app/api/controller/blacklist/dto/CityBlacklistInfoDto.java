package com.sooying.pay.app.api.controller.blacklist.dto;

import org.apache.commons.lang.builder.ToStringStyle;

import com.bench.common.lang.ToStringBuilder;
import com.sooying.pay.app.api.common.base.BasePageDto;

/**
 * 地市黑名单
 * 
 * @Description CityBlacklistInfoDto
 * @author liurh
 * @date 2018年8月3日
 */
public class CityBlacklistInfoDto extends BasePageDto {
    // 主键ID
    private String id;
    // 通道ID
    private String passagewayId;
    // 省份
    private String province;
    // 城市
    private String city;
    // 状态
    private String status;

    /**
     * 获取主键ID
     * 
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键ID
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取通道ID
     * 
     * @return the passagewayId
     */
    public String getPassagewayId() {
        return passagewayId;
    }

    /**
     * 设置通道ID
     * 
     * @param passagewayId
     */
    public void setPassagewayId(String passagewayId) {
        this.passagewayId = passagewayId;
    }

    /**
     * 获取省份
     * 
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     * 
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市
     * 
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     * 
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取状态
     * 
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     * 
     * @param status
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
