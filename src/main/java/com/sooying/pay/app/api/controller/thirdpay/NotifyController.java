package com.sooying.pay.app.api.controller.thirdpay;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.app.api.model.thirdpay.OrderInfo;
import com.sooying.pay.app.api.service.thirdpay.OrderInfoService;

/**
 * 
 * @Description NotifyController
 * @author liurh
 * @date 2018年2月26日
 */
@Controller
public class NotifyController {
	private static Logger logger = LoggerFactory.getLogger(NotifyController.class);
	private static final String LOG_INFO = "微信支付回调，";
	private static final String SUCCESS = "OK";

	/********支付状态**********/
    public final static Integer PAY_STATUS_0 = 0;//支付失败
    public final static Integer PAY_STATUS_1 = 1;//支付成功
    public final static Integer PAY_STATUS_2 = 2;//未支付
    
	@Resource
	private OrderInfoService orderInfoService;

	@RequestMapping(value = "/weChatCallBack.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String weChatCallBack(HttpServletRequest request, HttpServletResponse responset)
			throws UnsupportedEncodingException {
		try {
			logger.info(LOG_INFO + "请求进入回调接口！");
			// 获取请求参数
			String sign = request.getParameter("sign");
			logger.info(LOG_INFO + "参数sign：" + sign);
			String param = request.getParameter("param");
			logger.info(LOG_INFO + "参数param：" + param);

			// 参数分割
			String[] paramArrry = param.split("\\|");
			if (paramArrry.length < 3) {
				logger.info(LOG_INFO + "参数切分错误！");
				logger.info(LOG_INFO + "param：" + param);
				return "fail:param wrong";
			}
			// 订单号
			String orderCode = paramArrry[0];
			// 状态码
			String statusCode = paramArrry[1];

			// 根据订单号查询订单
			OrderInfo orderInfo = orderInfoService.queryOrderInfoByOrderCode(orderCode);
			if (orderInfo == null) {
				logger.info(LOG_INFO + "找不到订单号：" + orderCode);
				return "fail:cant find this po_num in db";
			}

			// 订单已处理
			if (PAY_STATUS_1.equals(orderInfo.getPayState())) {
				logger.info(LOG_INFO + "订单已处理成功，订单号" + orderCode);
				return SUCCESS;
			}

			// 订单未处理且回调状态为成功，更新数据库
			if ("0000".equalsIgnoreCase(statusCode)) {
			    orderInfo.setPayState(PAY_STATUS_1);

				// 更新订单状态
				orderInfoService.modifyOrderInfo(orderInfo);
				logger.info(LOG_INFO + "订单处理成功，订单号：" + orderCode);

				return SUCCESS;
			} else {
			    orderInfo.setPayState(PAY_STATUS_0);
				orderInfoService.modifyOrderInfo(orderInfo);
				logger.info(LOG_INFO + "支付失败，订单号：" + orderCode + "支付状态：" + statusCode);
				return SUCCESS;
			}
		} catch (Exception e) {
			logger.info(LOG_INFO + "处理异常：" + e.getMessage());
			return "fail";
		}
	}
}
