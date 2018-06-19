package com.sooying.pay.app.api.dao.platform.database;

import com.sooying.pay.app.api.model.platform.database.OverallDataInfo;

/**
 * Platform数据库查询
 * 
 * @Description QueryPlatformDao
 * @author liurh
 * @date 2018年6月19日
 */
public interface QueryPlatformDao {

    /**
     * 查询支付结果表大盘数据
     *
     * @param appId
     * @return
     */
    OverallDataInfo selectOverallDataInfo(int appId);
}
