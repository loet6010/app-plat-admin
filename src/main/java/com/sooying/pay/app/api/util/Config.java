package com.sooying.pay.app.api.util;

/**
 * 测试时请将参数改为平台提供的参数
 */
public class Config {

    public static final String PAY_URL;
    public static final String COMP_ID;
    public static final String PROD_ID;
    public static final String KEY;

    static {
        PropertiesUtil pu = new PropertiesUtil("classpath:conf/params.properties");
        PAY_URL = pu.getProperty("pay_url");
        COMP_ID = pu.getProperty("comp_id");
        PROD_ID = pu.getProperty("prod_id");
        KEY = pu.getProperty("key");
    }
}
