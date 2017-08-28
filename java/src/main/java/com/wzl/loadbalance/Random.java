package com.wzl.loadbalance;

import java.util.List;

/**
 * 随机
 *
 * @author zhenglong.wei
 * @create 2017-07-13 21:12
 */
public class Random implements  LoadBalance{

    @Override
    public Server getServer(List<Server> servers) {
        java.util.Random r=new java.util.Random();
        int i = r.nextInt(servers.size());
        return servers.get(i);
    }
}
