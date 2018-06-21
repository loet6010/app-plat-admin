package com.sooying.pay.app.api.controller.grade;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.app.api.controller.grade.dto.PassagewayGradeInfoDto;
import com.sooying.pay.app.api.service.grade.PassagewayGradeInfoService;
import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 通道分级系数数据
 * 
 * @Description PassagewayGradeInfoController
 * @author liurh
 * @date 2018年6月14日
 */
@Controller
public class PassagewayGradeInfoController {
    private static Logger logger = LoggerFactory.getLogger(PassagewayGradeInfoController.class);

    @Resource
    PassagewayGradeInfoService passagewayGradeInfoService;

    /**
     * 获取通道分级系数数据列表
     *
     * @param request
     * @param passagewayGradeInfoDto
     * @return
     */
    @RequestMapping(value = "/grade/getPassagewayGradeInfoList.json", method = { RequestMethod.GET })
    @ResponseBody
    public String getPassagewayGradeInfoList(HttpServletRequest request,
            PassagewayGradeInfoDto passagewayGradeInfoDto) {
        logger.info("PassagewayGradeInfoController getPassagewayGradeInfoList 获取通道分级系数数据列表");

        try {
            return passagewayGradeInfoService.getPassagewayGradeInfoList(passagewayGradeInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("PassagewayGradeInfoController 获取通道分级系数数据列表，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("PassagewayGradeInfoController 获取通道分级系数数据列表异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }
}
