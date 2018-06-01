/**
 * sooying.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.sooying.pay.app.api.dao.datainput;

import com.sooying.pay.app.api.model.datainput.TXDataInfo;

public interface TXDataDao {

    /**
     * 根据订单号查询记录是否存在
     *
     * @param orderId
     * @return
     */
    int selectTXDataCountByOrderid(String orderId);

    /**
     * 插入订单数据
     *
     * @param txDataInfo
     */
    void addTXData(TXDataInfo txDataInfo);

    /**
     * 更新订单数据
     *
     * @param txDataInfo
     */
    void updateTXData(TXDataInfo txDataInfo);

}
