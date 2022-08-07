package com.jie.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jie.mapper.UserDataMapper;
import com.jie.pojo.R;
import com.jie.pojo.UserData;

import com.jie.utils.RespBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
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
    @GetMapping("/statistics/dynamic")
    public R send1(){
        //获取当前日期，精确到年月日
        LocalDate date=LocalDate.now (  );
        //获取当前时间，精确到时分
        Date nowTime=new Date (  );
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("HH:mm");
        String nowtime1 = dateFormat1.format(nowTime);
        //五分钟前的时间
        Date now = new Date();
        Date now_5 = new Date(now.getTime() - 100000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
        String nowTime_5 = dateFormat.format(now_5);
        //查询
        QueryWrapper<UserData> queryWrapper=new QueryWrapper <> (  );
//        queryWrapper.like ("create_time",date);
        queryWrapper.between ( "create_time",nowTime_5,now );
//        queryWrapper.le ("create_time",nowTime);
//        queryWrapper.ge ( "create_time" ,nowTime_5);
        queryWrapper.like ( "accident_name","超车" );
        int counts=userDataMapper.selectCount ( queryWrapper );
        QueryWrapper<UserData> queryWrapper1=new QueryWrapper <> (  );
//        queryWrapper.like ("create_time",date);
//        queryWrapper.le ("create_time",nowTime);
//        queryWrapper.ge ( "create_time" ,nowTime_5);
        queryWrapper1.between ( "create_time",nowTime_5,now  );
        queryWrapper1.like ( "accident_name","直行" );
        int counts1=userDataMapper.selectCount ( queryWrapper1 );
        QueryWrapper<UserData> queryWrapper2=new QueryWrapper <> (  );
//        queryWrapper.like ("create_time",date);
//        queryWrapper.le ("create_time",nowTime);
//        queryWrapper.ge ( "create_time" ,nowTime_5);
        queryWrapper2.between ( "create_time",nowTime_5,now  );
        queryWrapper2.like ( "accident_name","追尾" );
        int counts2=userDataMapper.selectCount ( queryWrapper2 );
        QueryWrapper<UserData> queryWrapper3=new QueryWrapper <> (  );
//        queryWrapper.like ("create_time",date);
//        queryWrapper.le ("create_time",nowTime);
//        queryWrapper.ge ( "create_time" ,nowTime_5);
        queryWrapper3.between ( "create_time",nowTime_5,now );
        queryWrapper3.like ( "accident_name","其他" );
        int counts3=userDataMapper.selectCount ( queryWrapper3 );
        Map<String,Object> map3=new TreeMap <> (  );
        map3.put ( "date",date );
        map3.put ( "time", nowtime1);
        map3.put ( "超车事故",counts );
        map3.put ( "直行事故",counts1 );
        map3.put ( "追尾事故",counts2 );
        map3.put ( "其他事故",counts3 );
        return R.ok1 ().data ( map3 );
    }


}