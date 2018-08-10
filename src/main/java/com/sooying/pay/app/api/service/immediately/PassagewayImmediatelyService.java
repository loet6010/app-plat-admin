package com.sooying.pay.app.api.service.immediately;

/**
 * 通道立即生效
 * 
 * @Description PassagewayImmediatelyService
 * @author liurh
 * @date 2018年7月3日
 */
public interface PassagewayImmediatelyService {

    /**
     * 刷新通道分级系数数据
     *
     * @param passagewayId
     * @param type
     */
    void setRedisCash(String passagewayId, String type);
}
