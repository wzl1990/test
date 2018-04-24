package com.didi.es.marketing.core.util;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 * @author: weizhenglong
 * @since 2018-04-23
 */
public class BloomFilterDemo {

    public static void main(String[] args) {

        int size=1000000;
        BloomFilter<String> bf=BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),size,0.03);

        HashSet<String> sets=new HashSet<>(size);

        List<String> lists=new ArrayList<>(size);

        IntStream.range(0,size).forEach(e->{
            String uuid = UUID.randomUUID().toString();
            bf.put(uuid);
            sets.add(uuid);
            lists.add(uuid);
        });

        int wrong=0;
        int right=0;

        for(int i=0;i<10000;i++){
            String test=i%100==0?lists.get(i/100):UUID.randomUUID().toString();
            if(bf.mightContain(test)){
                if(sets.contains(test)){
                    right++;
                }else{
                    wrong++;
                }
            }
        }

        System.out.println(right);
        System.out.println(wrong);



    }
}
