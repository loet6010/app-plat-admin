package com.sooying.pay.app.api.service.blacklist;

import com.sooying.pay.app.api.controller.blacklist.dto.CityBlacklistInfoDto;

/**
 * 地市黑名单
 * 
 * @Description CityBlacklistInfoService
 * @author liurh
 * @date 2018年8月3日
 */
public interface CityBlacklistInfoService {

    /**
     * 获取地市黑名单列表
     *
     * @param cityBlacklistInfoDto
     * @return
     */
    String getCityBlacklistInfoList(CityBlacklistInfoDto cityBlacklistInfoDto);

    /**
     * 修改地市黑名单
     *
     * @param cityBlacklistInfoDto
     * @return
     */
    String modifyCityBlacklistInfo(CityBlacklistInfoDto cityBlacklistInfoDto);

    /**
     * 删除地市黑名单
     *
     * @param cityBlacklistInfoDto
     * @return
     */
    String removeCityBlacklistInfo(CityBlacklistInfoDto cityBlacklistInfoDto);

    /**
     * 修改地市黑名单激活状态
     *
     * @param cityBlacklistInfoDto
     * @return
     */
    String modifyCityBlacklistInfoStatus(CityBlacklistInfoDto cityBlacklistInfoDto);

    /**
     * 新增地市黑名单
     *
     * @param cityBlacklistInfoDto
     * @return
     */
    String addCityBlacklistInfo(CityBlacklistInfoDto cityBlacklistInfoDto);
}
