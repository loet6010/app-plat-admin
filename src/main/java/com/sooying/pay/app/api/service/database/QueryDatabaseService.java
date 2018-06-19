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
}
