package com.he.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient  //会自动在服务启动之后注册到 eureka 中
@EnableDiscoveryClient //服务发现 可以获取到注册中心的服务
@EnableCircuitBreaker  //添加熔断的支持，不是默认的 EnableHystrix
public class DeptProvider_8002 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8002.class,args);
    }

    //增加一个 hystrix 监控的 地址 注册到bean 中
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
}
