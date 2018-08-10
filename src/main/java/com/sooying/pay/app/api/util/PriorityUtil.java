package com.sooying.pay.app.api.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.bench.common.lang.StringUtils;
import com.sooying.pay.app.api.model.platform.grade.PassagewayCoefInfo;
import com.sooying.pay.app.api.model.platform.immediately.PassagewayMOFeeInfo;

/**
 * 通道系数优先级工具类
 * 
 * @Description PriorityUtil
 * @author liurh
 * @date 2018年7月3日
 */
public class PriorityUtil {

    /**
     * 构造方法私有，禁止实例化
     * 
     * @throws InstantiationException
     */
    private PriorityUtil() throws InstantiationException {
        throw new InstantiationException();
    }

    public static BigDecimal getPriorityNumber(BigDecimal defaultSynRate) {
        BigDecimal prorityNumber = new BigDecimal(1);
        if (defaultSynRate.doubleValue() > 0) {
            prorityNumber = prorityNumber.add(defaultSynRate.divide(new BigDecimal("100"), 4, RoundingMode.HALF_UP));
        }
        prorityNumber = prorityNumber.divide(new BigDecimal("100"));
        return prorityNumber;
    }

    public static BigDecimal getPriorityNumberData(PassagewayCoefInfo configPassageWayCoefInfo) {
        int postageFen = Integer.parseInt(configPassageWayCoefInfo.getPrice());
        int postageYuan = postageFen / 100;
        BigDecimal postageBigDecimal = new BigDecimal(postageYuan);
        BigDecimal sucRate = configPassageWayCoefInfo.getSuccessRate().divide(new BigDecimal("100"));
        BigDecimal synRate = configPassageWayCoefInfo.getSynchroRate().divide(new BigDecimal("100"));
        BigDecimal settlementRate = configPassageWayCoefInfo.getCountRate().divide(new BigDecimal("100"));
        return postageBigDecimal.multiply(sucRate).multiply(synRate).multiply(settlementRate).setScale(4,
                BigDecimal.ROUND_HALF_UP);
    }

    private static BigDecimal getSettlementRate(PassagewayCoefInfo configPassageWayCoefInfo) {
        BigDecimal setRate = new BigDecimal(0.5);
        if (configPassageWayCoefInfo != null
                && configPassageWayCoefInfo.getCountRate().compareTo(new BigDecimal(0)) > 0)
            setRate = configPassageWayCoefInfo.getCountRate().divide(new BigDecimal(100)).setScale(4,
                    BigDecimal.ROUND_HALF_UP);
        return setRate;
    }

    public static BigDecimal getPriorityNumberData(PassagewayMOFeeInfo synMoPassagewayInfo, int userLimit,
            String thirdPartyChannel, PassagewayCoefInfo configPassageWayCoefInfo) {
        int postageFen = synMoPassagewayInfo.getPostage();
        int postageYuan = postageFen / 100;
        BigDecimal postageBigDecimal = new BigDecimal(postageYuan);

        BigDecimal sucRate = getSucRate(synMoPassagewayInfo);
        BigDecimal synRate = getSynRate(synMoPassagewayInfo, userLimit, thirdPartyChannel);
        if (synRate.compareTo(BigDecimal.ZERO) <= 0) {
            synRate = configPassageWayCoefInfo.getSynchroRate().divide(new BigDecimal("100"));
        }
        BigDecimal settlementRate = getSettlementRate(configPassageWayCoefInfo);
        return postageBigDecimal.multiply(sucRate).multiply(synRate).multiply(settlementRate).setScale(3,
                BigDecimal.ROUND_HALF_UP);
    }

    private static BigDecimal getSucRate(PassagewayMOFeeInfo synMoPassagewayInfo) {

        int totalUserNum = synMoPassagewayInfo.getTotalUserNum();
        int sucUserNum = synMoPassagewayInfo.getSucUserNum();

        BigDecimal bigDecimalTotalUserNum = new BigDecimal(totalUserNum);
        BigDecimal sucUserNumBigDecimal = new BigDecimal(sucUserNum);

        if (totalUserNum <= 0) {
            return new BigDecimal(0);
        }
        return sucUserNumBigDecimal.divide(bigDecimalTotalUserNum, 3, BigDecimal.ROUND_HALF_UP);
    }

    private static BigDecimal getSynRate(PassagewayMOFeeInfo synMoPassagewayInfo, int userLimit,
            String thirdPartyChannel) {

        // 如果是第三方,则同步率直接为1
        if (StringUtils.contains(thirdPartyChannel, synMoPassagewayInfo.getPassagewayId())) {
            return new BigDecimal(1);
        }
        // 分省信息费
        int spProvinceInformationfee = synMoPassagewayInfo.getSpProvinceInformationfee();
        // 不分省份信息费
        int spInformationFee = synMoPassagewayInfo.getSpInformationFee();
        // 昨天的信息费
        int spYesterInformationfee = synMoPassagewayInfo.getSpYesterInformationfee();

        // 分省份成功mo
        int provinceSucMo = synMoPassagewayInfo.getSucMo();
        // 昨天的mo
        int yesterMo = synMoPassagewayInfo.getYesterMo();
        // 不分省份的实时mo
        int passagewaySucMo = synMoPassagewayInfo.getPassagewaySucMo();
        // 确认用户数与配置的基数
        int realTimeConfirmUser = synMoPassagewayInfo.getTotalUserNum();
        if (userLimit > 0) {
            // 如果配置的确认用户数比实时计算的确认用户数要大,则优先获取昨天的同步率,然后分省份和不分省份的同步率
            if (realTimeConfirmUser < userLimit) {
                if (yesterMo > 0 && spYesterInformationfee > 0) {
                    return new BigDecimal(spYesterInformationfee).divide(new BigDecimal(yesterMo), 3,
                            BigDecimal.ROUND_HALF_UP);
                } else if (spProvinceInformationfee > 0 && provinceSucMo > 0) {
                    return new BigDecimal(spProvinceInformationfee).divide(new BigDecimal(provinceSucMo), 3,
                            BigDecimal.ROUND_HALF_UP);
                } else if (passagewaySucMo > 0 && spInformationFee > 0) {
                    return new BigDecimal(spInformationFee).divide(new BigDecimal(passagewaySucMo), 3,
                            BigDecimal.ROUND_HALF_UP);
                }
            }
        }
        if (spProvinceInformationfee <= 0 || provinceSucMo <= 0) {
            if (passagewaySucMo > 0 && spInformationFee > 0) {
                return new BigDecimal(spInformationFee).divide(new BigDecimal(passagewaySucMo), 3,
                        BigDecimal.ROUND_HALF_UP);
            } else if (yesterMo > 0 && spYesterInformationfee > 0) {
                return new BigDecimal(spYesterInformationfee).divide(new BigDecimal(yesterMo), 3, BigDecimal.ROUND_HALF_UP);
            }
        } else {
            return new BigDecimal(spProvinceInformationfee).divide(new BigDecimal(provinceSucMo), 3,
                    BigDecimal.ROUND_HALF_UP);
        }
        return new BigDecimal(0);
    }
}
