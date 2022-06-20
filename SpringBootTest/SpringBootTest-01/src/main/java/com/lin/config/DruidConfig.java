package com.lin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.apache.commons.collections.map.LinkedMap;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class DruidConfig {
    // 绑定配置文件中的DataSource
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    // 后台监控功能
    // springboot内置servlet容器，没有web.xml，替代方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        // 后台需要有人登录，账号密码配置
        // 初始化参数
        Map<String, String> initParameters = new LinkedMap();
        initParameters.put("allow","");
        initParameters.put("loginUsername","root");
        initParameters.put("loginPassword","root");
        bean.setInitParameters(initParameters);
        return bean;
    }
}
