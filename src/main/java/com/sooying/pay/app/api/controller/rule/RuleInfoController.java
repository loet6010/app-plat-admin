package com.sooying.pay.app.api.controller.rule;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.app.api.controller.rule.dto.RuleInfoDto;
import com.sooying.pay.app.api.service.rule.RuleInfoService;
import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 通道过滤规则
 * 
 * @Description RuleInfoController
 * @author liurh
 * @date 2018年6月12日
 */
@Controller
public class RuleInfoController {
    private static Logger logger = LoggerFactory.getLogger(RuleInfoController.class);

    @Resource
    RuleInfoService ruleInfoService;

    /**
     * 获取通道过滤规则列表
     *
     * @param request
     * @param ruleInfoDto
     * @return
     */
    @RequestMapping(value = "/rule/getRuleInfoList.json", method = { RequestMethod.GET })
    @ResponseBody
    public String getRuleInfoList(HttpServletRequest request, RuleInfoDto ruleInfoDto) {
        logger.info("RuleInfoController getRuleInfoList 获取通道过滤规则列表");

        try {
            return ruleInfoService.getRuleInfoList(ruleInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("RuleInfoController 获取通道过滤规则列表，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("RuleInfoController 获取通道过滤规则列表异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 修改通道过滤规则
     *
     * @param request
     * @param ruleInfoDto
     * @return
     */
    @RequestMapping(value = "/rule/modifyRuleInfo.json", method = { RequestMethod.POST })
    @ResponseBody
    public String modifyRuleInfo(HttpServletRequest request, RuleInfoDto ruleInfoDto) {
        logger.info("RuleInfoController modifyRuleInfo 修改通道过滤规则");

        try {
            return ruleInfoService.modifyRuleInfo(ruleInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("RuleInfoController 修改通道过滤规则，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("RuleInfoController 修改通道过滤规则异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 删除通道过滤规则
     *
     * @param request
     * @param ruleInfoDto
     * @return
     */
    @RequestMapping(value = "/rule/removeRuleInfo.json", method = { RequestMethod.POST })
    @ResponseBody
    public String removeRuleInfo(HttpServletRequest request, RuleInfoDto ruleInfoDto) {
        logger.info("RuleInfoController removeRuleInfo 删除通道过滤规则");

        try {
            return ruleInfoService.removeRuleInfo(ruleInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("RuleInfoController 删除通道过滤规则，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("RuleInfoController 删除通道过滤规则异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 修改通道过滤规则激活状态
     *
     * @param request
     * @param ruleInfoDto
     * @return
     */
    @RequestMapping(value = "/rule/modifyRuleInfoStatus.json", method = { RequestMethod.POST })
    @ResponseBody
    public String modifyRuleInfoStatus(HttpServletRequest request, RuleInfoDto ruleInfoDto) {
        logger.info("RuleInfoController modifyRuleInfoStatus 修改通道过滤规则激活状态");

        try {
            return ruleInfoService.modifyRuleInfoStatus(ruleInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("RuleInfoController 修改通道过滤规则激活状态，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("RuleInfoController 修改通道过滤规则激活状态异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 新增通道过滤规则
     *
     * @param request
     * @param ruleInfoDto
     * @return
     */
    @RequestMapping(value = "/rule/addRuleInfo.json", method = { RequestMethod.POST })
    @ResponseBody
    public String addRuleInfo(HttpServletRequest request, RuleInfoDto ruleInfoDto) {
        logger.info("RuleInfoController addRuleInfo 新增通道过滤规则");

        try {
            return ruleInfoService.addRuleInfo(ruleInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("RuleInfoController 新增通道过滤规则，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("RuleInfoController 新增通道过滤规则异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }
}
