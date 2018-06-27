package com.sooying.pay.app.api.controller.grade.dto;

import com.sooying.pay.app.api.common.base.BasePageDto;

/**
 * 通道系数配置
 * 
 * @Description PassagewayCoefInfoDto
 * @author liurh
 * @date 2018年6月15日
 */
public class PassagewayCoefInfoDto extends BasePageDto {
    // 主键ID
    private String id;
    // 通道ID
    private String passagewayId;
    // 运营商
    private String netOperator;
    // 成功率
    private String successRate;
    // 同步率
    private String synchroRate;
    // 结算率
    private String countRate;
    // 资费
    private String price;
    // 固定标志
    private String changeStatus;

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
    public String getSuccessRate() {
        return successRate;
    }

    /**
     * @param successRate
     *            the successRate to set
     */
    public void setSuccessRate(String successRate) {
        this.successRate = successRate;
    }

    /**
     * @return the synchroRate
     */
    public String getSynchroRate() {
        return synchroRate;
    }

    /**
     * @param synchroRate
     *            the synchroRate to set
     */
    public void setSynchroRate(String synchroRate) {
        this.synchroRate = synchroRate;
    }

    /**
     * @return the countRate
     */
    public String getCountRate() {
        return countRate;
    }

    /**
     * @param countRate
     *            the countRate to set
     */
    public void setCountRate(String countRate) {
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
        return "PassagewayCoefInfoDto [id=" + id + ", passagewayId=" + passagewayId + ", netOperator=" + netOperator
                + ", successRate=" + successRate + ", synchroRate=" + synchroRate + ", countRate=" + countRate
                + ", price=" + price + ", changeStatus=" + changeStatus + "]";
    }

}
