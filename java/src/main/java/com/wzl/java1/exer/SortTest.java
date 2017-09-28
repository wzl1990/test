package com.wzl.java1.exer;

import com.google.common.base.Function;
import com.wzl.java1.java8.Apple;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Description :
 * Author: zhenglong
 * since 26 九月 2017
 */
@Data
public class SortTest {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Dog{
        private String name;
        private int age;
    }

    public static void main(String[] args) {
        List<Dog> list= Arrays.asList(new SortTest().new Dog( "DogA",5),new SortTest().new Dog( "DogB",7),new SortTest().new Dog( "DogC",2),new SortTest().new Dog( "DogD",3));
        Collections.sort(list, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {

                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println(list);
        list.sort((e1,e2)->{
            return  e1.getAge()-e2.getAge();
        });
        Comparator<Dog> comparing = Comparator.comparing(Dog::getAge);
        List<Dog> list2= Arrays.asList(new SortTest().new Dog( "DogA",5),new SortTest().new Dog( "DogB",7),new SortTest().new Dog( "DogC",2),new SortTest().new Dog( "DogD",3));
        Function<Dog, Integer> getAge = Dog::getAge;
        list2.sort(Comparator.comparing(getAge));
        System.out.println(list2);
        list.sort(Comparator.comparing(Dog::getAge).reversed().thenComparing(Dog::getName));

        Predicate<Dog> dogPredicate=(e->{
            return e.getAge()>5;
        });
        Predicate<Dog> w = dogPredicate.negate().and(e -> e.getName() == "aa");

    }
}

