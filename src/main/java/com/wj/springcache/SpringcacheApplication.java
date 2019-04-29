package com.wj.springcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.wj.springcache.mapper")
@EnableCaching
@SpringBootApplication
public class SpringcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcacheApplication.class, args);
    }

}
