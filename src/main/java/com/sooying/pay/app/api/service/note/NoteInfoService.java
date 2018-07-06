package com.sooying.pay.app.api.service.note;

import java.util.List;

import com.sooying.pay.app.api.controller.note.dto.NoteInfoDto;
import com.sooying.pay.app.api.model.platform.note.NoteInfo;
import com.sooying.pay.app.api.model.platform.note.NoteMultipleConfInfo;
import com.sooying.pay.app.api.model.platform.note.NoteSecondConfInfo;
import com.sooying.pay.app.api.model.platform.note.NoteSuccessInfo;

/**
 * 短信明细
 * 
 * @Description NoteInfoService
 * @author liurh
 * @date 2018年6月5日
 */
public interface NoteInfoService {

    /**
     * 获取短信明细列表
     *
     * @param noteInfoDto
     * @return
     */
    String getNoteInfoList(NoteInfoDto noteInfoDto);

    /**
     * 修改短信明细激活状态
     *
     * @param noteInfoDto
     * @return
     */
    String modifyNoteInfoStatus(NoteInfoDto noteInfoDto);

    /**
     * 修改短信明细SDK激活状态
     *
     * @param noteInfoDto
     * @return
     */
    String modifyNoteInfoSdkStatus(NoteInfoDto noteInfoDto);

    /**
     * 根据ID获取短信明细
     *
     * @param noteInfoDto
     * @return
     */
    NoteInfo getNoteInfoById(NoteInfoDto noteInfoDto);

    /**
     * 获取成功后相关信息列表
     *
     * @param passagewayId
     * @return
     */
    List<NoteSuccessInfo> getSeccessDataGridList(String passagewayId);

    /**
     * 获取普通二次确认下行信息列表
     *
     * @param passagewayId
     * @return
     */
    List<NoteSecondConfInfo> getSecondConfDataGridList(String passagewayId);

    /**
     * 获取动态二次和多次确认下行信息列表
     *
     * @param passagewayId
     * @return
     */
    List<NoteMultipleConfInfo> getMultipleConfDataGridList(String passagewayId);
}
