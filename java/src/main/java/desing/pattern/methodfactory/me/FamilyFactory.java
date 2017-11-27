package desing.pattern.methodfactory.me;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 17 十一月 2017
 */
public class FamilyFactory implements AnimalFactory {

    @Override
    public Animal newInstance() {
        return new Dog();
    }
}
