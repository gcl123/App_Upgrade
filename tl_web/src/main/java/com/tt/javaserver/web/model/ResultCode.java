package com.tt.javaserver.web.model;

/**
 * Created by feng on 12/3/15.
 */
public enum ResultCode {

    OK(0, "ok"),
    ERROR(-1, "error");


    private int code;

    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
