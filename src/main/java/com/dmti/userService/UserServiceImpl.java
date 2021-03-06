package com.dmti.userService;

import com.dmti.pojo.Msg;
import com.dmti.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private JdbcTemplate jdbctemplate;

    @Override
    public Object login(String name, String password) {
        List<Map<String,Object>> list = jdbctemplate.queryForList("SELECT * FROM sys_user WHERE name = '" + name + "' and password = '" + password+"'");
        if (list != null) {
            return new Msg(1,list.get(0));
        }
        return new Msg(0);
    }

    @Override
    public Object register(User user) {
        String sql = "INSERT INTO sys_user(name,password,nickname)VALUES('" + user.getName() + "','" + user.getPassword() + "','" + user.getNickname() + "')";
        if (jdbctemplate.update(sql) != 0) {
            return new Msg(1);
        }
        return new Msg(0);
    }

    @Override
    public Object updatePassword(User user) {
        String sql = "UPDATE sys_user SET `password` = '"+user.getPassword()+"' WHERE id = '"+user.getId()+"'";
        if (jdbctemplate.update(sql) != 0) {
            return new Msg(1);
        }
        return new Msg(0);
    }
}
