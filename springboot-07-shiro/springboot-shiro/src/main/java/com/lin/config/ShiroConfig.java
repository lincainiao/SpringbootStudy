package com.lin.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.catalina.valves.rewrite.Substitution;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // 3.ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        // 添加shiro内置过滤器
        /*
            anon: 无需认证就能访问
            authc: 必须认证了才能访问
            user: 必须拥有记住我功能才能访问
            perms: 拥有对某个资源的权限才能访问
            role: 拥有某个角色权限才能访问
         */
        Map<String, String> filterChainDefinitionMap = new LinkedMap();
        // 需要认证才能执行/user/add请求
        filterChainDefinitionMap.put("/user/add","authc");
        filterChainDefinitionMap.put("/user/update", "authc");
//        filterChainDefinitionMap.put("/user/*","authc");
        // 权限，正常情况下，未授权会跳转未授权页面
        // 含有user:add字符串的用户才能执行/user/add请求
        // 有多个参数时，需要全部都有才能执行请求
        filterChainDefinitionMap.put("/user/add","perms[user:add]");
        filterChainDefinitionMap.put("/user/update","perms[user:update]");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        // 设置到登录页面的请求，如果在进入页面失败被拦截的时候，就进入登录界面
        bean.setLoginUrl("/toLogin");
        // 设置未授权页面请求
        bean.setUnauthorizedUrl("/unauthorized");
        return bean;
    }

    // 2.WebSecurityManager对象(固定写法)
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联自定义的UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // 1.创建Realm对象，需要自定义类
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    // 集合ShiroDialect，用来整合shiro和thymeleaf
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
