package com.sooying.pay.app.api.controller.auth;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.app.api.controller.auth.dto.UserInfoDto;
import com.sooying.pay.app.api.service.auth.AuthUserTokenService;
import com.sooying.pay.app.api.util.ResultReturnUtil;

@Controller
public class AuthUserTokenController {
    private static Logger logger = LoggerFactory.getLogger(AuthUserTokenController.class);

    @Resource
    private AuthUserTokenService authUserTokenService;

    @RequestMapping(value = "/token/getUserAccountToken.do", method = { RequestMethod.GET })
    @ResponseBody
    public String getUserAccountToken(HttpServletRequest request, UserInfoDto userInfoDto) {
        logger.info("AuthUserTokenController 获取用户token");
        try {
            return authUserTokenService.getUserAccountToken(userInfoDto);
        } catch (Exception e) {
            logger.info("AuthUserTokenController 获取用户token异常：" + e);

            return ResultReturnUtil.getExceptionString();
        }
    }
}
