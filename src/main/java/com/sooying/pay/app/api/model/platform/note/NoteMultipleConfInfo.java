package com.sooying.pay.app.api.model.platform.note;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringStyle;

import com.bench.common.lang.ToStringBuilder;

/**
 * 动态二次和多次确认下行信息
 * 
 * @Description NoteMultipleConfInfo
 * @author liurh
 * @date 2018年7月6日
 */
public class NoteMultipleConfInfo {
    // 主键ID
    private long id;
    // 通道ID
    private String passagewayId;
    // 省份
    private String province;
    // 回复号码
    private String replyNumber;
    // 下行关键字
    private String downlinkKeyword;
    // 验证码标识
    private String verifyCodeId;
    // 验证码类型
    private String verifyCodeType;
    // 验证码长度
    private String verifyCodeLength;
    // 验证码前缀
    private String verifyCodePrefix;
    // 验证码后缀
    private String verifyCodePostfix;
    // 验证码步数
    private String verifyCodeStep;
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
     * @return the replyNumber
     */
    public String getReplyNumber() {
        return replyNumber;
    }

    /**
     * @param replyNumber
     *            the replyNumber to set
     */
    public void setReplyNumber(String replyNumber) {
        this.replyNumber = replyNumber;
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
     * @return the verifyCodeId
     */
    public String getVerifyCodeId() {
        return verifyCodeId;
    }

    /**
     * @param verifyCodeId
     *            the verifyCodeId to set
     */
    public void setVerifyCodeId(String verifyCodeId) {
        this.verifyCodeId = verifyCodeId;
    }

    /**
     * @return the verifyCodeType
     */
    public String getVerifyCodeType() {
        return verifyCodeType;
    }

    /**
     * @param verifyCodeType
     *            the verifyCodeType to set
     */
    public void setVerifyCodeType(String verifyCodeType) {
        this.verifyCodeType = verifyCodeType;
    }

    /**
     * @return the verifyCodeLength
     */
    public String getVerifyCodeLength() {
        return verifyCodeLength;
    }

    /**
     * @param verifyCodeLength
     *            the verifyCodeLength to set
     */
    public void setVerifyCodeLength(String verifyCodeLength) {
        this.verifyCodeLength = verifyCodeLength;
    }

    /**
     * @return the verifyCodePrefix
     */
    public String getVerifyCodePrefix() {
        return verifyCodePrefix;
    }

    /**
     * @param verifyCodePrefix
     *            the verifyCodePrefix to set
     */
    public void setVerifyCodePrefix(String verifyCodePrefix) {
        this.verifyCodePrefix = verifyCodePrefix;
    }

    /**
     * @return the verifyCodePostfix
     */
    public String getVerifyCodePostfix() {
        return verifyCodePostfix;
    }

    /**
     * @param verifyCodePostfix
     *            the verifyCodePostfix to set
     */
    public void setVerifyCodePostfix(String verifyCodePostfix) {
        this.verifyCodePostfix = verifyCodePostfix;
    }

    /**
     * @return the verifyCodeStep
     */
    public String getVerifyCodeStep() {
        return verifyCodeStep;
    }

    /**
     * @param verifyCodeStep
     *            the verifyCodeStep to set
     */
    public void setVerifyCodeStep(String verifyCodeStep) {
        this.verifyCodeStep = verifyCodeStep;
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
