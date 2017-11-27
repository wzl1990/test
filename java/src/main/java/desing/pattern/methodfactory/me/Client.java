package desing.pattern.methodfactory.me;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 17 十一月 2017
 */
public class Client {

    public static void main(String[] args) {
        AnimalFactory animalFactory=new FamilyFactory();
        Animal animal = animalFactory.newInstance();
        animal.display();
        AnimalFactory animalFactory2=new WildFactory();
        Animal animal2 = animalFactory2.newInstance();
        animal2.display();
    }
}
