package com.sooying.pay.app.api.model.platform.note;

/**
 * 短信明细
 * 
 * @Description NoteInfo
 * @author liurh
 * @date 2018年6月5日
 */
public class NoteInfo {
    // 主键ID
    private long id;
    // 通道ID
    private String passagewayId;
    // 通道名称
    private String passagewayName;
    // 代码类型
    private String codeType;
    // 激活状态
    private String status;
    // SDK激活状态
    private String sdkStatus;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id) {
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
     * @return the passagewayName
     */
    public String getPassagewayName() {
        return passagewayName;
    }

    /**
     * @param passagewayName
     *            the passagewayName to set
     */
    public void setPassagewayName(String passagewayName) {
        this.passagewayName = passagewayName;
    }

    /**
     * @return the codeType
     */
    public String getCodeType() {
        return codeType;
    }

    /**
     * @param codeType
     *            the codeType to set
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
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
        return "NoteInfo [id=" + id + ", passagewayId=" + passagewayId + ", passagewayName=" + passagewayName
                + ", codeType=" + codeType + ", status=" + status + ", sdkStatus=" + sdkStatus + "]";
    }
}
