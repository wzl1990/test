package com.wzl.mock;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import static org.junit.Assert.*;
public class UserManagerTest {
    // 建立一个test上下文对象。
    // 需要模拟的是接口
    Mockery context = new Mockery();
    // 需要模拟的是类
    // Mockery context = new Mockery() {
    // {setImposteriser(ClassImposteriser.INSTANCE);
    // } };
    // 生成一个mock对象
    final AddressService addressServcie = context.mock(AddressService.class);
    // final AddressServiceClass addressServcie = context
    // .mock(AddressServiceClass.class);

    @Test
    public void test1() {
        context.checking(new Expectations() {
            {
                oneOf(addressServcie).findAddress("yld");
                will(returnValue("nanjing"));
            }
        });
        UserManager um = new UserManager();
        um.addressService = addressServcie;
        assertEquals(1, um.getCityCode("yld"));
    }
}