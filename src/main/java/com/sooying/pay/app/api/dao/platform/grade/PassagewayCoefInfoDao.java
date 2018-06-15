package com.sooying.pay.app.api.dao.platform.grade;

import java.util.List;
import java.util.Map;

import com.sooying.pay.app.api.model.platform.grade.PassagewayCoefInfo;

/**
 * 通道系数配置
 * 
 * @Description PassagewayCoefInfoDao
 * @author liurh
 * @date 2018年6月15日
 */
public interface PassagewayCoefInfoDao {

    /**
     * 获取通道系数配置数量
     *
     * @param paramsMap
     * @return
     */
    int selectPassagewayCoefInfoCount(Map<String, Object> paramsMap);

    /**
     * 获取通道系数配置列表
     *
     * @param paramsMap
     * @return
     */
    List<PassagewayCoefInfo> selectPassagewayCoefInfoList(Map<String, Object> paramsMap);

    /**
     * 修改通道系数配置
     *
     * @param passagewayCoefInfo
     */
    void updatePassagewayCoefInfo(PassagewayCoefInfo passagewayCoefInfo);

    /**
     * 删除通道系数配置
     *
     * @param id
     */
    void deletePassagewayCoefInfo(Long id);

    /**
     * 新增通道系数配置
     *
     * @param passagewayCoefInfo
     */
    void insertPassagewayCoefInfo(PassagewayCoefInfo passagewayCoefInfo);
    
    /**
     * 根据通道ID查询运营商
     *
     * @param passagewayId
     * @return
     */
    String selectNetOperatorByPassagewayId(int passagewayId);
}
