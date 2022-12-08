package com.qhh.springbootshiro.mapper;

import com.qhh.springbootshiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: QiuHH
 * @CreateTime: 2022-12-08  16:44
 * @Description: TODO
 */
@Mapper
public interface UserMapper {
    void save(User user);
}
