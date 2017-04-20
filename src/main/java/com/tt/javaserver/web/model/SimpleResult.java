package com.tt.javaserver.web.model;

/**
 * Created by feng on 16/7/15.
 */
public class SimpleResult<T> {

    private int code;

    private String msg;

    private T data;

    public SimpleResult() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
