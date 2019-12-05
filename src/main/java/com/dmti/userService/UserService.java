package com.dmti.userService;

import com.dmti.pojo.User;

public interface UserService {
    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    Object login(String name, String password);

    /**
     * 注册
     * @param user
     * @return
     */
    Object register(User user);

    /**
     * 修改密码
     * @param user
     * @return
     */
    Object updatePassword(User user);
}
