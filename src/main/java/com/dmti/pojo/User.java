package com.dmti.pojo;

/**
 * @auther XuJun
 * @date 2019/12/5 16:18
 */
public class User {
    private int id;
    private String name;
    private String password;
    private String nickname;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public User(String name, String password, String nickname) {
        this.name = name;
        this.password = password;
        this.nickname = nickname;
    }
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
