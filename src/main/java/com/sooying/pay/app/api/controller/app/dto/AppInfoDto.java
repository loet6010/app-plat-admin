package com.sooying.pay.app.api.controller.app.dto;

import org.apache.commons.lang.builder.ToStringStyle;

import com.bench.common.lang.ToStringBuilder;
import com.sooying.pay.app.api.common.base.BasePageDto;

/**
 * 应用
 * 
 * @Description AppInfo
 * @author liurh
 * @date 2018年8月3日
 */
public class AppInfoDto extends BasePageDto {
    // 主键ID
    private String id;
    // 应用ID
    private String appId;
    // 应用名称
    private String appName;

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
     * 获取应用ID
     * 
     * @return the appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置应用ID
     * 
     * @param appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 获取应用名称
     * 
     * @return the appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置应用名称
     * 
     * @param appName
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
