package com.sooying.pay.app.api.service.rule.enums;

/**
 * 代码类型枚举
 * 
 * @Description CodeTypeEnum
 * @author liurh
 * @date 2018年6月11日
 */
public enum CodeTypeEnum {
    NET_PROXY(100, "NET_PROXY"),
    THIRD_PROXY(200, "THIRD_PROXY"),
    NOTE_PROXY(300, "NOTE_PROXY"),
    HALF_NOTE(1000, "HALF_NOTE");

    private int code;
    private String type;

    CodeTypeEnum(int code, String type) {
        this.code = code;
        this.type = type;
    }

    /**
     * 获取代码类型
     *
     * @param code
     * @return
     */
    public static String getType(int code) {
        for (CodeTypeEnum codeTypeEnum : CodeTypeEnum.values()) {
            if (codeTypeEnum.getCode() == code) {
                return codeTypeEnum.getType();
            }
        }

        return null;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}
