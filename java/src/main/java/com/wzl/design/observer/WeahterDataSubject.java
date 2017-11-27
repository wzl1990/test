package com.wzl.design.observer;

import java.util.Vector;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 24 十月 2017
 */
public class WeahterDataSubject  implements  Subject{

      Vector<Observer> vector=new Vector<>();

      float temperature;
      float humidity;
      float pressure;

      @Override
      public boolean registerObserver(Observer observer) {
            vector.add(observer);
            return false;
      }

      @Override
      public boolean removeObserver(Observer observer) {
            vector.remove(observer);
            return false;
      }

      @Override
      public void nofityObservers() {
              for(Observer o:vector){
                    o.update(temperature,humidity,pressure);
              }
      }

      public void changed(){
            nofityObservers();
      }

      public void set(float temperature,float humidity,float pressure){
            this.temperature=temperature;
            this.humidity=humidity;
            this.temperature=pressure;
            changed();
      }
}
