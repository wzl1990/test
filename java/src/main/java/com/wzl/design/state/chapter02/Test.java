package com.wzl.design.state.chapter02;

/**
 * @author: weizhenglong
 * @since 2018-04-11
 */
public class Test {

    public static void main(String[] args) {
        new StateContext(newState(1)).action();
        new StateContext(newState(2)).action();
        new StateContext(newState(3)).action();
    }

    private static AbstractState newState(int type){
        if(type==1){
            return new AllStateHandle();
        }
        if(type==2){
            return new WeekEndStateHandle();
        }
        if(type==3){
            return new WorkStateHandle();
        }
        throw new RuntimeException("not found state");
    }
}
