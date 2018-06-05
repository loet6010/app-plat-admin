package com.sooying.pay.app.api.service.auth.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sooying.pay.app.api.constants.ApiStatusEnum;
import com.sooying.pay.app.api.controller.auth.dto.UserInfoDto;
import com.sooying.pay.app.api.dao.platform.auth.AuthUserTokenDao;
import com.sooying.pay.app.api.model.platform.auth.AuthUserTokenInfo;
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
        String loginName = userInfoDto.getLoginName();
        String loginPassword = userInfoDto.getLoginPassword();
        String token = null;

        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(loginPassword)) {
            logger.info("AuthUserTokenServiceImpl 用户名或密码不能为空");

            return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_FAIL.getStatus(), "用户名或密码不能为空");
        }

        int userCount = authUserTokenDao.selectUserAccountCount(loginName, MD5Util.MD5EncodeUpperCase(loginPassword));

        if (userCount > 0) {
            // 用户存在，设置token
            token = MD5Util.MD5EncodeUpperCase(loginName + System.currentTimeMillis());
            CacheUtil.setToken(loginName, token);
        }

        // 设置返回信息
        AuthUserTokenInfo authUserTokenInfo = new AuthUserTokenInfo();
        authUserTokenInfo.setLoginName(loginName);
        authUserTokenInfo.setToken(token);

        List<Object> dataList = new ArrayList<Object>();
        dataList.add(authUserTokenInfo);

        return ResultReturnUtil.getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), "获取token成功", dataList);
    }

}