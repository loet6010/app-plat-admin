package com.sooying.pay.third.api.model.datainput;

import java.util.Date;

/**
 * @Description TXDataInfo
 * @author liurh
 * @date 2018年3月30日
 */
public class TXDataInfo {
    private String spId;
    private String orderId;
    private Date addTime;
    private Date endTime;
    private String userId;
    private int price;
    private int payType;
    private String status;

    /**
     * @return the spId
     */
    public String getSpId() {
        return spId;
    }

    /**
     * @param spId
     *            the spId to set
     */
    public void setSpId(String spId) {
        this.spId = spId;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     *            the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the addTime
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * @param addTime
     *            the addTime to set
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
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

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * @return the payType
     */
    public int getPayType() {
        return payType;
    }

    /**
     * @param payType
     *            the payType to set
     */
    public void setPayType(int payType) {
        this.payType = payType;
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
}
