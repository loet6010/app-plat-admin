package com.sooying.pay.app.api.dao.platform.app;

import java.util.List;
import java.util.Map;

import com.sooying.pay.app.api.model.platform.app.AppInfo;

/**
 * 应用
 * 
 * @Description AppInfoDao
 * @author liurh
 * @date 2018年8月3日
 */
public interface AppInfoDao {

    /**
     * 获取应用数量
     *
     * @param paramsMap
     * @return
     */
    int selectAppInfoCount(Map<String, Object> paramsMap);

    /**
     * 获取应用列表
     *
     * @param paramsMap
     * @return
     */
    List<AppInfo> selectAppInfoList(Map<String, Object> paramsMap);
}
