package com.lin.config;

import com.sun.org.apache.bcel.internal.generic.LCONST;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

// 国际化配置
public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String language = httpServletRequest.getParameter("l");
        // 使用默认的国家化配置
        Locale locale = Locale.getDefault();
        // 如果传入language不为空，说明请求链接中存在郭家湖配置参数
        if (!StringUtils.isEmpty(language)){
            // 分割字符——>国家_地区
            String[] s = language.split("_");
            locale = new Locale(s[0],s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
