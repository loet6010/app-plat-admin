package com.sooying.pay.app.api.constant;

import com.sooying.pay.app.api.base.BaseProperties;

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
    // 字符串"1"
    public static final String STRING_ONE = "1";
    // 字符串"0"
    public static final String STRING_ZERO = "0";
    // token缓存有效小时数
    public static final int CACHE_HOUR;
    // token缓存最大个数
    public static final int MAXIMUM_SIZE;

    static {
        BaseProperties propertiesTool = new BaseProperties("classpath:conf/params.properties");
        CACHE_HOUR = propertiesTool.getIntProperty("guava.cache.hour");
        MAXIMUM_SIZE = propertiesTool.getIntProperty("guava.cache.maximumSize");
    }
}
