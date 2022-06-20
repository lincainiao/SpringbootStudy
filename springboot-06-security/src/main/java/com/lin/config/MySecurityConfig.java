package com.lin.config;

import com.lin.mapper.GirlMapper;
import com.lin.pojo.Girl;
import com.lin.pojo.User;
import com.lin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.util.List;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    GirlMapper girlMapper;
    @Autowired
    DataSource dataSource;
    @Autowired
    UserServiceImpl userService;

    @Override
    // 授权
    protected void configure(HttpSecurity http) throws Exception {
        // 设置首页所有人可以访问，但是功能也只有对应的人才能访问
        http.authorizeRequests()
                // 请求授权的规则
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        // 没有权限自动跳到登录页面
        // 开启默认的登录页面
//        http.formLogin();
        // 自定义登录页面
        http.formLogin()
                // /toLogin : 到登录界面
                .loginPage("/toLogin")
                        // 自定义从前端接收用户名参数名称，默认为username，password
                        .usernameParameter("username").passwordParameter("password")
                        // 默认的登录请求
                        .loginProcessingUrl("/login");


        // 关闭csfr功能，防止注销失败
        http.csrf().disable();
        // 开启注销功能，注销完后需要回到首页
        http.logout().logoutSuccessUrl("/");

        // 开启“记住我功能”，默认保存14天
//        http.rememberMe();

        // 自定义接收前端的参数
        http.rememberMe().rememberMeParameter("rem");
    }

    // 认证
    @Override
    // spring security为了安全起见，对密码需要有特殊的编码 : passwordEncoder
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("zhizhi").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip2")
//                .and()
//                .withUser("ytm").password(new BCryptPasswordEncoder().encode("123")).roles("vip3")
//                .and()
//                .withUser("zsy").password(new BCryptPasswordEncoder().encode("123465")).roles("vip1");

//        User user = userService.getUserByName("zhizhi");
//        System.out.println(user.toString());
        auth.jdbcAuthentication().
                dataSource(dataSource).
                withDefaultSchema()
                .withUser("zhizhi").password("123").roles("vip1","vip2","vip3");
    }
}
