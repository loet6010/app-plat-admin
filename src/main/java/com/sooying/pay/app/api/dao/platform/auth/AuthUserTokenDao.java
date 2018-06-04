package com.sooying.pay.app.api.dao.platform.auth;

import org.apache.ibatis.annotations.Param;

/**
 * 用户登录获取token
 * 
 * @Description AuthUserTokenDao
 * @author liurh
 * @date 2018年6月4日
 */
public interface AuthUserTokenDao {
    /**
     * 查询用户数量
     *
     * @param paramsMap
     * @return
     */
    int selectUserAccountCount(@Param("loginName") String loginName, @Param("loginPassword") String loginPassword);
}
