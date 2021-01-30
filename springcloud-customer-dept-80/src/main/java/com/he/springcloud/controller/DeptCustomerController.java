package com.he.springcloud.controller;

import com.he.springcloud.pojo.Dept;
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


//    private static final String REST_URL_PREFIX = "http://localhost:8002";
    //ribbon 这里的地址是一个变量，通过服务名称来获取
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-POROVIDER-DEPT";

    @RequestMapping("/customer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/customer/dept/add")
    public Boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add/",dept,Boolean.class);
    }

    @RequestMapping("/customer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
}
