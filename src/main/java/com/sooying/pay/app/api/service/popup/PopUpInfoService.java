package com.sooying.pay.app.api.service.popup;

import com.sooying.pay.app.api.controller.popup.dto.PopUpInfoDto;

/**
 * 二次确认弹窗
 * 
 * @Description PopUpInfoService
 * @author liurh
 * @date 2018年6月13日
 */
public interface PopUpInfoService {

    /**
     * 获取二次确认弹窗列表
     *
     * @param popUpInfoDto
     * @return
     */
    String getPopUpInfoList(PopUpInfoDto popUpInfoDto);

    /**
     * 修改二次确认弹窗
     *
     * @param popUpInfoDto
     * @return
     */
    String modifyPopUpInfo(PopUpInfoDto popUpInfoDto);

    /**
     * 删除二次确认弹窗
     *
     * @param popUpInfoDto
     * @return
     */
    String removePopUpInfo(PopUpInfoDto popUpInfoDto);

    /**
     * 修改二次确认弹窗激活状态
     *
     * @param popUpInfoDto
     * @return
     */
    String modifyPopUpInfoStatus(PopUpInfoDto popUpInfoDto);

    /**
     * 新增二次确认弹窗
     *
     * @param popUpInfoDto
     * @return
     */
    String addPopUpInfo(PopUpInfoDto popUpInfoDto);
}
