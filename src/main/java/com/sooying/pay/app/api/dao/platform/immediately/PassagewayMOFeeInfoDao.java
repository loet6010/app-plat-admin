package com.sooying.pay.app.api.dao.platform.immediately;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.sooying.pay.app.api.model.platform.immediately.PassagewayMOFeeInfo;

/**
 * @Description PassagewayMOFeeInfoDao
 * @author liurh
 * @date 2018年7月3日
 */
public interface PassagewayMOFeeInfoDao {

    /**
     * 获取指定省份MO数据
     *
     * @param startDate
     * @param endDate
     * @param passagewayId
     * @param province
     * @return
     */
    PassagewayMOFeeInfo selectDesignateProvinceMOData(@Param("startDate") Date startDate,
            @Param("endDate") Date endDate, @Param("passagewayId") String passagewayId,
            @Param("province") String province);

    /**
     * 获取默认省份MO数据
     *
     * @param startDate
     * @param endDate
     * @param passagewayId
     * @return
     */
    PassagewayMOFeeInfo selectDefaultProvinceMOData(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("passagewayId") String passagewayId);

    /**
     * 获取通道成功MO
     *
     * @param startDate
     * @param endDate
     * @param passagewayId
     * @return
     */
    PassagewayMOFeeInfo selectPassagewaySuccessMO(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("passagewayId") String passagewayId);

    /**
     * 获取指定省份信息费数据
     *
     * @param startDate
     * @param endDate
     * @param passagewayId
     * @param province
     * @return
     */
    PassagewayMOFeeInfo selectDesignateProvinceFeeData(@Param("startDate") Date startDate,
            @Param("endDate") Date endDate, @Param("passagewayId") String passagewayId,
            @Param("province") String province);

    /**
     * 获取通道昨天MO
     *
     * @param startDate
     * @param endDate
     * @param passagewayId
     * @return
     */
    PassagewayMOFeeInfo selectPassagewayYesterdayMO(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("passagewayId") String passagewayId);

    /**
     * 获取通道同步信息费
     *
     * @param startDate
     * @param endDate
     * @param passagewayId
     * @return
     */
    PassagewayMOFeeInfo selectPassagewaySynFee(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("passagewayId") String passagewayId);

    /**
     * 获取通道昨天同步信息费
     *
     * @param passagewayId
     * @return
     */
    PassagewayMOFeeInfo selectPassagewayYesterdaySynFee(@Param("passagewayId") String passagewayId);
}
