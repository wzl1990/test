package com.wzl.test;

import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;


/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 17 十一月 2017
 */
public class Class1Mocked {
    public  String hello(String name){
        System.out.println("hello "+name);
        return "hello "+name;
    }
    public void show(){
        System.out.println("Class1Mocked.show()");
    }

    @Test
    public void testMockMethod() {
        Class1Mocked obj = createMock(Class1Mocked.class);

        expect(obj.hello("z3")).andReturn("hello l4");
        replay(obj);

        String actual = obj.hello("z3");
        assertEquals("hello l4", actual);

        verify(obj);
    }
}
