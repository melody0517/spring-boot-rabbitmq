package com.sjn.producer.utils;

import java.io.Serializable;

/**
 * @author caiqy
 */
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = -1;

    private int code;
    private String message;
    private T data;

    public CommonResult() {
        this.code = CodeMessage.SUCCESS.getCode();
        this.message = CodeMessage.SUCCESS.getMessage();
    }

    public CommonResult(int code) {
        this.code = code;
    }

    public CommonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public CommonResult(CodeMessage cm) {
        this.code = cm.getCode();
        this.message = cm.getMessage();
    }

    public static <T> CommonResult<T> success() {
        return new CommonResult<T>().setCodeMessage(CodeMessage.SUCCESS);
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>().setCodeMessage(CodeMessage.SUCCESS).setData(data);
    }

    public static <T> CommonResult<T> error(String message) {
        return new CommonResult<T>().setCode(CodeMessage.ERROR.getCode()).setMessage(message);
    }

    public static <T> CommonResult<T> makeRsp(int code, String msg) {
        return new CommonResult<T>().setCode(code).setMessage(msg);
    }

    public static <T> CommonResult<T> makeRsp(int code, String msg, T data) {
        return new CommonResult<T>().setCode(code).setMessage(msg).setData(data);
    }

    public static <T> CommonResult<T> error() {
        return new CommonResult<T>(CodeMessage.ERROR);
    }

    public static <T> CommonResult<T> error(CodeMessage cm) {
        return new CommonResult<T>(cm);
    }

    public int getCode() {
        return code;
    }

    public CommonResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonResult<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public CommonResult<T> setCodeAndMessage(int code) {
        this.message = CodeMessage.codeOf(code);
        this.code = code;
        return this;
    }

    public Object getData() {
        return data;
    }

    public CommonResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    public CommonResult<T> setCodeMessage(CodeMessage cm) {
        this.code = cm.getCode();
        this.message = cm.getMessage();
        return this;
    }
}
