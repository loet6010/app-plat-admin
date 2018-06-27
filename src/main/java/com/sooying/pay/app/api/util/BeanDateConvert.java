package com.sooying.pay.app.api.util;

import com.google.common.base.Strings;
import com.sooying.pay.app.api.common.constant.Constants;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换类
 * 
 * @Description DateConvert
 * @author liurh
 * @date 2018年6月12日
 */
public class BeanDateConvert implements Converter {

    /**
     * Convert the specified input object into an output object of the specified
     * type.
     *
     * @param type
     *            Data type to which this value should be converted
     * @param value
     *            The input value to be converted
     * @return The converted value
     *
     * @exception ConversionException
     *                if conversion cannot be performed successfully
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Object convert(Class type, Object value) {
        if (value == null || Strings.isNullOrEmpty(value.toString())) {
            return null;
        }
        if (value instanceof Date) {
            return value;
        }
        if (value instanceof Long) {
            Long longValue = (Long) value;
            return new Date(longValue.longValue());
        }
        if (value instanceof String) {
            String dateStr = (String) value;
            Date endTime = null;
            try {
                if (dateStr.matches(Constants.DATE_TIME_REGEXP)) {
                    DateFormat sdf = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
                    endTime = sdf.parse(dateStr);
                    return endTime;
                } else if (dateStr.matches(Constants.DATE_REGEXP)) {
                    DateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);
                    endTime = sdf.parse(dateStr);
                    return endTime;
                } else {
                    return dateStr;
                }
            } catch (ParseException e) {
                throw new IllegalArgumentException("Bean拷贝日期转换错误：" + e.getMessage());
            }
        }
        return value;
    }
}