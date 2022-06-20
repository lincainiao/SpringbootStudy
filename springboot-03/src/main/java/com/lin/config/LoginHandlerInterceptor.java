package com.lin.config;

import org.aopalliance.intercept.Interceptor;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 登录拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        // 登录成功，应该存在用户的Session
        Object userSession = request.getSession().getAttribute(Constant.USER_SESSION);
        if (userSession == null) {
            // 没有登录，重定向到index.html
            session.setAttribute("login_msg","no_login");
//            System.out.println(request.getSession().getAttribute("login_msg"));
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        return true;
    }
}
