package com.sooying.pay.app.api.dao.collect.database;

import com.sooying.pay.app.api.model.collect.database.StartDataInfo;

/**
 * Collect数据库查询
 * 
 * @Description QueryCollectDao
 * @author liurh
 * @date 2018年6月19日
 */
public interface QueryCollectDao {

    /**
     * 查询启动表数据
     *
     * @param appId
     * @return
     */
    StartDataInfo selectStartDataInfo(int appId);
}
