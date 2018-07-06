package com.sooying.pay.app.api.common.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 省份枚举信息
 * 
 * @Description ProvinceEnum
 * @author liurh
 * @date 2018年6月14日
 */
public enum ProvinceEnum {
    BEI_JING("北京", 1),
    SHANG_HAI("上海", 2),
    TIAN_JIN("天津", 3),
    CHONG_QING("重庆", 4),
    SI_CHUAN("四川", 5),
    GUI_ZHOU("贵州", 6),
    GUANG_DONG("广东", 7),
    ZHE_JIANG("浙江", 8),
    FU_JIAN("福建", 9),
    HU_NAN("湖南", 10),
    HU_BEI("湖北", 11),
    SHAN_DONG("山东", 12),
    SHAN_XI_2("山西", 13),
    HE_NAN("河南", 14),
    HE_BEI("河北", 15),
    JI_LING("吉林", 16),
    LIAO_NING("辽宁", 17),
    HEI_LONG_JIANG("黑龙江", 18),
    AN_HUI("安徽", 19),
    JIANG_SU("江苏", 20),
    JIANG_XI("江西", 21),
    HAI_NAN("海南", 22),
    SHAN_XI("陕西", 23),
    YUN_NAN("云南", 24),
    QING_HAI("青海", 25),
    NING_XIA("宁夏", 26),
    GAN_SU("甘肃", 27),
    XIN_JIANG("新疆", 28),
    XI_ZANG("西藏", 29),
    GUANG_XI("广西", 30),
    NEI_MENG_GU("内蒙古", 31),
    HONG_KONG("香港", 32),
    AO_MEN("澳门", 33),
    TAI_WAN("台湾", 34),
    DEFAULT("默认", 35);

    private String name;
    private int code;

    private ProvinceEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }

    /**
     * 获取字符串中的省份list
     *
     * @param value
     * @return
     */
    public static List<String> getProvinceList(String value) {
        List<String> provinceList = new ArrayList<String>();

        if (value == null) {
            return provinceList;
        }

        for (ProvinceEnum provinceEnum : ProvinceEnum.values()) {
            if (value.contains(provinceEnum.getName())) {
                provinceList.add(provinceEnum.getName());
            }
        }

        return provinceList;
    }
    
    /**
     * 获取省份枚举名称
     *
     * @param code
     * @return
     */
    public static String getEnumNameByCode(int code) {
        for (ProvinceEnum provinceEnum : ProvinceEnum.values()) {
            if (provinceEnum.getCode() == code) {
                return provinceEnum.toString();
            }
        }
        return null;
    }
    
    /**
     * 获取省份名称
     *
     * @param enumName
     * @return
     */
    public static String getNameByEnumName(String enumName) {
        for (ProvinceEnum provinceEnum : ProvinceEnum.values()) {
            if (provinceEnum.toString().equals(enumName)) {
                return provinceEnum.getName();
            }
        }
        return null;
    }
    
    /**
     * 根据枚举名获取省份枚举
     *
     * @param provinceEnumName
     * @return
     */
    public static ProvinceEnum getByProvinceEnum(String provinceEnumName) {
        for (ProvinceEnum provinceEnum : ProvinceEnum.values()) {
            if (provinceEnum.toString().contains(provinceEnumName)) {
                return provinceEnum;
            }
        }
        return null;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

}
