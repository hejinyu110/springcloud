package com.he.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeRule {
    public IRule myRule(){
        return new RandomRule();
    }
}
