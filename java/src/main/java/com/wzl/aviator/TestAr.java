package com.wzl.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description :
 * Author: zhenglong
 * since 28 九月 2017
 */
@Data
public class TestAr {
        int i;
        float f;
        Date date;
        // 构造方法
        public TestAr(int i, float f, Date date) {
            this.i = i;
            this.f = f;
            this.date = date;
        }

        public static void main(String[] args) {
            TestAr foo = new TestAr(100, 3.14f, new Date());
            Map<String, Object> env = new HashMap<String, Object>();
            env.put("foo", foo);
            System.out.println(AviatorEvaluator.execute("'foo.i = '+foo.i", env));   // foo.i = 100
            System.out.println(AviatorEvaluator.execute("'foo.f = '+foo.f", env));   // foo.f = 3.14
            System.out.println(AviatorEvaluator.execute("'foo.date.year = '+(foo.date.year+1990)", env));  // foo.date.year = 2106
        }
    }
