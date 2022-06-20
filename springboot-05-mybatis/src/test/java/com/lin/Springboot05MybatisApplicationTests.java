package com.lin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.File;
import java.util.Random;

@SpringBootTest
class Springboot05MybatisApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {

    }
}
