package com.wzl;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{

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
