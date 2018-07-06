package com.sooying.pay.app.api.model.platform.grade;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringStyle;

import com.bench.common.lang.ToStringBuilder;

/**
 * 通道分级系数数据
 * 
 * @Description PassagewayGradeInfo
 * @author liurh
 * @date 2018年6月14日
 */
public class PassagewayGradeInfo {
    // 主键ID
    private long id;
    // 通道ID
    private String passagewayId;
    // 省份
    private String province;
    // 资费
    private int price;
    // 运营商
    private String netOperator;
    // 优先级系数
    private BigDecimal priorityNumber;
    // 固定标志
    private String changeStatus;

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
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the netOperator
     */
    public String getNetOperator() {
        return netOperator;
    }

    /**
     * @param netOperator
     *            the netOperator to set
     */
    public void setNetOperator(String netOperator) {
        this.netOperator = netOperator;
    }

    /**
     * @return the priorityNumber
     */
    public BigDecimal getPriorityNumber() {
        return priorityNumber;
    }

    /**
     * @param priorityNumber
     *            the priorityNumber to set
     */
    public void setPriorityNumber(BigDecimal priorityNumber) {
        this.priorityNumber = priorityNumber;
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
     *
     * @return
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
