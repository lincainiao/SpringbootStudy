package com.lin;


import com.lin.service.UserService;
import com.lin.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComsumerApplicationTests {
    @Autowired
    UserServiceImpl userService;

    @Test
    public void contextLoads() {
        userService.butTicket();
    }
}
