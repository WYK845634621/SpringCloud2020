package com.yikai.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/5/17 10:53
 */
@Service
public class PaymentService {

    public String paymentinfo_ok(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + " payemtninfo_ok  " + id + "\t" + "哈哈";
    }


    @HystrixCommand(fallbackMethod = "paymetnninfo_TimeoutHandler", commandProperties = {
            //指定服务的响应时间,响应时间超时或者报异常都会调用fallback方法
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentinfo_timeout(Integer id) {
//        int timenumber = 4;
        int i = 10/0;
        try {
//            TimeUnit.SECONDS.sleep(timenumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + " paymentinfo_timeout  " + id + "\t" + "耗时: "  + "秒";
    }


    public String paymetnninfo_TimeoutHandler(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "系统繁忙: " + id +"  出现了异常";
    }


}
