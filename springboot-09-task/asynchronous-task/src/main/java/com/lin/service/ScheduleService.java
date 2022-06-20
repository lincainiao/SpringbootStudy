package com.lin.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    // 在一个特定的时间执行这个方法
    // cron表达式(秒 分 时 日 月 星期)
    /*
        10 15 10 * * ?  每天10点15分15秒执行
        30 2/5 10,18 * * ?  每天10点和18点从第二分钟开始，每隔5分钟在第10秒执行一次
        0 15 10 ? * 1-6 每隔月的周一到周六 10:15执行
     */
    @Scheduled(cron = "20 * * * * ?")
    public void schedule(){
        System.out.println("schedule...");
    }
}
