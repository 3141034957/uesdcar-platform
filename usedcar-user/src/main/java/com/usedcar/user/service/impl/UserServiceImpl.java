package com.usedcar.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usedcar.user.entity.User;
import com.usedcar.user.mapper.UserMapper;
import com.usedcar.user.service.UserService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    public User getByUsername(String username) {
        return getOne(new QueryWrapper<User>().eq("username", username));
    }
}
