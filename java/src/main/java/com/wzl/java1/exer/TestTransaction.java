package com.wzl.java1.exer;

import com.google.common.base.Function;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static  java.util.stream.Collectors.toList;
import  static  java.util.Comparator.comparing;


/**
 * Description :
 * Author: zhenglong
 * since 27 九月 2017
 */
public class TestTransaction {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario","Milan");
    Trader alan = new Trader("Alan","Cambridge");
    Trader brian = new Trader("Brian","Cambridge");
    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );
   //  出2011所有发生的交易，安低到高排序
    @Test
    public void test1(){
        Function<Transaction, Integer> getValue = Transaction::getValue;
        Comparator<Transaction> comparing = comparing(getValue);
        int compare = comparing.compare(new Transaction(alan, 2012, 950), new Transaction(mario, 2012, 700));
        List<Transaction> collect = transactions.stream().filter(e -> e.getYear() == 2011).sorted(comparing).collect(toList());
        System.out.println(collect);
        Map<String, List<Transaction>> collect1 = transactions.stream().collect(groupingBy(e -> e.getTrader().getCity()));
        collect1.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
        });



    }
    //交易员都在哪些不同的城市工作
    @Test
    public void test2(){
        List<String> distinct = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(toList());
        System.out.println(distinct);

    }
    //查找所有剑桥的交易员按名字拍讯
    @Test
    public void test3(){
        List<String> cambridge = transactions.stream().filter(e -> e.getTrader().getCity().equals("Cambridge")).map(e -> e.getTrader().getName()).collect(toList());
        System.out.println(cambridge);

    }
    //  交易员的名字并排序
    @Test
    public void test4(){

        List<String> collect = transactions.stream().map(Transaction::getTrader).map(Trader::getName).sorted().collect(toList());
        System.out.println(collect);
    }
    //有没有交易员是在米兰工作的
    @Test
    public void test5(){
        List<Trader> list=transactions.stream().map(Transaction::getTrader).filter(e->e.getCity().equals("Milan")).collect(toList());
        System.out.println(list);

    }

    //所有交易的最小交易额
    @Test
    public void test6(){

        Optional<Transaction> min = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println(min.get());
        Optional<Transaction> reduce = transactions.stream().reduce((e1, e2) -> e1.getValue() < e2.getValue() ? e1 : e2);
        System.out.println(reduce);

    }

    //所有交易的最大交易额
    @Test
    public void test7(){
        Integer collect = transactions.stream().collect(Collectors.summingInt(Transaction::getValue));
        System.out.println(collect);
        IntSummaryStatistics collect1 = transactions.stream().collect(Collectors.summarizingInt(Transaction::getValue));
        System.out.println(collect1);
    }

}
