package com.yikai.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/3/15 14:39
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced       //部署了多个后台时,只有使用这个注解才能调用
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
