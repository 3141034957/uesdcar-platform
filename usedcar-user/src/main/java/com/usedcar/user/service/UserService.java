package com.usedcar.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usedcar.user.entity.User;

public interface UserService extends IService<User> {
    User getByUsername(String username);
}
