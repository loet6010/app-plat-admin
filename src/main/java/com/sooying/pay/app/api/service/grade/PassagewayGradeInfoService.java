package com.sooying.pay.app.api.service.grade;

import com.sooying.pay.app.api.controller.grade.dto.PassagewayGradeInfoDto;

/**
 * 通道分级系数数据
 * 
 * @Description PassagewayGradeInfoService
 * @author liurh
 * @date 2018年6月14日
 */
public interface PassagewayGradeInfoService {

    /**
     * 获取通道分级系数数据列表
     *
     * @param ruleInfoDto
     * @return
     */
    String getPassagewayGradeInfoList(PassagewayGradeInfoDto passagewayGradeInfoDto);
}
