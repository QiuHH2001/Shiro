package com.qhh.springbootshiro.config;

import com.qhh.springbootshiro.config.shiro.realms.CustomerRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: QiuHH
 * @CreateTime: 2022-12-08  14:22
 * @Description: 整合shiro配置类
 */
@Configuration
public class ShiroConfig {

//    shiroFilter，拦截所有请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

//        给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

//        配置系统受限资源、公共资源
        Map<String,String> map = new HashMap<String,String>();
        map.put("/user/login","anon");//anon 设置为公共资源  放行资源放在下面
        map.put("/user/register","anon");//anon 设置为公共资源  放行资源放在下面
        map.put("/register.jsp","anon");//anon 设置为公共资源  放行资源放在下面
        map.put("/user/getImage","anon");

        map.put("/**","authc");//authc 请求这个资源需要认证和授权

        //默认认证界面路径---当认证不通过时跳转
        shiroFilterFactoryBean.setLoginUrl("/login.jsp");
        map.put("/**", "authc"); //需要认证和授权
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }


//    安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
//        给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }



//    自定义realm
    @Bean
    public Realm getRealm(){
        return new CustomerRealm();
    }
}
