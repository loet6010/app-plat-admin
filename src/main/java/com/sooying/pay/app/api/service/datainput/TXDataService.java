package com.sooying.pay.app.api.service.datainput;

import com.sooying.pay.app.api.base.ResultBase;
import com.sooying.pay.app.api.model.platform.datainput.TXDataInfo;

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
