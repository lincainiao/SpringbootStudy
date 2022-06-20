package com.lin;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Springboot06SecurityApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() throws SQLException {

    }

}
