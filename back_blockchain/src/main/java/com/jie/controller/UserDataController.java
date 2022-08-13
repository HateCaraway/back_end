package com.jie.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jie.mapper.UserDataMapper;
import com.jie.pojo.R;
import com.jie.pojo.UserData;

import com.jie.service.impl.UserDataServiceImpl;
import com.jie.service.impl.UserServiceImpl;
import com.jie.utils.RespBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
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
@RequestMapping("/accident")
@ResponseBody
public class UserDataController {
    @Resource
    UserDataMapper userDataMapper;
    @Autowired
    UserDataServiceImpl userDataService;


    @PostMapping( "/info/submit")//用户提交消息
    public RespBean store(@RequestBody UserData userData1) {
        return userDataService.store (userData1);
    }

    @GetMapping("/info/now")//管理员返回当天所有事故信息
    public RespBean sendToday() {
        return  userDataService.sendToday ();
    }

    @PostMapping("/info/all")//指定条件查询
    public RespBean findInfo(@RequestBody Map<String,String> map) {
        return userDataService.findInfo ( map );

    }
    @PostMapping("/info/updateStatus")//更新事故状态
    public RespBean updateStatus(@RequestBody Map<String,String> map){
        return userDataService.updateStatus (map);
    }


    @GetMapping("/statistics/dynamic")//指定时间间隔数据展示
    public RespBean dataShow(){
        return userDataService.dataShow ();
    }

    @GetMapping("/statistics/allTypes")
    public RespBean typeShwo(){
        return userDataService.typeShow ();
    }

    @GetMapping("/statistics/month")
    public RespBean monthShow(){
        return userDataService.monthShow ();
    }

    @GetMapping("/statistics/addressMarkers")
    public RespBean addressShow(){
        return userDataService.addressShow ();
    }

}