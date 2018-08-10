package com.sooying.pay.app.api.controller.grade;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.app.api.controller.grade.dto.PassagewayCoefInfoDto;
import com.sooying.pay.app.api.model.platform.grade.PassagewayCoefInfo;
import com.sooying.pay.app.api.service.grade.PassagewayCoefInfoService;
import com.sooying.pay.app.api.service.immediately.PassagewayImmediatelyService;
import com.sooying.pay.app.api.service.immediately.enums.RedisCashTypeEnum;
import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 通道系数配置
 * 
 * @Description PassagewayCoefInfoController
 * @author liurh
 * @date 2018年6月15日
 */
@Controller
public class PassagewayCoefInfoController {
    private static Logger logger = LoggerFactory.getLogger(PassagewayCoefInfoController.class);

    @Resource
    PassagewayCoefInfoService passagewayCoefInfoService;
    @Resource
    PassagewayImmediatelyService passagewayImmediatelyService;

    /**
     * 获取通道系数配置列表
     *
     * @param passagewayCoefInfoDto
     * @return
     */
    @RequestMapping(value = "/grade/getPassagewayCoefInfoList.json", method = { RequestMethod.GET })
    @ResponseBody
    public String getPassagewayCoefInfoList(PassagewayCoefInfoDto passagewayCoefInfoDto) {
        logger.info("PassagewayCoefInfoController getPassagewayCoefInfoList 获取通道系数配置列表");

        try {
            return passagewayCoefInfoService.getPassagewayCoefInfoList(passagewayCoefInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("PassagewayCoefInfoController 获取通道系数配置列表，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("PassagewayCoefInfoController 获取通道系数配置列表异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 修改通道系数配置
     *
     * @param passagewayCoefInfoDto
     * @return
     */
    @RequestMapping(value = "/grade/modifyPassagewayCoefInfo.json", method = { RequestMethod.POST })
    @ResponseBody
    public String modifyPassagewayCoefInfo(PassagewayCoefInfoDto passagewayCoefInfoDto) {
        logger.info("PassagewayCoefInfoController modifyPassagewayCoefInfo 修改通道系数配置");

        try {
            String message;
            PassagewayCoefInfo passagewayCoefInfo = passagewayCoefInfoService
                    .getPassagewayCoefInfoById(passagewayCoefInfoDto);

            if (passagewayCoefInfo != null) {
                message = passagewayCoefInfoService.modifyPassagewayCoefInfo(passagewayCoefInfoDto);

                // 刷新通道分级系数数据
                passagewayImmediatelyService.setRedisCash(passagewayCoefInfo.getPassagewayId(),
                        RedisCashTypeEnum.REDIS_CASH_TYPE_ENUM1.getStatus());
            } else {
                message = ResultReturnUtil.getExceptionString("通道系数配置不存在！");
            }

            return message;
        } catch (IllegalArgumentException e) {
            logger.info("PassagewayCoefInfoController 修改通道系数配置，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("PassagewayCoefInfoController 修改通道系数配置异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 删除通道系数配置
     *
     * @param passagewayCoefInfoDto
     * @return
     */
    @RequestMapping(value = "/grade/removePassagewayCoefInfo.json", method = { RequestMethod.POST })
    @ResponseBody
    public String removePassagewayCoefInfo(PassagewayCoefInfoDto passagewayCoefInfoDto) {
        logger.info("PassagewayCoefInfoController removePassagewayCoefInfo 删除通道系数配置");

        try {
            String message;
            PassagewayCoefInfo passagewayCoefInfo = passagewayCoefInfoService
                    .getPassagewayCoefInfoById(passagewayCoefInfoDto);

            if (passagewayCoefInfo != null) {
                message = passagewayCoefInfoService.removePassagewayCoefInfo(passagewayCoefInfoDto);

                // 刷新通道分级系数数据
                passagewayImmediatelyService.setRedisCash(passagewayCoefInfo.getPassagewayId(),
                        RedisCashTypeEnum.REDIS_CASH_TYPE_ENUM1.getStatus());
            } else {
                message = ResultReturnUtil.getExceptionString("通道系数配置不存在！");
            }

            return message;
        } catch (IllegalArgumentException e) {
            logger.info("PassagewayCoefInfoController 删除通道系数配置，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("PassagewayCoefInfoController 删除通道系数配置异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 新增通道系数配置
     *
     * @param passagewayCoefInfoDto
     * @return
     */
    @RequestMapping(value = "/grade/addPassagewayCoefInfo.json", method = { RequestMethod.POST })
    @ResponseBody
    public String addPassagewayCoefInfo(PassagewayCoefInfoDto passagewayCoefInfoDto) {
        logger.info("PassagewayCoefInfoController addPassagewayCoefInfo 新增通道系数配置");

        try {
            return passagewayCoefInfoService.addPassagewayCoefInfo(passagewayCoefInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("PassagewayCoefInfoController 新增通道系数配置，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("PassagewayCoefInfoController 新增通道系数配置异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }
    
    /**
     * 获取代码资费
     *
     * @param passagewayCoefInfoDto
     * @return
     */
    @RequestMapping(value = "/grade/getPassagewayIdPrice.json", method = { RequestMethod.GET })
    @ResponseBody
    public String getPassagewayIdPrice(PassagewayCoefInfoDto passagewayCoefInfoDto) {
        logger.info("PassagewayCoefInfoController getPassagewayIdPrice 获取代码资费");

        try {
            return passagewayCoefInfoService.getPassagewayIdPrice(passagewayCoefInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("PassagewayCoefInfoController 获取代码资费，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("PassagewayCoefInfoController 获取代码资费异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }
}
