package com.wzl.design.state.chapter02;

/**
 * @author: weizhenglong
 * @since 2018-04-11
 */
public class WeekEndStateHandle extends   AbstractState {

    @Override
    String handle() {
        System.out.println("week");
        return "week";
    }
}
