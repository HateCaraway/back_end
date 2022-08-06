package com.jie;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


//@CrossOrigin
@MapperScan("com.jie.mapper")
@SpringBootApplication
public class BackBlockchainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackBlockchainApplication.class, args);
	}



}
