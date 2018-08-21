package com.hand.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// Spring Boot 应用的标识
@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("com.hand.demo.infra.mapper")
//@tk.mybatis.spring.annotation.MapperScan(basePackages = { "com.hand.demo.mapper" },markerInterface = CityMapper.class)
@ServletComponentScan
public class WebApplication {

    public static void main(String[] args) {

        SpringApplication.run(WebApplication.class, args);

    }
}
