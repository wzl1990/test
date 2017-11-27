package desing.pattern.proxy.sample01;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 18 十一月 2017
 */
public class RealSubject  implements  Subject{
    @Override
    public void action() {
        System.out.println("zhenglong.wei real subject");
    }
}
