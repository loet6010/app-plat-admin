/**
 * sooying.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.sooying.pay.third.api.dao.thirdpay;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@SuppressWarnings("deprecation")
@Repository
public class MyDaoTest extends SqlMapClientTemplate {
    
    @Resource(name="devplatformSqlMapClient")
    public void setSqlMapClient(SqlMapClient sqlMapClient) {
        super.setSqlMapClient(sqlMapClient);
    }

    public int selectMyTestCount(long merchantId) {
        Map<String, Long> parameterObject = new HashMap<String, Long>();
        parameterObject.put("merchantId", merchantId);
        
        return (Integer) this.queryForObject("selectMerchantInfoByMerchantId", parameterObject);
    }

    
}
