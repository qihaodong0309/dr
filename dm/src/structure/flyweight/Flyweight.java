package structure.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 *
 * @author qihaodong
 */
public class Flyweight {

    public static void main(String[] args) {
        Flyweight test = new Flyweight();
        FlyweightFactory factory = test.new FlyweightFactory();
        FlyweightTest flyweight1 = factory.getConFlyweight("x");
        FlyweightTest flyweight2 = factory.getConFlyweight("xx");
        FlyweightTest flyweight3 = factory.getConFlyweight("xxx");
        FlyweightTest flyweight4 = factory.getConFlyweight("xx");
        FlyweightTest flyweight5 = factory.getConFlyweight("x");
        flyweight1.operation();
        flyweight2.operation();
        flyweight3.operation();
        flyweight4.operation();
        flyweight5.operation();
        System.out.println(flyweight1 == flyweight5);
        System.out.println(flyweight2 == flyweight4);
    }

    /**
     * 抽象享元角色（所有享元对象共享的模块）
     */
    interface FlyweightTest {
        void operation();
    }

    /**
     * 具体享元角色
     */
    class ConFlyweight implements FlyweightTest {

        String key;

        public ConFlyweight(String key) {
            this.key = key;
        }

        @Override
        public void operation() {
            System.out.println("享元角色 " + key + " operation() 方法被调用！");
        }
    }

    /**
     * 享元角色工厂
     */
    class FlyweightFactory {

        private Map<String, FlyweightTest> map = new HashMap<>();

        private FlyweightTest getConFlyweight(String key) {
            FlyweightTest result = map.get(key);
            if (result == null) {
                result = new ConFlyweight(key);
                map.put(key, result);
            }
            return result;
        }
    }

}
