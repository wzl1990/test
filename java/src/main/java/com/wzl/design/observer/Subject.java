package com.wzl.design.observer;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 24 十月 2017
 */
public interface Subject {

      boolean registerObserver(Observer observer);
      boolean removeObserver(Observer observer);
      void nofityObservers();


}
