package com.dmti.pojo;

/**
 * @auther XuJun
 * @date 2019/12/5 21:40
 */
public class CountPojo {
    private String name;
    private Integer count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public CountPojo(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public CountPojo() {
    }
}
