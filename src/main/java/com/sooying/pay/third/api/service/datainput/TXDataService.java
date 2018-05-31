package com.sooying.pay.third.api.service.datainput;

import com.sooying.pay.third.api.commom.ResultBase;
import com.sooying.pay.third.api.model.datainput.TXDataInfo;

/**
 * @Description TXDataService
 * @author liurh
 * @date 2018年3月30日
 */
public interface TXDataService {
    /**
     * 添加订单信息
     */
    public ResultBase addTXData(TXDataInfo txDataInfo);
}
