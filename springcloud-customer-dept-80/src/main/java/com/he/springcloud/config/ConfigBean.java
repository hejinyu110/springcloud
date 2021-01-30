package com.he.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean { //Configuation == spring -> appcationContext.xml
    @Bean
    @LoadBalanced  //Ribbon 负载均衡注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
