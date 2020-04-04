package com.yikai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/3/15 11:01
 */
@SpringBootApplication
@EnableDiscoveryClient      //在使用consule或者zookeeper时使用这个注解
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
