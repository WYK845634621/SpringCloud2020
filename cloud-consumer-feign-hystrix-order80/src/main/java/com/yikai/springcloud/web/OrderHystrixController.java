package com.yikai.springcloud.web;

import com.yikai.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/5/17 11:13
 */
@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String ok(@PathVariable("id") Integer id){
        return paymentHystrixService.ok(id);
    }


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    String timeout(@PathVariable("id") Integer id){
        return paymentHystrixService.timeout(id);
    }


}
