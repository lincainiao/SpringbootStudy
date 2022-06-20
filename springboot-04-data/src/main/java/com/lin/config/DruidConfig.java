package com.lin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    // 绑定配置文件中的DataSource
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDatasource(){
        return new DruidDataSource();
    }

    // 后台监控功能
    // springboot内置servlet容器，没有web.xml，替代方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        // 后台需要有人登录，账号密码配置
        // 初始化参数
        Map<String, String> initParameters = new HashMap<>();
        // allow : 允许谁可以访问, 值为空表示允许所有人
        initParameters.put("allow","");
        // 名字是固定的：loginUsername和loginPassword
        initParameters.put("loginUsername","root");
        initParameters.put("loginPassword","root");
        bean.setInitParameters(initParameters);
        return bean;
    }

    // filter
//    @Bean
//    public FilterRegistrationBean webStatFilter(){
//        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
//        bean.setFilter(new WebStatFilter());
//        // 可以过滤哪些请求
//        Map<String, String> initParameters = new HashMap<>();
//        // exclusions: 不需要过滤的
//        initParameters.put("exclusions","*.js,*.css,/druid/*");
//
//        bean.setInitParameters(initParameters);
//        return bean;
//    }
}
