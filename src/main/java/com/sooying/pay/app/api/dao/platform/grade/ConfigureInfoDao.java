package com.sooying.pay.app.api.dao.platform.grade;

import com.sooying.pay.app.api.model.platform.grade.ConfigureInfo;

/**
 * 通道常量配置
 * 
 * @Description ConfigureInfoDao
 * @author liurh
 * @date 2018年7月3日
 */
public interface ConfigureInfoDao {

    /**
     * 获取通道常量配置
     *
     * @return
     */
    ConfigureInfo selectConfigureInfo();
}
