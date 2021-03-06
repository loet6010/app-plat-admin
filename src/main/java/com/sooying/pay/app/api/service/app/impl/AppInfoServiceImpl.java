package com.sooying.pay.app.api.service.app.impl;

import com.bench.common.lang.StringUtils;
import com.sooying.pay.app.api.common.base.BasePagination;
import com.sooying.pay.app.api.common.enums.ApiStatusEnum;
import com.sooying.pay.app.api.controller.app.dto.AppInfoDto;
import com.sooying.pay.app.api.dao.platform.app.AppInfoDao;
import com.sooying.pay.app.api.model.platform.app.AppInfo;
import com.sooying.pay.app.api.service.app.AppInfoService;
import com.sooying.pay.app.api.util.ResultReturnUtil;
import com.sooying.pay.app.api.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 应用
 *
 * @author liurh
 * @Description AppInfoServiceImpl
 * @date 2018年8月3日
 */
@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService {
    private static Logger logger = LoggerFactory.getLogger(AppInfoServiceImpl.class);

    @Resource
    AppInfoDao appInfoDao;

    /**
     * 获取应用列表
     *
     * @param appInfoDto
     * @return
     */
    @Override
    public String getAppInfoList(AppInfoDto appInfoDto) {
        logger.info("AppInfoServiceImpl getAppInfoList user is {}, page is {}, rows is {}, {}",
                appInfoDto.getLoginName(), appInfoDto.getPage(), appInfoDto.getRows(), appInfoDto.toString());

        String msg = "获取应用成功";

        Map<String, Object> paramsMap = new HashMap<String, Object>();
        Integer appId = null;
        if (StringUtils.isNotBlank(appInfoDto.getAppId())) {
            appId = Integer.parseInt(appInfoDto.getAppId());
        }
        paramsMap.put("appId", appId);
        paramsMap.put("appName", StringUtil.matchFuzzyString(appInfoDto.getAppName()));

        // 查询总数
        int totalCount = appInfoDao.selectAppInfoCount(paramsMap);

        // 初始化分页信息
        BasePagination pagination = new BasePagination(totalCount, appInfoDto.getPage(), appInfoDto.getRows());

        paramsMap.put("start", pagination.getStart());
        paramsMap.put("rowsPerPage", pagination.getRowsPerPage());

        // 查询list
        List<AppInfo> list = appInfoDao.selectAppInfoList(paramsMap);

        // list装入返回类型
        List<Object> dataList = new ArrayList<Object>(list);

        logger.info("AppInfoServiceImpl getAppInfoList {}", msg);
        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), msg, dataList);
    }
}
