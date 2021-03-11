package creative.factory;

/**
 * 抽象工厂模式
 *
 * @author qihaodong
 */
public class AbstractFactory {

    /*
    抽象工厂模式只是在方法工厂模式的基础上，增加了新的商品类型，一个工厂可以生成不同维度的商品
     */

    public static void main(String[] args) {
        Factory factoryA = new FactoryA();
        factoryA.createProductA();
        factoryA.createProductB();
        Factory factoryB = new FactoryB();
        factoryB.createProductA();
        factoryB.createProductB();
    }

    /**
     * 商品A抽象类
     */
    public interface ProductA {
    }

    public static class ProductA1 implements ProductA {
        public ProductA1() {
            System.out.println("ProductA1 - 被生产");
        }
    }

    public static class ProductA2 implements ProductA {
        public ProductA2() {
            System.out.println("ProductA2 - 被生产");
        }
    }

    /**
     * 商品B抽象类
     */
    public interface ProductB {
    }

    public static class ProductB1 implements ProductB {
        public ProductB1() {
            System.out.println("ProductB1 - 被生产");
        }
    }

    public static class ProductB2 implements ProductB {
        public ProductB2() {
            System.out.println("ProductB2 - 被生产");
        }
    }

    public interface Factory {
        /**
         * 生产产品A
         *
         * @return
         */
        public ProductA createProductA();

        /**
         * 生成产品B
         *
         * @return
         */
        public ProductB createProductB();
    }

    public static class FactoryA implements Factory {

        @Override
        public ProductA createProductA() {
            return new ProductA1();
        }

        @Override
        public ProductB createProductB() {
            return new ProductB1();
        }
    }

    public static class FactoryB implements Factory {

        @Override
        public ProductA createProductA() {
            return new ProductA2();
        }

        @Override
        public ProductB createProductB() {
            return new ProductB2();
        }
    }

}
