package com.lin;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class SpringBootTest01ApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        System.out.println(dataSource.getClass());
    }

}
