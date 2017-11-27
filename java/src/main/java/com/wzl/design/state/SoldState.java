package com.wzl.design.state;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 03 十一月 2017
 */
public class SoldState {

    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine){
        this.gumballMachine=gumballMachine;
    }

    public void inertQunater(){
        gumballMachine.setState(GumballMachine.SOLD);
        System.out.println("卖了");
    }
}
