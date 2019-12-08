package com.hunau.userlogin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.hunau.userlogin.dao")
@SpringBootApplication
public class UserloginApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserloginApplication.class, args);
    }

}
