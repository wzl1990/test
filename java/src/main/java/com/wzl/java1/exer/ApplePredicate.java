package com.wzl.java1.exer;

import org.apache.poi.ss.formula.functions.T;

/**
 * Description :
 * Author: zhenglong
 * since 26 九月 2017
 */
@FunctionalInterface
public interface ApplePredicate<T> {

    boolean test(T t);
}
