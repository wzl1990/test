package desing.pattern.observer.sample01;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 17 十一月 2017
 */
public abstract class AbstractSubject {

    List<Observer> list=new ArrayList<>();

    public  boolean add(Observer observer){
        return list.add(observer);
    }

    public  boolean remove(Observer observer){
        return list.remove(observer);
    }

    public  void pushEvent(){
        list.stream().forEach(e->{
            e.update();
        });
    }


}
