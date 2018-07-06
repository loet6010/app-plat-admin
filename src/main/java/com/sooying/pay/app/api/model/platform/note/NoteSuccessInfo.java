package com.sooying.pay.app.api.model.platform.note;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringStyle;

import com.bench.common.lang.ToStringBuilder;

/**
 * 成功后相关信息
 * 
 * @Description NoteSuccessInfo
 * @author liurh
 * @date 2018年7月6日
 */
public class NoteSuccessInfo {
    // 主键DI
    private long id;
    // 通道ID
    private String passagewayId;
    // 省份
    private String province;
    // 下行号码
    private String downlinkNumber;
    // 下行关键字
    private String downlinkKeyword;
    // 创建时间
    private Date createTime;
    // 修改时间
    private Date modifyTime;

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
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     *            the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the downlinkNumber
     */
    public String getDownlinkNumber() {
        return downlinkNumber;
    }

    /**
     * @param downlinkNumber
     *            the downlinkNumber to set
     */
    public void setDownlinkNumber(String downlinkNumber) {
        this.downlinkNumber = downlinkNumber;
    }

    /**
     * @return the downlinkKeyword
     */
    public String getDownlinkKeyword() {
        return downlinkKeyword;
    }

    /**
     * @param downlinkKeyword
     *            the downlinkKeyword to set
     */
    public void setDownlinkKeyword(String downlinkKeyword) {
        this.downlinkKeyword = downlinkKeyword;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     *            the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     *            the modifyTime to set
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
