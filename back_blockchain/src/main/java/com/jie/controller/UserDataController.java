package com.jie.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jie.mapper.UserDataMapper;
import com.jie.pojo.R;
import com.jie.pojo.UserData;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 杰哥
 * @since 2022-08-02
 */
@CrossOrigin
@RestController
@RequestMapping("/user/accident")
@ResponseBody
public class UserDataController {
    @Resource
    UserDataMapper userDataMapper;

//    @PostMapping(value = "/submit")
//    public R save(@RequestBody Map<String,String> map ) {
//        String password = map.get ( "address" );
//        String aa = map.get ( "accident_type" );
//        String passwo1rd = map.get ( "time" );
//        System.out.println ( password );
//
//        Map <String, Object> maps1 = new HashMap <> ();
//        maps1.put ( "Message", "提交成功" );
//        return R.ok ().data ( maps1 );
//    }
    @PostMapping( "/submit")//用户提交消息
    public R save(@RequestBody UserData userData1) {
        System.out.println (userData1);
        userDataMapper.insert ( userData1 );
        Map<String,Object> maps1=new HashMap <> (  );
//        maps1.put ("Message","提交成功");
        return R.ok ();
    }

    @GetMapping("/now")//管理员返回当天所有事故信息
    public R send(@RequestParam(required = false) String jsONTRING) {
        QueryWrapper<UserData> queryWrapper=new QueryWrapper <> (  );
        LocalDate date=LocalDate.now (  );
        queryWrapper.like ( "time",date );
        List<UserData> list=userDataMapper.selectList ( queryWrapper );
        int totle=userDataMapper.selectCount ( queryWrapper );
        Map <String, Object> maps=new TreeMap <> (  );
        maps.put ( "total ",totle);
        maps.put ( "items",list );
        return  R.ok ().data (maps);
    }
    @GetMapping("/all")//指定条件查询
    public R find(@RequestParam Map<String,String> map) {
        String initial_time=map.get ( "start_time" );
        String date_line=map.get ( "end_time" );
        String accident_type=map.get ( "accident_name" );
        String address=map.get ( "address" );
        String search_time=map.get ( "search_date" );
        QueryWrapper<UserData> queryWrapper=new QueryWrapper <> (  );
        if(!StringUtils.isEmpty(search_time)) {
            queryWrapper.like ( "time", search_time );
        }

        if(!StringUtils.isEmpty(initial_time)) {
            queryWrapper.ge ( "create_time", initial_time );
        }
        if(!StringUtils.isEmpty(date_line)) {
            queryWrapper.le ( "create_time", date_line );
        }
        if(!StringUtils.isEmpty(accident_type)){
            queryWrapper.like ("accident_name",accident_type);
        }
        if(!StringUtils.isEmpty(address)){
            queryWrapper.like ("address",address);
        }
        List<UserData> list=userDataMapper.selectList ( queryWrapper );
        int totle=userDataMapper.selectCount ( queryWrapper );
        Map <String, Object> maps=new TreeMap <> (  );
        maps.put ( "total ",totle);
        maps.put ( "items",list );
        return  R.ok ().data (maps);
    }
}