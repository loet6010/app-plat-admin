package com.sooying.pay.app.api.service.grade.impl;

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
import com.sooying.pay.app.api.common.constant.Constants;
import com.sooying.pay.app.api.common.enums.ApiStatusEnum;
import com.sooying.pay.app.api.controller.grade.dto.PassagewayCoefInfoDto;
import com.sooying.pay.app.api.dao.platform.grade.PassagewayCoefInfoDao;
import com.sooying.pay.app.api.dao.platform.note.NoteInfoDao;
import com.sooying.pay.app.api.model.platform.grade.PassagewayCoefInfo;
import com.sooying.pay.app.api.model.platform.note.NoteInfo;
import com.sooying.pay.app.api.service.grade.PassagewayCoefInfoService;
import com.sooying.pay.app.api.util.BeanDateCopyUtil;
import com.sooying.pay.app.api.util.CheckUtil;
import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 通道系数配置
 *
 * @author liurh
 * @Description PassagewayCoefInfoServiceImpl
 * @date 2018年6月15日
 */
@Service("passagewayCoefInfoService")
public class PassagewayCoefInfoServiceImpl implements PassagewayCoefInfoService {
    private final static Logger logger = LoggerFactory.getLogger(PassagewayCoefInfoServiceImpl.class);

    @Resource
    PassagewayCoefInfoDao passagewayCoefInfoDao;
    @Resource
    NoteInfoDao noteInfoDao;

    /**
     * 获取通道系数配置列表
     *
     * @param passagewayCoefInfoDto
     * @return
     */
    @Override
    public String getPassagewayCoefInfoList(PassagewayCoefInfoDto passagewayCoefInfoDto) {
        logger.info("PassagewayCoefInfoServiceImpl getPassagewayCoefInfoList user is {}, page is {}, rows is {}, {}",
                passagewayCoefInfoDto.getLoginName(), passagewayCoefInfoDto.getPage(), passagewayCoefInfoDto.getRows(),
                passagewayCoefInfoDto.toString());

        // 查询条件
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("passagewayId", passagewayCoefInfoDto.getPassagewayId());
        paramsMap.put("netOperator", passagewayCoefInfoDto.getNetOperator());
        paramsMap.put("changeStatus", passagewayCoefInfoDto.getChangeStatus());

        // 查询总数
        int totalCount = passagewayCoefInfoDao.selectPassagewayCoefInfoCount(paramsMap);

        // 初始化分页信息
        BasePagination pagination = new BasePagination(totalCount, passagewayCoefInfoDto.getPage(),
                passagewayCoefInfoDto.getRows());

        paramsMap.put("start", pagination.getStart());
        paramsMap.put("rowsPerPage", pagination.getRowsPerPage());

        // 查询list
        List<PassagewayCoefInfo> list = passagewayCoefInfoDao.selectPassagewayCoefInfoList(paramsMap);

        // list装入返回类型
        List<Object> dataList = new ArrayList<Object>(list);

        String msg = "获取通道系数配置成功";
        logger.info("PassagewayCoefInfoServiceImpl getPassagewayCoefInfoList {}", msg);
        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), msg, dataList);
    }

    /**
     * 修改通道系数配置
     *
     * @param passagewayCoefInfoDto
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public String modifyPassagewayCoefInfo(PassagewayCoefInfoDto passagewayCoefInfoDto) {
        logger.info("PassagewayCoefInfoServiceImpl modifyPassagewayCoefInfo user is {}, {}",
                passagewayCoefInfoDto.getLoginName(), passagewayCoefInfoDto.toString());

        // 参数验证
        CheckUtil.idCheck(passagewayCoefInfoDto.getId());
        validatePassagewayCoefInfo(passagewayCoefInfoDto);

        // 对象拷贝
        PassagewayCoefInfo passagewayCoefInfo = new PassagewayCoefInfo();
        BeanDateCopyUtil.copyProperties(passagewayCoefInfo, passagewayCoefInfoDto);

        passagewayCoefInfoDao.updatePassagewayCoefInfo(passagewayCoefInfo);

        String msg = "修改通道系数配置成功";
        logger.info("PassagewayCoefInfoServiceImpl modifyPassagewayCoefInfo {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 删除通道系数配置
     *
     * @param passagewayCoefInfoDto
     * @return
     */
    @Override
    public String removePassagewayCoefInfo(PassagewayCoefInfoDto passagewayCoefInfoDto) {
        logger.info("PassagewayCoefInfoServiceImpl removePassagewayCoefInfo user is {}, id is {}",
                passagewayCoefInfoDto.getLoginName(), passagewayCoefInfoDto.getId());

        // 参数验证
        CheckUtil.idCheck(passagewayCoefInfoDto.getId());

        long id = Long.parseLong(passagewayCoefInfoDto.getId());
        passagewayCoefInfoDao.deletePassagewayCoefInfo(id);

        String msg = "删除通道系数配置成功";
        logger.info("PassagewayCoefInfoServiceImpl removePassagewayCoefInfo {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 新增通道系数配置
     *
     * @param passagewayCoefInfoDto
     * @return
     */
    @Override
    public String addPassagewayCoefInfo(PassagewayCoefInfoDto passagewayCoefInfoDto) {
        logger.info("PassagewayCoefInfoServiceImpl addPassagewayCoefInfo user is {}, {}",
                passagewayCoefInfoDto.getLoginName(), passagewayCoefInfoDto.toString());

        // 参数验证
        validatePassagewayCoefInfo(passagewayCoefInfoDto);
        Assert.isTrue(NumberUtils.isDigits(passagewayCoefInfoDto.getPassagewayId()), "通道ID必须是整数！");

        String netOperator = passagewayCoefInfoDao.selectNetOperatorByPassagewayId(
                Integer.parseInt(passagewayCoefInfoDto.getPassagewayId()));
        Assert.isTrue(netOperator != null, "通道ID不存在！");

        int existCount = passagewayCoefInfoDao.selectExistPassagewayIdCount(passagewayCoefInfoDto.getPassagewayId());
        Assert.isTrue(existCount <= 0, "已存在该通道的系数信息！");

        // 对象拷贝
        PassagewayCoefInfo passagewayCoefInfo = new PassagewayCoefInfo();
        BeanDateCopyUtil.copyProperties(passagewayCoefInfo, passagewayCoefInfoDto);
        passagewayCoefInfo.setNetOperator(netOperator);

        passagewayCoefInfoDao.insertPassagewayCoefInfo(passagewayCoefInfo);

        String msg = "新增通道系数配置成功";
        logger.info("PassagewayCoefInfoServiceImpl addPassagewayCoefInfo {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 参数验证
     *
     * @param passagewayCoefInfoDto
     */
    private void validatePassagewayCoefInfo(PassagewayCoefInfoDto passagewayCoefInfoDto) {
        Assert.isTrue(NumberUtils.isNumber(passagewayCoefInfoDto.getSuccessRate()), "成功率必须是数字！");
        Assert.isTrue(NumberUtils.isNumber(passagewayCoefInfoDto.getSynchroRate()), "同步率必须是数字！");
        Assert.isTrue(NumberUtils.isNumber(passagewayCoefInfoDto.getCountRate()), "结算率必须是数字！");
        Assert.isTrue(StringUtils.isNotBlank(passagewayCoefInfoDto.getPrice()), "资费不能为空！");
        Assert.isTrue(NumberUtils.isDigits(passagewayCoefInfoDto.getPrice()), "资费必须为整数！");
        Assert.isTrue(Constants.STRING_ONE.equals(passagewayCoefInfoDto.getChangeStatus()) ||
                Constants.STRING_ZERO.equals(passagewayCoefInfoDto.getChangeStatus()), "固定标志必须是0或1！");
    }

    /**
     * 根据ID获取通道系数配置
     *
     * @param passagewayCoefInfoDto
     * @return
     */
    @Override
    public PassagewayCoefInfo getPassagewayCoefInfoById(PassagewayCoefInfoDto passagewayCoefInfoDto) {
        logger.info("PassagewayCoefInfoServiceImpl getPassagewayCoefInfo id is {}", passagewayCoefInfoDto.getId());

        // 参数验证
        CheckUtil.idCheck(passagewayCoefInfoDto.getId());

        return passagewayCoefInfoDao.selectPassagewayCoefInfoById(Long.parseLong(passagewayCoefInfoDto.getId()));
    }

    /**
     * 获取代码资费
     *
     * @param passagewayCoefInfoDto
     * @return
     */
    @Override
    public String getPassagewayIdPrice(PassagewayCoefInfoDto passagewayCoefInfoDto) {
        logger.info("PassagewayCoefInfoServiceImpl getPassagewayIdPrice user is {}, passagewayId is {}",
                passagewayCoefInfoDto.getLoginName(), passagewayCoefInfoDto.getPassagewayId());

        // 查询短信明细
        NoteInfo noteInfo = noteInfoDao.selectNoteInfoByPassagewayId(passagewayCoefInfoDto.getPassagewayId());
        Assert.isTrue(noteInfo != null, "当前通道ID不存在短信明细！通道：" + passagewayCoefInfoDto.getPassagewayId());

        List<Object> dataList = new ArrayList<Object>();
        dataList.add(noteInfo);

        String msg = "获取代码资费成功";
        logger.info("PassagewayCoefInfoServiceImpl getPassagewayIdPrice {}", msg);
        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), msg, dataList);
    }
}