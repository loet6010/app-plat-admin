package com.sooying.pay.app.api.service.database.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.bench.common.lang.NumberUtils;
import com.bench.common.lang.StringUtils;
import com.sooying.pay.app.api.common.base.BasePagination;
import com.sooying.pay.app.api.common.constant.Constants;
import com.sooying.pay.app.api.common.enums.ApiStatusEnum;
import com.sooying.pay.app.api.controller.database.dto.DatabaseInfoDto;
import com.sooying.pay.app.api.dao.collect.database.QueryCollectDao;
import com.sooying.pay.app.api.dao.platform.database.QueryPlatformDao;
import com.sooying.pay.app.api.model.collect.database.StartDataInfo;
import com.sooying.pay.app.api.model.platform.database.OverallDataInfo;
import com.sooying.pay.app.api.model.platform.database.OverallFeeInfo;
import com.sooying.pay.app.api.model.platform.database.ProvinceSuccessRateInfo;
import com.sooying.pay.app.api.model.platform.database.SuccessRateInfo;
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

        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("appId", appId);

        // 获取代码成功率查询时间，间隔最多1天
        SearchTimeInfo searchTimeInfo = getValidateSearchTime(databaseInfoDto.getBeginTime(),
                databaseInfoDto.getEndTime(), 1);
        paramsMap.put("beginTime", searchTimeInfo.getBeginTime());
        paramsMap.put("endTime", searchTimeInfo.getEndTime());

        // 查询支付结果表大盘数据
        OverallDataInfo overallDataInfo = queryPlatformDao.selectOverallDataInfo(paramsMap);

        // 查询启动表数据
        StartDataInfo startDataInfo = queryCollectDao.selectStartDataInfo(paramsMap);

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

    /**
     * 获取代码成功率
     * 
     * @param databaseInfoDto
     * @return
     */
    @Override
    public String getSuccessRateInfoList(DatabaseInfoDto databaseInfoDto) {
        logger.info("QueryDatabaseServiceImpl getSuccessRateInfoList user is {}, passagewayId is {}",
                databaseInfoDto.getLoginName(), databaseInfoDto.getPassagewayId());

        Assert.isTrue(StringUtils.isNotBlank(databaseInfoDto.getNetType()), "运营商不能为空！");

        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("netType", databaseInfoDto.getNetType());
        paramsMap.put("province", databaseInfoDto.getProvince());
        paramsMap.put("passagewayId", databaseInfoDto.getPassagewayId());
        Integer appId = null;
        if (StringUtils.isNotBlank(databaseInfoDto.getAppId())) {
            Assert.isTrue(NumberUtils.isDigits(databaseInfoDto.getAppId()), "应用ID必须是整数！");
            
            appId = Integer.parseInt(databaseInfoDto.getAppId());
        }
        paramsMap.put("appId", appId);

        // 获取代码成功率查询时间，间隔最多1天
        SearchTimeInfo searchTimeInfo = getValidateSearchTime(databaseInfoDto.getBeginTime(),
                databaseInfoDto.getEndTime(), 1);
        paramsMap.put("beginTime", searchTimeInfo.getBeginTime());
        paramsMap.put("endTime", searchTimeInfo.getEndTime());

        // 查询总数
        int totalCount = queryPlatformDao.selectSuccessRateInfoCount(paramsMap);

        // 初始化分页信息
        BasePagination pagination = new BasePagination(totalCount);
        pagination.setCurrentPage(databaseInfoDto.getPage());
        pagination.setRowsPerPage(databaseInfoDto.getRows());
        pagination.initPage();

        paramsMap.put("start", pagination.getStart());
        paramsMap.put("rowsPerPage", pagination.getRowsPerPage());

        List<SuccessRateInfo> successRateInfoList = queryPlatformDao.selectSuccessRateInfoList(paramsMap);

        // list装入返回类型
        List<Object> dataList = new ArrayList<Object>();
        dataList.addAll(successRateInfoList);

        String msg = "获取代码成功率成功";
        logger.info("QueryDatabaseServiceImpl getSuccessRateInfoList {}", msg);
        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), msg, dataList);
    }

    /**
     * 获取代码分省份成功率
     * 
     * @param databaseInfoDto
     * @return
     */
    @Override
    public String getProvinceSuccessRateInfoList(DatabaseInfoDto databaseInfoDto) {
        logger.info("QueryDatabaseServiceImpl getProvinceSuccessRateInfoList user is {}, netType is {}, province is {}",
                databaseInfoDto.getLoginName(), databaseInfoDto.getNetType(), databaseInfoDto.getProvince());

        Assert.isTrue(StringUtils.isNotBlank(databaseInfoDto.getNetType()), "运营商不能为空！");

        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("netType", databaseInfoDto.getNetType());
        paramsMap.put("province", databaseInfoDto.getProvince());

        // 获取代码分省份成功率查询时间，间隔最多1天
        SearchTimeInfo searchTimeInfo = getValidateSearchTime(databaseInfoDto.getBeginTime(),
                databaseInfoDto.getEndTime(), 1);
        paramsMap.put("beginTime", searchTimeInfo.getBeginTime());
        paramsMap.put("endTime", searchTimeInfo.getEndTime());

        // 查询总数
        int totalCount = queryPlatformDao.selectProvinceSuccessRateInfoCount(paramsMap);

        // 初始化分页信息
        BasePagination pagination = new BasePagination(totalCount);
        pagination.setCurrentPage(databaseInfoDto.getPage());
        pagination.setRowsPerPage(databaseInfoDto.getRows());
        pagination.initPage();

        paramsMap.put("start", pagination.getStart());
        paramsMap.put("rowsPerPage", pagination.getRowsPerPage());

        List<ProvinceSuccessRateInfo> successRateInfoList = queryPlatformDao
                .selectProvinceSuccessRateInfoList(paramsMap);

        // list装入返回类型
        List<Object> dataList = new ArrayList<Object>();
        dataList.addAll(successRateInfoList);

        String msg = "获取代码分省份成功率成功";
        logger.info("QueryDatabaseServiceImpl getProvinceSuccessRateInfoList {}", msg);
        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), msg, dataList);
    }

    /**
     * 获取大盘同步信息费
     * 
     * @param databaseInfoDto
     * @return
     */
    @Override
    public String getOverallFeeInfoList(DatabaseInfoDto databaseInfoDto) {
        logger.info("QueryDatabaseServiceImpl getOverallFeeInfoList user is {}, passagewayId is {}",
                databaseInfoDto.getLoginName(), databaseInfoDto.getPassagewayId());

        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("passagewayId", databaseInfoDto.getPassagewayId());

        // 获取大盘同步信息费查询时间，间隔最多7天
        SearchTimeInfo searchTimeInfo = getValidateSearchTime(databaseInfoDto.getBeginTime(),
                databaseInfoDto.getEndTime(), 7);
        paramsMap.put("beginTime", searchTimeInfo.getBeginTime());
        paramsMap.put("endTime", searchTimeInfo.getEndTime());

        // 查询总数
        int totalCount = queryPlatformDao.selectOverallFeeInfoCount(paramsMap);

        // 初始化分页信息
        BasePagination pagination = new BasePagination(totalCount);
        pagination.setCurrentPage(databaseInfoDto.getPage());
        pagination.setRowsPerPage(databaseInfoDto.getRows());
        pagination.initPage();

        paramsMap.put("start", pagination.getStart());
        paramsMap.put("rowsPerPage", pagination.getRowsPerPage());

        List<OverallFeeInfo> successRateInfoList = queryPlatformDao.selectOverallFeeInfoList(paramsMap);

        // list装入返回类型
        List<Object> dataList = new ArrayList<Object>();
        dataList.addAll(successRateInfoList);

        String msg = "获取大盘同步信息费成功";
        logger.info("QueryDatabaseServiceImpl getOverallFeeInfoList {}", msg);
        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), msg, dataList);
    }

    /**
     * 获取验证后的查询时间
     *
     * @param beginTime
     * @param endTime
     * @param intervalDays
     * @return
     */
    private SearchTimeInfo getValidateSearchTime(String beginTime, String endTime, int intervalDays) {
        SearchTimeInfo searchTimeInfo = new SearchTimeInfo();

        // 验证日期格式
        Assert.isTrue((StringUtils.isNotBlank(beginTime) && StringUtils.isNotBlank(endTime))
                || (StringUtils.isBlank(beginTime) && StringUtils.isBlank(endTime)), "开始时间和结束时间必须同时为空或同时不为空！");
        Assert.isTrue(StringUtils.isBlank(beginTime) || beginTime.matches(Constants.DATE_TIME_REGEXP), "开始时间格式不正确！");
        Assert.isTrue(StringUtils.isBlank(endTime) || endTime.matches(Constants.DATE_TIME_REGEXP), "结束时间格式不正确！");

        // 转换日期格式
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
        try {
            if (StringUtils.isNotBlank(beginTime)) {
                // 验证日期间隔天数
                validateIntervalDays(sdf.parse(beginTime), sdf.parse(endTime), intervalDays);

                // 设置日期
                searchTimeInfo.setBeginTime(sdf.parse(beginTime));
                searchTimeInfo.setEndTime(sdf.parse(endTime));
            } else {
                // 设置日期为当天时间
                SimpleDateFormat sdfDate = new SimpleDateFormat(Constants.DATE_FORMAT);
                Date dateNow = new Date();
                String dateString = sdfDate.format(dateNow);
                String dateStringBegin = dateString + Constants.BLANK_ONE + Constants.TIME_BEGIN;
                String dateStringEnd = dateString + Constants.BLANK_ONE + Constants.TIME_END;

                // 设置日期
                searchTimeInfo.setBeginTime(sdf.parse(dateStringBegin));
                searchTimeInfo.setEndTime(sdf.parse(dateStringEnd));
            }
        } catch (ParseException e) {
            logger.info("QueryDatabaseServiceImpl validateSearchTime 时间类型转换错误：{}", e.getMessage());
            Assert.isTrue(false, "时间类型转换错误：" + e.getMessage());
        }

        return searchTimeInfo;
    }

    /**
     * 验证时间间隔
     *
     * @param beginTime
     * @param endTime
     * @param intervalDays
     */
    private void validateIntervalDays(Date beginTime, Date endTime, int intervalDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginTime);
        calendar.add(Calendar.DAY_OF_MONTH, intervalDays);

        Date maxDate = calendar.getTime();

        Assert.isTrue(endTime.compareTo(maxDate) <= 0, "日期间隔超过最大限制，当前查询日期最多间隔" + intervalDays + "天！");
    }

    /**
     * 查询时间Bean
     * 
     * @Description SearchTimeInfo
     * @author liurh
     * @date 2018年6月22日
     */
    private class SearchTimeInfo {
        private Date beginTime;
        private Date endTime;

        public Date getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(Date beginTime) {
            this.beginTime = beginTime;
        }

        public Date getEndTime() {
            return endTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }
    }
}
