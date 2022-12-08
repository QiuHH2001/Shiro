package com.qhh.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @Author: QiuHH
 * @CreateTime: 2022-12-08  10:16
 * @Description: 使用自定义realm加入md5 + salt + hash
 */
public class CustomerMd5Realm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //        获取用户名
        String principal = (String) authenticationToken.getPrincipal();
//        根据用户名查询相关数据库
        if ("qhh".equals(principal)){
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, "0d8b6e17773edbbb4b2faddb76720e54", ByteSource.Util.bytes("0x"),this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
