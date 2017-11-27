package desing.pattern.proxy.sample02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 18 十一月 2017
 */
public class SubjectHanderProxy implements InvocationHandler {

    private  Object target;

    public  SubjectHanderProxy(Class c){
        try {
            this.target=c.newInstance();
        }catch (Exception e){
            System.out.println("wew");
        }

    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        preAction();
        Object result = method.invoke(target, args);
        postAction();
        System.out.println(proxy.getClass().getName());
        return result;
    }

    private void preAction() {
        System.out.println("SubjectProxyHandler.preAction()");
    }
    private void postAction() {
        System.out.println("SubjectProxyHandler.postAction()");
    }
}
