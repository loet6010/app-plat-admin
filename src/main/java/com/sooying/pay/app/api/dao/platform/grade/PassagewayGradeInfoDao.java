package com.sooying.pay.app.api.dao.platform.grade;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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

    /**
     * 批量插入通道分级系数数据
     *
     * @param infoList
     */
    void batchInsertPassageWayGradeInfo(@Param("infoList") List<PassagewayGradeInfo> infoList);

    /**
     * 批量删除通道分级系数数据
     *
     * @param passagewayId
     */
    void batchDeletePassageWayGradeInfo(@Param("passagewayId") String passagewayId);
}
