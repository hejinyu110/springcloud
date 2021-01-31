package com.he.springcloud;

import com.he.myrule.HeRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候就自动去加载了 自定义的  Ribbon 类
// HeRule 不能放到  应用程序下面，否则服务器加载
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = HeRule.class)
public class DeptCustomer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptCustomer_80.class,args);
    }
}
