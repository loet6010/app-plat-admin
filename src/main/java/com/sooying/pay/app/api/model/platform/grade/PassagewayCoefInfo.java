package com.sooying.pay.app.api.model.platform.grade;

import java.math.BigDecimal;

/**
 * 通道系数配置
 * 
 * @Description PassagewayCoefInfo
 * @author liurh
 * @date 2018年6月15日
 */
public class PassagewayCoefInfo {
    // 主键ID
    private long id;
    // 通道ID
    private String passagewayId;
    // 运营商
    private String netOperator;
    // 成功率
    private BigDecimal successRate;
    // 同步率
    private BigDecimal synchroRate;
    // 结算率
    private BigDecimal countRate;
    // 资费
    private String price;
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
     * @return the successRate
     */
    public BigDecimal getSuccessRate() {
        return successRate;
    }

    /**
     * @param successRate
     *            the successRate to set
     */
    public void setSuccessRate(BigDecimal successRate) {
        this.successRate = successRate;
    }

    /**
     * @return the synchroRate
     */
    public BigDecimal getSynchroRate() {
        return synchroRate;
    }

    /**
     * @param synchroRate
     *            the synchroRate to set
     */
    public void setSynchroRate(BigDecimal synchroRate) {
        this.synchroRate = synchroRate;
    }

    /**
     * @return the countRate
     */
    public BigDecimal getCountRate() {
        return countRate;
    }

    /**
     * @param countRate
     *            the countRate to set
     */
    public void setCountRate(BigDecimal countRate) {
        this.countRate = countRate;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(String price) {
        this.price = price;
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
        return "PassagewayCoefInfo [id=" + id + ", passagewayId=" + passagewayId + ", netOperator=" + netOperator
                + ", successRate=" + successRate + ", synchroRate=" + synchroRate + ", countRate=" + countRate
                + ", price=" + price + ", changeStatus=" + changeStatus + "]";
    }

}
