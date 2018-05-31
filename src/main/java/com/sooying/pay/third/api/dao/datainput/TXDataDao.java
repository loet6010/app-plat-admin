/**
 * sooying.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.sooying.pay.third.api.dao.datainput;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.sooying.pay.third.api.model.datainput.TXDataInfo;

@SuppressWarnings("deprecation")
@Repository
public class TXDataDao extends SqlMapClientTemplate {
    
    @Resource(name="devplatformSqlMapClient")
    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        super.setSqlMapClient(sqlMapClient);
    }

    /**
     * 根据订单号查询记录是否存在
     *
     * @param orderId
     * @return
     */
    public int selectTXDataCountByOrderid(String orderId) {
        Map<String, String> parameterObject = new HashMap<String, String>();
        parameterObject.put("orderId", orderId);
        
        return (Integer) this.queryForObject("selectTXDataCountByOrderid", parameterObject);
    }
    
    /**
     * 插入订单数据
     *
     * @param txDataInfo
     */
    public void addTXData(TXDataInfo txDataInfo) {
        if (txDataInfo != null) {
            this.insert("addTXData", txDataInfo);
        }
    }
    
    /**
     * 更新订单数据
     *
     * @param txDataInfo
     */
    public void updateTXData(TXDataInfo txDataInfo) {
        if (txDataInfo != null) {
            this.update("updateTXData", txDataInfo);
        }
    }
    
}
