package com.yikai.springcloud.controller;

import com.yikai.springcloud.entities.CommonResult;
import com.yikai.springcloud.entities.Payment;
import com.yikai.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/3/15 11:38
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("****插入结果: " + result);

        if (result > 0){
            return new CommonResult(200,"插入数据库成功,port: " + port,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }



    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果: " + payment);
        log.info("热部署");
        if (payment != null){
            return new CommonResult(200,"查询成功,port: " + port,payment);
        }else {
            return new CommonResult(444,"没有对应记录,查询ID为: " + id,null);
        }
    }

}
