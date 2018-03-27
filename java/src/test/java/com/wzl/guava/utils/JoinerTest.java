package com.wzl.guava.utils;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class JoinerTest {

    private static final List<String> stringList= Arrays.asList("java","scala");
    private static final List<String> stringListWithNull= Arrays.asList("java","scala",null);
     static Map<String,String> map=new HashMap<String,String>();

     static {
         map.put("a","b");
         map.put("a","b");
     }

    @Test
    public void testJoin(){
        System.out.println(Joiner.on("#").join(stringList));
        System.out.println(Joiner.on("#").skipNulls().join(stringListWithNull));
        System.out.println(Joiner.on("#").useForNull("null").join(stringListWithNull));
    }

    @Test
    public void testJoinAppend(){
        System.out.println(Joiner.on("#").join("a","n"));
        StringBuilder sb=new StringBuilder();
        System.out.println(Joiner.on("#").appendTo(sb,stringList));
        System.out.println(sb.toString());
    }

    @Test
    public void testWithKeyValueSeparator(){
        System.out.println(Joiner.on("#").withKeyValueSeparator(",").join(map));
    }

    @Test
    public void testJava8Join(){
        System.out.println(stringList.stream().filter(item->!Objects.isNull(item)).collect(Collectors.joining("#")));
    }

}
