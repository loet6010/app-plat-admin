package com.sooying.pay.app.api.controller.grade.dto;

import com.sooying.pay.app.api.common.base.BasePageDto;

/**
 * 通道分级系数数据
 * 
 * @Description PassagewayGradeInfoDto
 * @author liurh
 * @date 2018年6月14日
 */
public class PassagewayGradeInfoDto extends BasePageDto {
    // 通道ID
    private String passagewayId;
    // 省份
    private String province;
    // 资费
    private String price;
    // 运营商
    private String netOperator;

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
     *
     * @return
     */
    @Override
    public String toString() {
        super.toString();
        return "PassagewayGradeInfoDto [passagewayId=" + passagewayId + ", province=" + province + ", price=" + price
                + ", netOperator=" + netOperator + "]";
    }
}
