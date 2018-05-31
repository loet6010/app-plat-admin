package com.sooying.pay.app.api.controller.thirdpay;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sooying.pay.app.api.base.Response;
import com.sooying.pay.app.api.util.CommUtil;
import com.sooying.pay.app.api.util.Config;
import com.sooying.pay.app.api.util.HttpKit;
import com.sooying.pay.app.api.util.IpUtils;
import com.sooying.pay.app.api.util.MD5SignUtil;
import com.sooying.pay.app.api.util.ReqGetPayParam;

/**
 * @Description PayController
 * @author liurh
 * @date 2018年2月26日
 */
@Controller
@RequestMapping(value = "/pay")
public class PayController {
    private static Logger logger = LoggerFactory.getLogger(PayController.class);

    @RequestMapping(value = "/payorder.do")
    @ResponseBody
    public Response<Map<String, String>> payOrder(@RequestParam String orderCode, @RequestParam Double payAmt,
            @RequestParam String goodsName, @RequestParam String ipAddr, @RequestParam String userId,
            @RequestParam String channelType, String mobile, String imei, String userName, String mac, String notifyUrl,
            HttpServletRequest request) throws Exception {
        Response<Map<String, String>> response = new Response<Map<String, String>>();
        response.start();
        long startTime = new Date().getTime();
        if (StringUtils.isBlank(orderCode) || StringUtils.isBlank(ipAddr) || null == payAmt || 0 == payAmt) {
            response.setMsg("参数输入错误");
            return response.endAndFailed();
        }

        ReqGetPayParam param = new ReqGetPayParam();
        // String orderCode = CommUtil.getCurrentTimeStamp();
        param.setComp_id(Config.COMP_ID); // 商户编号
        param.setProd_id(Config.PROD_ID); // 产品编号
        param.setPo_num(orderCode); // 商户订单号，商户系统生成的唯一编号
        param.setVersion("1.0"); // 接口版本，固定值 1.0
        param.setSourceType("H5"); // 来源，默认 H5
        // notify_url
        param.setNotify_url(notifyUrl);// 回调商户服务器的 URL，必须是绝对路径的全 URL
        param.setReturn_url("");// 页面通知 URL
        param.setTime_stamp(CommUtil.getCurrentTimeStamp());// 时间戳，格式为“yyyymmddHHMMss”
        JSONObject js = new JSONObject(); // 支付内容，商户根据需求进行传递
        js.put("channelType", channelType);// 支付类型
        js.put("money", payAmt);// 金额,单位为分
        js.put("body", goodsName);// 商品名称
        js.put("userId", userId);// 用户唯一标识
        js.put("userIp", ipAddr);// 用户客户端请求IP
        js.put("userSourceType", "Android");// 用户来源 Android IOS PC H5 等
        js.put("userTel", mobile);// 用户手机号
        js.put("userName", userName);// 用户名
        js.put("userImei", imei);// 用户客户端imei地址
        js.put("userMac", mac);// 用户客户端Mac地址
        js.put("channelCode", "3"); // 渠道编号,可传 ""
        js.put("serIp", IpUtils.getIpAddr(request));// 服务端IP
        param.setPay_content(js.toString());
        try {
            String reqPayParam = CommUtil.getReqGetPayParam(param);
            String sign = MD5SignUtil.createSign(reqPayParam, Config.KEY);
            String reqParam = "param=" + reqPayParam + "&sign=" + sign;
            logger.info("订单号：" + orderCode + "请求参数：" + reqParam);
            String resParam = HttpKit.post(Config.PAY_URL, reqParam);
            logger.info("订单号：" + orderCode + "返回参数：" + resParam);
            if (!CommUtil.isEmpty(resParam)) {
                JSONObject res_js = JSON.parseObject(resParam);
                if ("0000".equals(res_js.getString("ret_code"))) {
                    JSONObject res_content = res_js.getJSONObject("ret_content");
                    String pay_info = res_content.getString("pay_info");
                    logger.info("订单号：" + orderCode + "支付参数：" + pay_info);
                    response.setReturnUrl(pay_info);
                    return response.success();
                }
                return response.endAndFailed();
            } else {
                /**************** 交互失败 **************/
                String errMsg = "";
                logger.error("生成订单失败:orderCode {{}},startTime {{}},errMsg {{}}", orderCode, startTime, resParam);
                response.setMsg(errMsg);
                return response.endAndFailed();
            }
        } catch (Exception e) {
            logger.error("生成订单失败:orderCode {{}},startTime{{}}：", orderCode, startTime, e);
            response.setMsg(e.getMessage());
            e.printStackTrace();
            return response.endAndFailed();
        }
    }

}
