package com.wzl.java1.exer;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.wzl.java1.java8.Apple;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TestLambda2 {
	
	List<Apple> apples = Arrays.asList(
			new Apple("red",100),
			new Apple("green",90),
			new Apple("green",120),
			new Apple("red",150)

	);

	@Test
	public void test4() {
		Stream<String> stringStream = apples.stream().flatMap(e -> Arrays.stream(e.getColor().split("")));
		List<String> collect = stringStream.collect(Collectors.toList());
		System.out.println(collect);
	}

	@Test
	public void test3() {
		List<String> list=Arrays.asList("HELLO","WORD");
		Function<T[], Stream<T>> streamFunction = Arrays::stream;
		List<String> collect = list.stream()
				.map(word -> word.split(""))
				.flatMap(e -> Arrays.stream(e))
				.sorted((e1,e2)->e2.compareTo(e1))
				.collect(Collectors.toList());
		System.out.println(collect);
	}

	@Test
	public void test2(){
		List<Integer> collect = apples.stream().filter(e -> {
			System.out.println("filger" + e.getWeight());
			return e.getWeight() > 102;
		}).map(e -> {
			System.out.println("map" + e.getWeight());
			return e.getWeight();
		}).limit(2).collect(Collectors.toList());
		System.out.println(collect);
	}
	
	@Test
	public void test1(){
            List list=filterApple(apples, new ApplePredicate<Apple>() {
			@Override
			public boolean test(Apple apple) {
				return apple.getColor().equals("red");
			}
		});
		System.out.println(list);
		Comparator<Apple> comparing = Comparator.comparing(Apple::getWeight);
		Function<Apple, Integer> getWeight = Apple::getWeight;
		Function<Apple, Integer> w = (e->e.getWeight());
		Maps.EntryTransformer<String, Integer, String> stringIntegerStringEntryTransformer = String::substring;
		String wzl = stringIntegerStringEntryTransformer.transformEntry("wzl", 1);
		System.out.println(wzl);
		apples.sort(java.util.Comparator.comparing(Apple::getWeight));
		List<String> str = Arrays.asList("a","b","A","B");
		str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		System.out.println(str);


		List<String> str2 = Arrays.asList("a","b","A","B");

		str2.sort(String::compareToIgnoreCase);
		Maps.EntryTransformer<String, String, Integer> compareToIgnoreCase = String::compareToIgnoreCase;
		Function<String, Integer> stringToInteger = Integer::parseInt;
		Integer a=stringToInteger.apply("1");
		Maps.EntryTransformer<List, Object, Boolean> listObjectBooleanEntryTransformer = List::contains;
	}
	
    private List<Apple> filterApple(List<Apple> apples,ApplePredicate<Apple> applePredicate){
		List list=new ArrayList();
		for(Apple apple:apples){
			if(applePredicate.test(apple)){
          list.add(apple);
			}
		}
		return list;
	}

}
