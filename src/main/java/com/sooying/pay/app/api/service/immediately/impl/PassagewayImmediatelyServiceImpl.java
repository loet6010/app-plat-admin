package com.sooying.pay.app.api.service.immediately.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bench.common.lang.DateUtils;
import com.bench.common.lang.ObjectUtils;
import com.bench.common.lang.StringUtils;
import com.sooying.pay.app.api.common.enums.ProvinceEnum;
import com.sooying.pay.app.api.dao.platform.grade.ConfigureInfoDao;
import com.sooying.pay.app.api.dao.platform.grade.PassagewayCoefInfoDao;
import com.sooying.pay.app.api.dao.platform.grade.PassagewayGradeInfoDao;
import com.sooying.pay.app.api.dao.platform.immediately.PassagewayMOFeeInfoDao;
import com.sooying.pay.app.api.dao.platform.note.NoteInfoDao;
import com.sooying.pay.app.api.dao.platform.rule.RuleInfoDao;
import com.sooying.pay.app.api.model.platform.grade.ConfigureInfo;
import com.sooying.pay.app.api.model.platform.grade.PassagewayCoefInfo;
import com.sooying.pay.app.api.model.platform.grade.PassagewayGradeInfo;
import com.sooying.pay.app.api.model.platform.immediately.PassagewayMOFeeInfo;
import com.sooying.pay.app.api.model.platform.note.NoteInfo;
import com.sooying.pay.app.api.model.platform.rule.RuleInfo;
import com.sooying.pay.app.api.service.immediately.PassagewayImmediatelyService;
import com.sooying.pay.app.api.service.immediately.enums.NetInfoStatusEnum;
import com.sooying.pay.app.api.service.immediately.enums.RedisCashTypeEnum;
import com.sooying.pay.app.api.util.DateUtil;
import com.sooying.pay.app.api.util.PriorityUtil;

/**
 * 通道立即生效
 * 
 * @Description PassagewayImmediatelyServiceImpl
 * @author liurh
 * @date 2018年7月3日
 */
@Service("passagewayImmediatelyService")
public class PassagewayImmediatelyServiceImpl implements PassagewayImmediatelyService {
    private final static Logger logger = LoggerFactory.getLogger(PassagewayImmediatelyServiceImpl.class);

    private final static String DEFAULT_PROVINCE_NAME = "DEFAULT";

    // 异步线程池
    private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(15);

    @Resource
    NoteInfoDao noteInfoDao;
    @Resource
    PassagewayGradeInfoDao passagewayGradeInfoDao;
    @Resource
    PassagewayCoefInfoDao passagewayCoefInfoDao;
    @Resource
    RuleInfoDao ruleInfoDao;
    @Resource
    ConfigureInfoDao configureInfoDao;
    @Resource
    PassagewayMOFeeInfoDao passagewayMOFeeInfoDao;

    /**
     * 刷新通道分级系数数据
     *
     * @param passagewayId
     * @param type
     */
    @Override
    public void setRedisCash(String passagewayId, String type) {
        // 获取短信明细
        NoteInfo noteInfo = noteInfoDao.selectNoteInfoByPassagewayId(passagewayId);

        // 短信明细不存在时不做处理
        if (noteInfo == null) {
            logger.info("Immediately_redis noteInfo not exist, passagewayId is {}, type is {}", passagewayId, type);
            return;
        }

        // 获取通道系数配置
        PassagewayCoefInfo passagewayCoefInfo = passagewayCoefInfoDao
                .selectPassagewayCoefInfoByPassagewayId(passagewayId);
        // 获取通道常量配置
        ConfigureInfo configureInfo = configureInfoDao.selectConfigureInfo();

        logger.info("Immediately_redis noteInfo exist, passagewayId is {}, status is {}, type is {}", passagewayId,
                noteInfo.getStatus(), type);

        if (RedisCashTypeEnum.REDIS_CASH_TYPE_ENUM0.getStatus().equals(type)) {
            // 激活修改操作
            setNoteInfoForRedis(noteInfo, passagewayCoefInfo, configureInfo);
        } else if (RedisCashTypeEnum.REDIS_CASH_TYPE_ENUM1.getStatus().equals(type)) {
            /* 修改通道系数操作 */

            // 获取通道即时生效过滤规则
            RuleInfo ruleInfo = ruleInfoDao.selectImmediatelyRuleInfoByPassagewayId(passagewayId);
            String ruleVal = (ruleInfo != null) ? ruleInfo.getRuleValue() : null;

            logger.info(
                    "Immediately_redis passagewayCoefInfo passagewayId is {}, status is {}, sdk_status is {}, type is {}",
                    passagewayId, noteInfo.getStatus(), noteInfo.getSdkStatus(), type);

            // 通道系数配置存在，且短信明细和SDK都为激活状态，刷新通道分级系数数据
            if (passagewayCoefInfo != null && NetInfoStatusEnum.NET_INFO_ENABLE.getStatus().equals(noteInfo.getStatus())
                    && NetInfoStatusEnum.NET_INFO_ENABLE.getStatus().equals(noteInfo.getSdkStatus())) {
                addPassagewayCoefInfoRedisAsync(noteInfo, ruleVal, passagewayCoefInfo, configureInfo);
            }

            // 通道系数配置不存在，删除通道分级系数数据
            if (passagewayCoefInfo == null) {
                removePassagewayCoefInfoRedis(passagewayId);
            }
        }

    }

    /**
     * 激活修改操作
     *
     * @param noteInfo
     * @param passagewayCoefInfo
     * @param configureInfo
     */
    private void setNoteInfoForRedis(NoteInfo noteInfo, PassagewayCoefInfo passagewayCoefInfo,
            ConfigureInfo configureInfo) {
        // 获取通道即时生效过滤规则
        RuleInfo ruleInfo = ruleInfoDao.selectImmediatelyRuleInfoByPassagewayId(noteInfo.getPassagewayId());
        String ruleVal = (ruleInfo != null) ? ruleInfo.getRuleValue() : null;

        logger.info("Immediately_redis noteInfo passagewayId is {}, status is {}, sdk_status {}",
                noteInfo.getPassagewayId(), noteInfo.getStatus(), noteInfo.getSdkStatus());

        // 短信明细和SDK都为激活状态，进行数据处理
        if (NetInfoStatusEnum.NET_INFO_ENABLE.getStatus().equals(noteInfo.getStatus())
                && NetInfoStatusEnum.NET_INFO_ENABLE.getStatus().equals(noteInfo.getSdkStatus())) {
            // 通道系数存在，刷新通道分级系数数据
            if (passagewayCoefInfo != null) {
                addPassagewayCoefInfoRedisAsync(noteInfo, ruleVal, passagewayCoefInfo, configureInfo);
            } else {
                logger.info("Immediately_redis passagewayCoefInfo is not exist");
            }
        } else {
            // 短信明细或SDK为失效状态，删除通道分级系数数据
            removePassagewayCoefInfoRedis(noteInfo.getPassagewayId());
        }
    }

    /**
     * 删除通道分级系数数据
     *
     * @param passagewayId
     */
    private void removePassagewayCoefInfoRedis(String passagewayId) {
        logger.info("PassagewayImmediatelyServiceImpl removePassagewayCoefInfoRedis 开始执行：passagewayId is {}",
                passagewayId);

        passagewayGradeInfoDao.batchDeletePassageWayGradeInfo(passagewayId);

        logger.info("PassagewayImmediatelyServiceImpl removePassagewayCoefInfoRedis 结束执行");
    }

    /**
     * 异步刷新通道分级系数数据
     *
     * @param noteInfo
     * @param ruleVal
     * @param passagewayCoefInfo
     * @param configureInfo
     */
    private void addPassagewayCoefInfoRedisAsync(final NoteInfo noteInfo, final String ruleVal,
            final PassagewayCoefInfo passagewayCoefInfo, final ConfigureInfo configureInfo) {
        logger.info("PassagewayImmediatelyServiceImpl addPassagewayCoefInfoRedisAsync 启动异步请求");

        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                addPassagewayCoefInfoRedis(noteInfo, ruleVal, passagewayCoefInfo, configureInfo);
            }
        });
    }

    /**
     * 刷新通道分级系数数据
     *
     * @param noteInfo
     * @param ruleVal
     * @param passagewayCoefInfo
     * @param configureInfo
     */
    private void addPassagewayCoefInfoRedis(NoteInfo noteInfo, String ruleVal, PassagewayCoefInfo passagewayCoefInfo,
            ConfigureInfo configureInfo) {
        logger.info("PassagewayImmediatelyServiceImpl addPassagewayCoefInfoRedis 开始执行：passagewayId is {}",
                noteInfo.getPassagewayId());
        // 初始化分级系数数据列表
        List<PassagewayGradeInfo> insertList = new ArrayList<PassagewayGradeInfo>();

        // 循环每个省份
        for (String province : getProvinceList()) {
            ProvinceEnum provinceEnum = null;
            try {
                provinceEnum = ProvinceEnum.valueOf(province);
            } catch (Exception ignored) {
            }

            // 省份不存在，且又不是默认省份时，不做处理
            if (provinceEnum == null && !DEFAULT_PROVINCE_NAME.equals(province)) {
                continue;
            }

            // 开发地区不为空，且省份存在，但是匹配不到省份时，不做处理
            if (!StringUtils.isEmpty(ruleVal) && provinceEnum != null && !ruleVal.contains(provinceEnum.getName())) {
                continue;
            }

            // 获取单个省份的分级系数数据
            PassagewayGradeInfo passagewayGradeInfo = getPassagewayGradeInfo(passagewayCoefInfo, province,
                    configureInfo);
            if (passagewayGradeInfo != null) {
                insertList.add(passagewayGradeInfo);
            }
        }

        // 分级系数数据列表不为空时，批量插入数据库
        if (!CollectionUtils.isEmpty(insertList)) {
            // 删除通道分级系数数据
            removePassagewayCoefInfoRedis(noteInfo.getPassagewayId());

            logger.info("Immediately_redis batchInsertPassageWayGradeInfo insertList is {}",
                    ObjectUtils.toString(insertList));
            // 批量插入通道分级系数数据
            passagewayGradeInfoDao.batchInsertPassageWayGradeInfo(insertList);
        }

        logger.info("PassagewayImmediatelyServiceImpl addPassagewayCoefInfoRedis 结束执行");
    }

    /**
     * 获取单个省份的分级系数数据
     *
     * @param passagewayCoefInfo
     * @param province
     * @param configureInfo
     * @return
     */
    private PassagewayGradeInfo getPassagewayGradeInfo(PassagewayCoefInfo passagewayCoefInfo, String province,
            ConfigureInfo configureInfo) {
        PassagewayGradeInfo passagewayGradeInfo = new PassagewayGradeInfo();
        if ("0".equals(passagewayCoefInfo.getChangeStatus())) {
            passagewayGradeInfo.setPriorityNumber(PriorityUtil.getPriorityNumberData(passagewayCoefInfo));
        } else {
            BigDecimal priorityNumberData = getPriorityNumberData(getEndDate(), configureInfo.getIntervalMinute(),
                    configureInfo.getDepth(), configureInfo.getUserConfirmCount(), province, passagewayCoefInfo);

            if (priorityNumberData == null) {
                priorityNumberData = PriorityUtil.getPriorityNumberData(passagewayCoefInfo);
            }

            if (priorityNumberData.doubleValue() < 1 / 1000.0f) {
                priorityNumberData = PriorityUtil.getPriorityNumber(passagewayCoefInfo.getSynchroRate());
            }

            passagewayGradeInfo.setPriorityNumber(priorityNumberData);
        }
        if (passagewayGradeInfo.getPriorityNumber() == null
                || passagewayGradeInfo.getPriorityNumber().doubleValue() < 1 / 1000.0f) {
            passagewayGradeInfo.setPriorityNumber(PriorityUtil.getPriorityNumber(passagewayCoefInfo.getSynchroRate()));
        }

        passagewayGradeInfo.setProvince(province);
        passagewayGradeInfo.setNetOperator(passagewayCoefInfo.getNetOperator());
        passagewayGradeInfo.setChangeStatus(passagewayCoefInfo.getChangeStatus());
        passagewayGradeInfo.setPassagewayId(passagewayCoefInfo.getPassagewayId());
        passagewayGradeInfo.setPrice(Integer.parseInt(passagewayCoefInfo.getPrice()));

        return passagewayGradeInfo;
    }

    /**
     * 获取优先级系数
     *
     * @param end
     * @param intervalMinutes
     * @param depth
     * @param userThreshold
     * @param provinceEnumName
     * @param passagewayCoefInfo
     * @return
     */
    private BigDecimal getPriorityNumberData(Date end, long intervalMinutes, long depth, long userThreshold,
            String provinceEnumName, PassagewayCoefInfo passagewayCoefInfo) {
        // 默认省份取固定值
        if (DEFAULT_PROVINCE_NAME.equals(provinceEnumName)) {
            Date start = DateUtils.addMinutes(end, -depth * intervalMinutes);
            PassagewayMOFeeInfo defaultPassageData = passagewayMOFeeInfoDao.selectDefaultProvinceMOData(start, end,
                    passagewayCoefInfo.getPassagewayId());
            // 默认取通道深度最长的信息信息费
            if (defaultPassageData != null) {
                defaultPassageData.setPostage(Integer.parseInt(passagewayCoefInfo.getPrice()));
                PassagewayMOFeeInfo defaultMo = passagewayMOFeeInfoDao.selectPassagewaySuccessMO(start, end,
                        passagewayCoefInfo.getPassagewayId());
                // 只有不为空才有意义 假如通道mo（passageway_suc_mo）和通道信息费(sp_information_fee)大于0
                if (defaultMo != null && defaultMo.getPassagewaySucMo() > 0) {
                    defaultPassageData.setPassagewaySucMo(defaultMo.getPassagewaySucMo());
                    PassagewayMOFeeInfo defaultMr = passagewayMOFeeInfoDao.selectPassagewaySynFee(start, end,
                            passagewayCoefInfo.getPassagewayId());
                    if (defaultMr != null) {
                        defaultPassageData.setSpInformationFee(defaultMr.getSpInformationFee());
                    }
                }

                return PriorityUtil.getPriorityNumberData(defaultPassageData, (int) userThreshold, "",
                        passagewayCoefInfo);
            }
            return null;
        }

        String province = "";
        try {
            ProvinceEnum provinceEnum = ProvinceEnum.valueOf(provinceEnumName);
            province = provinceEnum.getName();
        } catch (Exception ignored) {
        }

        // 根据paytask通道分级系数算法计算
        int step = 1;
        Date start = DateUtils.addMinutes(end, -step * intervalMinutes);
        PassagewayMOFeeInfo tructMoPassageData = passagewayMOFeeInfoDao.selectDesignateProvinceMOData(start, end,
                passagewayCoefInfo.getPassagewayId(), province);
        boolean checkYesterday = true;
        Date successStart;
        // 根据深度进行轮询
        while (step < depth) {
            if (tructMoPassageData != null && tructMoPassageData.getTotalUserNum() >= userThreshold) {
                checkYesterday = false;
                break;
            }
            step++;
            successStart = DateUtils.addMinutes(end, -step * intervalMinutes);
            tructMoPassageData = passagewayMOFeeInfoDao.selectDesignateProvinceMOData(successStart, end,
                    passagewayCoefInfo.getPassagewayId(), province);
        }

        if (tructMoPassageData != null && tructMoPassageData.getTotalUserNum() >= userThreshold) {
            checkYesterday = false;
        }

        // 其他逻辑
        if (checkYesterday) {
            successStart = DateUtils.addDays(end, -1);
            PassagewayMOFeeInfo todaySynMo = passagewayMOFeeInfoDao.selectDesignateProvinceMOData(successStart, end,
                    passagewayCoefInfo.getPassagewayId(), province);
            if (todaySynMo != null) {
                tructMoPassageData = todaySynMo;
            }
        }

        if (tructMoPassageData != null) {
            start = DateUtils.addMinutes(end, -depth * intervalMinutes);
            PassagewayMOFeeInfo passagewayMo = passagewayMOFeeInfoDao.selectPassagewaySuccessMO(start, end,
                    passagewayCoefInfo.getPassagewayId());
            // 通道MO和通道信息费大于0
            if (passagewayMo != null && passagewayMo.getPassagewaySucMo() > 0) {
                tructMoPassageData.setPassagewaySucMo(passagewayMo.getPassagewaySucMo());
                PassagewayMOFeeInfo passagewayMr = passagewayMOFeeInfoDao.selectPassagewaySynFee(start, end,
                        passagewayCoefInfo.getPassagewayId());
                if (passagewayMr != null)
                    tructMoPassageData.setSpInformationFee(passagewayMr.getSpInformationFee());
            } else {
                Date yesterdayEnd = getCurrentDayStart();
                Date yesterdayStart = DateUtils.addDays(yesterdayEnd, -1);
                PassagewayMOFeeInfo yearMo = passagewayMOFeeInfoDao.selectPassagewayYesterdayMO(yesterdayStart,
                        yesterdayEnd, passagewayCoefInfo.getPassagewayId());
                // 假如昨天mo(yester_mo)和昨天信息费(sp_yester_informationfee)大于0
                if (yearMo != null && yearMo.getYesterMo() > 0) {
                    tructMoPassageData.setYesterMo(yearMo.getYesterMo());
                    PassagewayMOFeeInfo yearMr = passagewayMOFeeInfoDao
                            .selectPassagewayYesterdaySynFee(passagewayCoefInfo.getPassagewayId());
                    if (yearMr != null)
                        tructMoPassageData.setSpYesterInformationfee(yearMr.getSpYesterInformationfee());
                }
            }
            // 假如分省信息费（sp_province_informationfee）和分省mo（suc_mo）大于0
            if (tructMoPassageData.getSucMo() > 0) {
                PassagewayMOFeeInfo provinceMr = passagewayMOFeeInfoDao.selectDesignateProvinceFeeData(start, end,
                        passagewayCoefInfo.getPassagewayId(), province);
                if (provinceMr != null && StringUtils.isNotBlank(provinceMr.getProvince())
                        && provinceMr.getProvince().equals(province))
                    tructMoPassageData.setSpProvinceInformationfee(provinceMr.getSpProvinceInformationfee());
            }
            tructMoPassageData.setPostage(Integer.parseInt(passagewayCoefInfo.getPrice()));
        }
        if (tructMoPassageData == null)
            return null;

        return PriorityUtil.getPriorityNumberData(tructMoPassageData, (int) userThreshold, "", passagewayCoefInfo);

    }

    /**
     * 获取省份列表
     *
     * @return
     */
    private static List<String> getProvinceList() {
        List<String> provinceList = new ArrayList<String>();
        for (ProvinceEnum provinceEnum : ProvinceEnum.values()) {
            if (provinceEnum == ProvinceEnum.HONG_KONG || provinceEnum == ProvinceEnum.TAI_WAN
                    || provinceEnum == ProvinceEnum.AO_MEN) {
                continue;
            }
            provinceList.add(ObjectUtils.toString(provinceEnum));
        }
        if (!provinceList.contains(DEFAULT_PROVINCE_NAME)) {
            provinceList.add(DEFAULT_PROVINCE_NAME);
        }
        return provinceList;
    }

    /**
     * 获取结束时间
     *
     * @return
     */
    private static Date getEndDate() {
        Date date = new Date();
        String curDateStr = DateUtil.convertDate2String(date, DateUtil.LONG_DATE_FORMAT_MINUTE) + ":00";

        return DateUtil.convertString2Date(curDateStr, DateUtil.LONG_DATE_FORMAT);
    }

    /**
     * 获取当前开始时间
     *
     * @return
     */
    private static Date getCurrentDayStart() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

}
