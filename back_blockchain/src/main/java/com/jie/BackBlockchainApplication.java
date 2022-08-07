package com.jie;
import com.jie.mapper.UserDataMapper;
import com.jie.pojo.UserData;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;


//@CrossOrigin
@MapperScan("com.jie.mapper")
@SpringBootApplication
public class BackBlockchainApplication {


	public static void main(String[] args) {



		SpringApplication.run(BackBlockchainApplication.class, args);

	}



}
