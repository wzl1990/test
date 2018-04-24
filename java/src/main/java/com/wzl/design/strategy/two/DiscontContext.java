package com.wzl.design.strategy.two;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * @author: weizhenglong
 * @since 2018-04-11
 */
@Setter
@AllArgsConstructor
public class DiscontContext {



    private AbstractStrategy abstractStrategy;

    public double cal(double original){
        return abstractStrategy.discont(original);
    }


}
