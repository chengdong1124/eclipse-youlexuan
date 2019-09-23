package com.offcn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.offcn.dao")  //或者不写在mapper上注解@Mapper
public class Myapp {

	public static void main(String[] args) {
		SpringApplication.run(Myapp.class, args);
	}
}
