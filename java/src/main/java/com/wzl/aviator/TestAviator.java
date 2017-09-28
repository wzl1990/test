package com.wzl.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.Options;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description :
 * Author: zhenglong
 * since 28 九月 2017
 */
public class TestAviator {

   @Test
   public void test1(){
       AviatorEvaluator.setOption(Options.TRACE, true);
           Long result = (Long) AviatorEvaluator.execute("1+2+3");
           System.out.println(result);
   }

    @Test
    public void test2(){
        String yourName = "Michael";
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("yourName", yourName);
        String result = (String) AviatorEvaluator.execute(" 'hello ' + yourName ", env);
        System.out.println(result);  // hello Michael
        System.out.println(AviatorEvaluator.execute(" 'a\"b' "));           // 字符串 a"b
        System.out.println(AviatorEvaluator.execute(" \"a\'b\" "));         // 字符串 a'b
        System.out.println(AviatorEvaluator.execute(" 'hello ' + 3 "));     // 字符串 hello 3
        System.out.println(AviatorEvaluator.execute(" 'hello '+ unknow ")); // 字符串 hello null
    }

    @Test
    public void test3(){
        String name = "dennis";
        System.out.println(AviatorEvaluator.exec(" 'hello2 ' + yourName2 ", name)); // hello dennis
    }

    @Test
    public void test4(){
        System.out.println(AviatorEvaluator.execute("string.length('hello')"));
    }

    @Test
    public void test5(){
        //注册函数
        AviatorEvaluator.addFunction(new AddFunction());
        System.out.println(AviatorEvaluator.execute("add(1, 2)"));           // 3.0
        System.out.println(AviatorEvaluator.execute("add(add(1, 2), 100)")); // 103.0
    }


    class AddFunction extends AbstractFunction {
        @Override
        public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
            Number left = FunctionUtils.getNumberValue(arg1, env);
            Number right = FunctionUtils.getNumberValue(arg2, env);
            return new AviatorDouble(left.doubleValue() + right.doubleValue());
        }
        public String getName() {
            return "add";
        }
    }

    @Test
    public void test6(){
        AviatorEvaluator.addFunction(new GetFirstNonNullFunction());
        System.out.println(AviatorEvaluator.execute("getFirstNonNull(1)"));
        System.out.println(AviatorEvaluator.execute("getFirstNonNull(1,2,3,4,null,5)"));
        System.out.println(AviatorEvaluator.execute("getFirstNonNull(a,b,c,d)"));
    }

    public class GetFirstNonNullFunction extends AbstractVariadicFunction {
        public AviatorObject variadicCall(Map<String, Object> env, AviatorObject... args) {
            if (args != null) {
                for (AviatorObject arg : args) {
                    if (arg.getValue(env) != null) {
                        return arg;
                    }
                }
            }
            return new AviatorString(null);
        }
        @Override
        public String getName() {
            return "getFirstNonNull";
        }
    }

    @Test
    public void test7(){
        String expression = "a-(b-c)>100";
        Expression compiledExp = AviatorEvaluator.compile(expression);
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("a", 100.3);
        env.put("b", 45);
        env.put("c", 199.100);
        // 执行表达式
        Boolean result = (Boolean) compiledExp.execute(env);
        System.out.println(result);  // false
    }


    @Test
    public void test8(){
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("a", 100.3);
        env.put("b", 45);
        env.put("c", 199.100);
        cal("a-(b-c)>100",env);
        cal("a-(b-c)",env);
        cal("a+b+c",env);
    }

    private void  cal(String expression,Map map){
       // AviatorEvaluator.setOption(Options.TRACE, true);
        try {
         //   AviatorEvaluator.setTraceOutputStream(new FileOutputStream(new File("aviator.log")));

        }catch (Exception e){
            e.getMessage();
        }
        Expression compiledExp = AviatorEvaluator.compile(expression,true);
        System.out.println(compiledExp.execute(map));
    }

    @Test
    public void test9(){
        final List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add(" world");
        final int[] array = new int[3];
        array[0] = 0;
        array[1] = 1;
        array[2] = 3;
        final Map<String, Date> map = new HashMap<String, Date>();
        map.put("date", new Date());
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("list", list);
        env.put("array", array);
        env.put("mmap", map);
        System.out.println(AviatorEvaluator.execute("list[0]+list[1]", env));   // hello world
        System.out.println(AviatorEvaluator.execute("'array[0]+array[1]+array[2]=' + (array[0]+array[1]+array[2])", env));  // array[0]+array[1]+array[2]=4
        System.out.println(AviatorEvaluator.execute("'today is ' + mmap.date ", env));  // today is Wed Feb 24 17:31:45 CST 2016
    }

    @Test
    public void test10(){
        String email = "killme2008@gmail.com";
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("email", email);
        String username = (String) AviatorEvaluator.execute("email=~/([\\w0-8]+)@\\w+[\\.\\w+]+/ ? $1 : 'unknow' ", env);
        System.out.println(username); // killme2008
    }
    @Test
    public  void test11(){
        System.out.println(AviatorEvaluator.execute("nil == nil"));   //true
        System.out.println(AviatorEvaluator.execute(" 3> nil"));      //true
        System.out.println(AviatorEvaluator.execute(" true!= nil"));  //true
        System.out.println(AviatorEvaluator.execute(" ' '>nil "));    //true
        System.out.println(AviatorEvaluator.execute(" a==nil "));
    }

    @Test
    public void test12(){
        Map<String, Object> env = new HashMap<String, Object>();
        final Date date = new Date();
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(date);
        env.put("date", date);
        env.put("dateStr", dateStr);
        Boolean result = (Boolean) AviatorEvaluator.execute("date==dateStr", env);
        System.out.println(result);  // true
        result = (Boolean) AviatorEvaluator.execute("date > '2010-12-20 00:00:00:00' ", env);
        System.out.println(result);  // true
        result = (Boolean) AviatorEvaluator.execute("date < '2200-12-20 00:00:00:00' ", env);
        System.out.println(result);  // true
        result = (Boolean) AviatorEvaluator.execute("date==date ", env);
        System.out.println(result);  // true
    }

    @Test
    public void test13(){
        System.out.println(AviatorEvaluator.exec("99999999999999999999999999999999 + 99999999999999999999999999999999"));
    }

    @Test
    public void test14(){
        Map<String, Object> env = new HashMap<String, Object>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(20);
        list.add(10);
        env.put("list", list);
        Object result = AviatorEvaluator.execute("count(list)", env);
        System.out.println(result);  // 3
        result = AviatorEvaluator.execute("reduce(list,+,0)", env);
        System.out.println(result);  // 33
        result = AviatorEvaluator.execute("filter(list,seq.gt(9))", env);
        System.out.println(result);  // [10, 20]
        result = AviatorEvaluator.execute("include(list,10)", env);
        System.out.println(result);  // true
        result = AviatorEvaluator.execute("sort(list)", env);
        System.out.println(result);  // [3, 10, 20]
        AviatorEvaluator.execute("map(list,println)", env);
    }



}
