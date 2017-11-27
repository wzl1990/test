package com.wzl.java8.course2.java8;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;


public class TestStreamAPI3 {
	
	List<Employee> emps = Arrays.asList(
			new Employee(102, "李四", 79, 6666.66, Employee.Status.BUSY),
			new Employee(101, "张三", 79, 9999.99, Employee.Status.FREE),
			new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
			new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
			new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
			new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
			new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY),
			new Employee(106, "张三", 38, 5555.55, Employee.Status.BUSY)

	);

	@Test
	public  void test11(){

		Stream<Employee> sorted = emps.stream().sorted(Comparator.comparing(Employee::getAge).reversed().thenComparing(Employee::getSalary));
		System.out.println(sorted.collect(Collectors.toList()));
		Stream<Employee> sorted2 = emps.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getSalary).reversed());
		System.out.println(sorted2.collect(Collectors.toList()));

	}

	public static <E> List<E> getDuplicateElements(List<E> list) {
		return list.stream()                           // list 对应的 Stream
				.collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
				.entrySet().stream()                   // 所有 entry 对应的 Stream
				.filter(entry -> entry.getValue() > 1) // 过滤出元素出现次数大于 1 的 entry
				.map(entry -> entry.getKey())          // 获得 entry 的键（重复元素）对应的 Stream
				.collect(Collectors.toList());         // 转化为 List
	}

	public static void main(String[] args) throws Exception {
		List<String> list = Arrays.asList("a", "b", "c", "d", "a", "a", "d", "d");
		List<String> add=new ArrayList<>();
		Map<String, Integer> collect = list.stream()                           // list 对应的 Stream
				.collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b));
		System.out.println(collect);
		List<String> duplicateElements = getDuplicateElements(list);

		System.out.println("list 中重复的元素：" + duplicateElements);
	}

	@Test
	public  void test10(){
		int addIndex=1;
		List<String> collect = emps.stream().collect(Collectors.toMap(e -> e.getName(), e -> 1, (a, b) -> a + b)).entrySet()
				.stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey())          // 获得 entry 的键（重复元素）对应的 Stream
				.collect(Collectors.toList());
		System.out.println(collect);
		List<Employee> add=new ArrayList<>();
		List<Employee> collect1 = emps.stream().collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)).entrySet()
				.stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey())          // 获得 entry 的键（重复元素）对应的 Stream
				.collect(Collectors.toList());
		System.out.println(collect);
		System.out.println(collect1);

		/*while (addIndex < emps.size()) {
			if (emps.get(addIndex).getName().equals(emps.get(addIndex - 1).getName())) {
				System.out.println(emps.get(addIndex).getName());
				emps.remove(addIndex);
			} else {
				addIndex++;
			}
		}*/

		int addSkuWidth=1;
		while (addSkuWidth <10) {
			if (emps.size() > 0) {
				addSkuWidth ++;
				//emps.remove(addSkuWidth);
			} else {
				break;
			}
		}

	}
	@Test
	public void test0(){
		System.out.println(BigInteger.valueOf(Double.valueOf(Math.pow(2, 6)).longValue()));
			int factorialWidth = Double.valueOf(Math.floor(20 / Math.pow(3, 1.0 / 2))).intValue();
		System.out.println(factorialWidth);
		BigInteger factorial = BigInteger.ONE;
		BigInteger two = BigInteger.ONE;
		for (int i = 1; i <= 20; i++) {

			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		System.out.println(factorial.intValue());
		System.out.println(BigInteger.valueOf(Double.valueOf(Math.pow(2, 20)).longValue()));
	}

	
	//3. 终止操作
	/*
		归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 */
	@Test
	public void test1(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Integer sum = list.stream()
			.reduce(0, (x, y) -> x + y);
		
		System.out.println(sum);
		
		System.out.println("----------------------------------------");
		
		Optional<Double> op = emps.stream()
			.map(Employee::getSalary)
			.reduce(Double::sum);
		
		System.out.println(op.get());
	}
	
	//需求：搜索名字中 “六” 出现的次数
	@Test
	public void test2(){
		Optional<Integer> sum = emps.stream()
			.map(Employee::getName)
			.flatMap(TestStreamAPI1::filterCharacter)
			.map((ch) -> {
				if(ch.equals('六'))
					return 1;
				else 
					return 0;
			}).reduce(Integer::sum);
		
		System.out.println(sum.get());
	}
	
	//collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
	@Test
	public void test3(){
		List<String> list = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toList());
		
		list.forEach(System.out::println);
		
		System.out.println("----------------------------------");
		
		Set<String> set = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toSet());
		
		set.forEach(System.out::println);

		System.out.println("----------------------------------");
		
		HashSet<String> hs = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toCollection(HashSet::new));
		
		hs.forEach(System.out::println);
	}
	
	@Test
	public void test4(){
		Optional<Double> max = emps.stream()
			.map(Employee::getSalary)
			.collect(Collectors.maxBy(Double::compare));
		
		System.out.println(max.get());
		
		Optional<Employee> op = emps.stream()
			.collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
		
		System.out.println(op.get());
		
		Double sum = emps.stream()
			.collect(Collectors.summingDouble(Employee::getSalary));
		
		System.out.println(sum);
		
		Double avg = emps.stream()
			.collect(Collectors.averagingDouble(Employee::getSalary));
		
		System.out.println(avg);
		
		Long count = emps.stream()
			.collect(Collectors.counting());
		
		System.out.println(count);
		
		System.out.println("--------------------------------------------");
		
		DoubleSummaryStatistics dss = emps.stream()
			.collect(Collectors.summarizingDouble(Employee::getSalary));
		
		System.out.println(dss.getMax());
	}
	
	//分组
	@Test
	public void test5(){
		Map<Employee.Status, List<Employee>> map = emps.stream()
			.collect(Collectors.groupingBy(Employee::getStatus));
		
		System.out.println(map);
	}
	
	//多级分组
	@Test
	public void test6(){
		Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream()
			.collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
				if(e.getAge() >= 60)
					return "老年";
				else if(e.getAge() >= 35)
					return "中年";
				else
					return "成年";
			})));
		
		System.out.println(map);
	}
	
	//分区
	@Test
	public void test7(){
		Map<Boolean, List<Employee>> map = emps.stream()
			.collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));
		
		System.out.println(map);
	}
	
	//
	@Test
	public void test8(){
		String str = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.joining("," , "----", "----"));
		
		System.out.println(str);
	}
	
	@Test
	public void test9(){
		Optional<Double> sum = emps.stream()
			.map(Employee::getSalary)
			.collect(Collectors.reducing(Double::sum));
		
		System.out.println(sum.get());
	}
}
