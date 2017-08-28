package com.wzl.loadbalance;

import java.util.List;

/**
 * @author zhenglong.wei
 * @create 2017-07-13 21:03
 */
public interface LoadBalance {

     Server getServer(List<Server> servers);
}
