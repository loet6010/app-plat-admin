package com.sooying.pay.app.api.service.rule.impl;

import java.lang.reflect.InvocationTargetException;
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
import com.sooying.pay.app.api.controller.rule.dto.RuleInfoDto;
import com.sooying.pay.app.api.dao.platform.rule.RuleInfoDao;
import com.sooying.pay.app.api.model.platform.rule.RuleInfo;
import com.sooying.pay.app.api.service.rule.RuleInfoService;
import com.sooying.pay.app.api.service.rule.enums.CodeTypeEnum;
import com.sooying.pay.app.api.service.rule.enums.RuleTypeEnum;
import com.sooying.pay.app.api.util.BeanDateCopyUtil;
import com.sooying.pay.app.api.util.CheckUtil;
import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 通道过滤规则
 * 
 * @Description RuleInfoServiceImpl
 * @author liurh
 * @date 2018年6月11日
 */
@Service("ruleInfoService")
public class RuleInfoServiceImpl implements RuleInfoService {
    private final static Logger logger = LoggerFactory.getLogger(RuleInfoServiceImpl.class);

    @Resource
    RuleInfoDao ruleInfoDao;

    /**
     * 获取通道过滤规则列表
     * 
     * @param ruleInfoDto
     * @return
     */
    @Override
    public String getRuleInfoList(RuleInfoDto ruleInfoDto) {
        logger.info("RuleInfoServiceImpl getRuleInfoList user is {}, page is {}, rows is {}, passagewayId is {}",
                ruleInfoDto.getLoginName(), ruleInfoDto.getPage(), ruleInfoDto.getRows(),
                ruleInfoDto.getPassagewayId());

        // 参数验证
        Assert.isTrue(StringUtils.isNotBlank(ruleInfoDto.getPassagewayId()), "通道ID不能为空！");

        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("passagewayId", ruleInfoDto.getPassagewayId());

        // 查询总数
        int totalCount = ruleInfoDao.selectRuleInfoCount(paramsMap);

        // 初始化分页信息
        BasePagination pagination = new BasePagination(totalCount);
        pagination.setCurrentPage(ruleInfoDto.getPage());
        pagination.setRowsPerPage(ruleInfoDto.getRows());
        pagination.initPage();

        paramsMap.put("start", pagination.getStart());
        paramsMap.put("rowsPerPage", pagination.getRowsPerPage());

        // 查询list
        List<RuleInfo> list = ruleInfoDao.selectRuleInfoList(paramsMap);

        // list装入返回类型
        List<Object> dataList = new ArrayList<Object>();
        dataList.addAll(list);

        String msg = "获取通道过滤规则成功";
        logger.info("RuleInfoServiceImpl getRuleInfoList {}", msg);
        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), msg, dataList);
    }

    /**
     * 修改通道过滤规则
     * 
     * @param ruleInfoDto
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public String modifyRuleInfo(RuleInfoDto ruleInfoDto) {
        logger.info("RuleInfoServiceImpl modifyRuleInfo user is {}, id is {}, ruleValue is {}, startTime is {}",
                ruleInfoDto.getLoginName(), ruleInfoDto.getId(), ruleInfoDto.getRuleValue(),
                ruleInfoDto.getStartTime());

        // 参数验证
        CheckUtil.idCheck(ruleInfoDto.getId());
        Assert.isTrue(StringUtils.isNotBlank(ruleInfoDto.getStartTime()), "生效时间不能为空！");

        // 对象拷贝
        RuleInfo ruleInfo = new RuleInfo();
        BeanDateCopyUtil.copyProperties(ruleInfo, ruleInfoDto);

        ruleInfoDao.updateRuleInfo(ruleInfo);

        String msg = "修改通道过滤规则成功";
        logger.info("RuleInfoServiceImpl modifyRuleInfo {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 删除通道过滤规则
     * 
     * @param ruleInfoDto
     * @return
     */
    @Override
    public String removeRuleInfo(RuleInfoDto ruleInfoDto) {
        logger.info("RuleInfoServiceImpl removeRuleInfo user is {}, id is {}", ruleInfoDto.getLoginName(),
                ruleInfoDto.getId());

        // 参数验证
        Assert.isTrue(NumberUtils.isNumber(ruleInfoDto.getId()) && Long.parseLong(ruleInfoDto.getId()) > 0,
                "id必须是数字且大于0！");

        long id = Long.parseLong(ruleInfoDto.getId());
        ruleInfoDao.deleteRuleInfo(id);

        String msg = "删除通道过滤规则成功";
        logger.info("RuleInfoServiceImpl removeRuleInfo {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 修改通道过滤规则激活状态
     * 
     * @param ruleInfoDto
     * @return
     */
    @Override
    public String modifyRuleInfoStatus(RuleInfoDto ruleInfoDto) {
        logger.info("RuleInfoServiceImpl modifyRuleInfoStatus user is {}, id is {}, status is {}",
                ruleInfoDto.getLoginName(), ruleInfoDto.getId(), ruleInfoDto.getStatus());

        // 参数验证
        CheckUtil.idCheck(ruleInfoDto.getId());
        CheckUtil.statusCheck(ruleInfoDto.getStatus());

        RuleInfo ruleInfo = new RuleInfo();
        ruleInfo.setId(Long.parseLong(ruleInfoDto.getId()));
        ruleInfo.setStatus(ruleInfoDto.getStatus());

        ruleInfoDao.updateRuleInfoStatus(ruleInfo);

        String msg = "修改通道过滤规则激活状态成功";
        logger.info("RuleInfoServiceImpl modifyRuleInfoStatus {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 新增通道过滤规则
     * 
     * @param ruleInfoDto
     * @return
     */
    @Override
    public String addRuleInfo(RuleInfoDto ruleInfoDto) {
        logger.info("RuleInfoServiceImpl addRuleInfo user is {}, {}", ruleInfoDto.getLoginName(),
                ruleInfoDto.toString());

        // 参数验证
        Assert.isTrue(NumberUtils.isNumber(ruleInfoDto.getPassagewayId())
                && StringUtils.isNotBlank(ruleInfoDto.getPassagewayId()), "通道ID不能为空且必须是数字！");
        Assert.isTrue(StringUtils.isNotBlank(ruleInfoDto.getStartTime()), "生效时间不能为空！");

        // 获取代码类型
        String type = null;
        if ("0".equals(ruleInfoDto.getType())) {
            Integer code = ruleInfoDao.selectPluginType(Integer.parseInt(ruleInfoDto.getPassagewayId()));
            type = CodeTypeEnum.getType(code);
        } else if ("1".equals(ruleInfoDto.getType())) {
            int feeGroupCount = ruleInfoDao.selectFeeGroupCount(ruleInfoDto.getPassagewayId());
            if (feeGroupCount > 0) {
                type = "FEE_GROUP";
            }
        }
        Assert.isTrue(type != null, "通道ID不存在！");

        // 对象拷贝
        RuleInfo ruleInfo = new RuleInfo();
        BeanDateCopyUtil.copyProperties(ruleInfo, ruleInfoDto);
        ruleInfo.setCodeType(type);

        // 验证过滤规则是否已存在
        validateAddRuleInfo(ruleInfoDto, ruleInfo);

        // 日限量
        if (StringUtils.isNotBlank(ruleInfoDto.getDayLimited())) {
            ruleInfo.setRuleType(RuleTypeEnum.DAY_LIMITED.getType());
            ruleInfo.setRuleValue(ruleInfoDto.getDayLimited());

            ruleInfoDao.insertRuleInfo(ruleInfo);
        }

        // 月限量
        if (StringUtils.isNotBlank(ruleInfoDto.getMonthLimited())) {
            ruleInfo.setRuleType(RuleTypeEnum.MONTH_LIMITED.getType());
            ruleInfo.setRuleValue(ruleInfoDto.getMonthLimited());

            ruleInfoDao.insertRuleInfo(ruleInfo);
        }

        // 屏蔽时间
        if (StringUtils.isNotBlank(ruleInfoDto.getShieldDate())) {
            ruleInfo.setRuleType(RuleTypeEnum.SHIELD_DATE.getType());
            ruleInfo.setRuleValue(ruleInfoDto.getShieldDate());

            ruleInfoDao.insertRuleInfo(ruleInfo);
        }

        // 开放地区
        if (StringUtils.isNotBlank(ruleInfoDto.getShieldArea())) {
            ruleInfo.setRuleType(RuleTypeEnum.SHIELD_AREA.getType());
            ruleInfo.setRuleValue(ruleInfoDto.getShieldArea());

            ruleInfoDao.insertRuleInfo(ruleInfo);
        }

        // 省份日限量
        if (StringUtils.isNotBlank(ruleInfoDto.getProvinceDayLimited())) {
            ruleInfo.setRuleType(RuleTypeEnum.PROVINCE_DAY_LIMITED.getType());
            ruleInfo.setRuleValue(ruleInfoDto.getProvinceDayLimited());

            ruleInfoDao.insertRuleInfo(ruleInfo);
        }

        // 省份月限量
        if (StringUtils.isNotBlank(ruleInfoDto.getProvinceMonthLimited())) {
            ruleInfo.setRuleType(RuleTypeEnum.PROVINCE_MONTH_LIMITED.getType());
            ruleInfo.setRuleValue(ruleInfoDto.getProvinceMonthLimited());

            ruleInfoDao.insertRuleInfo(ruleInfo);
        }

        String msg = "新增通道过滤规则成功";
        logger.info("RuleInfoServiceImpl addRuleInfo {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 验证过滤规则是否已存在
     *
     * @param ruleInfoDto
     * @param ruleInfo
     */
    private void validateAddRuleInfo(RuleInfoDto ruleInfoDto, RuleInfo ruleInfo) {
        // 日限量
        if (StringUtils.isNotBlank(ruleInfoDto.getDayLimited())) {
            ruleInfo.setRuleType(RuleTypeEnum.DAY_LIMITED.getType());

            int existCount = ruleInfoDao.selectRuleValueExistCount(ruleInfo);
            Assert.isTrue(existCount <= 0, "该通道已存在,大于规则生效时间的日限量！");
        }

        // 月限量
        if (StringUtils.isNotBlank(ruleInfoDto.getMonthLimited())) {
            ruleInfo.setRuleType(RuleTypeEnum.MONTH_LIMITED.getType());

            int existCount = ruleInfoDao.selectRuleValueExistCount(ruleInfo);
            Assert.isTrue(existCount <= 0, "该通道已存在,大于规则生效时间的月限量！");
        }

        // 屏蔽时间
        if (StringUtils.isNotBlank(ruleInfoDto.getShieldDate())) {
            ruleInfo.setRuleType(RuleTypeEnum.SHIELD_DATE.getType());

            int existCount = ruleInfoDao.selectRuleValueExistCount(ruleInfo);
            Assert.isTrue(existCount <= 0, "该通道已存在,大于规则生效时间的屏蔽时间！");
        }

        // 开放地区
        if (StringUtils.isNotBlank(ruleInfoDto.getShieldArea())) {
            ruleInfo.setRuleType(RuleTypeEnum.SHIELD_AREA.getType());

            int existCount = ruleInfoDao.selectRuleValueExistCount(ruleInfo);
            Assert.isTrue(existCount <= 0, "该通道已存在,大于规则生效时间的开放地区！");
        }

        // 省份日限量
        if (StringUtils.isNotBlank(ruleInfoDto.getProvinceDayLimited())) {
            ruleInfo.setRuleType(RuleTypeEnum.PROVINCE_DAY_LIMITED.getType());

            int existCount = ruleInfoDao.selectRuleValueExistCount(ruleInfo);
            Assert.isTrue(existCount <= 0, "该通道已存在,大于规则生效时间的省份日限量！");
        }

        // 省份月限量
        if (StringUtils.isNotBlank(ruleInfoDto.getProvinceMonthLimited())) {
            ruleInfo.setRuleType(RuleTypeEnum.PROVINCE_MONTH_LIMITED.getType());

            int existCount = ruleInfoDao.selectRuleValueExistCount(ruleInfo);
            Assert.isTrue(existCount <= 0, "该通道已存在,大于规则生效时间的省份月限量！");
        }
    }

    /**
     * 根据ID获取通道过滤规则
     * 
     * @param ruleInfoDto
     * @return
     */
    @Override
    public RuleInfo getRuleInfoById(RuleInfoDto ruleInfoDto) {
        logger.info("RuleInfoServiceImpl getRuleInfoById id is {}", ruleInfoDto.getId());

        // 参数验证
        CheckUtil.idCheck(ruleInfoDto.getId());

        return ruleInfoDao.selectRuleInfoById(Long.parseLong(ruleInfoDto.getId()));
    }

}
