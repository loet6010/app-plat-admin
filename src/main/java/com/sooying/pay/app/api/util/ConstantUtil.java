package com.sooying.pay.app.api.util;

/**
 * 平台常量参数工具类
 * 
 * @Description ConstantUtil
 * @author liurh
 * @date 2018年6月4日
 */
public class ConstantUtil {
    // UTF-8字符集编码
    public static final String UTF8 = "UTF-8";
    // token缓存有效小时数
    public static final int CACHE_HOUR;
    // token缓存最大个数
    public static final int MAXIMUM_SIZE;

    static {
        PropertiesUtil pu = new PropertiesUtil("classpath:conf/params.properties");
        CACHE_HOUR = pu.getIntProperty("guava.cache.hour");
        MAXIMUM_SIZE = pu.getIntProperty("guava.cache.maximumSize");
    }
}
