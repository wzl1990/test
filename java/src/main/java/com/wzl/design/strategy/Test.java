package com.wzl.design.strategy;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 25 十月 2017
 */
public class Test {

    public static void main(String[] args) {
        AbstractDuck a=new BlueDuck(new BFlyBehavior());
        a.performFly();
    }
}
