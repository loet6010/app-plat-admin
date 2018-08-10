package com.sooying.pay.app.api.dao.platform.database;

import java.util.List;
import java.util.Map;

import com.sooying.pay.app.api.model.platform.database.OverallDataInfo;
import com.sooying.pay.app.api.model.platform.database.OverallFeeInfo;
import com.sooying.pay.app.api.model.platform.database.ProvinceSuccessRateInfo;
import com.sooying.pay.app.api.model.platform.database.ResultErrorInfo;
import com.sooying.pay.app.api.model.platform.database.SuccessRateInfo;

/**
 * Platform数据库查询
 * 
 * @Description QueryPlatformDao
 * @author liurh
 * @date 2018年6月19日
 */
public interface QueryPlatformDao {

    /**
     * 查询支付结果表大盘数据
     *
     * @param paramsMap
     * @return
     */
    OverallDataInfo selectOverallDataInfo(Map<String, Object> paramsMap);

    /**
     * 查询代码成功率数量
     *
     * @param paramsMap
     * @return
     */
    int selectSuccessRateInfoCount(Map<String, Object> paramsMap);

    /**
     * 查询代码成功率列表
     *
     * @param paramsMap
     * @return
     */
    List<SuccessRateInfo> selectSuccessRateInfoList(Map<String, Object> paramsMap);

    /**
     * 查询分时段代码成功率数量
     *
     * @param paramsMap
     * @return
     */
    int selectTimeFrameSuccessRateInfoCount(Map<String, Object> paramsMap);

    /**
     * 查询分时段代码成功率列表
     *
     * @param paramsMap
     * @return
     */
    List<SuccessRateInfo> selectTimeFrameSuccessRateInfoList(Map<String, Object> paramsMap);

    /**
     * 查询代码分省份成功率数量
     *
     * @param paramsMap
     * @return
     */
    int selectProvinceSuccessRateInfoCount(Map<String, Object> paramsMap);

    /**
     * 查询代码分省份成功率列表
     *
     * @param paramsMap
     * @return
     */
    List<ProvinceSuccessRateInfo> selectProvinceSuccessRateInfoList(Map<String, Object> paramsMap);

    /**
     * 查询大盘同步信息费数量
     *
     * @param paramsMap
     * @return
     */
    int selectOverallFeeInfoCount(Map<String, Object> paramsMap);

    /**
     * 查询大盘同步信息费列表
     *
     * @param paramsMap
     * @return
     */
    List<OverallFeeInfo> selectOverallFeeInfoList(Map<String, Object> paramsMap);
    
    /**
     * 查询错误码占比数量
     *
     * @param paramsMap
     * @return
     */
    int selectResultErrorInfoCount(Map<String, Object> paramsMap);

    /**
     * 查询错误码占比列表
     *
     * @param paramsMap
     * @return
     */
    List<ResultErrorInfo> selectResultErrorInfoList(Map<String, Object> paramsMap);
}
