package com.sooying.pay.app.api.service.popup.impl;

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
import com.sooying.pay.app.api.constant.Constants;
import com.sooying.pay.app.api.constant.ProvinceEnum;
import com.sooying.pay.app.api.controller.popup.dto.PopUpInfoDto;
import com.sooying.pay.app.api.dao.platform.popup.PopUpInfoDao;
import com.sooying.pay.app.api.model.platform.popup.PopUpInfo;
import com.sooying.pay.app.api.service.popup.PopUpInfoService;
import com.sooying.pay.app.api.util.BeanDateCopyUtil;
import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 二次确认弹窗
 * 
 * @Description PopUpInfoServiceImpl
 * @author liurh
 * @date 2018年6月13日
 */
@Service("popUpInfoService")
public class PopUpInfoServiceImpl implements PopUpInfoService {
    private static Logger logger = LoggerFactory.getLogger(PopUpInfoServiceImpl.class);

    @Resource
    PopUpInfoDao popUpInfoDao;

    /**
     * 获取二次确认弹窗列表
     * 
     * @param popUpInfoDto
     * @return
     */
    @Override
    public String getPopUpInfoList(PopUpInfoDto popUpInfoDto) {
        logger.info("PopUpInfoServiceImpl getPopUpInfoList user is {}, passagewayId is {}", popUpInfoDto.getLoginName(),
                popUpInfoDto.getPassagewayId());

        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("passagewayId", popUpInfoDto.getPassagewayId());
        paramsMap.put("netType", popUpInfoDto.getNetType());
        paramsMap.put("channelNo", popUpInfoDto.getChannelNo());
        paramsMap.put("province", popUpInfoDto.getProvince());

        // 查询总数
        int totalCount = popUpInfoDao.selectPopUpInfoCount(paramsMap);

        // 初始化分页信息
        BasePagination pagination = new BasePagination(totalCount);
        pagination.setCurrentPage(popUpInfoDto.getPage());
        pagination.setRowsPerPage(popUpInfoDto.getRows());
        pagination.initPage();

        paramsMap.put("start", pagination.getStart());
        paramsMap.put("rowsPerPage", pagination.getRowsPerPage());

        // 查询list
        List<PopUpInfo> list = popUpInfoDao.selectPopUpInfoList(paramsMap);

        // list装入返回类型
        List<Object> dataList = new ArrayList<Object>();
        dataList.addAll(list);

        String msg = "获取二次确认弹窗成功";
        logger.info("PopUpInfoServiceImpl getPopUpInfoList {}", msg);
        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), msg, dataList);
    }

    /**
     * 修改二次确认弹窗
     * 
     * @param popUpInfoDto
     * @return
     */
    @Override
    public String modifyPopUpInfo(PopUpInfoDto popUpInfoDto) {
        logger.info("PopUpInfoServiceImpl modifyPopUpInfo user is {}, id is {}, priority is {}",
                popUpInfoDto.getLoginName(), popUpInfoDto.getId(), popUpInfoDto.getPriority());

        // 参数验证
        Assert.isTrue(NumberUtils.isNumber(popUpInfoDto.getId()) && Long.parseLong(popUpInfoDto.getId()) > 0,
                "id必须是数字且大于0！");
        Assert.isTrue(StringUtils.isNotBlank(popUpInfoDto.getPriority()), "优先级不能为空！");

        // Bean拷贝
        PopUpInfo popUpInfo = new PopUpInfo();
        BeanDateCopyUtil.copyProperties(popUpInfo, popUpInfoDto);

        // 设置规则格式
        String popUpRule = getPopUpRule(popUpInfoDto);
        popUpInfo.setPopUpRule(popUpRule);

        // 设置通道ID存在状态
        if (StringUtils.isNotBlank(popUpInfoDto.getPassagewayId())) {
            popUpInfo.setPluginStatus(Constants.STATUS_VALID);
        } else {
            popUpInfo.setPluginStatus(Constants.STATUS_INVALID);
        }

        popUpInfoDao.updatePopUpInfo(popUpInfo);

        String msg = "修改二次确认弹窗成功";
        logger.info("PopUpInfoServiceImpl modifyPopUpInfo {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 删除二次确认弹窗
     * 
     * @param popUpInfoDto
     * @return
     */
    @Override
    public String removePopUpInfo(PopUpInfoDto popUpInfoDto) {
        logger.info("PopUpInfoServiceImpl removePopUpInfo user is {}, id is {}", popUpInfoDto.getLoginName(),
                popUpInfoDto.getId());

        // 参数验证
        Assert.isTrue(NumberUtils.isNumber(popUpInfoDto.getId()) && Long.parseLong(popUpInfoDto.getId()) > 0,
                "id必须是数字且大于0！");

        long id = Long.parseLong(popUpInfoDto.getId());
        popUpInfoDao.deletePopUpInfo(id);

        String msg = "删除二次确认弹窗成功";
        logger.info("PopUpInfoServiceImpl removePopUpInfo {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 修改二次确认弹窗激活状态
     * 
     * @param popUpInfoDto
     * @return
     */
    @Override
    public String modifyPopUpInfoStatus(PopUpInfoDto popUpInfoDto) {
        logger.info("PopUpInfoServiceImpl modifyPopUpInfoStatus user is {}, id is {}, status is {}",
                popUpInfoDto.getLoginName(), popUpInfoDto.getId(), popUpInfoDto.getStatus());

        // 参数验证
        Assert.isTrue(NumberUtils.isNumber(popUpInfoDto.getId()) && Long.parseLong(popUpInfoDto.getId()) > 0,
                "id必须是数字且大于0！");
        Assert.isTrue(Constants.STATUS_VALID.equals(popUpInfoDto.getStatus())
                || Constants.STATUS_INVALID.equals(popUpInfoDto.getStatus()), "激活状态必须是0或1！");

        PopUpInfo popUpInfo = new PopUpInfo();
        popUpInfo.setId(Long.parseLong(popUpInfoDto.getId()));
        popUpInfo.setStatus(popUpInfoDto.getStatus());

        popUpInfoDao.updatePopUpInfoStatus(popUpInfo);

        String msg = "修改二次确认弹窗激活状态成功";
        logger.info("PopUpInfoServiceImpl modifyPopUpInfoStatus {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 新增二次确认弹窗
     * 
     * @param popUpInfoDto
     * @return
     */
    @Override
    public String addPopUpInfo(PopUpInfoDto popUpInfoDto) {
        logger.info("PopUpInfoServiceImpl addPopUpInfo user is {}, priority is {}", popUpInfoDto.getLoginName(),
                popUpInfoDto.getPriority());

        // 参数验证
        Assert.isTrue(StringUtils.isNotBlank(popUpInfoDto.getPriority()), "优先级不能为空！");

        // Bean拷贝
        PopUpInfo popUpInfo = new PopUpInfo();
        BeanDateCopyUtil.copyProperties(popUpInfo, popUpInfoDto);

        // 设置规则格式
        String popUpRule = getPopUpRule(popUpInfoDto);
        popUpInfo.setPopUpRule(popUpRule);

        // 设置通道ID存在状态
        if (StringUtils.isNotBlank(popUpInfoDto.getPassagewayId())) {
            popUpInfo.setPluginStatus(Constants.STATUS_VALID);
        } else {
            popUpInfo.setPluginStatus(Constants.STATUS_INVALID);
        }

        popUpInfoDao.insertPopUpInfo(popUpInfo);

        String msg = "新增二次确认弹窗成功";
        logger.info("PopUpInfoServiceImpl addPopUpInfo {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 获取设置规则格式
     *
     * @param popUpInfoDto
     * @return
     */
    private String getPopUpRule(PopUpInfoDto popUpInfoDto) {
        StringBuilder ruleBuilder = new StringBuilder();

        if (StringUtils.isNotBlank(popUpInfoDto.getPassagewayId())) {
            ruleBuilder.append("#popup.pluginId == '").append(popUpInfoDto.getPassagewayId()).append("'");
        }

        if (StringUtils.isNotBlank(popUpInfoDto.getChannelNo())) {
            setRuleBuilder(ruleBuilder);
            ruleBuilder.append("#popup.channelNo=='").append(popUpInfoDto.getChannelNo()).append("'");
        }

        if (StringUtils.isNotBlank(popUpInfoDto.getNetType())) {
            setRuleBuilder(ruleBuilder);
            ruleBuilder.append("#popup.netType=='").append(popUpInfoDto.getNetType()).append("'");
        }

        if (StringUtils.isNotBlank(popUpInfoDto.getAppId())) {
            setRuleBuilder(ruleBuilder);
            ruleBuilder.append("#popup.appId=='").append(popUpInfoDto.getAppId()).append("'");
        }

        if (StringUtils.isNotBlank(popUpInfoDto.getProvince())) {
            if (ruleBuilder.length() > 0) {
                ruleBuilder.append(" && (").append(getProvinceString(popUpInfoDto.getProvince())).append(")");
            } else {
                ruleBuilder.append(getProvinceString(popUpInfoDto.getProvince()));
            }
        }

        return ruleBuilder.toString();
    }

    /**
     * 设置间隔符号
     *
     * @param ruleBuilder
     */
    private void setRuleBuilder(StringBuilder ruleBuilder) {
        if (ruleBuilder.length() > 0) {
            ruleBuilder.append(" && ");
        }
    }

    /**
     * 获取省份拼接字符串
     *
     * @param value
     * @return
     */
    private String getProvinceString(String value) {
        StringBuilder sBuilder = new StringBuilder();

        List<String> provinceList = ProvinceEnum.getProvinceList(value);
        for (String province : provinceList) {
            sBuilder.append("#popup.province=='").append(province).append("' || ");
        }

        return StringUtils.removeEnd(sBuilder.toString(), " || ");
    }

}
