package com.sooying.pay.app.api.service.database;

import com.sooying.pay.app.api.controller.database.dto.DatabaseInfoDto;

/**
 * 数据库查询
 * 
 * @Description QueryDatabaseService
 * @author liurh
 * @date 2018年6月19日
 */
public interface QueryDatabaseService {

    /**
     * 获取大盘数据
     *
     * @param databaseInfoDto
     * @return
     */
    String getOverallDataInfo(DatabaseInfoDto databaseInfoDto);

    /**
     * 获取代码成功率
     *
     * @param databaseInfoDto
     * @return
     */
    String getSuccessRateInfoList(DatabaseInfoDto databaseInfoDto);

    /**
     * 获取代码分省份成功率
     *
     * @param databaseInfoDto
     * @return
     */
    String getProvinceSuccessRateInfoList(DatabaseInfoDto databaseInfoDto);
    
    /**
     * 获取大盘同步信息费
     *
     * @param databaseInfoDto
     * @return
     */
    String getOverallFeeInfoList(DatabaseInfoDto databaseInfoDto);
    
    /**
     * 获取结果表错误码占比
     *
     * @param databaseInfoDto
     * @return
     */
    String getResultErrorInfoList(DatabaseInfoDto databaseInfoDto);
}
