package com.example.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 杰哥
 * @since 2022-08-07
 */
@Data
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", accidentType=" + accidentType +
                ", address='" + address + '\'' +
                ", accidentName='" + accidentName + '\'' +
                ", addressLng='" + addressLng + '\'' +
                ", addressLat='" + addressLat + '\'' +
                ", time='" + time + '\'' +
                ", version=" + version +
                ", deleted=" + deleted +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAccidentType() {
        return accidentType;
    }

    public void setAccidentType(Integer accidentType) {
        this.accidentType = accidentType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccidentName() {
        return accidentName;
    }

    public void setAccidentName(String accidentName) {
        this.accidentName = accidentName;
    }

    public String getAddressLng() {
        return addressLng;
    }

    public void setAddressLng(String addressLng) {
        this.addressLng = addressLng;
    }

    public String getAddressLat() {
        return addressLat;
    }

    public void setAddressLat(String addressLat) {
        this.addressLat = addressLat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @JsonProperty("user_id")
    @JSONField(name = "user_id")
    private String userId;

    private Integer accidentType;

    private String address;

    private String accidentName;

    private String addressLng;

    private String addressLat;

    private String time;

    @Version
    private Integer version;

    @TableLogic
    private Integer deleted;
    @JsonProperty("create_time")
    @JSONField(name = "create_time")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
