package com.example.utils;

import com.example.mapper.UserDataMapper;
import com.example.entity.UserData;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Random;

@Component
public class CreateData {
    @Resource
    UserDataMapper userDataMapper;
    @PostConstruct
    public  void create_date(){
//        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		Boolean result = false;
		int count = 0;
        Random random=new Random (  );
		while(count<10000) {
			try {
                    Thread.sleep ( 20 * 1000 );

                    for (int i = 0; i < random.nextInt (10); i++) {
                        UserData userData = new UserData ();
                        StringBuilder str = new StringBuilder ();//定义变长字符串
                        Random random1 = new Random ();
//随机生成数字，并添加到字符串
                        for (int m = 0; m < 12; m++) {
                            str.append ( random1.nextInt ( 10 ) );
                        }
                        userData.setUserId ( str.toString () );
                        userData.setAddress ( "重庆渝北区XXX大道" );
                        userData.setAccidentType ( 3 );
                        userData.setAddressLat ( "216.345" );
                        userData.setAddressLng ( "521.624" );
                        userData.setTime ( "2022-08-07 9:29:31" );
                        userData.setAccidentName ( "追尾事故" );
                        userDataMapper.insert ( userData);
                    }
                    for (int j = 1; j < random.nextInt (10); j++) {
                        UserData userData1 = new UserData ();
                        StringBuilder str2 = new StringBuilder ();//定义变长字符串
                        Random random2 = new Random ();
//随机生成数字，并添加到字符串
                        for (int m = 0; m < 12; m++) {
                            str2.append ( random2.nextInt ( 10 ) );
                        }
                        userData1.setUserId ( str2.toString () );
                        userData1.setAddress ( "重庆九龙坡区" );
                        userData1.setAccidentType ( 3 );
                        userData1.setAddressLat ( "216.345" );
                        userData1.setAddressLng ( "521.624" );
                        userData1.setTime ( "2022-08-07 19:29:31" );
                        userData1.setAccidentName ( "直行事故" );
                        userDataMapper.insert ( userData1 );

                    }
                    for(int k=0;k<random.nextInt (10);k++){
                        UserData userData3 = new UserData ();
                        StringBuilder str3 = new StringBuilder ();//定义变长字符串
                        Random random3 = new Random ();
//随机生成数字，并添加到字符串
                        for (int m = 0; m < 12; m++) {
                            str3.append ( random3.nextInt ( 10 ) );
                        }
                        userData3.setUserId ( str3.toString () );
                        userData3.setAddress ( "重庆南岸区" );
                        userData3.setAccidentType ( 3 );
                        userData3.setAddressLat ( "216.345" );
                        userData3.setAddressLng ( "521.624" );
                        userData3.setTime ( "2022-08-07 21:29:31" );
                        userData3.setAccidentName ( "超车事故" );
                        userDataMapper.insert ( userData3 );
                    }
                    for(int o=0;o<random.nextInt (10);o++){
                        UserData userData4 = new UserData ();
                        StringBuilder str4 = new StringBuilder ();//定义变长字符串
                        Random random4 = new Random ();
//随机生成数字，并添加到字符串
                        for (int m = 0; m < 12; m++) {
                            str4.append ( random4.nextInt ( 10 ) );
                        }
                        userData4.setUserId ( str4.toString () );
                        userData4.setAddress ( "重庆南岸区" );
                        userData4.setAccidentType ( 3 );
                        userData4.setAddressLat ( "216.345" );
                        userData4.setAddressLng ( "521.624" );
                        userData4.setTime ( "2022-08-07 11:29:31" );
                        userData4.setAccidentName ( "其他事故" );
                        userDataMapper.insert ( userData4 );
                    }
                    count++;
                    } catch (InterruptedException e) {
                e.printStackTrace ();
            }

                }
            }
}
