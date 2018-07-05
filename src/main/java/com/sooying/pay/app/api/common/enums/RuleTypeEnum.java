package com.sooying.pay.app.api.common.enums;

/**
 * 规则类型枚举
 * 
 * @Description RuleTypeEnum
 * @author liurh
 * @date 2018年6月11日
 */
public enum RuleTypeEnum {
    DAY_LIMITED("DAY_LIMITED", "日限量"),
    MONTH_LIMITED("MONTH_LIMITED", "月限量"),
    SHIELD_DATE("SHIELD_DATE", "屏蔽时间"),
    SHIELD_AREA("SHIELD_AREA", "日开放地区"),
    PROVINCE_DAY_LIMITED("PROVINCE_DAY_LIMITED", "日省份日限量"),
    PROVINCE_MONTH_LIMITED("PROVINCE_MONTH_LIMITED", "日省份日限量");

    private String type;
    private String name;

    private RuleTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
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
