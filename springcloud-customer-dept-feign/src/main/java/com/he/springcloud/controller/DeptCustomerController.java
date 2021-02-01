package com.he.springcloud.controller;

import com.he.springcloud.pojo.Dept;
import com.he.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptCustomerController {

    @Autowired
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
