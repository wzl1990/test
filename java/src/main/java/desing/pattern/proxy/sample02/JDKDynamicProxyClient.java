package desing.pattern.proxy.sample02;

import desing.pattern.proxy.sample01.RealSubject;
import desing.pattern.proxy.sample01.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 18 十一月 2017
 */
public class JDKDynamicProxyClient {

    public static void main(String[] args) {
        InvocationHandler handler = new SubjectHanderProxy(RealSubject.class);
        Subject proxy =
                (Subject) Proxy.newProxyInstance(JDKDynamicProxyClient.class.getClassLoader(),
                        new Class[] {Subject.class}, handler);
        proxy.action();
    }
}
