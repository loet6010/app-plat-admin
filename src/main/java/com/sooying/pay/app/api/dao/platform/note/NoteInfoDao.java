package com.sooying.pay.app.api.dao.platform.note;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sooying.pay.app.api.model.platform.note.NoteInfo;
import com.sooying.pay.app.api.model.platform.note.NoteMultipleConfInfo;
import com.sooying.pay.app.api.model.platform.note.NoteSecondConfInfo;
import com.sooying.pay.app.api.model.platform.note.NoteSuccessInfo;

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
     * @param noteInfo
     */
    void updateNoteInfoStatus(NoteInfo noteInfo);

    /**
     * 修改短信明细SDK激活状态
     *
     * @param noteInfo
     */
    void updateNoteInfoSdkStatus(NoteInfo noteInfo);

    /**
     * 根据通道ID获取短信明细
     *
     * @param passagewayId
     * @return
     */
    NoteInfo selectNoteInfoByPassagewayId(@Param("passagewayId") String passagewayId);

    /**
     * 根据ID获取短信明细
     *
     * @param id
     * @return
     */
    NoteInfo selectNoteInfoById(@Param("id") Long id);

    /**
     * 查询成功后相关信息列表
     *
     * @param passagewayId
     * @return
     */
    List<NoteSuccessInfo> selectSuccessDataGridList(@Param("passagewayId") String passagewayId);

    /**
     * 普通二次确认下行信息列表
     *
     * @param passagewayId
     * @return
     */
    List<NoteSecondConfInfo> selectSecondConfDataGridList(@Param("passagewayId") String passagewayId);

    /**
     * 普通二次确认下行信息列表
     *
     * @param passagewayId
     * @return
     */
    List<NoteMultipleConfInfo> selectMultipleConfDataGridList(@Param("passagewayId") String passagewayId);
}
