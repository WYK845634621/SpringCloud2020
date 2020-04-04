package com.yikai.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/3/16 15:23
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;


    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper port: " + port + UUID.randomUUID().toString();
    }

}
