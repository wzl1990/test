package com.wzl.design.factory.chapter1;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 05 十一月 2017
 */
public class Invoker {

    private  Command command;

    public  Invoker(Command command){
        this.command=command;
    }

    public  void call(){
        command.execute();
    }
}
