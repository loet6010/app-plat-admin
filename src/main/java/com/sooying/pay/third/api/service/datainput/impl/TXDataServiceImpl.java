package com.sooying.pay.third.api.service.datainput.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sooying.pay.third.api.commom.ResultBase;
import com.sooying.pay.third.api.dao.datainput.TXDataDao;
import com.sooying.pay.third.api.model.datainput.TXDataInfo;
import com.sooying.pay.third.api.service.datainput.TXDataService;
import com.sooying.pay.third.api.service.thirdpay.impl.OrderInfoServiceImpl;

/**
 * @Description TXDataServiceImpl
 * @author liurh
 * @date 2018年3月30日
 */
@Service("tXDataService")
public class TXDataServiceImpl implements TXDataService {
    private final static Logger logger = Logger.getLogger(OrderInfoServiceImpl.class);

    @Resource
    private TXDataDao tXDataDao;

    /**
     *
     * @param txDataInfo
     * @return
     */
    @Override
    public ResultBase addTXData(TXDataInfo txDataInfo) {
        try {
            logger.info("addTXData orderId:" + txDataInfo.getOrderId());
            int count = tXDataDao.selectTXDataCountByOrderid(txDataInfo.getOrderId());
            if (count > 0) {
                tXDataDao.updateTXData(txDataInfo);
            } else {
                tXDataDao.addTXData(txDataInfo);
            }

        } catch (Exception e) {
            logger.info("addTXData exception:" + e);
            return new ResultBase(false, e.getMessage());
        }

        return new ResultBase(true, "ok");
    }
}
