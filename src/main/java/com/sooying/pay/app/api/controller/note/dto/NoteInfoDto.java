package com.sooying.pay.app.api.controller.note.dto;

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
     *
     * @return
     */
    @Override
    public String toString() {
        super.toString();
        return "NoteInfoDto [id=" + id + ", passagewayId=" + passagewayId + ", status=" + status + "]";
    }

}
