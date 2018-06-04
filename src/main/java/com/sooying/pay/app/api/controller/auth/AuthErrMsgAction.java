package com.sooying.pay.app.api.controller.auth;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 拦截器错误信息返回
 * 
 * @Description AuthErrMsgAction
 * @author liurh
 * @date 2018年6月1日
 */
@Controller
public class AuthErrMsgAction {

    @RequestMapping(value = "/auth/showAuthMsg.do")
    @ResponseBody
    public String showAuthMsg(String errMsg) throws Exception {
        System.out.println(errMsg);

        byte[] encrypted = errMsg.getBytes("UTF-8");
        
        String returnMsg = new String(Base64.encodeBase64(encrypted));
        
        System.out.println(returnMsg);

        return returnMsg;
    }
}
