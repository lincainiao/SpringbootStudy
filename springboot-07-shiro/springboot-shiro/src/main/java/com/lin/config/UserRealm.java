package com.lin.config;

import com.lin.constant.Constant;
import com.lin.pojo.Girl;
import com.lin.pojo.User;
import com.lin.service.GirlServiceImpl;
import com.lin.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import sun.misc.FpUtils;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UnknownFormatConversionException;

// 自定义Realm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    GirlServiceImpl girlService;
    @Autowired
    UserServiceImpl userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("--------授权--------");
        // 给用户赋予权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取当前登录的对象
        Subject currentUser = SecurityUtils.getSubject();
        User user =(User) currentUser.getPrincipal(); // 拿到user对象
        String[] perms = user.getPerms().split(",");
        for (int i = 0; i < perms.length; i++) {
            info.addStringPermission(perms[i].trim());
        }
//        info.addStringPermission(user.getPerms()); // 设置当前用户的权限，从数据库中获取
        return info;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        AuthenticationInfo result = null;
        System.out.println("--------认证--------");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.getUseByName(token.getUsername());
        if (user != null) {
            // 认证完成后将登录的user存入session中
            Subject currentUser = SecurityUtils.getSubject();
            Session session = currentUser.getSession();
            session.setAttribute(Constant.USER_SESSION, user);// 将user对象存入第一个参数，这样就能让授权获取
            result = new SimpleAuthenticationInfo(user, user.getPwd(), "");
        }
        return result;
    }

}
