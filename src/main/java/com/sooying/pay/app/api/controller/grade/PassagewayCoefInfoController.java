package com.sooying.pay.app.api.controller.grade;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.app.api.controller.grade.dto.PassagewayCoefInfoDto;
import com.sooying.pay.app.api.service.grade.PassagewayCoefInfoService;
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

    /**
     * 获取通道系数配置列表
     *
     * @param request
     * @param passagewayCoefInfoDto
     * @return
     */
    @RequestMapping(value = "/grade/getPassagewayCoefInfoList.json", method = { RequestMethod.GET })
    @ResponseBody
    public String getPassagewayCoefInfoList(HttpServletRequest request, PassagewayCoefInfoDto passagewayCoefInfoDto) {
        logger.info("PassagewayCoefInfoController 获取通道系数配置列表，通道ID：{}", passagewayCoefInfoDto.getPassagewayId());

        try {
            return passagewayCoefInfoService.getPassagewayCoefInfoList(passagewayCoefInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("PassagewayCoefInfoController 获取通道系数配置列表，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("PassagewayCoefInfoController 获取通道系数配置列表异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 修改通道系数配置
     *
     * @param request
     * @param passagewayCoefInfoDto
     * @return
     */
    @RequestMapping(value = "/grade/modifyPassagewayCoefInfo.json", method = { RequestMethod.POST })
    @ResponseBody
    public String modifyPassagewayCoefInfo(HttpServletRequest request, PassagewayCoefInfoDto passagewayCoefInfoDto) {
        logger.info("PassagewayCoefInfoController 修改通道系数配置，id：{}", passagewayCoefInfoDto.getId());

        try {
            return passagewayCoefInfoService.modifyPassagewayCoefInfo(passagewayCoefInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("PassagewayCoefInfoController 修改通道系数配置，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("PassagewayCoefInfoController 修改通道系数配置异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 删除通道系数配置
     *
     * @param request
     * @param passagewayCoefInfoDto
     * @return
     */
    @RequestMapping(value = "/grade/removePassagewayCoefInfo.json", method = { RequestMethod.POST })
    @ResponseBody
    public String removePassagewayCoefInfo(HttpServletRequest request, PassagewayCoefInfoDto passagewayCoefInfoDto) {
        logger.info("PassagewayCoefInfoController 删除通道系数配置，id：{}", passagewayCoefInfoDto.getId());

        try {
            return passagewayCoefInfoService.removePassagewayCoefInfo(passagewayCoefInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("PassagewayCoefInfoController 删除通道系数配置，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("PassagewayCoefInfoController 删除通道系数配置异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 新增通道系数配置
     *
     * @param request
     * @param passagewayCoefInfoDto
     * @return
     */
    @RequestMapping(value = "/grade/addPassagewayCoefInfo.json", method = { RequestMethod.POST })
    @ResponseBody
    public String addPassagewayCoefInfo(HttpServletRequest request, PassagewayCoefInfoDto passagewayCoefInfoDto) {
        logger.info("PassagewayCoefInfoController 新增通道系数配置，通道ID：{}", passagewayCoefInfoDto.getPassagewayId());

        try {
            return passagewayCoefInfoService.addPassagewayCoefInfo(passagewayCoefInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("PassagewayCoefInfoController 新增通道系数配置，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("PassagewayCoefInfoController 新增通道系数配置异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }
}
