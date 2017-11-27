package com.wzl.design.strategy;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 24 十月 2017
 */
public class BlueDuck extends AbstractDuck {

    public  BlueDuck( BFlyBehavior flyBehavior){
        super.flyBehavior=flyBehavior;
    }



    @Override
    public void display() {
        System.out.println("blue");
    }
}
