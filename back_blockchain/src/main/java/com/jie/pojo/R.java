package com.jie.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jie.utils.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: R
 * @description: 全局统一返回结果
 * @date: 2020/11/16
 * @author: cakin
 */
@JsonInclude(JsonInclude.Include.NON_NULL)//空字段默认不返回
@Data
@ApiModel(value = "全局统一返回结果")
public class R {
    @Override
    public String toString() {
        return "R{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
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

    public Map <String, Object> getData() {
        return data;
    }

    public void setData(Map <String, Object> data) {
        this.data = data;
    }

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object> ();

    public R(){}

    /**
     * 功能描述：成功返回
     *
     * @author cakin
     * @date 2020/11/16
     * @return R 成功返回结果
     * @description:
     */
    public static R ok(){
        R r = new R();
        r.setSuccess( ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }
    public static R ok1(){
        R r = new R();
        r.setSuccess( ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        return r;
    }

    /**
     * 功能描述：失败返回
     *
     * @author cakin
     * @date 2020/11/16
     * @return R 失败返回结果
     */
    public static R error(){
        R r = new R();
        r.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
        return r;
    }

    /**
     * 功能描述：设置返回结果
     *
     * @author cakin
     * @date 2020/11/16
     * @param resultCodeEnum 结果枚举
     * @return R 返回给前端的结果
     */
    public static R setResult(ResultCodeEnum resultCodeEnum){
        R r = new R();
        r.setSuccess(resultCodeEnum.getSuccess());
        r.setCode(resultCodeEnum.getCode());
        r.setMessage(resultCodeEnum.getMessage());
        return r;
    }

    /**
     * 功能描述：设置success状态
     *
     * @author cakin
     * @date 2020/11/16
     * @param success 值为true或false
     * @return R 返回给前端的数据
     */
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    /**
     * 功能描述：设置message内容
     *
     * @author cakin
     * @date 2020/11/16
     * @param message 消息内容
     * @return R 返回给前端的数据
     */
    public R message(String message){
        this.setMessage(message);
        return this;
    }

    /**
     * 功能描述：设置code内容
     *
     * @author cakin
     * @date 2020/11/16
     * @param code 返回码
     * @return R 返回给前端的数据
     */
    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    /**
     * 功能描述：单值设置数据
     *
     * @author cakin
     * @date 2020/11/16
     * @param key 键
     * @param value 值
     * @return R 返回给前端的数据
     */
    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    /**
     * 功能描述：多值设置数据

     * @param map 集合
     * @return R 返回给前端的数据
     */
    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
