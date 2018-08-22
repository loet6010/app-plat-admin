package com.sooying.pay.app.api.service.note.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.sooying.pay.app.api.common.base.BasePagination;
import com.sooying.pay.app.api.common.constant.Constants;
import com.sooying.pay.app.api.common.enums.ApiStatusEnum;
import com.sooying.pay.app.api.common.enums.ProvinceEnum;
import com.sooying.pay.app.api.controller.note.dto.NoteInfoDto;
import com.sooying.pay.app.api.dao.platform.grade.PassagewayCoefInfoDao;
import com.sooying.pay.app.api.dao.platform.note.NoteInfoDao;
import com.sooying.pay.app.api.dao.platform.openapi.OpenApiPassagewayConfigInfoDao;
import com.sooying.pay.app.api.dao.platform.rule.RuleInfoDao;
import com.sooying.pay.app.api.model.platform.grade.PassagewayCoefInfo;
import com.sooying.pay.app.api.model.platform.note.NoteInfo;
import com.sooying.pay.app.api.model.platform.note.NoteMultipleConfInfo;
import com.sooying.pay.app.api.model.platform.note.NoteSecondConfInfo;
import com.sooying.pay.app.api.model.platform.note.NoteSuccessInfo;
import com.sooying.pay.app.api.service.note.NoteInfoService;
import com.sooying.pay.app.api.util.CheckUtil;
import com.sooying.pay.app.api.util.ResultReturnUtil;
import com.sooying.pay.app.api.util.StringUtil;

/**
 * 短信明细
 * 
 * @Description NoteInfoServiceImpl
 * @author liurh
 * @date 2018年6月5日
 */
@Service("noteInfoService")
public class NoteInfoServiceImpl implements NoteInfoService {
    private final static Logger logger = LoggerFactory.getLogger(NoteInfoServiceImpl.class);

    @Resource
    NoteInfoDao noteInfoDao;
    @Resource
    OpenApiPassagewayConfigInfoDao openApiPassagewayConfigInfoDao;
    @Resource
    PassagewayCoefInfoDao passagewayCoefInfoDao;
    @Resource
    RuleInfoDao ruleInfoDao;

    /**
     * 获取短信明细列表
     * 
     * @param noteInfoDto
     * @return
     */
    @Override
    public String getNoteInfoList(NoteInfoDto noteInfoDto) {
        logger.info("NoteInfoServiceImpl getNoteInfoList user is {}, page is {}, rows is {}, {}",
                noteInfoDto.getLoginName(), noteInfoDto.getPage(), noteInfoDto.getRows(), noteInfoDto.toString());

        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("passagewayId", noteInfoDto.getPassagewayId());
        paramsMap.put("passagewayName", StringUtil.matchFuzzyString(noteInfoDto.getPassagewayName()));

        // 查询总数
        int totalCount = noteInfoDao.selectNoteInfoCount(paramsMap);

        // 初始化分页信息
        BasePagination pagination = new BasePagination(totalCount,noteInfoDto.getPage(),noteInfoDto.getRows());

        paramsMap.put("start", pagination.getStart());
        paramsMap.put("rowsPerPage", pagination.getRowsPerPage());

        // 查询list
        List<NoteInfo> list = noteInfoDao.selectNoteInfoList(paramsMap);

        // list装入返回类型
        List<Object> dataList = new ArrayList<Object>(list);

        String msg = "获取短信明细成功";
        logger.info("NoteInfoServiceImpl getNoteInfoList {}", msg);
        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), msg, dataList);
    }

    /**
     * 修改短信明细激活状态
     * 
     * @param noteInfoDto
     * @return
     */
    @Override
    public String modifyNoteInfoStatus(NoteInfoDto noteInfoDto) {
        logger.info("NoteInfoServiceImpl modifyNoteInfoStatus user is {}, id is {}, status is {}",
                noteInfoDto.getLoginName(), noteInfoDto.getId(), noteInfoDto.getStatus());

        // 参数验证
        CheckUtil.idCheck(noteInfoDto.getId());
        CheckUtil.statusCheck(noteInfoDto.getStatus());

        String msg = "修改短信明细激活状态成功";

        // 激活校验
        if (Constants.STRING_ONE.equals(noteInfoDto.getStatus())) {
            msg = validateChangeStatus(noteInfoDto.getPassagewayId());
        }

        NoteInfo noteInfo = new NoteInfo();
        noteInfo.setId(Long.parseLong(noteInfoDto.getId()));
        noteInfo.setStatus(noteInfoDto.getStatus());

        noteInfoDao.updateNoteInfoStatus(noteInfo);

        logger.info("NoteInfoServiceImpl modifyNoteInfoStatus {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 修改短信明细SDK激活状态
     *
     * @param noteInfoDto
     * @return
     */
    @Override
    public String modifyNoteInfoSdkStatus(NoteInfoDto noteInfoDto) {
        logger.info("NoteInfoServiceImpl modifyNoteInfoSdkStatus user is {}, id is {}, sdkStatus is {}",
                noteInfoDto.getLoginName(), noteInfoDto.getId(), noteInfoDto.getSdkStatus());

        // 参数验证
        CheckUtil.idCheck(noteInfoDto.getId());
        CheckUtil.statusCheck(noteInfoDto.getSdkStatus());

        NoteInfo noteInfo = new NoteInfo();
        noteInfo.setId(Long.parseLong(noteInfoDto.getId()));
        noteInfo.setSdkStatus(noteInfoDto.getSdkStatus());

        noteInfoDao.updateNoteInfoSdkStatus(noteInfo);

        String msg = "修改短信明细SDK激活状态成功";
        logger.info("NoteInfoServiceImpl modifyNoteInfoSdkStatus {}", msg);
        return ResultReturnUtil.getSuccessString(msg);
    }

    /**
     * 根据ID获取短信明细
     * 
     * @param noteInfoDto
     * @return
     */
    @Override
    public NoteInfo getNoteInfoById(NoteInfoDto noteInfoDto) {
        logger.info("NoteInfoServiceImpl getNoteInfoById id is {}", noteInfoDto.getId());

        // 参数验证
        CheckUtil.idCheck(noteInfoDto.getId());

        return noteInfoDao.selectNoteInfoById(Long.parseLong(noteInfoDto.getId()));
    }

    /**
     * 获取成功后相关信息列表
     *
     * @param passagewayId
     * @return
     */
    @Override
    public List<NoteSuccessInfo> getSuccessDataGridList(String passagewayId) {
        List<NoteSuccessInfo> list = new ArrayList<NoteSuccessInfo>();
        if (Long.parseLong(passagewayId) <= 0) {
            return list;
        } else {
            try {
                list = noteInfoDao.selectSuccessDataGridList(passagewayId);
                for (NoteSuccessInfo dto : list) {
                    if (StringUtils.isNotBlank(dto.getProvince())) {
                        String prov = String.valueOf(ProvinceEnum.getByProvinceEnum(dto.getProvince()).getName());
                        dto.setProvince(prov);
                    }
                }
                return list;
            } catch (Exception e) {
                return list;
            }
        }
    }

    /**
     * 获取普通二次确认下行信息列表
     *
     * @param passagewayId
     * @return
     */
    @Override
    public List<NoteSecondConfInfo> getSecondConfDataGridList(String passagewayId) {
        List<NoteSecondConfInfo> list = new ArrayList<NoteSecondConfInfo>();
        if (Long.parseLong(passagewayId) <= 0) {
            return list;
        } else {
            try {
                list = noteInfoDao.selectSecondConfDataGridList(passagewayId);
                for (NoteSecondConfInfo dto : list) {
                    if (StringUtils.isNotBlank(dto.getProvince())) {
                        String prov = String.valueOf(ProvinceEnum.getByProvinceEnum(dto.getProvince()).getName());
                        dto.setProvince(prov);
                    }
                }
                return list;
            } catch (Exception e) {
                return list;
            }
        }
    }

    /**
     * 获取动态二次和多次确认下行信息列表
     *
     * @param passagewayId
     * @return
     */
    @Override
    public List<NoteMultipleConfInfo> getMultipleConfDataGridList(String passagewayId) {
        List<NoteMultipleConfInfo> list = new ArrayList<NoteMultipleConfInfo>();
        if (Long.parseLong(passagewayId) <= 0) {
            return list;
        } else {
            try {
                list = noteInfoDao.selectMultipleConfDataGridList(passagewayId);
                for (NoteMultipleConfInfo dto : list) {
                    if (StringUtils.isNotBlank(dto.getProvince())) {
                        String prov = String.valueOf(ProvinceEnum.getByProvinceEnum(dto.getProvince()).getName());
                        dto.setProvince(prov);
                    }
                }
                return list;
            } catch (Exception e) {
                return list;
            }
        }
    }

    // 激活校验
    private String validateChangeStatus(String passagewayId) {
        String msg = "修改短信明细激活状态成功";

        // 激活信息校验:成功后相关信息、普通二次确认下行信息、动态二次和多次确认下行信息，都没有填写时，无法激活
        List<NoteSuccessInfo> successInfoList = getSuccessDataGridList(passagewayId);
        List<NoteSecondConfInfo> secondConfInfoList = getSecondConfDataGridList(passagewayId);
        List<NoteMultipleConfInfo> multipleConfInfoList = getMultipleConfDataGridList(passagewayId);
        Assert.isTrue(successInfoList.size() > 0 || secondConfInfoList.size() > 0 || multipleConfInfoList.size() > 0,
                "成功后相关信息、普通二次确认下行信息、动态二次和多次确认下行信息，三项必须填写一项！");

        // 外放表或积分扣量规则有任一配置时，不需要配通道系数即可激活
        int openCount = openApiPassagewayConfigInfoDao.selectOpenApiPassagewayConfigInfoCount(passagewayId);
        int integralCount = openApiPassagewayConfigInfoDao
                .selectIntegralPassagewayConfigCount(StringUtil.matchFuzzyString(passagewayId));
        if (openCount <= 0 && integralCount <= 0) {
            PassagewayCoefInfo passagewayCoefInfo = passagewayCoefInfoDao
                    .selectPassagewayCoefInfoByPassagewayId(passagewayId);
            Assert.isTrue(passagewayCoefInfo != null, "非外放代码或未配积分扣量规则，必须要有通道系数配置！");

            // 通道过滤规则配置非必须配置，只做提醒
            Map<String, Object> paramsMap = new HashMap<String, Object>();
            paramsMap.put("passagewayId", passagewayId);
            int ruleCount = ruleInfoDao.selectRuleInfoCount(paramsMap);
            if (ruleCount <= 0) {
                msg = "激活成功，但通道过滤规则没有配置，请注意配置！";
            }
        }

        return msg;
    }

}
