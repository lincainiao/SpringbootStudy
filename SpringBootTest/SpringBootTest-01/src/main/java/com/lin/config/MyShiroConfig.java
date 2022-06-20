package com.lin.config;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;

@Configuration
public class MyShiroConfig {
    // Realm
    @Bean(name = "realm")
    public MyRealm realm(){
        MyRealm realm = new MyRealm();
        return realm;
    }

    // WebSecurityManager
    @Bean(name = "webSecurityManager")
    public DefaultWebSecurityManager webSecurityManager(@Qualifier("realm") MyRealm realm){
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        webSecurityManager.setRealm(realm);
        return webSecurityManager;
    }

    //
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("webSecurityManager") DefaultWebSecurityManager webSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(webSecurityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedMap();
        // 需要认证才能执行/allGirls请求
        filterChainDefinitionMap.put("/allGirls","authc");
        filterChainDefinitionMap.put("/allUsers","authc");
        filterChainDefinitionMap.put("/main","authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        // 设置转到登录页的请求
        bean.setLoginUrl("/index");
        // 设置为认证界面
        bean.setUnauthorizedUrl("/");
        return bean;
    }
}
