package com.sooying.pay.app.api.constant;

/**
 * 接口返回枚举类
 * 
 * @Description ApiStatusEnum
 * @author liurh
 * @date 2018年6月4日
 */
public enum ApiStatusEnum {
    API_STATUS_SUCCESS("0", "请求成功"),
    API_STATUS_TOKEN_INVALID("1", "token失效"),
    API_STATUS_FAIL("2", "请求失败");

    private String status;
    private String message;

    private ApiStatusEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
