package com.wzl;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
    
    @Test
    public void test09() {
        List<Integer> integers = Arrays.asList(1, 5, 8, 3, 5, 23, 45);
        for (Iterator iterator = integers.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
        Map<String, String> map = new HashMap();
        map.put("a", "a");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }


        @Test
    public  void test18(){
            Executors.newCachedThreadPool();

        BigDecimal bigDecimal=new BigDecimal("17");
        bigDecimal.setScale(2);
        System.out.println(bigDecimal);
    }

    @Test
    public  void test(){
        float x = 1.0f;
        float y = 0.8f;
        float z = x - y;
        System.out.println(z);
    }

    @Test
    public void test3(){
        float x = 1.5f;
        float y = 0.7f;

        BigDecimal x1 = new BigDecimal(Float.toString(x));
        BigDecimal x2 = new BigDecimal(Float.toString(y));
        float z = x1.divide(x2,5).floatValue();//  x1.subtract(x2).floatValue();
        System.out.println(z);
    }
    @Test
    public void test2(){
        float x = 1.0f;
        float y = 0.8f;

        BigDecimal x1 = new BigDecimal(Float.toString(x));
        BigDecimal x2 = new BigDecimal(Float.toString(y));
        float z = x1.subtract(x2).floatValue();
        System.out.println(z);
    }




    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
