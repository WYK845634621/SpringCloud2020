package com.yikai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/5/17 11:10
 */
@SpringBootApplication
@EnableFeignClients
public class OrderHystrixMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain.class,args);
    }

}
