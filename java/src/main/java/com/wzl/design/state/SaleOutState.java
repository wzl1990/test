package com.wzl.design.state;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 03 十一月 2017
 */
public class SaleOutState {

    GumballMachine gumballMachine;

    public SaleOutState(GumballMachine gumballMachine){
        this.gumballMachine=gumballMachine;
    }

    public void inertQunater(){
        System.out.println("投币了");
        gumballMachine.setState(GumballMachine.HAS_QUANTER);

    }
}
