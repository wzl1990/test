package com.wzl.loadbalance;

import java.util.ArrayList;
import java.util.List;

/**
 * 权重
 *
 * @author zhenglong.wei
 * @create 2017-07-13 23:35
 */
public class Hash implements  LoadBalance {

    private static Integer index;

    @Override
    public Server getServer(List<Server> servers) {
        String ip="127.0.0.1";
        int hashCode = ip.hashCode();
        int i = hashCode % servers.size();
        return servers.get(i);
    }
}
