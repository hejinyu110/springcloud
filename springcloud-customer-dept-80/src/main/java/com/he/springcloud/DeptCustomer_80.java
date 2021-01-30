package com.he.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.swing.*;

@SpringBootApplication
@EnableEurekaClient
public class DeptCustomer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptCustomer_80.class,args);
    }
}
