package com.sooying.pay.app.api.service.grade;

import com.sooying.pay.app.api.controller.grade.dto.PassagewayCoefInfoDto;
import com.sooying.pay.app.api.model.platform.grade.PassagewayCoefInfo;

/**
 * 通道系数配置
 * 
 * @Description PassagewayCoefInfoService
 * @author liurh
 * @date 2018年6月15日
 */
public interface PassagewayCoefInfoService {

    /**
     * 获取通道系数配置列表
     *
     * @param passagewayCoefInfoDto
     * @return
     */
    String getPassagewayCoefInfoList(PassagewayCoefInfoDto passagewayCoefInfoDto);

    /**
     * 修改通道系数配置
     *
     * @param passagewayCoefInfoDto
     * @return
     */
    String modifyPassagewayCoefInfo(PassagewayCoefInfoDto passagewayCoefInfoDto);

    /**
     * 删除通道系数配置
     *
     * @param passagewayCoefInfoDto
     * @return
     */
    String removePassagewayCoefInfo(PassagewayCoefInfoDto passagewayCoefInfoDto);

    /**
     * 新增通道系数配置
     *
     * @param passagewayCoefInfoDto
     * @return
     */
    String addPassagewayCoefInfo(PassagewayCoefInfoDto passagewayCoefInfoDto);
    
    /**
     * 根据ID获取通道系数配置
     *
     * @param passagewayCoefInfoDto
     * @return
     */
    PassagewayCoefInfo getPassagewayCoefInfoById(PassagewayCoefInfoDto passagewayCoefInfoDto);
}
