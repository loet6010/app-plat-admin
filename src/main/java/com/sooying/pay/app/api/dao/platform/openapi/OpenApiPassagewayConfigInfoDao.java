package com.sooying.pay.app.api.dao.platform.openapi;

import org.apache.ibatis.annotations.Param;

/**
 * 外放API
 * 
 * @Description OpenApiPassagewayConfigInfoDao
 * @author liurh
 * @date 2018年7月6日
 */
public interface OpenApiPassagewayConfigInfoDao {

    /**
     * 查询外放配置数
     *
     * @param passagewayId
     * @return
     */
    int selectOpenApiPassagewayConfigInfoCount(@Param("passagewayId") String passagewayId);
    
    /**
     * 查询已激活的积分配置数
     *
     * @param passagewayId
     * @return
     */
    int selectIntegralPassagewayConfigCount(@Param("passagewayId") String passagewayId);
}
