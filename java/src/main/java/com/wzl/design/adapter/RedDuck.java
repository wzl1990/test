package com.wzl.design.adapter;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 25 十月 2017
 */
public class RedDuck implements Duck {
    @Override
    public void fly() {
        System.out.println("flu");
    }

    @Override
    public void swarm() {
        System.out.println("swarm");
    }
}
