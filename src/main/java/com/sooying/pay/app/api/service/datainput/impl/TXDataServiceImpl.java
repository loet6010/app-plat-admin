package com.sooying.pay.app.api.service.datainput.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sooying.pay.app.api.base.ResultBase;
import com.sooying.pay.app.api.dao.datainput.TXDataDao;
import com.sooying.pay.app.api.dao.datainput.model.TXDataInfo;
import com.sooying.pay.app.api.service.datainput.TXDataService;
import com.sooying.pay.app.api.service.thirdpay.impl.OrderInfoServiceImpl;

/**
 * @Description TXDataServiceImpl
 * @author liurh
 * @date 2018年3月30日
 */
@Service("tXDataService")
public class TXDataServiceImpl implements TXDataService {
    private final static Logger logger = LoggerFactory.getLogger(OrderInfoServiceImpl.class);

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
