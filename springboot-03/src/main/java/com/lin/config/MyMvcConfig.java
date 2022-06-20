package com.lin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

// mvc扩展配置
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    // 视图跳转
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController( "/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        // 在UserController中重定向到/main.html，那么/main.html会结合视图解析器转到dashboard.html
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean
    // 自定义的国际化配置
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Override
    // 自定义拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                    // 拦截的请求
                    .addPathPatterns("/**")
                    // 排除的请求
                    .excludePathPatterns("/index.html","/","/user/login","/css/**","/js/**","/img/**","/signout");
    }
}
