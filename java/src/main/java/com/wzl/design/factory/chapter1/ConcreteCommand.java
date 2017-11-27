package com.wzl.design.factory.chapter1;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 05 十一月 2017
 */
public class ConcreteCommand implements  Command {

    private  Receiver receiver=new Receiver();

    @Override
    public void execute() {
        System.out.println("命令的执行");
        receiver.action();
    }
}
