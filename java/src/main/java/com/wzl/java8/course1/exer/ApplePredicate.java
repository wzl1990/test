package com.wzl.java8.course1.exer;

/**
 * Description :
 * Author: zhenglong
 * since 26 九月 2017
 */
@FunctionalInterface
public interface ApplePredicate<T> {

    boolean test(T t);
}
