package com.he.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

//数据网络传输需要序列化
@Data
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class Dept implements Serializable {

    private long deptno;
    private String dname;
    //这个数据是存在哪个库的  微服务架构 一个服务对应一个数据库
    private String db_source;

    public Dept (String dname){
        this.dname = dname;
    }

}
