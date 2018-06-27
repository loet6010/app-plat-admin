package com.sooying.pay.app.api.controller.auth.dto;

import com.sooying.pay.app.api.common.base.BasePageDto;

/**
 * 用户登录dto
 * 
 * @Description UserInfoDto
 * @author liurh
 * @date 2018年6月4日
 */
public class UserInfoDto extends BasePageDto {
    // 用户登录密码
    private String loginPassword;

    /**
     * @return the loginPassword
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * @param loginPassword
     *            the loginPassword to set
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
