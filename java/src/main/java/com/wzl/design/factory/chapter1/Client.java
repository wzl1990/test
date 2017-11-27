package com.wzl.design.factory.chapter1;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 05 十一月 2017
 */
public class Client {

    public static void main(String[] args) {
        Command command=new ConcreteCommand();
         Invoker invoker=new Invoker(command);
         invoker.call();
    }
}
