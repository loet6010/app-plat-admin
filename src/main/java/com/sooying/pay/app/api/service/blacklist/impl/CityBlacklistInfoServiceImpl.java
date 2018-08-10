package com.sooying.pay.app.api.service.blacklist.impl;

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
import com.sooying.pay.app.api.common.base.BasePagination;
import com.sooying.pay.app.api.common.enums.ApiStatusEnum;
import com.sooying.pay.app.api.common.enums.ProvinceEnum;
import com.sooying.pay.app.api.controller.blacklist.dto.CityBlacklistInfoDto;
import com.sooying.pay.app.api.dao.platform.blacklist.CityBlacklistInfoDao;
import com.sooying.pay.app.api.dao.platform.note.NoteInfoDao;
import com.sooying.pay.app.api.model.platform.blacklist.CityBlacklistInfo;
import com.sooying.pay.app.api.model.platform.note.NoteInfo;
import com.sooying.pay.app.api.service.blacklist.CityBlacklistInfoService;
import com.sooying.pay.app.api.util.BeanDateCopyUtil;
import com.sooying.pay.app.api.util.CheckUtil;
import com.sooying.pay.app.api.util.ResultReturnUtil;
import com.sooying.pay.app.api.util.StringUtil;

/**
 * 地市黑名单
 * 
 * @Description CityBlacklistInfoServiceImpl
 * @author liurh
 * @date 2018年8月3日
 */
@Service("cityBlacklistInfoService")
public class CityBlacklistInfoServiceImpl implements CityBlacklistInfoService {
    private static Logger logger = LoggerFactory.getLogger(CityBlacklistInfoServiceImpl.class);

    @Resource
    CityBlacklistInfoDao cityBlacklistInfoDao;
    @Resource
    NoteInfoDao noteInfoDao;

    /**
     * 获取地市黑名单列表
     * 
     * @param cityBlacklistInfoDto
     * @return
     */
    @Override
    public String getCityBlacklistInfoList(CityBlacklistInfoDto cityBlacklistInfoDto) {
        logger.info("CityBlacklistInfoServiceImpl getCityBlacklistInfoList user is {}, page is {}, rows is {}, {}",
                cityBlacklistInfoDto.getLoginName(), cityBlacklistInfoDto.getPage(), cityBlacklistInfoDto.getRows(),
                cityBlacklistInfoDto.toString());

        Map<String, Object> paramsMap = new HashMap<String, Object>();
        Integer passagewayId = null;
        if (NumberUtils.isDigits(cityBlacklistInfoDto.getPassagewayId())) {
            passagewayId = Integer.parseInt(cityBlacklistInfoDto.getPassagewayId());
        }
        paramsMap.put("passagewayId", passagewayId);
        paramsMap.put("province", cityBlacklistInfoDto.getProvince());
        paramsMap.put("city", StringUtil.matchFuzzyString(cityBlacklistInfoDto.getCity()));

        // 查询总数
        int totalCount = cityBlacklistInfoDao.selectCityBlacklistInfoCount(paramsMap);

        // 初始化分页信息
        BasePagination pagination = new BasePagination(totalCount);
        pagination.setCurrentPage(cityBlacklistInfoDto.getPage());
        pagination.setRowsPerPage(cityBlacklistInfoDto.getRows());
        pagination.initPage();

        paramsMap.put("start", pagination.getStart());
        paramsMap.put("rowsPerPage", pagination.getRowsPerPage());

        // 查询list
        List<CityBlacklistInfo> list = cityBlacklistInfoDao.selectCityBlacklistInfoList(paramsMap);

        // list装入返回类型
        List<Object> dataList = new ArrayList<Object>(list);

        String msg = "获取地市黑名单成功";
        logger.info("CityBlacklistInfoServiceImpl getCityBlacklistInfoList {}", msg);
        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), msg, dataList);
    }

    /**
     * 修改地市黑名单
     * 
     * @param cityBlacklistInfoDto
     * @return
     */
    @Override
    public String modifyCityBlacklistInfo(CityBlacklistInfoDto cityBlacklistInfoDto) {
        logger.info("CityBlacklistInfoServiceImpl modifyCityBlacklistInfo user is {}, {}",
                cityBlacklistInfoDto.getLoginName(), cityBlacklistInfoDto.toString());

        // 参数验证
        CheckUtil.idCheck(cityBlacklistInfoDto.getId());
        validateBlacklistInfo(cityBlacklistInfoDto);

        // 设置内容
        CityBlacklistInfo cityBlacklistInfo = new CityBlacklistInfo();
        setCityBlacklistInfo(cityBlacklistInfo, cityBlacklistInfoDto);

        cityBlacklistInfoDao.updateCityBlacklistInfo(cityBlacklistInfo);

        String msg = "修改地市黑名单成功";
        logger.info("CityBlacklistInfoServiceImpl modifyCityBlacklistInfo {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 删除地市黑名单
     * 
     * @param cityBlacklistInfoDto
     * @return
     */
    @Override
    public String removeCityBlacklistInfo(CityBlacklistInfoDto cityBlacklistInfoDto) {
        logger.info("CityBlacklistInfoServiceImpl removeCityBlacklistInfo user is {}, id is {}",
                cityBlacklistInfoDto.getLoginName(), cityBlacklistInfoDto.getId());

        // 参数验证
        CheckUtil.idCheck(cityBlacklistInfoDto.getId());

        long id = Long.parseLong(cityBlacklistInfoDto.getId());
        cityBlacklistInfoDao.deleteCityBlacklistInfo(id);

        String msg = "删除地市黑名单成功";
        logger.info("CityBlacklistInfoServiceImpl removeCityBlacklistInfo {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 修改地市黑名单激活状态
     * 
     * @param cityBlacklistInfoDto
     * @return
     */
    @Override
    public String modifyCityBlacklistInfoStatus(CityBlacklistInfoDto cityBlacklistInfoDto) {
        logger.info("CityBlacklistInfoServiceImpl modifyCityBlacklistInfoStatus user is {}, id is {}, status is {}",
                cityBlacklistInfoDto.getLoginName(), cityBlacklistInfoDto.getId(), cityBlacklistInfoDto.getStatus());

        // 参数验证
        CheckUtil.idCheck(cityBlacklistInfoDto.getId());
        CheckUtil.statusCheck(cityBlacklistInfoDto.getStatus());

        CityBlacklistInfo cityBlacklistInfo = new CityBlacklistInfo();
        cityBlacklistInfo.setId(Long.parseLong(cityBlacklistInfoDto.getId()));
        cityBlacklistInfo.setStatus(cityBlacklistInfoDto.getStatus());

        cityBlacklistInfoDao.updateCityBlacklistInfoStatus(cityBlacklistInfo);

        String msg = "修改地市黑名单激活状态成功";
        logger.info("CityBlacklistInfoServiceImpl modifyCityBlacklistInfoStatus {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 新增地市黑名单
     * 
     * @param cityBlacklistInfoDto
     * @return
     */
    @Override
    public String addCityBlacklistInfo(CityBlacklistInfoDto cityBlacklistInfoDto) {
        logger.info("CityBlacklistInfoServiceImpl addCityBlacklistInfo user is {}, {}",
                cityBlacklistInfoDto.getLoginName(), cityBlacklistInfoDto.toString());

        // 参数验证
        validateBlacklistInfo(cityBlacklistInfoDto);

        // 设置内容
        CityBlacklistInfo cityBlacklistInfo = new CityBlacklistInfo();
        setCityBlacklistInfo(cityBlacklistInfo, cityBlacklistInfoDto);

        cityBlacklistInfoDao.insertCityBlacklistInfo(cityBlacklistInfo);

        String msg = "新增地市黑名单成功";
        logger.info("CityBlacklistInfoServiceImpl addCityBlacklistInfo {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 设置地市黑名单内容
     *
     * @param cityBlacklistInfo
     * @param cityBlacklistInfoDto
     */
    private void setCityBlacklistInfo(CityBlacklistInfo cityBlacklistInfo, CityBlacklistInfoDto cityBlacklistInfoDto) {
        // Bean拷贝
        BeanDateCopyUtil.copyProperties(cityBlacklistInfo, cityBlacklistInfoDto);
    }

    /**
     * 校验地市黑名单参数
     *
     * @param cityBlacklistInfoDto
     */
    private void validateBlacklistInfo(CityBlacklistInfoDto cityBlacklistInfoDto) {
        Assert.isTrue(NumberUtils.isDigits(cityBlacklistInfoDto.getPassagewayId()), "通道ID必须是整数！");
        NoteInfo noteInfo = noteInfoDao.selectNoteInfoByPassagewayId(cityBlacklistInfoDto.getPassagewayId());
        Assert.isTrue(noteInfo != null, "通道ID不存在！");

        Assert.isTrue(NumberUtils.isDigits(cityBlacklistInfoDto.getProvince()), "省份必须是数字枚举！");
        String province = ProvinceEnum.getEnumNameByCode(Integer.parseInt(cityBlacklistInfoDto.getProvince()));
        Assert.isTrue(StringUtils.isNotBlank(province), "省份枚举类型不存在！");

        Assert.isTrue(StringUtils.isNotBlank(cityBlacklistInfoDto.getCity()), "城市不能为空！");
    }
}
