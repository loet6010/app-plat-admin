package com.sooying.pay.app.api.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.bench.common.lang.NumberUtils;

/**
 * 获取配置文件
 * 
 * @Description PropertiesUtil
 * @author liurh
 * @date 2018年6月4日
 */
public class BaseProperties {
    private static final Map<String, Properties> allProperties = new HashMap<String, Properties>();

    private static Logger logger = LoggerFactory.getLogger(BaseProperties.class);

    private static ResourceLoader resourceLoader = new DefaultResourceLoader();

    private final Properties properties;

    public BaseProperties(String... resourcesPaths) {
        properties = loadProperties(resourcesPaths);
    }

    public Properties getProperties() {
        return properties;
    }

    public static String getValueByPropFileName(String propFileName, String key) {
        return allProperties.get(propFileName).getProperty(key);
    }

    /**
     * 取出Property。
     */
    private String getValue(String key) {
        String systemProperty = System.getProperty(key);
        if (systemProperty != null) {
            return systemProperty;
        }
        return properties.getProperty(key);
    }

    /**
     * 取出String类型的Property,如果都为Null则抛出异常.
     */
    public String getProperty(String key) {
        String value = getValue(key);
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    /**
     * 取出int类型的Property,如果都为Null则抛出异常.
     */
    public int getIntProperty(String key) {
        String value = getValue(key);

        if (value == null) {
            throw new NoSuchElementException();
        }

        if (!NumberUtils.isNumber(value)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(value);
    }

    /**
     * 取出String类型的Property.如果都为Null返回Default值.
     */
    public String getProperty(String key, String defaultValue) {
        String value = getValue(key);
        return value != null ? value : defaultValue;
    }

    /**
     * 载入多个文件, 文件路径使用Spring Resource格式.
     */
    private Properties loadProperties(String... resourcesPaths) {
        Properties props = new Properties();

        for (String location : resourcesPaths) {

            logger.info("Loading properties file from path:{}", location);

            InputStream is = null;
            try {
                Resource resource = resourceLoader.getResource(location);
                is = resource.getInputStream();
                props.load(is);
            } catch (IOException ex) {
                logger.info("Could not load properties from path:{}, {} ", location, ex.getMessage());
            } finally {
                IOUtils.closeQuietly(is);
            }
        }
        return props;
    }

}
