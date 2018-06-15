package com.sooying.pay.app.api.controller.popup;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.app.api.controller.popup.dto.PopUpInfoDto;
import com.sooying.pay.app.api.service.popup.PopUpInfoService;
import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 二次确认弹窗
 * 
 * @Description PopUpInfoController
 * @author liurh
 * @date 2018年6月13日
 */
@Controller
public class PopUpInfoController {
    private static Logger logger = LoggerFactory.getLogger(PopUpInfoController.class);

    @Resource
    PopUpInfoService popUpInfoService;

    /**
     * 获取二次确认弹窗列表
     *
     * @param request
     * @param popUpInfoDto
     * @return
     */
    @RequestMapping(value = "/popup/getPopUpInfoList.json", method = { RequestMethod.GET })
    @ResponseBody
    public String getPopUpInfoList(HttpServletRequest request, PopUpInfoDto popUpInfoDto) {
        logger.info("PopUpInfoController getPopUpInfoList 获取二次确认弹窗列表");

        try {
            return popUpInfoService.getPopUpInfoList(popUpInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("获取二次确认弹窗列表，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("PopUpInfoController 获取二次确认弹窗列表异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 修改二次确认弹窗
     *
     * @param request
     * @param popUpInfoDto
     * @return
     */
    @RequestMapping(value = "/popup/modifyPopUpInfo.json", method = { RequestMethod.POST })
    @ResponseBody
    public String modifyPopUpInfo(HttpServletRequest request, PopUpInfoDto popUpInfoDto) {
        logger.info("PopUpInfoController modifyPopUpInfo 修改二次确认弹窗");

        try {
            return popUpInfoService.modifyPopUpInfo(popUpInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("PopUpInfoController 修改二次确认弹窗，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("PopUpInfoController 修改二次确认弹窗异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 删除二次确认弹窗
     *
     * @param request
     * @param popUpInfoDto
     * @return
     */
    @RequestMapping(value = "/popup/removePopUpInfo.json", method = { RequestMethod.POST })
    @ResponseBody
    public String removePopUpInfo(HttpServletRequest request, PopUpInfoDto popUpInfoDto) {
        logger.info("PopUpInfoController removePopUpInfo 删除二次确认弹窗");

        try {
            return popUpInfoService.removePopUpInfo(popUpInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("PopUpInfoController 删除二次确认弹窗，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("PopUpInfoController 删除二次确认弹窗异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 修改二次确认弹窗激活状态
     *
     * @param request
     * @param popUpInfoDto
     * @return
     */
    @RequestMapping(value = "/popup/modifyPopUpInfoStatus.json", method = { RequestMethod.POST })
    @ResponseBody
    public String modifyPopUpInfoStatus(HttpServletRequest request, PopUpInfoDto popUpInfoDto) {
        logger.info("PopUpInfoController modifyPopUpInfoStatus 修改二次确认弹窗激活状态");

        try {
            return popUpInfoService.modifyPopUpInfoStatus(popUpInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("PopUpInfoController 修改二次确认弹窗激活状态，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("PopUpInfoController 修改二次确认弹窗激活状态异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 新增二次确认弹窗
     *
     * @param request
     * @param popUpInfoDto
     * @return
     */
    @RequestMapping(value = "/popup/addPopUpInfo.json", method = { RequestMethod.POST })
    @ResponseBody
    public String addPopUpInfo(HttpServletRequest request, PopUpInfoDto popUpInfoDto) {
        logger.info("PopUpInfoController addPopUpInfo 新增二次确认弹窗");

        try {
            return popUpInfoService.addPopUpInfo(popUpInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("PopUpInfoController 新增二次确认弹窗，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("PopUpInfoController 新增二次确认弹窗异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }
}
