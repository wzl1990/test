package com.wzl.guava.utils;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;


public class SpliterTest {

    @Test
    public void testSpliter(){
        List<String> strings = Splitter.on("#").splitToList("wei#zheng#long");
        List<String> strings2 = Splitter.on("#").splitToList(" wei#zheng#long");
        List<String> strings3 = Splitter.on("#").trimResults().splitToList(" wei#zheng#long");
        System.out.println(strings);
        System.out.println(strings2);
        System.out.println(strings3);
        System.out.println(Splitter.on("#").splitToList("wei#zhenglong#long###").size());
        System.out.println(Splitter.on("#").omitEmptyStrings().splitToList("wei#zhenglong#long###").size());

    }

    @Test
    public void testFixedSpliter(){
        System.out.println(Splitter.fixedLength(3).splitToList("aaabbbccc"));
        List<String> strings = Splitter.onPattern(",").splitToList("a,b,c");
        System.out.println(strings);
    }
}
