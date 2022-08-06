package com.jie.utils;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum RespBeanEnum {

    SUCCESS(true,20000,"提交成功"),
    ERROR(false,20001,"提交失败"),
    LOGIN_SUCCSEE(true,20000,"欢迎"),
    LOGIN_ERROR(false,20001,"用户名或密码错误"),
    SELECT_SUCCESS(true,20000,"查询成功"),

    ;

    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private Integer code;
    private String message;



    RespBeanEnum(boolean success, Integer code, String message) {
        this.success=success;
        this.code=code;
        this.message=message;
    }
}
