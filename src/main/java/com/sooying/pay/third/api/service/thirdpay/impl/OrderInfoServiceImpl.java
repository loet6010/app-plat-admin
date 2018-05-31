package com.sooying.pay.third.api.service.thirdpay.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sooying.pay.third.api.dao.thirdpay.MyDaoTest;
import com.sooying.pay.third.api.model.thirdpay.OrderInfo;
import com.sooying.pay.third.api.service.thirdpay.OrderInfoService;

/**
 * @Description OrderInfoServiceImpl
 * @author liurh
 * @date 2018年2月26日
 */
@Service("orderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {
    private final static Logger logger = LoggerFactory.getLogger(OrderInfoServiceImpl.class);
    
    @Resource
    private MyDaoTest myDaoTest;
    
    /**
     *
     * @param orderInfo
     */
    @Override
    public void addOrderInfo(OrderInfo orderInfo) {

    }

    /**
     *
     * @param orderInfo
     * @return
     */
    @Override
    public int modifyOrderInfo(OrderInfo orderInfo) {
        return 0;
    }

    /**
     *
     * @param orderCode
     * @return
     */
    @Override
    public OrderInfo queryOrderInfoByOrderCode(String orderCode) {
        int count = myDaoTest.selectMyTestCount(10010);
        logger.info("DATABASE TEST :" + count);
        return null;
    }

}
