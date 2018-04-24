package com.wzl.design.strategy.two;

/**
 * @author: weizhenglong
 * @since 2018-04-11
 */
public class Test {

    public static void main(String[] args) {
        AbstractStrategy abstractStrategy=new StudentStrategy();
        DiscontContext discontContext=new DiscontContext(abstractStrategy);

        discontContext.cal(76);


    }
}
