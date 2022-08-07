package com.jie.utils;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RespBean {

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RespBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", object=" + object +
                ", data=" + data +
                '}';
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Map <String, Object> getData() {
        return data;
    }

    public void setData(Map <String, Object> data) {
        this.data = data;
    }
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private long code;
    private String message;
    private Object object;
    private Map<String, Object> data = new HashMap<String, Object> ();


    public RespBean(){}

    public static RespBean success(){
        RespBean respBean=new RespBean ();
        respBean.setCode (RespBeanEnum.SUCCESS.getCode ());
        respBean.setMessage (RespBeanEnum.SUCCESS.getMessage ());
        respBean.setSuccess ( RespBeanEnum.SUCCESS.isSuccess () );
        return respBean;
    }
    public static RespBean login_success(){
        RespBean respBean=new RespBean ();
        respBean.setSuccess ( RespBeanEnum.LOGIN_SUCCSEE.isSuccess () );
        respBean.setMessage ( RespBeanEnum.LOGIN_SUCCSEE.getMessage () );
        respBean.setCode ( RespBeanEnum.LOGIN_SUCCSEE.getCode () );
        return respBean;
    }
    public static RespBean login_error(){
        RespBean respBean=new RespBean ();
        respBean.setSuccess ( RespBeanEnum.LOGIN_ERROR.isSuccess () );
        respBean.setCode ( RespBeanEnum.LOGIN_ERROR.getCode () );
        respBean.setMessage ( RespBeanEnum.LOGIN_ERROR.getMessage () );
        return respBean;
    }

    public RespBean data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public RespBean data1(Map<String, Object> map){
        this.setData(map);
        return this;
    }




}
