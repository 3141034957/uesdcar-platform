package com.usedcar.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 用户服务应用启动类
 * 用于启动 usedcar-user 微服务
 */
@SpringBootApplication
@MapperScan("com.usedcar.user.mapper")
public class UsedcarUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsedcarUserApplication.class, args);
        System.out.println("🚗【UsedCar 用户服务】启动成功！");
    }
}
