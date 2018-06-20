package com.sooying.pay.app.api.interceptor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bench.common.lang.StringUtils;
import com.sooying.pay.app.api.constant.ApiStatusEnum;
import com.sooying.pay.app.api.util.CacheUtil;

/**
 * token校验
 * 
 * @Description AuthInterceptor
 * @author liurh
 * @date 2018年6月1日
 */
public class AuthInterceptor implements HandlerInterceptor {

    /**
     * 请求处理之前，拦截所有后缀为.json的请求
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 登录用户token验证
        String loginName = request.getParameter("loginName");
        String token = request.getParameter("token");

        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(token)) {
            forward(ApiStatusEnum.API_STATUS_FAIL.getStatus(), "用户名和token都不能为空！", request, response);
            return false;
        }

        // 查询缓存token
        String cacheToken = CacheUtil.getToken(loginName);

        if (!token.equals(cacheToken)) {
            forward(ApiStatusEnum.API_STATUS_TOKEN_INVALID.getStatus(), "当前用户未登录或token已失效，请重新登录获取token！", request,
                    response);
            return false;
        }

        return true;
    }

    /**
     * 请求进行处理之后
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    /**
     * 请求结束之后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

    /**
     * 设置拦截返回信息
     *
     * @param status
     * @param msg
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void forward(String resultStatus, String message, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request
                .getRequestDispatcher("/auth/showAuthMsg.do?resultStatus=" + resultStatus + "&message=" + message);
        rd.forward(request, response);
    }

}
