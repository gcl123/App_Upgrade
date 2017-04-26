package com.tt.javaserver.web.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by feng on 16/7/15.
 */
public class SimpleResult<T> {

    //code 0:成功 -1:失败 -2 :数据为空
    private int code;

    private String msg;

    private T data;

    public SimpleResult() {
    }

    public SimpleResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public SimpleResult(int code, String msg, int total, String name, Object object) {
        this.code = code;
        this.msg = msg;
        Map<String, Object> map = new HashMap();
        map.put("total", total);
        map.put(name, object);
        this.setData((T) map);
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

    @Override
    public String toString() {
        return "SimpleResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
