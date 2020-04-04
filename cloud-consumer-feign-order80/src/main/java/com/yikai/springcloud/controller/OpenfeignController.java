package com.yikai.springcloud.controller;

import com.yikai.springcloud.entities.CommonResult;
import com.yikai.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/4/4 17:41
 */
@RestController
@Slf4j
public class OpenfeignController {
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }


    /**
     * @Note: feign客户端默认的超时时间是1秒
     * @Date:2020/4/4 18:07 @Auth:yikai.wang @Desc(V): 1.0.7
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String timeout(){
        return paymentService.timeout();
    }
}
