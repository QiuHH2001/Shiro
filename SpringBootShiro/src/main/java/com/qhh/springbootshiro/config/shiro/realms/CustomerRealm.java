package com.qhh.springbootshiro.config.shiro.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Author: QiuHH
 * @CreateTime: 2022-12-08  14:30
 * @Description: 自定义realm
 */
//@Component
public class CustomerRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从传过来的token获取到的用户名
        String principal = (String) authenticationToken.getPrincipal();
        System.out.println("用户名"+principal);

        //假设是从数据库获得的 用户名，密码
        String password_db="123";
        String username_db="qhh";

        if (username_db.equals(principal)){
//            SimpleAuthenticationInfo simpleAuthenticationInfo =
            return new SimpleAuthenticationInfo(principal,"123", this.getName());
        }

        return null;
    }
}
