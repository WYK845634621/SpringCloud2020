package com.yikai.myrule;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/3/31 17:21
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule getRule(){
        return new RandomRule();
    }

}
