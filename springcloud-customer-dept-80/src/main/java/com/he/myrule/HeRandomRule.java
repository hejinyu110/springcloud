package com.he.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class HeRandomRule extends AbstractLoadBalancerRule {
    private int total = 0;//调用的次数
    private int currentIndex = 0;//当前调用的服务小标

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();//获取所有活着的服务
                List<Server> allList = lb.getAllServers();//获取所有服务
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

//                int index = this.chooseRandomInt(serverCount); //随机获取一个活着的服务下表
//                server = (Server)upList.get(index); 获取到服务

                //将每个可用的服务使用五次后再使用下一个服务
                if(total < 5 ){
                    server = upList.get(currentIndex);
                    total ++;
                }else{
                    total = 0;
                    currentIndex ++;
                    if (currentIndex > upList.size()){
                        currentIndex =0;
                    }
                     server = upList.get(currentIndex);
                }
                System.out.println("service========================== "+currentIndex+" total"+total);

                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }

    @Override
    public Server choose(Object o) {
        System.out.println("default choose");
        return null;
    }
}
