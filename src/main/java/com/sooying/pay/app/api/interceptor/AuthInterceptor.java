package com.sooying.pay.app.api.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 权限校验
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
        System.out.println("AuthInterceptor");

        String token = request.getParameter("token");

        System.out.println(token);

        if ("abcde".equals(token)) {
            return Boolean.TRUE;
        } else {
            forward("您没有登录或登录超时，请重新登录！", request, response);

            return Boolean.FALSE;
        }
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

    private void forward(String msg, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/auth/showAuthMsg.do?errMsg=" + msg).forward(request, response);
    }

}
