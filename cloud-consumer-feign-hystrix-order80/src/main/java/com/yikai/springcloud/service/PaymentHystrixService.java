package com.yikai.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/5/17 11:11
 */
@Component
@FeignClient(value = "cloud-provider-hystrix-payment")
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String ok(@PathVariable("id") Integer id);


    @GetMapping("/payment/hystrix/timeout/{id}")
    String timeout(@PathVariable("id") Integer id);
}
