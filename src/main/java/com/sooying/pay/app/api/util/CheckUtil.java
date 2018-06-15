package com.sooying.pay.app.api.util;

import org.springframework.util.Assert;

import com.bench.common.lang.NumberUtils;

/**
 * 检查工具类
 * 
 * @Description CheckUtil
 * @author liurh
 * @date 2018年6月15日
 */
public class CheckUtil {

    /**
     * 构造方法私有，禁止实例化
     * 
     * @throws InstantiationException
     */
    private CheckUtil() throws InstantiationException {
        throw new InstantiationException();
    }
    
    /**
     * 主键ID验证
     *
     * @param id
     */
    public static void idCheck(String id) {
        Assert.isTrue(NumberUtils.isDigits(id) && Long.parseLong(id) > 0, "id必须是整数且大于0！");
    }
}
