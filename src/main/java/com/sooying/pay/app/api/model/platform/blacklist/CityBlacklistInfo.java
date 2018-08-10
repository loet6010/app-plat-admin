package com.sooying.pay.app.api.model.platform.blacklist;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringStyle;

import com.bench.common.lang.ToStringBuilder;

/**
 * 地市黑名单
 * 
 * @Description CityBlacklistInfo
 * @author liurh
 * @date 2018年8月3日
 */
public class CityBlacklistInfo {
    // 主键ID
    private long id;
    // 通道ID
    private int passagewayId;
    // 省份
    private String province;
    // 城市
    private String city;
    // 通道类型
    private String passagewayType;
    // 状态
    private String status;
    // 创建时间
    private Date createTime;
    // 修改时间
    private Date modifyTime;

    /**
     * 获取主键ID
     * 
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * 设置主键ID
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 获取通道ID
     * 
     * @return the passagewayId
     */
    public int getPassagewayId() {
        return passagewayId;
    }

    /**
     * 设置通道ID
     * 
     * @param passagewayId
     */
    public void setPassagewayId(int passagewayId) {
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
     * 获取通道类型
     * 
     * @return the passagewayType
     */
    public String getPassagewayType() {
        return passagewayType;
    }

    /**
     * 设置通道类型
     * 
     * @param passagewayType
     */
    public void setPassagewayType(String passagewayType) {
        this.passagewayType = passagewayType;
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
     * 获取创建时间
     * 
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     * 
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     * 
     * @return the modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     * 
     * @param modifyTime
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
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
