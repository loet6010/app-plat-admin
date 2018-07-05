package com.sooying.pay.app.api.dao.platform.immediately;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.sooying.pay.app.api.model.platform.immediately.SynMoPassageDataInfo;

/**
 * @Description MoPassagewayInfoDao
 * @author liurh
 * @date 2018年7月3日
 */
public interface MoPassagewayInfoDao {

    /**
     * 获取时段统计数据
     *
     * @param paramsMap
     * @return
     */
    SynMoPassageDataInfo selectInsertMoInfo(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("passagewayId") String passagewayId, @Param("province") String province);

    SynMoPassageDataInfo selectDefaultInsertMoInfo(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("passagewayId") String passagewayId);

    SynMoPassageDataInfo selectUpdatePassagewayMo(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("passagewayId") String passagewayId);

    SynMoPassageDataInfo selectUpdateInformation(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("passagewayId") String passagewayId, @Param("province") String province);

    SynMoPassageDataInfo selectUpdatePassagewayYesterdayMo(@Param("startDate") Date startDate,
            @Param("endDate") Date endDate, @Param("passagewayId") String passagewayId);

    SynMoPassageDataInfo selectUpdateInformationP1(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("passagewayId") String passagewayId);

    SynMoPassageDataInfo selectUpdateInformationYesterP1(@Param("passagewayId") String passagewayId);
}
