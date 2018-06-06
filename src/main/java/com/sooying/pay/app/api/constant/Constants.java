package com.sooying.pay.app.api.constant;

import com.sooying.pay.app.api.base.PropertiesTool;

/**
 * 平台常量参数
 * 
 * @Description ConstantUtil
 * @author liurh
 * @date 2018年6月4日
 */
public class Constants {
    // UTF-8字符集编码
    public static final String UTF8 = "UTF-8";
    // 状态有效
    public static final String STATUS_VALID = "1";
    // 状态无效
    public static final String STATUS_INVALID = "0";
    // token缓存有效小时数
    public static final int CACHE_HOUR;
    // token缓存最大个数
    public static final int MAXIMUM_SIZE;

    static {
        PropertiesTool propertiesTool = new PropertiesTool("classpath:conf/params.properties");
        CACHE_HOUR = propertiesTool.getIntProperty("guava.cache.hour");
        MAXIMUM_SIZE = propertiesTool.getIntProperty("guava.cache.maximumSize");
    }
}