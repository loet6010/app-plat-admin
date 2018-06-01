package com.sooying.pay.app.api.controller.datainput;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.app.api.base.ResultBase;
import com.sooying.pay.app.api.model.datainput.TXDataInfo;
import com.sooying.pay.app.api.service.datainput.TXDataService;

@Controller
public class TXDataController {
    private static Logger logger = LoggerFactory.getLogger(TXDataController.class);

    /******** 支付状态 **********/
    public final static String STATUS_OK = "ok";
    public final static String STATUS_FAIL = "fail:";

    @Resource
    private TXDataService tXDataService;

    @RequestMapping(value = "/synTXData.json", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String synTXData(@RequestParam String spid, @RequestParam String orderid, @RequestParam String addtime,
            @RequestParam String endtime, @RequestParam String userid, @RequestParam String price,
            @RequestParam String paytype, @RequestParam String status, HttpServletRequest request)
            throws UnsupportedEncodingException {
        try {
            if (StringUtils.isEmpty(spid) || StringUtils.isEmpty(orderid) || StringUtils.isEmpty(userid) || StringUtils.isEmpty(status)) {
                return STATUS_FAIL + "spid,orderid,userid and status can not be empty!";
            }
            
            if (!NumberUtils.isNumber(price) || !NumberUtils.isNumber(paytype)) {
                return STATUS_FAIL + "price and paytype must by number!";
            }
            
            SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            TXDataInfo txDataInfo = new TXDataInfo();
            txDataInfo.setSpId(spid);
            txDataInfo.setOrderId(orderid);
            txDataInfo.setAddTime(sFormat.parse(addtime));
            txDataInfo.setEndTime(sFormat.parse(endtime));
            txDataInfo.setUserId(userid);
            txDataInfo.setPrice(Integer.parseInt(price));
            txDataInfo.setPayType(Integer.parseInt(paytype));
            txDataInfo.setStatus(status);

            ResultBase resultBase = tXDataService.addTXData(txDataInfo);

            if (resultBase.isSuccess()) {
                return STATUS_OK;
            } else {
                return STATUS_FAIL + resultBase.getDetailMessage();
            }
        } catch (Exception e) {
            logger.info("synTXData处理异常：" + e.getMessage());
            
            return STATUS_FAIL + e.getMessage();
        }
    }
}
