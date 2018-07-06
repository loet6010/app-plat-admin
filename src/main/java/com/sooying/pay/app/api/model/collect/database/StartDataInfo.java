package com.sooying.pay.app.api.model.collect.database;

import org.apache.commons.lang.builder.ToStringStyle;

import com.bench.common.lang.ToStringBuilder;

/**
 * 启动表数据
 * 
 * @Description StartDataInfo
 * @author liurh
 * @date 2018年6月19日
 */
public class StartDataInfo {
    // 应用ID
    private int appId;
    // 启动表激活用户
    private int startActiveCount;
    // 启动表请求用户
    private int startRequestCount;

    /**
     * @return the appId
     */
    public int getAppId() {
        return appId;
    }

    /**
     * @param appId
     *            the appId to set
     */
    public void setAppId(int appId) {
        this.appId = appId;
    }

    /**
     * @return the startActiveCount
     */
    public int getStartActiveCount() {
        return startActiveCount;
    }

    /**
     * @param startActiveCount
     *            the startActiveCount to set
     */
    public void setStartActiveCount(int startActiveCount) {
        this.startActiveCount = startActiveCount;
    }

    /**
     * @return the startRequestCount
     */
    public int getStartRequestCount() {
        return startRequestCount;
    }

    /**
     * @param startRequestCount
     *            the startRequestCount to set
     */
    public void setStartRequestCount(int startRequestCount) {
        this.startRequestCount = startRequestCount;
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
