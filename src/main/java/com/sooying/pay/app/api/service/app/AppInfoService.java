package com.sooying.pay.app.api.service.app;

import com.sooying.pay.app.api.controller.app.dto.AppInfoDto;

/**
 * 应用
 * 
 * @Description AppInfoService
 * @author liurh
 * @date 2018年8月3日
 */
public interface AppInfoService {

    /**
     * 获取应用列表
     *
     * @param appInfoDto
     * @return
     */
    String getAppInfoList(AppInfoDto appInfoDto);
}
