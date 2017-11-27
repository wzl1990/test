package com.wzl.design.factory.demo;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 27 十月 2017
 */
public class FactoryBW330 implements FactoryBW {

    @Override
     public  AbstractBW newBW(){
          return   new BW320();
     }
}
