package com.sooying.pay.app.api.controller.app;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.app.api.controller.app.dto.AppInfoDto;
import com.sooying.pay.app.api.service.app.AppInfoService;
import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 应用
 * 
 * @Description AppInfoController
 * @author liurh
 * @date 2018年8月3日
 */
@Controller
public class AppInfoController {
    private static Logger logger = LoggerFactory.getLogger(AppInfoController.class);

    @Resource
    AppInfoService appInfoService;

    /**
     * 获取应用列表
     *
     * @param appInfoDto
     * @return
     */
    @RequestMapping(value = "/app/getAppInfoList.json", method = { RequestMethod.GET })
    @ResponseBody
    public String getAppInfoList(AppInfoDto appInfoDto) {
        logger.info("AppInfoController getAppInfoList 获取应用列表");

        try {
            return appInfoService.getAppInfoList(appInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("获取应用列表，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("AppInfoController 获取应用列表异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }
}
