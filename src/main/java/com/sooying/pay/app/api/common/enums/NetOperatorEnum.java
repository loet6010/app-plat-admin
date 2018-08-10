package com.sooying.pay.app.api.common.enums;

/**
 * 运营商枚举类型
 * 
 * @Description NetOperatorEnum
 * @author liurh
 * @date 2018年8月2日
 */
public enum NetOperatorEnum {
    MOBILE("MOBILE","移动"),
    UNICOM("UNICOM","联通"),
    TELECOM("TELECOM","电信");
    
    private String code;
    private String name;

    NetOperatorEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
    
    /**
     * 获取运营商名称
     *
     * @param code
     * @return
     */
    public static String getNameByCode(String code) {
        for (NetOperatorEnum netOperatorEnum : NetOperatorEnum.values()) {
            if (netOperatorEnum.getCode().equals(code)) {
                return netOperatorEnum.getName();
            }
        }
        return null;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
