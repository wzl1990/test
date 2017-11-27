package desing.pattern.proxy.sample01;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 18 十一月 2017
 */
public class SubjectProxy implements  Subject {

    private RealSubject realSubject;

    public SubjectProxy(RealSubject realSubject){
        this.realSubject=realSubject;
    }


    @Override
    public void action() {
        realSubject.action();
    }
}
