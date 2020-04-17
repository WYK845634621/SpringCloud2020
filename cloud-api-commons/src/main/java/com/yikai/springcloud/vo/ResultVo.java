package com.yikai.springcloud.vo;

import java.io.Serializable;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/4/16 14:53
 */
public class ResultVo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String CODE_WAITING = "2";
    public static final String CODE_SUCCESS = "20000";
    public static final String CODE_FAIL = "0";
    public static final String MSG_WAITING = "等待";
    public static final String MSG_SUCCESS = "成功";
    public static final String MSG_FAIL = "失败";
    private Object log;
    private String code = "0";
    private String msg = "失败";
    private T result;

    public ResultVo() {
    }

    public ResultVo(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVo(String code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.result = t;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Object getLog() {
        return this.log;
    }

    public void setLog(Object log) {
        this.log = log;
    }
}