package com.wzl.java8.course1.exer;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Description :
 * Author: zhenglong
 * since 28 九月 2017
 */
@SuppressWarnings("all")
public class TestGroup {

    enum CaloricLevel { DIET, NORMAL, FAT };

    public static final List<Dish> menu =
            asList( new Dish("pork", false, 800, Dish.Type.MEAT),
                    new Dish("beef", false, 700, Dish.Type.MEAT),
                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                    new Dish("prawns", false, 400, Dish.Type.FISH),
                    new Dish("salmon", false, 450, Dish.Type.FISH));

    public static final Map<String, List<String>> dishTags = new HashMap<>();

    static {
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));
    }

    @Test
    public void Test1(){
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(JSON.toJSONString(collect));
    }
    @Test
    public void Test2(){
        Map<CaloricLevel, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(e->{
          if( e.getCalories()<400) return CaloricLevel.DIET;
          else  if(e.getCalories()>700) return CaloricLevel.FAT;
          else return CaloricLevel.NORMAL;
        }));
        System.out.println(JSON.toJSONString(collect));
    }
    @Test
    public void Test3() {
        Map<CaloricLevel, Map<Dish.Type, List<Dish>>> collect = menu.stream().collect(Collectors.groupingBy(e -> {
            if (e.getCalories() < 400) return CaloricLevel.DIET;
            else if (e.getCalories() > 700) return CaloricLevel.FAT;
            else return CaloricLevel.NORMAL;
        }, Collectors.groupingBy(Dish::getType)));


    }
}
