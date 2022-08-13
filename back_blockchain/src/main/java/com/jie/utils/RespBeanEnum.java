package com.jie.utils;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum RespBeanEnum {

    SUCCESS(20000,"提交成功"),
    ERROR(20001,"提交失败"),
    LOGIN_SUCCSEE(20000,"欢迎"),
    LOGIN_ERROR(20001,"用户名或密码错误"),
    SELECT_SUCCESS(20000,"查询成功"),
    RETURN_SUCCESS(20000,"获取成功"),
    UPDATE_STATUS(20000,"出警成功"),
    NOW_SUCCESS(20000,"更新成功"),

    ;

//    private boolean success;

//    public boolean isSuccess() {
//        return success;
//    }

//    public void setSuccess(boolean success) {
//        this.success = success;
//    }

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



    RespBeanEnum( Integer code, String message) {
//        this.success=success;
        this.code=code;
        this.message=message;
    }
}
