package com.wzl.effect_java;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 17 十月 2017
 */
public class InstrumnentHashSet<E> extends HashSet<E> {

    private int count;

    public InstrumnentHashSet(){

    }
    public InstrumnentHashSet(int initCap,float loadFactor){
        super(initCap,loadFactor);
    }

    @Override
    public boolean add(E e) {
        count++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<?extends  E> c){
        count+=c.size();
        return  super.addAll(c);
    }

    public int getCount(){
        return  count;
    }

    public static void main(String[] args) {
        InstrumnentHashSet<String> s=new InstrumnentHashSet<String>();
        s.addAll(Arrays.asList("ss"));
        System.out.println(s.count);
    }
}
