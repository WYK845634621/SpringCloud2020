package com.yikai.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description feign的日志配置规则
 * @Tips
 * @Author yikai.wang
 * @Date 2020/4/4 18:17
 */
@Configuration
public class FeignLogConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
