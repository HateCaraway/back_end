package com.jie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jie.pojo.UserData;
import com.jie.mapper.UserDataMapper;
import com.jie.service.IUserDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jie.utils.RespBean;
import com.sun.javafx.collections.MappingChange;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杰哥
 * @since 2022-08-02
 */
@Service
public class UserDataServiceImpl extends ServiceImpl<UserDataMapper, UserData> implements IUserDataService {
    @Resource
    UserDataMapper userDataMapper;

    @Override
    public RespBean store(UserData userData){
        userDataMapper.insert ( userData );
        return RespBean.success ();
    }

    @Override
    public RespBean findInfo(Map<String, String> map) {
        String initial_time=map.get ( "start_month" );
        String date_line=map.get ( "end_month" );
        String accident_type=map.get ( "accident_name" );
        String address=map.get ( "address_name" );
        String search_time=map.get ( "search_date" );
        String user_id=map.get ( "user_id" );
        Integer page= Integer.valueOf ( map.get ( "page" ) );
        Integer limit= Integer.valueOf ( map.get ( "limit" ) );
        QueryWrapper<UserData> queryWrapper=new QueryWrapper <> (  );
        Page<UserData> page1=new Page <> (page,limit);
        queryWrapper.select (  ).orderByDesc ( "create_time" );
        if(!StringUtils.isEmpty(search_time)) {
            queryWrapper.like ( "time", search_time );
        }
        if(!StringUtils.isEmpty ( user_id )){
            queryWrapper.like ("user_id",user_id );
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
        userDataMapper.selectPage (page1, queryWrapper );
        List<UserData> list=page1.getRecords ();
        int totle=userDataMapper.selectCount ( queryWrapper );
        Map <String, Object> maps=new TreeMap<> (  );
        maps.put ( "total ",totle);
        maps.put ( "items", list );
        return  RespBean.return_success ().data1 (maps);
    }

    @Override
    public RespBean updateStatus(Map<String,String> map) {
        int accident_id= Integer.parseInt ( map.get ( "accident_id" ) );
        String status=map.get ( "status" );
        UserData userData=new UserData ();
        userData.setAccidentId (accident_id);
        userData.setStatus ( status );
        userDataMapper.updateById ( userData );
        return RespBean.update_status ();
    }

    @Override
    public RespBean sendToday() {
        QueryWrapper<UserData> queryWrapper=new QueryWrapper <> (  );
        LocalDate date=LocalDate.now (  );
        queryWrapper.like ( "create_time",date );
        List<UserData> list=userDataMapper.selectList ( queryWrapper );
        int totle=userDataMapper.selectCount ( queryWrapper );
        Map <String, Object> maps=new TreeMap <> (  );
        maps.put ( "total ",totle);
        maps.put ( "items",list );
        return RespBean.now_success ().data1 ( maps );
    }

    @Override
    public RespBean dataShow() {
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
        return RespBean.data_show ().data1 ( map3 );
    }

    @Override
    public RespBean typeShow() {
        QueryWrapper<UserData> queryWrapper=new QueryWrapper <> (  );
        queryWrapper.like ( "accident_name","超车事故" );
        Integer a=userDataMapper.selectCount ( queryWrapper );
        QueryWrapper<UserData> queryWrapper1=new QueryWrapper <> (  );
        queryWrapper1.like ( "accident_name","直行事故" );
        Integer b=userDataMapper.selectCount ( queryWrapper1 );
        QueryWrapper<UserData> queryWrapper2=new QueryWrapper <> (  );
        queryWrapper.like ( "accident_name","追尾事故" );
        Integer c=userDataMapper.selectCount ( queryWrapper2 );
        QueryWrapper<UserData> queryWrapper3=new QueryWrapper <> (  );
        queryWrapper.like ( "accident_name","其他事故" );
        Integer d=userDataMapper.selectCount ( queryWrapper3);
        List<String> list=new ArrayList <> (  );
        list.add ( "超车事故" );
        list.add ( "直行事故" );
        list.add ( "追尾事故" );
        list.add ( "其他事故" );
        Map<String,Object> map=new HashMap <> (  );
        QueryWrapper<UserData> queryWrapper4=new QueryWrapper <> (  );
        queryWrapper4.last ( "limit 1" );
        Date Times= userDataMapper.selectOne ( queryWrapper4 ).getCreateTime() ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime_10 = dateFormat.format(Times);
        map.put ( "type_name",list);
        map.put ( "time",nowTime_10 );
        map.put ( "超车事故",a);
        map.put ( "直行事故",b );
        map.put ( "追尾事故",c );
        map.put ( "其他事故",d);
        return RespBean.data_show ().data1 ( map );
    }

    @Override
    public RespBean monthShow() {
        List<String> monthlist=new ArrayList <String> (  ){{
            this.add ( "2022-01" );
            this.add ( "2022-02" );
            this.add ( "2022-03" );;
            this.add ( "2022-04" );
            this.add ( "2022-05" );
            this.add ( "2022-06" );
            this.add ( "2022-07" );
            this.add ( "2022-08" );
            this.add ( "2022-09" );
            this.add ( "2022-10" );
            this.add ( "2022-11" );
            this.add ( "2022-12" );
        }};
        List<Object> datash=new ArrayList <> (  );
        for (String month : monthlist) {
            Map<String,Object> map1=new HashMap <> (  );
            QueryWrapper <UserData> queryWrapper = new QueryWrapper <> ();
            queryWrapper.like ( "create_time", month );
            queryWrapper.like ( "accident_name","超车事故" );
            Integer a = userDataMapper.selectCount ( queryWrapper );

            QueryWrapper <UserData> queryWrapper1 = new QueryWrapper <> ();
            queryWrapper1.like ( "create_time", month );
            queryWrapper1.like ( "accident_name","追尾事故" );
            Integer b = userDataMapper.selectCount ( queryWrapper1 );

            QueryWrapper <UserData> queryWrapper2 = new QueryWrapper <> ();
            queryWrapper2.like ( "create_time", month );
            queryWrapper2.like ( "accident_name","直行事故" );
            Integer c = userDataMapper.selectCount ( queryWrapper2 );

            QueryWrapper <UserData> queryWrapper3 = new QueryWrapper <> ();
            queryWrapper3.like ( "create_time", month );
            queryWrapper3.like ( "accident_name","其他事故" );
            Integer d = userDataMapper.selectCount ( queryWrapper3 );
            map1.put ( "month",month );
            map1.put ( "超车事故",a );
            map1.put ( "追尾事故",b );
            map1.put ( "直行事故",c );
            map1.put ( "其他事故",d );
            datash.add ( map1 );
        }
        List<String> list=new ArrayList <> (  );
        list.add ( "超车事故" );
        list.add ( "直行事故" );
        list.add ( "追尾事故" );
        list.add ( "其他事故" );
        Map<String,Object> map=new HashMap <> (  );
        QueryWrapper<UserData> queryWrapper4=new QueryWrapper <> (  );
        queryWrapper4.last ( "limit 1" );
        queryWrapper4.select (  ).orderByDesc ( "create_time" );
        Date Times= userDataMapper.selectOne ( queryWrapper4 ).getCreateTime () ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime_10 = dateFormat.format(Times);
        map.put ( "type_names",list );
        map.put ( "time",nowTime_10 );
        map.put ( "items",datash);
        return RespBean.data_show ().data1 ( map );
    }

    @Override
    public RespBean addressShow() {
        QueryWrapper<UserData> queryWrapper=new QueryWrapper <> (  );
        queryWrapper.like ( "status" ,"已");
        List<UserData> userDatalist=userDataMapper.selectList ( queryWrapper );

        Map<String,Object> processed=new HashMap <> (  );//第一层
        processed.put ( "type", "FeatureCollection" );
        List<Object> features=new ArrayList <> (  );//第二层

        for (UserData userData:userDatalist) {
            Map<String,Object> feature1=new HashMap <> (  );//第三层
            feature1.put ("type","Feature");
            Map <String, Object> geometry = new HashMap <> ();//第五层
            List <Object> address = new ArrayList <> ();//第六层
            address.add ( userData.getAddressLat () );
            address.add ( userData.getAddressLng () );
            geometry.put ( "type", "Point" );
            geometry.put ( "coordinates",address );
            Map<String,Object> properties=new HashMap <> (  );//第五层
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createtime = dateFormat.format(userData.getCreateTime ());
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updatetime = dateFormat1.format(userData.getUpdateTime ());
            properties.put ( "name",userData.getAddress () );
            properties.put ( "create_time",createtime);
            properties.put ( "update_time",updatetime);
            feature1.put ( "properties",properties );
            feature1.put ( "geometry",geometry );
            features.add ( feature1 );
        }
        processed.put ( "features",features );
        QueryWrapper<UserData> queryWrapper1=new QueryWrapper <> (  );
        queryWrapper1.like ( "status" ,"未");
        List<UserData> userDatalist1=userDataMapper.selectList ( queryWrapper1 );

        Map<String,Object> processed1=new HashMap <> (  );//第一层
        processed1.put ( "type", "FeatureCollection" );
        List<Object> featuress=new ArrayList <> (  );//第二层

        for (UserData userData:userDatalist1) {
            Map<String,Object> feature1=new HashMap <> (  );//第三层
            feature1.put ("type","Feature");
            Map <String, Object> geometry = new HashMap <> ();//第五层
            List <Object> address = new ArrayList <> ();//第六层
            address.add ( userData.getAddressLat () );
            address.add ( userData.getAddressLng () );
            geometry.put ( "type", "Point" );
            geometry.put ( "coordinates",address );
            Map<String,Object> properties=new HashMap <> (  );//第五层
            properties.put ( "name",userData.getAddress () );
            properties.put ( "create_time",userData.getCreateTime () );
            feature1.put ( "properties",properties );
            feature1.put ( "geometry",geometry );
            featuress.add ( feature1 );
        }
        processed1.put ( "features",featuress );

        Map<String,Object> map=new HashMap <> (  );//第零层
        map.put ( "processed",processed );
        map.put ( "not_processed",processed1);
        return RespBean.data_show ().data1 ( map );
    }

}
