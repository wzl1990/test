package com.wzl.loadbalance;

import java.util.List;

/**
 * 轮训算法
 * @author zhenglong.wei
 * @create 2017-07-13 21:04
 */
public class RoundRobin implements  LoadBalance {

    private static Integer index;
    @Override
    public Server getServer(List<Server> servers) {
        Server server=null;
        synchronized(index){
            if(index>servers.size()){
                 server=servers.get(index);
                 index++;
            }
        }
        return server;
    }

}
