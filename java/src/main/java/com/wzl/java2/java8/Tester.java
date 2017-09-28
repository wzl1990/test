package com.wzl.java2.java8;

import java.util.stream.IntStream;
import java.util.stream.LongStream;


public class Tester {
	
	public static void main(String[] args) {
        long sum2 = LongStream.range(1, 10000004005l).parallel()/*.map(Tester::fib)*/.sum();
 
        int sum = IntStream.range(1, 100000045).map(Tester::fib).sum();
        System.out.println(sum+"-"+sum2);
        System.out.println("AAAAAAAAAAAAAAA");
    }
 
    private static int fib(int n) {
       /* if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    	System.out.println(n);*/
    	return 1;
    }	

}
