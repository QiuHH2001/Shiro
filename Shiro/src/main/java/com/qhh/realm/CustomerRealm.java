package com.qhh.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Author: QiuHH
 * @CreateTime: 2022-12-08  09:38
 * @Description: 自定义realm实现，将认证/授权数据的来源转为数据库实现
 */
public class CustomerRealm extends AuthorizingRealm {
//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

//    认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        获取用户名
        String principal = (String) authenticationToken.getPrincipal();
//        根据用户名查询相关数据库
        if ("qhh".equals(principal)){
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, "123",this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
