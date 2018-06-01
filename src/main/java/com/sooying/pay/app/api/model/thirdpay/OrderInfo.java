package com.sooying.pay.app.api.model.thirdpay;

import java.util.Date;

/**
 * @Description:订单信息
 *
 * @author caimiao
 */
public class OrderInfo {
    private Integer orderId;
    private String activateCode;
    private String orderCode;
    private Double payAmt;
    private Double userPayAmt;
    private String userIp;
    private String userOs;
    private String payPlatform;
    private String payCode;
    private String platformTransid;
    private Date createTime;
    private Date payTime;
    private String goodsName;
    private Integer goodsNum;
    private Integer payState;
    private String remark;
    private String goodsNote;
    private String payFailReason;
    private String appCode;
    private String chlCode;
    private String model;
    private String province;

    private String outerAppCode;
    private String outerChannelId;
    private String outerImsi;
    private String outerImei;
    private Integer outerScreenWidth;
    private Integer outerScreenHeight;
    private String outerAppVersion;
    private String outerAppVersionName;
    private String outerSdkVersion;
    private String outerModel;
    private String outerManufacturer;
    private String outerOrderId;
    private String outerReturnUrl;

    private String payType;
    private String returnSts;
    private String outerBackUrl;
    private String sdkSts;
    private String sdkPayType;

    private String versionNo;
    private String payVersion;
    private String sdkNo;
    private String channelNo;
    private Integer monthPayState;

    private String tel;

    private String openId;
    private String tokenId;

    /**
     * @return the orderId
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     *            the orderId to set
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the activateCode
     */
    public String getActivateCode() {
        return activateCode;
    }

    /**
     * @param activateCode
     *            the activateCode to set
     */
    public void setActivateCode(String activateCode) {
        this.activateCode = activateCode;
    }

    /**
     * @return the orderCode
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * @param orderCode
     *            the orderCode to set
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * @return the payAmt
     */
    public Double getPayAmt() {
        return payAmt;
    }

    /**
     * @param payAmt
     *            the payAmt to set
     */
    public void setPayAmt(Double payAmt) {
        this.payAmt = payAmt;
    }

    /**
     * @return the userPayAmt
     */
    public Double getUserPayAmt() {
        return userPayAmt;
    }

    /**
     * @param userPayAmt
     *            the userPayAmt to set
     */
    public void setUserPayAmt(Double userPayAmt) {
        this.userPayAmt = userPayAmt;
    }

    /**
     * @return the userIp
     */
    public String getUserIp() {
        return userIp;
    }

    /**
     * @param userIp
     *            the userIp to set
     */
    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    /**
     * @return the userOs
     */
    public String getUserOs() {
        return userOs;
    }

    /**
     * @param userOs
     *            the userOs to set
     */
    public void setUserOs(String userOs) {
        this.userOs = userOs;
    }

    /**
     * @return the payPlatform
     */
    public String getPayPlatform() {
        return payPlatform;
    }

    /**
     * @param payPlatform
     *            the payPlatform to set
     */
    public void setPayPlatform(String payPlatform) {
        this.payPlatform = payPlatform;
    }

    /**
     * @return the payCode
     */
    public String getPayCode() {
        return payCode;
    }

    /**
     * @param payCode
     *            the payCode to set
     */
    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    /**
     * @return the platformTransid
     */
    public String getPlatformTransid() {
        return platformTransid;
    }

    /**
     * @param platformTransid
     *            the platformTransid to set
     */
    public void setPlatformTransid(String platformTransid) {
        this.platformTransid = platformTransid;
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
     * @return the payTime
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * @param payTime
     *            the payTime to set
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * @return the goodsName
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * @param goodsName
     *            the goodsName to set
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * @return the goodsNum
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * @param goodsNum
     *            the goodsNum to set
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * @return the payState
     */
    public Integer getPayState() {
        return payState;
    }

    /**
     * @param payState
     *            the payState to set
     */
    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     *            the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the goodsNote
     */
    public String getGoodsNote() {
        return goodsNote;
    }

    /**
     * @param goodsNote
     *            the goodsNote to set
     */
    public void setGoodsNote(String goodsNote) {
        this.goodsNote = goodsNote;
    }

    /**
     * @return the payFailReason
     */
    public String getPayFailReason() {
        return payFailReason;
    }

    /**
     * @param payFailReason
     *            the payFailReason to set
     */
    public void setPayFailReason(String payFailReason) {
        this.payFailReason = payFailReason;
    }

    /**
     * @return the appCode
     */
    public String getAppCode() {
        return appCode;
    }

    /**
     * @param appCode
     *            the appCode to set
     */
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    /**
     * @return the chlCode
     */
    public String getChlCode() {
        return chlCode;
    }

    /**
     * @param chlCode
     *            the chlCode to set
     */
    public void setChlCode(String chlCode) {
        this.chlCode = chlCode;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model
     *            the model to set
     */
    public void setModel(String model) {
        this.model = model;
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
     * @return the outerAppCode
     */
    public String getOuterAppCode() {
        return outerAppCode;
    }

    /**
     * @param outerAppCode
     *            the outerAppCode to set
     */
    public void setOuterAppCode(String outerAppCode) {
        this.outerAppCode = outerAppCode;
    }

    /**
     * @return the outerChannelId
     */
    public String getOuterChannelId() {
        return outerChannelId;
    }

    /**
     * @param outerChannelId
     *            the outerChannelId to set
     */
    public void setOuterChannelId(String outerChannelId) {
        this.outerChannelId = outerChannelId;
    }

    /**
     * @return the outerImsi
     */
    public String getOuterImsi() {
        return outerImsi;
    }

    /**
     * @param outerImsi
     *            the outerImsi to set
     */
    public void setOuterImsi(String outerImsi) {
        this.outerImsi = outerImsi;
    }

    /**
     * @return the outerImei
     */
    public String getOuterImei() {
        return outerImei;
    }

    /**
     * @param outerImei
     *            the outerImei to set
     */
    public void setOuterImei(String outerImei) {
        this.outerImei = outerImei;
    }

    /**
     * @return the outerScreenWidth
     */
    public Integer getOuterScreenWidth() {
        return outerScreenWidth;
    }

    /**
     * @param outerScreenWidth
     *            the outerScreenWidth to set
     */
    public void setOuterScreenWidth(Integer outerScreenWidth) {
        this.outerScreenWidth = outerScreenWidth;
    }

    /**
     * @return the outerScreenHeight
     */
    public Integer getOuterScreenHeight() {
        return outerScreenHeight;
    }

    /**
     * @param outerScreenHeight
     *            the outerScreenHeight to set
     */
    public void setOuterScreenHeight(Integer outerScreenHeight) {
        this.outerScreenHeight = outerScreenHeight;
    }

    /**
     * @return the outerAppVersion
     */
    public String getOuterAppVersion() {
        return outerAppVersion;
    }

    /**
     * @param outerAppVersion
     *            the outerAppVersion to set
     */
    public void setOuterAppVersion(String outerAppVersion) {
        this.outerAppVersion = outerAppVersion;
    }

    /**
     * @return the outerAppVersionName
     */
    public String getOuterAppVersionName() {
        return outerAppVersionName;
    }

    /**
     * @param outerAppVersionName
     *            the outerAppVersionName to set
     */
    public void setOuterAppVersionName(String outerAppVersionName) {
        this.outerAppVersionName = outerAppVersionName;
    }

    /**
     * @return the outerSdkVersion
     */
    public String getOuterSdkVersion() {
        return outerSdkVersion;
    }

    /**
     * @param outerSdkVersion
     *            the outerSdkVersion to set
     */
    public void setOuterSdkVersion(String outerSdkVersion) {
        this.outerSdkVersion = outerSdkVersion;
    }

    /**
     * @return the outerModel
     */
    public String getOuterModel() {
        return outerModel;
    }

    /**
     * @param outerModel
     *            the outerModel to set
     */
    public void setOuterModel(String outerModel) {
        this.outerModel = outerModel;
    }

    /**
     * @return the outerManufacturer
     */
    public String getOuterManufacturer() {
        return outerManufacturer;
    }

    /**
     * @param outerManufacturer
     *            the outerManufacturer to set
     */
    public void setOuterManufacturer(String outerManufacturer) {
        this.outerManufacturer = outerManufacturer;
    }

    /**
     * @return the outerOrderId
     */
    public String getOuterOrderId() {
        return outerOrderId;
    }

    /**
     * @param outerOrderId
     *            the outerOrderId to set
     */
    public void setOuterOrderId(String outerOrderId) {
        this.outerOrderId = outerOrderId;
    }

    /**
     * @return the outerReturnUrl
     */
    public String getOuterReturnUrl() {
        return outerReturnUrl;
    }

    /**
     * @param outerReturnUrl
     *            the outerReturnUrl to set
     */
    public void setOuterReturnUrl(String outerReturnUrl) {
        this.outerReturnUrl = outerReturnUrl;
    }

    /**
     * @return the payType
     */
    public String getPayType() {
        return payType;
    }

    /**
     * @param payType
     *            the payType to set
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * @return the returnSts
     */
    public String getReturnSts() {
        return returnSts;
    }

    /**
     * @param returnSts
     *            the returnSts to set
     */
    public void setReturnSts(String returnSts) {
        this.returnSts = returnSts;
    }

    /**
     * @return the outerBackUrl
     */
    public String getOuterBackUrl() {
        return outerBackUrl;
    }

    /**
     * @param outerBackUrl
     *            the outerBackUrl to set
     */
    public void setOuterBackUrl(String outerBackUrl) {
        this.outerBackUrl = outerBackUrl;
    }

    /**
     * @return the sdkSts
     */
    public String getSdkSts() {
        return sdkSts;
    }

    /**
     * @param sdkSts
     *            the sdkSts to set
     */
    public void setSdkSts(String sdkSts) {
        this.sdkSts = sdkSts;
    }

    /**
     * @return the sdkPayType
     */
    public String getSdkPayType() {
        return sdkPayType;
    }

    /**
     * @param sdkPayType
     *            the sdkPayType to set
     */
    public void setSdkPayType(String sdkPayType) {
        this.sdkPayType = sdkPayType;
    }

    /**
     * @return the versionNo
     */
    public String getVersionNo() {
        return versionNo;
    }

    /**
     * @param versionNo
     *            the versionNo to set
     */
    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    /**
     * @return the payVersion
     */
    public String getPayVersion() {
        return payVersion;
    }

    /**
     * @param payVersion
     *            the payVersion to set
     */
    public void setPayVersion(String payVersion) {
        this.payVersion = payVersion;
    }

    /**
     * @return the sdkNo
     */
    public String getSdkNo() {
        return sdkNo;
    }

    /**
     * @param sdkNo
     *            the sdkNo to set
     */
    public void setSdkNo(String sdkNo) {
        this.sdkNo = sdkNo;
    }

    /**
     * @return the channelNo
     */
    public String getChannelNo() {
        return channelNo;
    }

    /**
     * @param channelNo
     *            the channelNo to set
     */
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    /**
     * @return the monthPayState
     */
    public Integer getMonthPayState() {
        return monthPayState;
    }

    /**
     * @param monthPayState
     *            the monthPayState to set
     */
    public void setMonthPayState(Integer monthPayState) {
        this.monthPayState = monthPayState;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     *            the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId
     *            the openId to set
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * @return the tokenId
     */
    public String getTokenId() {
        return tokenId;
    }

    /**
     * @param tokenId
     *            the tokenId to set
     */
    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

}
