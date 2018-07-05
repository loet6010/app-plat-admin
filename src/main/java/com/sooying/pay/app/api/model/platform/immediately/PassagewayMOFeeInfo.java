package com.sooying.pay.app.api.model.platform.immediately;

import com.bench.common.lang.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 通道MO同步信息费
 * 
 * @Description PassagewayMOFeeInfo
 * @author liurh
 * @date 2018年7月4日
 */
public class PassagewayMOFeeInfo {
    // 主键ID
    private long id;
    // 省份
    private String province;
    // 运营商
    private String netType;
    // 通道id
    private String passagewayId;
    // 资费
    private int postage;
    // 成功mo
    private int sucMo;
    // 总用户数
    private int totalUserNum;
    // 成功用户数
    private int sucUserNum;
    // 昨天的通道mo
    private int yesterMo;
    // 通道成功mo
    private int passagewaySucMo;
    // 通道分省信息费
    private int spProvinceInformationfee;
    // 通道信息费
    private int spInformationFee;
    // 昨天的信息费
    private int spYesterInformationfee;
    // 预估结算率
    private BigDecimal budgetSettlementRate;
    // 优先级系数
    private BigDecimal prorityNumber;
    // 状态
    private String changeStatus;
    // 昨天分省份,分通道,分运营商,分资费的成功用户数
    private int yesterSucUserNum;
    // 昨天分省份,分通道,分运营商,分资费的确认用户数
    private int yesterTotalUserNum;
    // 创建时间
    private Date createTime;
    // 开始时间
    private Date startTime;
    // 结束时间
    private Date endTime;

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
     * @return the netType
     */
    public String getNetType() {
        return netType;
    }

    /**
     * @param netType
     *            the netType to set
     */
    public void setNetType(String netType) {
        this.netType = netType;
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
     * @return the postage
     */
    public int getPostage() {
        return postage;
    }

    /**
     * @param postage
     *            the postage to set
     */
    public void setPostage(int postage) {
        this.postage = postage;
    }

    /**
     * @return the sucMo
     */
    public int getSucMo() {
        return sucMo;
    }

    /**
     * @param sucMo
     *            the sucMo to set
     */
    public void setSucMo(int sucMo) {
        this.sucMo = sucMo;
    }

    /**
     * @return the totalUserNum
     */
    public int getTotalUserNum() {
        return totalUserNum;
    }

    /**
     * @param totalUserNum
     *            the totalUserNum to set
     */
    public void setTotalUserNum(int totalUserNum) {
        this.totalUserNum = totalUserNum;
    }

    /**
     * @return the sucUserNum
     */
    public int getSucUserNum() {
        return sucUserNum;
    }

    /**
     * @param sucUserNum
     *            the sucUserNum to set
     */
    public void setSucUserNum(int sucUserNum) {
        this.sucUserNum = sucUserNum;
    }

    /**
     * @return the yesterMo
     */
    public int getYesterMo() {
        return yesterMo;
    }

    /**
     * @param yesterMo
     *            the yesterMo to set
     */
    public void setYesterMo(int yesterMo) {
        this.yesterMo = yesterMo;
    }

    /**
     * @return the passagewaySucMo
     */
    public int getPassagewaySucMo() {
        return passagewaySucMo;
    }

    /**
     * @param passagewaySucMo
     *            the passagewaySucMo to set
     */
    public void setPassagewaySucMo(int passagewaySucMo) {
        this.passagewaySucMo = passagewaySucMo;
    }

    /**
     * @return the spProvinceInformationfee
     */
    public int getSpProvinceInformationfee() {
        return spProvinceInformationfee;
    }

    /**
     * @param spProvinceInformationfee
     *            the spProvinceInformationfee to set
     */
    public void setSpProvinceInformationfee(int spProvinceInformationfee) {
        this.spProvinceInformationfee = spProvinceInformationfee;
    }

    /**
     * @return the spInformationFee
     */
    public int getSpInformationFee() {
        return spInformationFee;
    }

    /**
     * @param spInformationFee
     *            the spInformationFee to set
     */
    public void setSpInformationFee(int spInformationFee) {
        this.spInformationFee = spInformationFee;
    }

    /**
     * @return the spYesterInformationfee
     */
    public int getSpYesterInformationfee() {
        return spYesterInformationfee;
    }

    /**
     * @param spYesterInformationfee
     *            the spYesterInformationfee to set
     */
    public void setSpYesterInformationfee(int spYesterInformationfee) {
        this.spYesterInformationfee = spYesterInformationfee;
    }

    /**
     * @return the budgetSettlementRate
     */
    public BigDecimal getBudgetSettlementRate() {
        return budgetSettlementRate;
    }

    /**
     * @param budgetSettlementRate
     *            the budgetSettlementRate to set
     */
    public void setBudgetSettlementRate(BigDecimal budgetSettlementRate) {
        this.budgetSettlementRate = budgetSettlementRate;
    }

    /**
     * @return the prorityNumber
     */
    public BigDecimal getProrityNumber() {
        return prorityNumber;
    }

    /**
     * @param prorityNumber
     *            the prorityNumber to set
     */
    public void setProrityNumber(BigDecimal prorityNumber) {
        this.prorityNumber = prorityNumber;
    }

    /**
     * @return the changeStatus
     */
    public String getChangeStatus() {
        return changeStatus;
    }

    /**
     * @param changeStatus
     *            the changeStatus to set
     */
    public void setChangeStatus(String changeStatus) {
        this.changeStatus = changeStatus;
    }

    /**
     * @return the yesterSucUserNum
     */
    public int getYesterSucUserNum() {
        return yesterSucUserNum;
    }

    /**
     * @param yesterSucUserNum
     *            the yesterSucUserNum to set
     */
    public void setYesterSucUserNum(int yesterSucUserNum) {
        this.yesterSucUserNum = yesterSucUserNum;
    }

    /**
     * @return the yesterTotalUserNum
     */
    public int getYesterTotalUserNum() {
        return yesterTotalUserNum;
    }

    /**
     * @param yesterTotalUserNum
     *            the yesterTotalUserNum to set
     */
    public void setYesterTotalUserNum(int yesterTotalUserNum) {
        this.yesterTotalUserNum = yesterTotalUserNum;
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
     * @return the startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     *            the startTime to set
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     *            the endTime to set
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
