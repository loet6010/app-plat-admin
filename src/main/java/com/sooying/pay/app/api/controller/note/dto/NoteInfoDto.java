package com.sooying.pay.app.api.controller.note.dto;

import org.apache.commons.lang.builder.ToStringStyle;

import com.bench.common.lang.ToStringBuilder;
import com.sooying.pay.app.api.common.base.BasePageDto;

/**
 * 短信明细dto
 * 
 * @Description NoteInfoDto
 * @author liurh
 * @date 2018年6月5日
 */
public class NoteInfoDto extends BasePageDto {
    // 主键ID
    private String id;
    // 通道ID
    private String passagewayId;
    // 激活状态
    private String status;
    // SDK激活状态
    private String sdkStatus;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the passagewayId
     */
    public String getPassagewayId() {
        return passagewayId;
    }

    /**
     * @param passagewayId
     *            the passagewayId to set
     */
    public void setPassagewayId(String passagewayId) {
        this.passagewayId = passagewayId;
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
     * @return the sdkStatus
     */
    public String getSdkStatus() {
        return sdkStatus;
    }

    /**
     * @param sdkStatus
     *            the sdkStatus to set
     */
    public void setSdkStatus(String sdkStatus) {
        this.sdkStatus = sdkStatus;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
