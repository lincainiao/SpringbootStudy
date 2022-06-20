package com.lin.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Service // 这个是dubbo的注解，可以被扫描到，在项目一启动就自动注入到注册中心
@Component
public class TicketServiceImpl implements TicketService{
    @Override
    public String getTicket() {
        return "hello zhizhi";
    }
}
