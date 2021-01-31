package com.he.springcloud.controller;

import com.he.springcloud.pojo.Dept;
import com.he.springcloud.pojo.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptCustomerController {
    //消费者 没有 service
    //restTemplate 供我们调用就可了，，注册到spring 中
    //(url,实体：map,class<T> responseType)

    @Autowired
    private RestTemplate restTemplate;//提供简单的 http服务的方法，简单的restfull 模板

    private DeptClientService deptClientService = null;

    @RequestMapping("/customer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptClientService.queryById(id);
    }

    @RequestMapping("/customer/dept/add")
    public Boolean add(Dept dept){
        return deptClientService.addDept(dept);
    }

    @RequestMapping("/customer/dept/list")
    public List<Dept> list(){
        return deptClientService.queryAll();
    }
}
