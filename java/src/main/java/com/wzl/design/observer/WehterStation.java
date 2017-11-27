package com.wzl.design.observer;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 24 十月 2017
 */
public class WehterStation {

    public static void main(String[] args) {
        WeahterDataSubject weahterDataSubject=new WeahterDataSubject();
        CurrentConditionDisplay currentConditionDisplay=new CurrentConditionDisplay(weahterDataSubject);
        weahterDataSubject.registerObserver(currentConditionDisplay);
        weahterDataSubject.set(1,2,3);
        weahterDataSubject.set(2,3,3);
    }
}
