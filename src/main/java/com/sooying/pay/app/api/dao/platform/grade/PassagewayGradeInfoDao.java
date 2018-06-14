package com.sooying.pay.app.api.dao.platform.grade;

import java.util.List;
import java.util.Map;

import com.sooying.pay.app.api.model.platform.grade.PassagewayGradeInfo;

/**
 * 通道分级系数数据
 * 
 * @Description PassagewayGradeInfoDao
 * @author liurh
 * @date 2018年6月14日
 */
public interface PassagewayGradeInfoDao {

    /**
     * 获取通道分级系数数据数量
     *
     * @param paramsMap
     * @return
     */
    int selectPassagewayGradeInfoCount(Map<String, Object> paramsMap);

    /**
     * 获取通道分级系数数据列表
     *
     * @param paramsMap
     * @return
     */
    List<PassagewayGradeInfo> selectPassagewayGradeInfoList(Map<String, Object> paramsMap);
}
