package com.sooying.pay.app.api.util;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sooying.pay.app.api.common.constant.Constants;
import com.sooying.pay.app.api.common.enums.ApiStatusEnum;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 请求返回工具类
 * 
 * @Description ResultReturnUtil
 * @author liurh
 * @date 2018年6月4日
 */
public class ResultReturnUtil {
    private final static Logger logger = LoggerFactory.getLogger(ResultReturnUtil.class);

    /**
     * 构造方法私有，禁止实例化
     * 
     * @throws InstantiationException
     */
    private ResultReturnUtil() throws InstantiationException {
        throw new InstantiationException();
    }

    /**
     * 获取处理成功返回内容
     *
     * @param msg
     * @return
     */
    public static String getSuccessString(String msg) {
        return getResultString(ApiStatusEnum.API_STATUS_SUCCESS.getStatus(), msg);
    }

    /**
     * 获取返回内容
     *
     * @param resultStatus
     * @param message
     * @return
     */
    public static String getResultString(String resultStatus, String message) {
        return getResultString(resultStatus, message, null);
    }

    /**
     * 获取返回内容
     *
     * @param resultStatus
     * @param message
     * @param dataList
     * @return
     */
    public static String getResultString(String resultStatus, String message, List<Object> dataList) {
        String returnString = null;

        JSONObject json = new JSONObject();
        json.put("resultStatus", resultStatus);
        json.put("message", message);

        if (dataList != null) {
            JSONArray jsonArray = JSONArray.fromObject(dataList);
            json.put("dataList", jsonArray);
        }

        try {
            byte[] encrypted = json.toString().getBytes(Constants.UTF8);
            returnString = new String(Base64.encodeBase64(encrypted));
        } catch (Exception e) {
            logger.info("ResultReturnUtil getResultString Exception:" + e);

            returnString = getExceptionString();
        }

        return returnString;
    }
    
    /**
     * 接口异常返回信息
     *
     * @param msg
     * @return
     */
    public static String getExceptionString(String msg) {
        return getResultString(ApiStatusEnum.API_STATUS_FAIL.getStatus(),msg);
    }
    
    /**
     * 接口异常返回信息
     *
     * @return
     */
    private static String getExceptionString() {
        return "eyJtZXNzYWdlIjoiQVBJIEV4Y2VwdGlvbiIsInJlc3VsdFN0YXR1cyI6IjIifQ==";
    }
}
