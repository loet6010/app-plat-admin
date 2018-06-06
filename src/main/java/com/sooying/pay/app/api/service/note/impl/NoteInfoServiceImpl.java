package com.sooying.pay.app.api.service.note.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bench.common.lang.NumberUtils;
import com.sooying.pay.app.api.base.Pagination;
import com.sooying.pay.app.api.constant.ApiStatusEnum;
import com.sooying.pay.app.api.constant.Constants;
import com.sooying.pay.app.api.controller.note.dto.NoteInfoDto;
import com.sooying.pay.app.api.dao.platform.note.NoteInfoDao;
import com.sooying.pay.app.api.model.platform.note.NoteInfo;
import com.sooying.pay.app.api.service.note.NoteInfoService;
import com.sooying.pay.app.api.util.ResultReturnUtil;

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

    /**
     * 获取短信明细列表
     * 
     * @param noteInfoDto
     * @return
     */
    @Override
    public String getNoteInfoList(NoteInfoDto noteInfoDto) {
        logger.info("NoteInfoServiceImpl getNoteInfoList passagewayId is {}", noteInfoDto.getPassagewayId());

        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("passagewayId", noteInfoDto.getPassagewayId());

        // 查询总数
        int totalCount = noteInfoDao.selectNoteInfoCount(paramsMap);

        // 初始化分页信息
        Pagination pagination = new Pagination(totalCount);
        pagination.setCurrentPage(noteInfoDto.getPage());
        pagination.setRowsPerPage(noteInfoDto.getRows());
        pagination.initPage();

        paramsMap.put("start", pagination.getStart());
        paramsMap.put("rowsPerPage", pagination.getRowsPerPage());

        List<NoteInfo> list = noteInfoDao.selectNoteInfoList(paramsMap);

        List<Object> dataList = new ArrayList<Object>();
        dataList.addAll(list);

        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), "获取短信明细成功", dataList);
    }

    /**
     * 修改短信明细激活状态
     * 
     * @param noteInfoDto
     * @return
     */
    @Override
    public String modifyNoteInfoStatus(NoteInfoDto noteInfoDto) {
        logger.info("NoteInfoServiceImpl modifyNoteInfoStatus id is {},status is {}", noteInfoDto.getId(),
                noteInfoDto.getStatus());

        // 参数验证
        if (!NumberUtils.isNumber(noteInfoDto.getId()) || Long.parseLong(noteInfoDto.getId()) <= 0) {
            return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_FAIL.getStatus(), "id必须是数字且大于0！");
        }
        if (!(Constants.STATUS_VALID.equals(noteInfoDto.getStatus())
                || Constants.STATUS_INVALID.equals(noteInfoDto.getStatus()))) {
            return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_FAIL.getStatus(), "激活状态必须是0或1！");
        }

        NoteInfo noteInfo = new NoteInfo();
        noteInfo.setId(Long.parseLong(noteInfoDto.getId()));
        noteInfo.setStatus(noteInfoDto.getStatus());

        noteInfoDao.updateNoteInfoStatus(noteInfo);

        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus());
    }

}
