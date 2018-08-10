package com.sooying.pay.app.api.controller.blacklist;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.app.api.controller.blacklist.dto.CityBlacklistInfoDto;
import com.sooying.pay.app.api.service.blacklist.CityBlacklistInfoService;
import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 地市黑名单
 * 
 * @Description CityBlacklistInfoController
 * @author liurh
 * @date 2018年8月3日
 */
@Controller
public class CityBlacklistInfoController {
    private static Logger logger = LoggerFactory.getLogger(CityBlacklistInfoController.class);

    @Resource
    CityBlacklistInfoService cityBlacklistInfoService;

    /**
     * 获取地市黑名单列表
     *
     * @param cityBlacklistInfoDto
     * @return
     */
    @RequestMapping(value = "/blacklist/getCityBlacklistInfoList.json", method = { RequestMethod.GET })
    @ResponseBody
    public String getCityBlacklistInfoList(CityBlacklistInfoDto cityBlacklistInfoDto) {
        logger.info("CityBlacklistInfoController getCityBlacklistInfoList 获取地市黑名单列表");

        try {
            return cityBlacklistInfoService.getCityBlacklistInfoList(cityBlacklistInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("获取地市黑名单列表，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("CityBlacklistInfoController 获取地市黑名单列表异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 修改地市黑名单
     *
     * @param cityBlacklistInfoDto
     * @return
     */
    @RequestMapping(value = "/blacklist/modifyCityBlacklistInfo.json", method = { RequestMethod.POST })
    @ResponseBody
    public String modifyCityBlacklistInfo(CityBlacklistInfoDto cityBlacklistInfoDto) {
        logger.info("CityBlacklistInfoController modifyCityBlacklistInfo 修改地市黑名单");

        try {
            return cityBlacklistInfoService.modifyCityBlacklistInfo(cityBlacklistInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("CityBlacklistInfoController 修改地市黑名单，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("CityBlacklistInfoController 修改地市黑名单异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 删除地市黑名单
     *
     * @param cityBlacklistInfoDto
     * @return
     */
    @RequestMapping(value = "/blacklist/removeCityBlacklistInfo.json", method = { RequestMethod.POST })
    @ResponseBody
    public String removeCityBlacklistInfo(CityBlacklistInfoDto cityBlacklistInfoDto) {
        logger.info("CityBlacklistInfoController removeCityBlacklistInfo 删除地市黑名单");

        try {
            return cityBlacklistInfoService.removeCityBlacklistInfo(cityBlacklistInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("CityBlacklistInfoController 删除地市黑名单，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("CityBlacklistInfoController 删除地市黑名单异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 修改地市黑名单激活状态
     *
     * @param cityBlacklistInfoDto
     * @return
     */
    @RequestMapping(value = "/blacklist/modifyCityBlacklistInfoStatus.json", method = { RequestMethod.POST })
    @ResponseBody
    public String modifyCityBlacklistInfoStatus(CityBlacklistInfoDto cityBlacklistInfoDto) {
        logger.info("CityBlacklistInfoController modifyCityBlacklistInfoStatus 修改地市黑名单激活状态");

        try {
            return cityBlacklistInfoService.modifyCityBlacklistInfoStatus(cityBlacklistInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("CityBlacklistInfoController 修改地市黑名单激活状态，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("CityBlacklistInfoController 修改地市黑名单激活状态异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 新增地市黑名单
     *
     * @param cityBlacklistInfoDto
     * @return
     */
    @RequestMapping(value = "/blacklist/addCityBlacklistInfo.json", method = { RequestMethod.POST })
    @ResponseBody
    public String addCityBlacklistInfo(CityBlacklistInfoDto cityBlacklistInfoDto) {
        logger.info("CityBlacklistInfoController addCityBlacklistInfo 新增地市黑名单");

        try {
            return cityBlacklistInfoService.addCityBlacklistInfo(cityBlacklistInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("CityBlacklistInfoController 新增地市黑名单，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("CityBlacklistInfoController 新增地市黑名单异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }
}
