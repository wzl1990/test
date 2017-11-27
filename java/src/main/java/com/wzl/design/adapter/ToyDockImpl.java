package com.wzl.design.adapter;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 25 十月 2017
 */
public class ToyDockImpl implements ToyDuck {
    @Override
    public void fly() {
        System.out.println("toy fly");
    }

    @Override
    public void drift() {
        System.out.println("drift");
    }
}
