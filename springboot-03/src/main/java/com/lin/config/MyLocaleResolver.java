package com.lin.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

// 国际化配置请求
public class MyLocaleResolver implements LocaleResolver {
    @Override
    // 解析请求
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求中的参数连接
        String language = request.getParameter("l");
        // 如果没有就使用默认的
        Locale locale = Locale.getDefault();
        // 如果请求的链接携带了国际化的参数
        if (!StringUtils.isEmpty(language)){
            // 分割获得的参数
            String[] s = language.split("_");
            // 国家_地区
            locale = new Locale(s[0], s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
