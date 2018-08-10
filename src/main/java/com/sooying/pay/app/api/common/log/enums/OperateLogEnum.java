package com.sooying.pay.app.api.common.log.enums;

import org.apache.commons.lang.StringUtils;

/**
 * 操作日志枚举
 * 
 * @Description OperateLogEnum
 * @author liurh
 * @date 2018年6月23日
 */
public enum OperateLogEnum {
    DEFAULT("0", "默认"),
    UPDATE("1", "更新"),
    DELETE("2", "删除"),
    INSERT("3", "插入");

    private String code;
    private String type;

    OperateLogEnum(String code, String type) {
        this.code = code;
        this.type = type;
    }

    public static OperateLogEnum getLogTypeEnum(String code) {
        for (OperateLogEnum logTypeEnum : OperateLogEnum.values()) {
            if (StringUtils.equals(code, logTypeEnum.getCode())) {
                return logTypeEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
