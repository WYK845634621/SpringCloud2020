package com.yikai.springcloud.controller;

import com.yikai.springcloud.entities.CommonResult;
import com.yikai.springcloud.entities.Payment;
import com.yikai.springcloud.service.PaymentService;
import com.yikai.springcloud.vo.ParamVo;
import com.yikai.springcloud.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
            return new CommonResult(200,"插入数据库成功,poer: " + port,result);
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


    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String s : services){
            log.info("服务名: " + s);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances){
            log.info("实例信息: " + instance.getHost() +"  " + instance.getPort() + "  " + instance.getInstanceId() +"  " + instance.getServiceId());
        }
        return  this.discoveryClient;
    }

    @GetMapping("/payment/feign/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return port;
    }


    @PostMapping("/payment/post")
    public ResultVo<String> post(@RequestBody ParamVo<String,String> paramVo){
        ResultVo<String> resultVo = new ResultVo<>();
        try {
            resultVo.setResult(paramVo.getCondition());
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return resultVo;
    }

}
