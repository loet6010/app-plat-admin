package com.sooying.pay.app.api.dao.platform.log;

import com.sooying.pay.app.api.model.platform.log.OperateLogInfo;

/**
 * 操作日志
 * 
 * @Description OperateLogInfoDao
 * @author liurh
 * @date 2018年6月23日
 */
public interface OperateLogInfoDao {

    /**
     * 新增操作日志
     *
     * @param operateLogInfo
     */
    void addOperateLog(OperateLogInfo operateLogInfo);
}
