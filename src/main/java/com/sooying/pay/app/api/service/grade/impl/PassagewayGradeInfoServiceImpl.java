package com.sooying.pay.app.api.service.grade.impl;

import java.util.ArrayList;
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
import com.sooying.pay.app.api.base.BasePagination;
import com.sooying.pay.app.api.constant.ApiStatusEnum;
import com.sooying.pay.app.api.constant.ProvinceEnum;
import com.sooying.pay.app.api.controller.grade.dto.PassagewayGradeInfoDto;
import com.sooying.pay.app.api.dao.platform.grade.PassagewayGradeInfoDao;
import com.sooying.pay.app.api.model.platform.grade.PassagewayGradeInfo;
import com.sooying.pay.app.api.service.grade.PassagewayGradeInfoService;
import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 通道分级系数数据
 * 
 * @Description PassagewayGradeInfoServiceImpl
 * @author liurh
 * @date 2018年6月14日
 */
@Service("passagewayGradeInfoService")
public class PassagewayGradeInfoServiceImpl implements PassagewayGradeInfoService {
    private static Logger logger = LoggerFactory.getLogger(PassagewayGradeInfoServiceImpl.class);

    @Resource
    PassagewayGradeInfoDao passagewayGradeInfoDao;

    /**
     * 获取通道分级系数数据列表
     * 
     * @param passagewayGradeInfoDto
     * @return
     */
    @Override
    public String getPassagewayGradeInfoList(PassagewayGradeInfoDto passagewayGradeInfoDto) {
        logger.info("PassagewayGradeInfoServiceImpl getPassagewayGradeInfoList user is {}, page is {}, rows is {}, {}",
                passagewayGradeInfoDto.getLoginName(), passagewayGradeInfoDto.getPage(),
                passagewayGradeInfoDto.getRows(), passagewayGradeInfoDto.toString());

        String province = null;
        if (StringUtils.isNotBlank(passagewayGradeInfoDto.getProvince())) {
            Assert.isTrue(NumberUtils.isNumber(passagewayGradeInfoDto.getProvince()), "省份枚举必须是数字！");
            province = ProvinceEnum.getEnumNameByCode(Integer.parseInt(passagewayGradeInfoDto.getProvince()));
        }

        Integer price = null;
        if (StringUtils.isNotBlank(passagewayGradeInfoDto.getPrice())) {
            Assert.isTrue(NumberUtils.isNumber(passagewayGradeInfoDto.getPrice()), "资费必须是数字！");
            price = Integer.parseInt(passagewayGradeInfoDto.getPrice());
        }

        // 查询参数
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("passagewayId", passagewayGradeInfoDto.getPassagewayId());
        paramsMap.put("province", province);
        paramsMap.put("price", price);
        paramsMap.put("netOperator", passagewayGradeInfoDto.getNetOperator());

        // 查询总数
        int totalCount = passagewayGradeInfoDao.selectPassagewayGradeInfoCount(paramsMap);

        // 初始化分页信息
        BasePagination pagination = new BasePagination(totalCount);
        pagination.setCurrentPage(passagewayGradeInfoDto.getPage());
        pagination.setRowsPerPage(passagewayGradeInfoDto.getRows());
        pagination.initPage();

        paramsMap.put("start", pagination.getStart());
        paramsMap.put("rowsPerPage", pagination.getRowsPerPage());

        // 查询list
        List<PassagewayGradeInfo> list = passagewayGradeInfoDao.selectPassagewayGradeInfoList(paramsMap);

        // 设置省份名称
        setProvinceName(list);

        // list装入返回类型
        List<Object> dataList = new ArrayList<Object>();
        dataList.addAll(list);

        String msg = "获取通道分级系数数据成功";
        logger.info("PassagewayGradeInfoServiceImpl getPassagewayGradeInfoList {}", msg);
        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), msg, dataList);
    }

    /**
     * 设置省份名称
     *
     * @param list
     */
    private void setProvinceName(List<PassagewayGradeInfo> list) {
        for (PassagewayGradeInfo passagewayGradeInfo : list) {
            // 通过枚举名称获取省份名称
            String province = ProvinceEnum.getNameByEnumName(passagewayGradeInfo.getProvince());

            passagewayGradeInfo.setProvince(province);
        }
    }

}
