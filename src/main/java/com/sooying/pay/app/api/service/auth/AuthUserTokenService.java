package com.sooying.pay.app.api.service.auth;

import com.sooying.pay.app.api.controller.auth.dto.UserInfoDto;

/**
 * 用户登录获取token
 * 
 * @Description AuthUserTokenService
 * @author liurh
 * @date 2018年6月4日
 */
public interface AuthUserTokenService {

    /**
     * 用户登录获取token
     *
     * @param userInfoDto
     * @return
     */
    String getUserAccountToken(UserInfoDto userInfoDto);
}
