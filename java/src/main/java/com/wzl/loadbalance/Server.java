package com.wzl.loadbalance;

/**
 * 服务
 *
 * @author zhenglong.wei
 * @create 2017-07-13 21:01
 */
public class Server {

    private String ip;

    private int weight;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
