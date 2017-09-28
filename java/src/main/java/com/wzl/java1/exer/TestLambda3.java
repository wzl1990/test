package com.wzl.java1.exer;

import org.junit.Test;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;

public class TestLambda3 {

	@Test
	public  void test1(){
		IntPredicate intPredicate=(i->i>5);
		System.out.println(intPredicate.test(5));
		IntConsumer intConsumer=(i-> System.out.println(i+8));
		intConsumer.accept(3);
		IntSupplier supplier=(()->7);
		System.out.println(supplier.getAsInt());
		IntFunction<Long> longIntFunction=(e->new Long(e));
		System.out.println(longIntFunction.apply(5));

		final int portNumber = 1337;
		Runnable r = () -> System.out.println(portNumber);



	}
}
