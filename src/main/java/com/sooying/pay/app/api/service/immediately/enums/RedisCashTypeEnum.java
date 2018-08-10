package com.sooying.pay.app.api.service.immediately.enums;

/**
 * 通道即时生效枚举
 * 
 * @Description RedisCashTypeEnum
 * @author liurh
 * @date 2018年7月3日
 */
public enum RedisCashTypeEnum {
    REDIS_CASH_TYPE_ENUM0("0", "短信明细激活关闭操作"),
    REDIS_CASH_TYPE_ENUM1("1", "修改通道系数"),
    REDIS_CASH_TYPE_ENUM2("2", "修改过滤规则");

    private String status;
    private String desc;

    RedisCashTypeEnum(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
