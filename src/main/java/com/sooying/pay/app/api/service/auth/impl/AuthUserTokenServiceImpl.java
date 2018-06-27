package com.sooying.pay.app.api.service.auth.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.bench.common.lang.StringUtils;
import com.sooying.pay.app.api.common.constant.ApiStatusEnum;
import com.sooying.pay.app.api.controller.auth.dto.UserInfoDto;
import com.sooying.pay.app.api.dao.platform.auth.AuthUserTokenDao;
import com.sooying.pay.app.api.model.platform.auth.UserInfo;
import com.sooying.pay.app.api.service.auth.AuthUserTokenService;
import com.sooying.pay.app.api.util.CacheUtil;
import com.sooying.pay.app.api.util.MD5Util;
import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 用户登录获取token
 * 
 * @Description AuthUserTokenServiceImpl
 * @author liurh
 * @date 2018年6月4日
 */
@Service("authUserTokenService")
public class AuthUserTokenServiceImpl implements AuthUserTokenService {
    private final static Logger logger = LoggerFactory.getLogger(AuthUserTokenServiceImpl.class);

    @Resource
    AuthUserTokenDao authUserTokenDao;

    /**
     * 用户登录获取token
     *
     * @param userInfoDto
     * @return
     */
    @Override
    public String getUserAccountToken(UserInfoDto userInfoDto) {
        logger.info("AuthUserTokenServiceImpl getUserAccountToken user is {}", userInfoDto.getLoginName());

        String loginName = userInfoDto.getLoginName();
        String loginPassword = userInfoDto.getLoginPassword();

        Assert.isTrue(StringUtils.isNotBlank(loginName) && StringUtils.isNotBlank(loginPassword), "用户名或密码不能为空！");
        int userCount = authUserTokenDao.selectUserAccountCount(loginName, MD5Util.MD5EncodeUpperCase(loginPassword));
        Assert.isTrue(userCount > 0, "用户名或密码错误！");

        // 用户存在，设置token
        String token = MD5Util.MD5EncodeUpperCase(loginName + System.currentTimeMillis());
        CacheUtil.setToken(loginName, token);

        // 设置返回信息
        UserInfo userInfo = new UserInfo();
        userInfo.setLoginName(loginName);
        userInfo.setToken(token);

        List<Object> dataList = new ArrayList<Object>();
        dataList.add(userInfo);

        String msg = "获取token成功";
        logger.info("AuthUserTokenServiceImpl getUserAccountToken {}", msg);
        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), msg, dataList);
    }

}
