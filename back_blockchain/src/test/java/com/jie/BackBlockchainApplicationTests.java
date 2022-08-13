package com.jie;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jie.mapper.UserDataMapper;

import com.jie.pojo.User;
import com.jie.pojo.UserData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Random;

@SpringBootTest
class BackBlockchainApplicationTests {
	@Resource
	UserDataMapper userDataMapper;
	//假数据生成
	@Test
	void test() {
		for (int j=0; j <4; j++) {
			UserData userData=new UserData ();
			StringBuilder str = new StringBuilder ();//定义变长字符串
			Random random = new Random ();
//随机生成数字，并添加到字符串
			for (int i = 0; i < 11; i++) {
				str.append ( random.nextInt ( 10 ) );
			}
			userData.setUserId ( str.toString () );
			userData.setAddress ( "重庆南岸区XXX大道" );
			userData.setAccidentType ( 3);
			userData.setAddressLat ( "216.345" );
			userData.setAddressLng ( "521.624" );
			userData.setTime ( "2022-08-07 19:29:31" );
			userData.setAccidentName ("追尾事故");
			userDataMapper.insert ( userData );

		}


	}
	@Test
	void select() {
//		QueryWrapper<UserData> queryWrapper=new QueryWrapper <> (  );
//		queryWrapper.isNotNull ( "user_id" );
//		System.out.println ( userDataMapper.selectCount ( queryWrapper ) );
		UserData userData=new UserData ();
		userData.setAccidentId ( 3 );
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
	@Test
	void deleteall(){
		QueryWrapper<UserData> queryWrapper=new QueryWrapper <> (  );
		queryWrapper.between ( "id",2247,96665 );
		userDataMapper.delete ( queryWrapper );
	}

	@Test
	void ceshi(){
		Page<UserData> page=new Page <> ( 6,20 );
		QueryWrapper<UserData> queryWrapper =new QueryWrapper <> (  );
		queryWrapper.select().orderByDesc("create_time");
		userDataMapper.selectPage ( page,queryWrapper );
		System.out.println (page.getRecords ());
	}
	@Test
	void chaxunzongshu(){
		QueryWrapper<UserData> userDataQueryWrapper=new QueryWrapper <> (  );
		userDataQueryWrapper.eq ( "deleted" ,1);
		userDataMapper.selectList ( userDataQueryWrapper );
	}
	@Test
	void change(){
		QueryWrapper<UserData> queryWrapper=new QueryWrapper <> (  );
		queryWrapper.eq ( "user_id","02469578735" );
		UserData userData=userDataMapper.selectOne ( queryWrapper);
		UserData userData1=new UserData ();
		userData1.setAccidentId ( userData.getAccidentId () );
		userData1.setStatus ( "已出警" );
		userDataMapper.updateById ( userData1 );


	}

}

