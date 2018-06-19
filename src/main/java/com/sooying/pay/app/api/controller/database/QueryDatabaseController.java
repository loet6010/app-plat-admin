package com.sooying.pay.app.api.controller.database;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.app.api.controller.database.dto.DatabaseInfoDto;
import com.sooying.pay.app.api.service.database.QueryDatabaseService;
import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 数据库查询
 * 
 * @Description DatabaseInfoController
 * @author liurh
 * @date 2018年6月19日
 */
@Controller
public class QueryDatabaseController {
    private static Logger logger = LoggerFactory.getLogger(QueryDatabaseController.class);

    @Resource
    QueryDatabaseService queryDatabaseService;

    /**
     * 获取大盘数据
     *
     * @param request
     * @param noteInfoDto
     * @return
     */
    @RequestMapping(value = "/database/getOverallDataInfo.json", method = { RequestMethod.GET })
    @ResponseBody
    public String getOverallDataInfo(HttpServletRequest request, DatabaseInfoDto databaseInfoDto) {
        logger.info("QueryDatabaseController getOverallDataInfo 获取大盘数据");

        try {
            return queryDatabaseService.getOverallDataInfo(databaseInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("QueryDatabaseController 获取大盘数据，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("QueryDatabaseController 获取大盘数据异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }
}
