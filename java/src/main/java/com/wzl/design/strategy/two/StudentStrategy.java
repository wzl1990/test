package com.wzl.design.strategy.two;

/**
 * @author: weizhenglong
 * @since 2018-04-11
 */
public class StudentStrategy extends AbstractStrategy {

    @Override
    public double discont(double original) {
        return original-1;
    }
}
