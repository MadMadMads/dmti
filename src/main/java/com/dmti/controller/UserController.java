package com.dmti.controller;

import com.alibaba.fastjson.JSONObject;
import com.dmti.pojo.User;
import com.dmti.userService.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @auther XuJun
 * @date 2019/12/5 17:10
 */
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Object login(@RequestBody JSONObject jsonParam) {
        return userService.login(jsonParam.getString("name"),jsonParam.getString("password"));
    }
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Object register(@RequestBody JSONObject jsonParam) {
        return userService.register(new User(jsonParam.getString("name"),jsonParam.getString("password"),jsonParam.getString("nickname")));
    }
    @ResponseBody
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Object updatePassword(@RequestBody JSONObject jsonParam) {
        User user = new User();
        user.setId(jsonParam.getInteger("id"));
        user.setPassword(jsonParam.getString("password"));
        return userService.register(user);
    }
}
