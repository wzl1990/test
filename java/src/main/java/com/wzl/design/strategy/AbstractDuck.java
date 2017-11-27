package com.wzl.design.strategy;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 24 十月 2017
 */
public abstract class AbstractDuck {

    FlyBehavior flyBehavior;

    public void performFly(){
        flyBehavior.fly();
    }

    public void swarm(){
        System.out.println("swarm");
    }

    public abstract void display();
}
