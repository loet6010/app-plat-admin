package com.sooying.pay.app.api.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sooying.pay.app.api.common.constant.Constants;

/**
 * 缓存工具类
 * 
 * @Description CacheUtil
 * @author liurh
 * @date 2018年6月4日
 */
public class CacheUtil {
    private static Logger logger = LoggerFactory.getLogger(CacheUtil.class);

    private static LoadingCache<String, String> cacheTokenList;

    /**
     * 构造方法私有，禁止实例化
     * 
     * @throws InstantiationException
     */
    private CacheUtil() throws InstantiationException {
        throw new InstantiationException();
    }

    /*
      缓存形式存放token信息
     */
    static {
        logger.info("CacheUtil cacheTokenList init hour is {},maximumSize is {}", Constants.CACHE_HOUR,
                Constants.MAXIMUM_SIZE);
        cacheTokenList = CacheBuilder.newBuilder().maximumSize(Constants.MAXIMUM_SIZE)
                .expireAfterWrite(Constants.CACHE_HOUR, TimeUnit.HOURS).build(new CacheLoader<String, String>() {
                    public String load(String key) {
                        return "";
                    }
                });
    }

    /**
     * 根据key获取token
     *
     * @param key
     * @return
     */
    public static String getToken(String key) {
        String token = null;
        try {
            token = cacheTokenList.get(key);
        } catch (ExecutionException e) {
            logger.error("CacheUtil getToken Exception" + e.getMessage());
        }

        return token;
    }

    /**
     * 设置token
     *
     * @param key
     * @param token
     */
    public static void setToken(String key, String token) {
        cacheTokenList.put(key, token);
    }
}
