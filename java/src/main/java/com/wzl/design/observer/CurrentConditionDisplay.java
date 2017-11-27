package com.wzl.design.observer;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 24 十月 2017
 */
public class CurrentConditionDisplay implements Observer,DisplayElement{

    private  float temperature;

    private float humidity;

    private float pressure;

    private  Subject subject;

    public CurrentConditionDisplay(Subject subject){
     this.subject=subject;
    }

    @Override
    public void display() {
        System.out.println("temperature="+temperature+":"+"humidity="+humidity);

    }
    @Override
    public void update(float temperature, float humidity, float pressure) {
           this.temperature=temperature;
           this.humidity=humidity;
           this.pressure=pressure;
           display();
    }




}
