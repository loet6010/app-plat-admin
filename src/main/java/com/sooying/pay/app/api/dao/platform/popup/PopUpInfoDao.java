package com.sooying.pay.app.api.dao.platform.popup;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sooying.pay.app.api.model.platform.popup.PopUpInfo;

/**
 * 二次确认弹窗
 * 
 * @Description PopUpInfoDao
 * @author liurh
 * @date 2018年6月13日
 */
public interface PopUpInfoDao {

    /**
     * 获取二次确认弹窗数量
     *
     * @param paramsMap
     * @return
     */
    int selectPopUpInfoCount(Map<String, Object> paramsMap);

    /**
     * 获取二次确认弹窗列表
     *
     * @param paramsMap
     * @return
     */
    List<PopUpInfo> selectPopUpInfoList(Map<String, Object> paramsMap);

    /**
     * 修改二次确认弹窗
     *
     * @param popUpInfo
     */
    void updatePopUpInfo(PopUpInfo popUpInfo);

    /**
     * 删除二次确认弹窗
     *
     * @param id
     */
    void deletePopUpInfo(@Param("id") Long id);

    /**
     * 修改二次确认弹窗激活状态
     *
     * @param popUpInfo
     */
    void updatePopUpInfoStatus(PopUpInfo popUpInfo);

    /**
     * 新增二次确认弹窗
     *
     * @param popUpInfo
     */
    void insertPopUpInfo(PopUpInfo popUpInfo);
}
