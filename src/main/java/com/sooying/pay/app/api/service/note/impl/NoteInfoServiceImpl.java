package com.sooying.pay.app.api.service.note.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sooying.pay.app.api.common.base.BasePagination;
import com.sooying.pay.app.api.common.constant.ApiStatusEnum;
import com.sooying.pay.app.api.controller.note.dto.NoteInfoDto;
import com.sooying.pay.app.api.dao.platform.note.NoteInfoDao;
import com.sooying.pay.app.api.model.platform.note.NoteInfo;
import com.sooying.pay.app.api.service.note.NoteInfoService;
import com.sooying.pay.app.api.util.CheckUtil;
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
        logger.info("NoteInfoServiceImpl getNoteInfoList user is {}, page is {}, rows is {}, {}",
                noteInfoDto.getLoginName(), noteInfoDto.getPage(), noteInfoDto.getRows(), noteInfoDto.toString());

        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("passagewayId", noteInfoDto.getPassagewayId());

        // 查询总数
        int totalCount = noteInfoDao.selectNoteInfoCount(paramsMap);

        // 初始化分页信息
        BasePagination pagination = new BasePagination(totalCount);
        pagination.setCurrentPage(noteInfoDto.getPage());
        pagination.setRowsPerPage(noteInfoDto.getRows());
        pagination.initPage();

        paramsMap.put("start", pagination.getStart());
        paramsMap.put("rowsPerPage", pagination.getRowsPerPage());

        // 查询list
        List<NoteInfo> list = noteInfoDao.selectNoteInfoList(paramsMap);

        // list装入返回类型
        List<Object> dataList = new ArrayList<Object>();
        dataList.addAll(list);

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

        NoteInfo noteInfo = new NoteInfo();
        noteInfo.setId(Long.parseLong(noteInfoDto.getId()));
        noteInfo.setStatus(noteInfoDto.getStatus());

        noteInfoDao.updateNoteInfoStatus(noteInfo);

        String msg = "修改短信明细激活状态成功";
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

}
