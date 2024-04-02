package com.example;

import lombok.Data;

@Data
public class R {
    /**
     * 响应状态码
     */
    private int code;
    /**
     * 请求是否成功的布尔值
     */
    private boolean success;
    /**
     * 响应的数据
     */
    private Object data;
    private String message;

    /**
     * 成功
     *
     * @param data 数据
     * @return R
     */
    public static R success(Object data, String message) {
        R r = new R();
        r.setData(data);
        r.setMessage(message);
        r.setSuccess(true);
        r.setCode(200);
        return r;
    }

    public static R success(String message) {
        R r = new R();
        r.setMessage(message);
        r.setSuccess(true);
        r.setCode(200);
        return r;
    }

    public static R error() {
        R r = new R();
        r.setCode(500);
        r.setSuccess(false);
        return r;
    }

    public static R error(String msg) {
        R r = new R();
        r.setCode(500);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }
}
