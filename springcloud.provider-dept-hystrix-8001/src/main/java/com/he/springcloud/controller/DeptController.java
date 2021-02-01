package com.he.springcloud.controller;

import com.he.springcloud.pojo.Dept;
import com.he.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //提供restful 服务
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;


    @RequestMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    //hystrix 熔断服务 ，如果有异常则直接调用 熔断的方法返回信息
    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        System.out.println("get params "+id);
        Dept dept = deptService.queryById(id);
        if (dept == null) {
            throw new RuntimeException("id=>"+id+" 不存在，或者无法获取到信息");
        }
        return deptService.queryById(id);
    }
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("没有对应的信息 null in hystrix")
                .setDb_source("no database in mysql");
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    //注册进来的微服务可以获取到一些消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务信息
        List<String> services = client.getServices();
        System.out.println("discovery=>services"+services);
        //得到一个具体的微服务信息
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances){
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()+"\t"
            );
        }
        return this.client;

    }
}
