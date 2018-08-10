package com.sooying.pay.app.api.dao.platform.blacklist;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sooying.pay.app.api.model.platform.blacklist.CityBlacklistInfo;

/**
 * 地市黑名单
 * 
 * @Description CityBlacklistInfoDao
 * @author liurh
 * @date 2018年8月3日
 */
public interface CityBlacklistInfoDao {

    /**
     * 获取地市黑名单数量
     *
     * @param paramsMap
     * @return
     */
    int selectCityBlacklistInfoCount(Map<String, Object> paramsMap);

    /**
     * 获取地市黑名单列表
     *
     * @param paramsMap
     * @return
     */
    List<CityBlacklistInfo> selectCityBlacklistInfoList(Map<String, Object> paramsMap);

    /**
     * 修改地市黑名单
     *
     * @param cityBlacklistInfo
     */
    void updateCityBlacklistInfo(CityBlacklistInfo cityBlacklistInfo);

    /**
     * 删除地市黑名单
     *
     * @param id
     */
    void deleteCityBlacklistInfo(@Param("id") Long id);

    /**
     * 修改地市黑名单激活状态
     *
     * @param cityBlacklistInfo
     */
    void updateCityBlacklistInfoStatus(CityBlacklistInfo cityBlacklistInfo);

    /**
     * 新增地市黑名单
     *
     * @param cityBlacklistInfo
     */
    void insertCityBlacklistInfo(CityBlacklistInfo cityBlacklistInfo);
}
