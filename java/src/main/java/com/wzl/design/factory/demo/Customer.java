package com.wzl.design.factory.demo;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 27 十月 2017
 */
public class Customer {

    public static void main(String[] args) {
        FactoryBW bw530=new FactoryBW530();
        bw530.newBW();
        FactoryBW bw330=new FactoryBW330();
        bw330.newBW();
    }
}
