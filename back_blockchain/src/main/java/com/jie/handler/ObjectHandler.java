package com.jie.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class ObjectHandler implements MetaObjectHandler{
    @Override
    public void insertFill(MetaObject metaObject) {
        //源码setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        this.setFieldValByName ( "createTime" ,new Date (  ),metaObject);
    }
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName ( "updateTime",new Date (  ),metaObject );
    }

}
