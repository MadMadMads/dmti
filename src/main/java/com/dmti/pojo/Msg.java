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

    public Msg(int status, Object data) {
        this.status = status;
        this.data = data;
    }
    public Msg(int status) {
        this.status = status;
    }
}
