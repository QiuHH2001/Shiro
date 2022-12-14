package com.qhh.springbootshiro.controller;

import com.qhh.springbootshiro.entity.User;
import com.qhh.springbootshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: QiuHH
 * @CreateTime: 2022-12-08  15:01
 * @Description: TODO
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户注册
     */
    @RequestMapping("/register")
    public String register(User user){
        userService.register(user);
        return "redirect:/login.jsp";
    }


    /**
     * 身份认证
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String login(String username, String password){
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
            return "redirect:/index.jsp";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
        }
        return "redirect:/login.jsp";
    }

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.jsp";
    }


}
