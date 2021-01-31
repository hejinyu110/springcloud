package com.he.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeRule {
    public IRule myRule(){
//        return new RandomRule();
        return new HeRandomRule(); //默认是轮训，现在换位每个五次
    }
}
