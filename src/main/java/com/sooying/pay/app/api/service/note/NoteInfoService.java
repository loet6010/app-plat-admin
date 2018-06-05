package com.sooying.pay.app.api.service.note;

import com.sooying.pay.app.api.controller.note.dto.NoteInfoDto;

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
}
