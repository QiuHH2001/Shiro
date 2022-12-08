package com.qhh;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 * @Author: QiuHH
 * @CreateTime: 2022-12-08  09:00
 * @Description: TODO
 */
public class TestAuthenticator {
    public static void main(String[] args) {
//        创建安全管理器对象
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
//        给安全管理器设置realm
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));
//        给全局安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);
//        关键对象 subject
        Subject subject = SecurityUtils.getSubject();
//        创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("qhh", "123");
        try {
            subject.login(token);
            System.out.println("认证状态：" + subject.isAuthenticated());
        } catch (Exception e){
            e.printStackTrace();
        }





    }
}
