package com.jie;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jie.mapper.UserDataMapper;

import com.jie.pojo.UserData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class BackBlockchainApplicationTests {
	@Autowired
	UserDataMapper userDataMapper;
	//假数据生成
	@Test
	void test() {
		for (int j=0; j <4; j++) {
			UserData userData=new UserData ();
			StringBuilder str = new StringBuilder ();//定义变长字符串
			Random random = new Random ();
//随机生成数字，并添加到字符串
			for (int i = 0; i < 12; i++) {
				str.append ( random.nextInt ( 10 ) );
			}
			userData.setUserId ( str.toString () );
			userData.setAddress ( "重庆渝中区XXX大道" );
			userData.setAccidentType ( 3);
			userData.setAddressLat ( "216.345" );
			userData.setAddressLng ( "521.624" );
			userData.setTime ( "2022-08-08 08:12:31" );
			userData.setAccidentName ("超车事故");
			userDataMapper.insert ( userData );

		}


	}
	@Test
	void select() {
//		QueryWrapper<UserData> queryWrapper=new QueryWrapper <> (  );
//		queryWrapper.isNotNull ( "user_id" );
//		System.out.println ( userDataMapper.selectCount ( queryWrapper ) );
		UserData userData=new UserData ();
		userData.setId ( 3 );
		userData.setAddress ( "重庆九龙坡" );
		userDataMapper.updateById ( userData );

	}

	@Test
	void test1(){
//		QueryWrapper<UserData> queryWrapper =new QueryWrapper <> (  );
//		queryWrapper.le ( "id",10 );
//		List <UserData> list= userDataMapper.selectList ( queryWrapper  );
//		System.out.println ( com.alibaba.fastjson.JSONArray.toJSONString ( list ) );
		UserData userData1=userDataMapper.selectById ( 1 );
		String json = JSONObject.toJSONString(userData1);
		System.out.println ( json );

	}
//	@Test
//	void deleteall(){
//		QueryWrapper<UserData> queryWrapper=new QueryWrapper <> (  );
//		queryWrapper.isNotNull ( "user_id" );
//		userDataMapper.delete ( queryWrapper );
//	}
}

