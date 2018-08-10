package com.sooying.pay.app.api.service.immediately.enums;

import org.apache.commons.lang.StringUtils;

/**
 * 激活状态枚举
 *
 * @Description NetInfoStatusEnum
 * @author liurh
 * @date 2018年7月3日
 */
public enum NetInfoStatusEnum {
	 NET_INFO_ENABLE("1", "状态激活"),
	 NET_INFO_DISABLE("0", "状态失效");

    private String status;
    private String desc;

    NetInfoStatusEnum(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static NetInfoStatusEnum getNetInfoStatusEnumByStatus(String status) {
        for (NetInfoStatusEnum netInfoStatusEnum : NetInfoStatusEnum.values()) {
            if (StringUtils.equals(status, netInfoStatusEnum.getStatus())) {
                return netInfoStatusEnum;
            }
        }

        return null;
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
