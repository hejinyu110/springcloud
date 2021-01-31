package com.he.springcloud;

import com.he.myrule.HeRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.he.springcloud")
@ComponentScan("com.he.springcloud")
public class FeignDeptCustomer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptCustomer_80.class,args);
    }
}
