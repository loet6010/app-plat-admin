package com.sooying.pay.app.api.log;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sooying.pay.app.api.constant.OperateLogEnum;
import com.sooying.pay.app.api.dao.platform.log.OperateLogInfoDao;
import com.sooying.pay.app.api.model.platform.log.OperateLogInfo;

/**
 * 操作日志
 * 
 * @Description OperateLogAspect
 * @author liurh
 * @date 2018年6月23日
 */
@Aspect
@Component
public class OperateLogAspect {
    private static Logger logger = LoggerFactory.getLogger(OperateLogAspect.class);

    @Resource
    private OperateLogInfoDao operateLogInfoDao;

    private final static String PROJECT_NAME = "手机APP接口平台";
    private final static String PLATFORM_NAME = "app-plat-admin";

    /**
     * 对DAO层的删除操作进行记录
     *
     * @param joinPoint
     */
    @Before("execution(* com.sooying.pay.app.api.dao.*.*.*Dao.delete*(..))")
    public void deleteRecord(JoinPoint joinPoint) {
        logger.info("OperateLogAspect deleteRecord 对{}进行删除记录", joinPoint.getSignature().toString());

        addDataLog(joinPoint, OperateLogEnum.DELETE.getCode(), "删除数据");
    }

    /**
     * 对DAO层的更新操作进行记录
     *
     * @param joinPoint
     */
    @Before("execution(* com.sooying.pay.app.api.dao.*.*.*Dao.update*(..))")
    public void updateRecord(JoinPoint joinPoint) {
        logger.info("OperateLogAspect updateRecord 对{}进行更新记录", joinPoint.getSignature().toString());

        addDataLog(joinPoint, OperateLogEnum.UPDATE.getCode(), "更新数据");
    }

    /**
     * 对DAO层的插入操作进行记录
     *
     * @param joinPoint
     */
    @Before("execution(* com.sooying.pay.app.api.dao.*.*.*Dao.insert*(..))")
    public void insertRecord(JoinPoint joinPoint) {
        boolean isInsertLog = true;
        try {
            isInsertLog = validateIsInsertLog(joinPoint);
        } catch (Exception e) {
            logger.info("OperateLogAspect insertRecord 发生异常：{}", e.getMessage());
        }

        // 过滤插入日志的操作
        if (!isInsertLog) {
            logger.info("OperateLogAspect insertRecord 对{}进行更新记录", joinPoint.getSignature().toString());

            addDataLog(joinPoint, OperateLogEnum.INSERT.getCode(), "插入数据");
        }
    }

    /**
     * 判断是否插入日志操作
     *
     * @param joinPoint
     * @return
     */
    private boolean validateIsInsertLog(JoinPoint joinPoint) {
        boolean isInsertLog = false;
        if (joinPoint != null && joinPoint.getArgs().length > 1 && joinPoint.getArgs()[0] != null) {
            String clazzName = (joinPoint.getArgs()[0]).getClass().getName();
            if ("java.lang.String".equals(clazzName)) {
                String insertName = (String) joinPoint.getArgs()[0];
                if ("insertOperateLog".equals(insertName)) {
                    isInsertLog = true;
                }
            }
        }

        return isInsertLog;
    }

    /**
     * 插入操作日志到数据库
     *
     * @param joinPoint
     * @param type
     * @param remark
     */
    private synchronized void addDataLog(JoinPoint joinPoint, String type, String remark) {
        try {
            OperateLogInfo operateLogInfo = new OperateLogInfo();
            operateLogInfo.setOperator(getLoginName());
            operateLogInfo.setProjectName(PROJECT_NAME);
            operateLogInfo.setPlatformName(PLATFORM_NAME);
            operateLogInfo.setChannel("");
            operateLogInfo.setType(type);
            operateLogInfo.setContent(convertArgsTOString(joinPoint.getArgs()));
            operateLogInfo.setLoginIP(getVisitIP());
            operateLogInfo.setTriggerPoint(joinPoint.getSignature().toString());
            operateLogInfo.setRemark(remark);

            // 操作日志插入到日志表中
            operateLogInfoDao.addOperateLog(operateLogInfo);
        } catch (Exception e) {
            logger.error("LoggingAspect.addDataLog:发生异常", e);
        }
    }

    /**
     * 获取HttpServletRequest
     *
     * @return
     */
    private HttpServletRequest getHttpServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (requestAttributes != null) {
            request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        }

        return request;
    }

    /**
     * 获得当前登陆的用户名
     *
     * @return
     */
    private String getLoginName() {
        HttpServletRequest request = getHttpServletRequest();
        String loginName = request.getParameter("loginName");

        return loginName;
    }

    /**
     * 获取客户端IP
     *
     * @return
     */
    private String getVisitIP() {
        String visitAddr = "";
        
        HttpServletRequest request = getHttpServletRequest();
        if (request == null) {
            visitAddr = "";
        } else if (((HttpServletRequest) request).getHeader("x-forwarded-for") == null) {
            visitAddr = request.getRemoteAddr();
        } else {
            visitAddr = ((HttpServletRequest) request).getHeader("x-forwarded-for");
        }

        return visitAddr;
    }

    /**
     * 将目标方法的所有参数变成string类型返回
     *
     * @param args
     * @return
     */
    private String convertArgsTOString(Object[] args) {
        if (args.length == 0) {
            return "";
        }
        Class<? extends Object> clazz;
        String clazzName;

        StringBuffer stringBuffer = new StringBuffer("{");
        for (Object object : args) {
            if (object != null) {
                clazz = object.getClass();
                clazzName = clazz.getName();

                if ("java.util.ArrayList".equals(clazzName)) {
                    stringBuffer.append(convertListTOString(object));
                } else if ("java.util.HashMap".equals(clazzName)) {
                    stringBuffer.append(convertMapTOString(object));
                } else if (clazzName != null && clazzName.startsWith("com.sooying")) {
                    stringBuffer.append(convertObjectTOString(object));
                } else if ("java.lang.String".equals(clazzName)) {
                    stringBuffer.append(convertStringTOString(object));
                } else {
                    stringBuffer.append(convertBasicsTOString(object));
                }
            } else {
                stringBuffer.append("null");
            }
            stringBuffer.append(";");
        }
        if (args.length > 0) {
            stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        }
        stringBuffer.append("}");

        return stringBuffer.toString();
    }

    /**
     * 将普通对象变成string类型
     *
     * @param object
     * @return
     */
    private String convertObjectTOString(Object object) {
        Class<? extends Object> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Field field;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(clazz.getSimpleName()).append("{");
        for (int i = 0; i < fields.length; i++) {
            field = fields[i];
            field.setAccessible(true);
            stringBuffer.append(field.getName()).append("=");
            if ("java.lang.String".equals(field.getType().getName())) {
                stringBuffer.append("\"");
            }
            try {
                stringBuffer.append(field.get(object));
            } catch (IllegalAccessException e) {
                stringBuffer.append("解析异常");
            }
            if ("java.lang.String".equals(field.getType().getName())) {
                stringBuffer.append("\"");
            }
            stringBuffer.append(", ");
        }
        if (fields.length > 0) {
            stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
        }
        stringBuffer.append("}");

        return stringBuffer.toString();
    }

    /**
     * 将基础类型对象变成string类型
     *
     * @param object
     * @return
     */
    private String convertBasicsTOString(Object object) {
        Class<? extends Object> clazz = object.getClass();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(clazz.getSimpleName()).append("{").append(object).append("}");

        return stringBuffer.toString();
    }

    /**
     * 将string变成string类型
     *
     * @param object
     * @return
     */
    private String convertStringTOString(Object object) {
        Class<? extends Object> clazz = object.getClass();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(clazz.getSimpleName()).append("{").append("\"").append(object).append("\"").append("}");

        return stringBuffer.toString();
    }

    /**
     * 将map对象变成string类型
     *
     * @param object
     * @return
     */
    @SuppressWarnings("unchecked")
    private String convertMapTOString(Object object) {
        Class<? extends Object> clazz = object.getClass();
        Map<Object, Object> map = (Map<Object, Object>) object;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(clazz.getSimpleName()).append("{");
        for (Object key : map.keySet()) {
            stringBuffer.append(key).append(":").append(map.get(key)).append(";");
        }
        if (map.size() > 0) {
            stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        }
        stringBuffer.append("}");

        return stringBuffer.toString();
    }

    /**
     * 将list对象变成string类型
     *
     * @param object
     * @return
     */
    @SuppressWarnings("unchecked")
    private String convertListTOString(Object object) {
        Class<? extends Object> clazz = object.getClass();
        List<Object> list = (List<Object>) object;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(clazz.getSimpleName()).append("{");
        for (Object o : list) {
            if (o != null) {
                stringBuffer.append(convertObjectTOString(o)).append(";");
            }
        }
        if (list.size() > 0) {
            stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        }
        stringBuffer.append("}");

        return stringBuffer.toString();
    }

}