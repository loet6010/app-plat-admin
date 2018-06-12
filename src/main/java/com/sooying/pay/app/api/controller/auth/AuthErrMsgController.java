package com.sooying.pay.app.api.controller.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 拦截器错误信息返回
 * 
 * @Description AuthErrMsgAction
 * @author liurh
 * @date 2018年6月1日
 */
@Controller
public class AuthErrMsgController {
    Logger logger = LoggerFactory.getLogger(AuthErrMsgController.class);

    /**
     * 拦截器错误信息返回
     *
     * @param resultStatus
     * @param message
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/auth/showAuthMsg.do")
    @ResponseBody
    public String showAuthMsg(String resultStatus, String message) throws Exception {
        logger.info(message);
        return ResultReturnUtil.getResultString(resultStatus, message);
    }
}
