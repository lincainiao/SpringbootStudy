package com.lin.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import sun.util.resources.cldr.kea.TimeZoneNames_kea;

@Service // 这里是spring的@Service
public class UserServiceImpl {
    // 想从provider中获取ticket，要去注册中心拿到服务
    @Reference // 类似于@Autowired;
    // 引用方法，需要定义路径相同的接口名
    TicketService ticketService;
    public void butTicket(){
        System.out.println("从注册中心拿到了"+ticketService.getTicket());
    }
}
