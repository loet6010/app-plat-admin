package com.sooying.pay.app.api.util;

import com.bench.common.lang.StringUtils;
import com.sooying.pay.app.api.constant.Constants;

/**
 * 字符串工具类
 * 
 * @Description StringUtil
 * @author liurh
 * @date 2018年6月25日
 */
public class StringUtil {

    /**
     * 构造方法私有，禁止实例化
     * 
     * @throws InstantiationException
     */
    private StringUtil() throws InstantiationException {
        throw new InstantiationException();
    }

    /**
     * 返回模糊匹配字符串
     * 
     * @param parameterStr
     * @return
     */
    public static String matchFuzzyString(String parameterStr) {
        if (StringUtils.isBlank(parameterStr)) {
            return StringUtils.EMPTY;
        }

        return Constants.PERCENT + parameterStr + Constants.PERCENT;
    }
}
