package com.sooying.pay.app.api.model.platform.auth;

/**
 * 用户登录获取token
 * 
 * @Description AuthUserTokenInfo
 * @author liurh
 * @date 2018年6月4日
 */
public class AuthUserTokenInfo {
    // 用户名
    private String loginName;
    // token字段
    private String token;

    /**
     * @return the loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName
     *            the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     *            the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

}
