package com.sooying.pay.app.api.service.database.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.bench.common.lang.NumberUtils;
import com.sooying.pay.app.api.constant.ApiStatusEnum;
import com.sooying.pay.app.api.controller.database.dto.DatabaseInfoDto;
import com.sooying.pay.app.api.dao.collect.database.QueryCollectDao;
import com.sooying.pay.app.api.dao.platform.database.QueryPlatformDao;
import com.sooying.pay.app.api.model.collect.database.StartDataInfo;
import com.sooying.pay.app.api.model.platform.database.OverallDataInfo;
import com.sooying.pay.app.api.service.database.QueryDatabaseService;
import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 数据库查询
 * 
 * @Description QueryDatabaseServiceImpl
 * @author liurh
 * @date 2018年6月19日
 */
@Service("queryDatabaseService")
public class QueryDatabaseServiceImpl implements QueryDatabaseService {
    private static Logger logger = LoggerFactory.getLogger(QueryDatabaseServiceImpl.class);

    @Resource
    QueryPlatformDao queryPlatformDao;
    @Resource
    QueryCollectDao queryCollectDao;

    /**
     * 获取大盘数据
     * 
     * @param databaseInfoDto
     * @return
     */
    @Override
    public String getOverallDataInfo(DatabaseInfoDto databaseInfoDto) {
        logger.info("QueryDatabaseServiceImpl getOverallDataInfo user is {}, appId is {}",
                databaseInfoDto.getLoginName(), databaseInfoDto.getAppId());

        // 参数校验
        Assert.isTrue(NumberUtils.isDigits(databaseInfoDto.getAppId()), "应用ID必须是整数！");

        int appId = Integer.parseInt(databaseInfoDto.getAppId());

        // 查询支付结果表大盘数据
        OverallDataInfo overallDataInfo = queryPlatformDao.selectOverallDataInfo(appId);

        // 查询启动表数据
        StartDataInfo startDataInfo = queryCollectDao.selectStartDataInfo(appId);

        Assert.isTrue(!(overallDataInfo == null && startDataInfo == null), "当前应用ID:" + appId + "，无大盘数据！");

        // 启动表数据并入大盘数据
        if (overallDataInfo == null) {
            overallDataInfo = new OverallDataInfo();
            overallDataInfo.setAppId(appId);
        }
        if (startDataInfo != null) {
            overallDataInfo.setStartActiveCount(startDataInfo.getStartActiveCount());
            overallDataInfo.setStartRequestCount(startDataInfo.getStartRequestCount());
        }

        // list装入返回类型
        List<Object> dataList = new ArrayList<Object>();
        dataList.add(overallDataInfo);

        String msg = "获取大盘数据成功";
        logger.info("QueryDatabaseServiceImpl getOverallDataInfo {}", msg);
        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), msg, dataList);
    }

}
