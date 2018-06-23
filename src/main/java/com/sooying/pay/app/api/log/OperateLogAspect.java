package com.sooying.pay.app.api.log;

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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
            operateLogInfo.setContent(convertArgsTOJsonString(joinPoint.getArgs()));
            operateLogInfo.setLoginIP(getVisitIP());
            operateLogInfo.setTriggerPoint(joinPoint.getSignature().toString());
            operateLogInfo.setRemark(remark);

            // 操作日志插入到日志表中
            operateLogInfoDao.addOperateLog(operateLogInfo);
        } catch (Exception e) {
            logger.info("OperateLogAspect addDataLog 发生异常：{}", e.getMessage());
        }
    }

    /**
     * 获取HttpServletRequest
     *
     * @return
     */
    private HttpServletRequest getHttpServletRequest() {
        HttpServletRequest request = null;

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
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
        return request.getParameter("loginName");
    }

    /**
     * 获取客户端IP
     *
     * @return
     */
    private String getVisitIP() {
        HttpServletRequest request = getHttpServletRequest();

        if (request == null) {
            return "";
        } else if (((HttpServletRequest) request).getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        } else {
            return ((HttpServletRequest) request).getHeader("x-forwarded-for");
        }
    }

    /**
     * 将目标方法的所有参数返回json字符串
     *
     * @param args
     * @return
     */
    private String convertArgsTOJsonString(Object[] args) {
        JSONObject returnJson = new JSONObject();

        for (Object object : args) {
            if (object == null) {
                continue;
            }
            Class<? extends Object> clazz = object.getClass();
            String clazzName = clazz.getName();
            String simpleName = clazz.getSimpleName();
            if (clazzName.contains("com.sooying.pay.app.api")
                    || (clazzName.startsWith("java.util") && clazzName.contains("Map"))) {
                JSONObject json = JSONObject.fromObject(object);
                returnJson.put(simpleName, json);
            } else if (clazzName.startsWith("java.util") && clazzName.contains("List")) {
                JSONArray jsonArray = JSONArray.fromObject(object);
                returnJson.put(simpleName, jsonArray);
            } else {
                returnJson.put(simpleName, object.toString());
            }
        }

        return returnJson.toString();
    }

}