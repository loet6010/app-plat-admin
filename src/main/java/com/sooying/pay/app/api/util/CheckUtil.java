package com.sooying.pay.app.api.util;

import org.springframework.util.Assert;

import com.bench.common.lang.NumberUtils;
import com.sooying.pay.app.api.constant.Constants;

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
     * 主键ID校验
     *
     * @param id
     */
    public static void idCheck(String id) {
        Assert.isTrue(NumberUtils.isDigits(id) && Long.parseLong(id) > 0, "id必须是整数且大于0！");
    }

    /**
     * 激活状态校验
     *
     * @param status
     */
    public static void statusCheck(String status) {
        Assert.isTrue(Constants.STRING_ONE.equals(status) || Constants.STRING_ZERO.equals(status), "激活状态必须是0或1！");
    }
}
