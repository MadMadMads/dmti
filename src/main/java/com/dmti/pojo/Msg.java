package com.dmti.pojo;

/**
 * @auther XuJun
 * @date 2019/12/5 16:48
 */
public class Msg {
    /**
     * 0失败 1成功
     */
    private int status;
    /**
     * 返回的数据
     */
    private Object data;

    private String msg;

    public Msg() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Msg(int status, Object data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public Msg(int status, Object data) {
        this.status = status;
        this.data = data;
    }

    public Msg(int status) {
        this.status = status;
    }
}
