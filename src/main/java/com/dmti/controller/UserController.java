package com.dmti.controller;

import com.alibaba.fastjson.JSONObject;
import com.dmti.pojo.User;
import com.dmti.userService.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RestController
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
