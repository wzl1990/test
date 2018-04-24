package com.wzl.design.state.chapter02;

/**
 * @author: weizhenglong
 * @since 2018-04-11
 */
public class WorkStateHandle extends   AbstractState {

    @Override
    String handle() {
        System.out.println("work");
        return "work";
    }
}
