package com.wzl.design.adapter;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 25 十月 2017
 */
public class ToyDuckAdapter implements Duck {

    private ToyDuck toyDuck;

    public ToyDuckAdapter(ToyDuck toyDuck){
        this.toyDuck=toyDuck;
    }

    @Override
    public void fly() {
        toyDuck.fly();
    }

    @Override
    public void swarm() {
      toyDuck.drift();
    }

    public static void main(String[] args) {
        Duck duck=new ToyDuckAdapter(new ToyDockImpl());
        duck.fly();
    }
}
