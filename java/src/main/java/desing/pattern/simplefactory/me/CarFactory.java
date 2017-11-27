package desing.pattern.simplefactory.me;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 17 十一月 2017
 */
public class CarFactory {

    public  Car newCatFactory(int type){
        if(type==0){
            return  new BigCar();
        }else {
            return  new SmallCar();
        }
    }
}
