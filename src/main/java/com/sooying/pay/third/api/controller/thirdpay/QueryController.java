package com.sooying.pay.third.api.controller.thirdpay;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.third.api.model.thirdpay.OrderInfo;
import com.sooying.pay.third.api.service.thirdpay.OrderInfoService;

/**
 * 
 * @Description QueryController
 * @author liurh
 * @date 2018年2月26日
 */
@Controller
public class QueryController {
    private static Logger logger = LoggerFactory.getLogger(QueryController.class);
    private static final String LOG_INFO = "微信支付查询，";

    /******** 支付状态 **********/
    public final static Integer PAY_STATUS_0 = 0;// 支付失败
    public final static Integer PAY_STATUS_1 = 1;// 支付成功
    public final static Integer PAY_STATUS_2 = 2;// 未支付

    @Resource
    private OrderInfoService orderInfoService;

    @RequestMapping(value = "/queryResult.do", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Integer weChatCallBack(@RequestParam String orderCode, HttpServletRequest request)
            throws UnsupportedEncodingException {
        try {
            logger.info(LOG_INFO + "支付结果查询接口！");

            // 根据订单号查询订单
            OrderInfo orderInfo = orderInfoService.queryOrderInfoByOrderCode(orderCode);
            if (orderInfo == null) {
                logger.info(LOG_INFO + "找不到订单号：" + orderCode);
                return PAY_STATUS_2;
            }

            // 订单已处理
            return orderInfo.getPayState();
            
        } catch (Exception e) {
            logger.info(LOG_INFO + "处理异常：" + e.getMessage());
            return PAY_STATUS_0;
        }
    }
}
