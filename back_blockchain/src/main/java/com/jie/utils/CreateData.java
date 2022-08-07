package com.jie.utils;

import com.jie.mapper.UserDataMapper;
import com.jie.pojo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class CreateData {
//    @Resource
//    UserDataMapper userDataMapper;
//    @PostConstruct
//    public  void create_date(){
////        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
//		Boolean result = false;
//		int count = 0;
//		while(count<10000) {
//			try {
//                    Thread.sleep ( 50 * 1000 );
//
//                    for (int i = 1; i < 5; i++) {
//                        UserData userData = new UserData ();
//                        StringBuilder str = new StringBuilder ();//定义变长字符串
//                        userData.setUserId ( str.toString () );
//                        userData.setAddress ( "重庆渝北区XXX大道" );
//                        userData.setAccidentType ( 3 );
//                        userData.setAddressLat ( "216.345" );
//                        userData.setAddressLng ( "521.624" );
//                        userData.setTime ( "2022-08-07 9:29:31" );
//                        userData.setAccidentName ( "追尾事故" );
//                        userDataMapper.insert ( userData );
//                    }
//                    for (int j = 1; j < 3; j++) {
//                        UserData userData1 = new UserData ();
//                        StringBuilder str1 = new StringBuilder ();//定义变长字符串
//                        userData1.setUserId ( str1.toString () );
//                        userData1.setAddress ( "重庆九龙坡区" );
//                        userData1.setAccidentType ( 3 );
//                        userData1.setAddressLat ( "216.345" );
//                        userData1.setAddressLng ( "521.624" );
//                        userData1.setTime ( "2022-08-07 19:29:31" );
//                        userData1.setAccidentName ( "直行事故" );
//                        userDataMapper.insert ( userData1 );
//
//                    }
//                    for(int k=0;k<1;k++){
//                        UserData userData1 = new UserData ();
//                        StringBuilder str1 = new StringBuilder ();//定义变长字符串
//                        userData1.setUserId ( str1.toString () );
//                        userData1.setAddress ( "重庆南岸区" );
//                        userData1.setAccidentType ( 3 );
//                        userData1.setAddressLat ( "216.345" );
//                        userData1.setAddressLng ( "521.624" );
//                        userData1.setTime ( "2022-08-07 21:29:31" );
//                        userData1.setAccidentName ( "超车事故" );
//                        userDataMapper.insert ( userData1 );
//                    }
//                    for(int o=0;o<4;o++){
//                        UserData userData1 = new UserData ();
//                        StringBuilder str1 = new StringBuilder ();//定义变长字符串
//                        userData1.setUserId ( str1.toString () );
//                        userData1.setAddress ( "重庆南岸区" );
//                        userData1.setAccidentType ( 3 );
//                        userData1.setAddressLat ( "216.345" );
//                        userData1.setAddressLng ( "521.624" );
//                        userData1.setTime ( "2022-08-07 11:29:31" );
//                        userData1.setAccidentName ( "其他事故" );
//                        userDataMapper.insert ( userData1 );
//                    }
//                    count++;
//                    } catch (InterruptedException e) {
//                e.printStackTrace ();
//            }
//
//                }
//            }
}
