package com.wzl.effect_java;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 17 十月 2017
 */
@Data
public class Herp {

    public  enum Type{
        A,
        B,
        C;
    }

    private Type type;
    private String name;

    @Override
    public String toString(){
        return name;
    }

    public static void main(String[] args) {
        Herp[] herps={};

        Set<Herp>[] herpByType=new Set[Type.values().length];
        for(int i=0;i<herpByType.length;i++){
            herpByType[i]=new HashSet<Herp>();
        }


    }
}
