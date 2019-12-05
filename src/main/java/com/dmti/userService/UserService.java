package com.dmti.userService;

import com.dmti.pojo.User;

/**
 * @auther XuJun
 * @date 2019/12/5 16:12
 */
public interface UserService {
    Object login(String name, String password);
    Object register(User user);
}
