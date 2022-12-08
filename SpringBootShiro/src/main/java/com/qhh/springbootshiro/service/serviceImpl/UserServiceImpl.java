package com.qhh.springbootshiro.service.serviceImpl;

import com.qhh.springbootshiro.entity.User;
import com.qhh.springbootshiro.mapper.UserMapper;
import com.qhh.springbootshiro.service.UserService;
import com.qhh.springbootshiro.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: QiuHH
 * @CreateTime: 2022-12-08  17:22
 * @Description: TODO
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        //处理业务调用dao
        //1.生成随机盐
        String salt = SaltUtils.getSalt(8);
        //2.将随机盐保存到数据
        user.setSalt(salt);
        //3.明文密码进行md5 + salt + hash散列
        Md5Hash md5Hash = new Md5Hash(user.getPassword(),salt,1024);
        user.setPassword(md5Hash.toHex());

        userMapper.save(user);
    }
}
