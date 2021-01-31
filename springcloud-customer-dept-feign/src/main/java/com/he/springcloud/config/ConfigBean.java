package com.he.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean { //Configuation == spring -> appcationContext.xml

    // IRule
    //RoundRobinRule 轮询
    //RandomRule 随机
    //AvailabilityFilteringRule 会先过滤掉故障的服务，对剩下的轮询
    //RetryRule 先按照轮询获取服务，如果服务获取失败，则会在指定的时间进行重试

    @Bean
    @LoadBalanced()  //Ribbon 负载均衡注解  默认是轮询
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    @Bean  //返回 随机负载
//    public IRule myRule(){
//        return new RandomRule();
//        return new HeRandomRule();
//    }
}
