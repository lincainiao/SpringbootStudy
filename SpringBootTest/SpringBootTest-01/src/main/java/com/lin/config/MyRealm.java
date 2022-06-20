package com.lin.config;

import com.lin.pojo.User;
import com.lin.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    UserServiceImpl userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        AuthenticationInfo result = null;
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.getUserByName(token.getUsername());
        if (user != null){
            Subject currentUser = SecurityUtils.getSubject();
            // 将user对象存入第一个参数，这样就能让授权获取
            result = new SimpleAuthenticationInfo("", user.getPwd(), "");
            // 登录成功后将用户存入session中
            Session session = currentUser.getSession();
            session.setAttribute(Constant.USER_SESSION, user);
        }
        return result;
    }
}
