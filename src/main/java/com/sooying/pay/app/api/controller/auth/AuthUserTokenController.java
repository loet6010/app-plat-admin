package com.sooying.pay.app.api.controller.auth;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.app.api.controller.auth.dto.UserInfoDto;
import com.sooying.pay.app.api.service.auth.AuthUserTokenService;
import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 用户登录获取token
 * 
 * @Description AuthUserTokenController
 * @author liurh
 * @date 2018年6月5日
 */
@Controller
public class AuthUserTokenController {
    private static Logger logger = LoggerFactory.getLogger(AuthUserTokenController.class);

    @Resource
    private AuthUserTokenService authUserTokenService;

    /**
     * 用户登录获取token
     *
     * @param userInfoDto
     * @return
     */
    @RequestMapping(value = "/token/getUserAccountToken.do", method = { RequestMethod.GET })
    @ResponseBody
    public String getUserAccountToken(UserInfoDto userInfoDto) {
        logger.info("AuthUserTokenController getUserAccountToken 获取用户token");

        try {
            return authUserTokenService.getUserAccountToken(userInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("AuthUserTokenController 用户登录获取token，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("AuthUserTokenController 获取用户token异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }
}
