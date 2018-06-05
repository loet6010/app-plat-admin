package com.sooying.pay.app.api.dao.platform.note;

import java.util.List;
import java.util.Map;

import com.sooying.pay.app.api.model.platform.note.NoteInfo;

/**
 * 短信明细
 * 
 * @Description NoteInfo
 * @author liurh
 * @date 2018年6月5日
 */
public interface NoteInfoDao {

    /**
     * 获取短信明细数量
     *
     * @param paramsMap
     * @return
     */
    int selectNoteInfoCount(Map<String, Object> paramsMap);

    /**
     * 获取短信明细列表
     *
     * @param paramsMap
     * @return
     */
    List<NoteInfo> selectNoteInfoList(Map<String, Object> paramsMap);

    /**
     * 修改短信明细激活状态
     *
     * @param paramsMap
     */
    void updateNoteInfoStatus(Map<String, Object> paramsMap);
}
