package com.wzl.design.state.chapter02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: weizhenglong
 * @since 2018-04-11
 */
@AllArgsConstructor
@Setter
@Getter
public class StateContext {


    private AbstractState abstractState;

    public void action(){
        abstractState.handle();
    }
}
