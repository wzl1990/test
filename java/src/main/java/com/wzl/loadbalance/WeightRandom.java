package com.wzl.loadbalance;

import java.util.ArrayList;
import java.util.List;

/**
 * 权重
 *
 * @author zhenglong.wei
 * @create 2017-07-13 23:35
 */
public class WeightRandom implements  LoadBalance {

    private static Integer index;

    @Override
    public Server getServer(List<Server> servers) {
        List<Server> list=new ArrayList<>();
        for(Server s:servers){
            int weight = s.getWeight();
            for(int i=0;i<weight;i++){
                list.add(s);
            }
        }
        java.util.Random r=new java.util.Random();
        int i = r.nextInt(servers.size());
        return list.get(i);
    }
}
