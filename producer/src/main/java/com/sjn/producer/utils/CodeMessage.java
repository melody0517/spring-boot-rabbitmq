package com.sjn.producer.utils;


public enum CodeMessage {
    SUCCESS(0, "成功"),
    ERROR(1, "服务异常"),
    ;


    private int code;
    private String message;

    CodeMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String codeOf(int code) {
        for (CodeMessage cm : CodeMessage.values()) {
            if (cm.getCode() == code) {
                return cm.getMessage();
            }
        }
        return null;
    }
}