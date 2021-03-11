package creative.factory;

/**
 * 工厂方法模式
 * 不属于 23 种设计模式
 *
 * @author qihaodong
 */
public class MethodFactory {

     /*
    和简单工厂模式相比，工厂方法模式只是在上层多了一步抽象工厂，把创建产品的具体实现放在不同的工厂类中
    这里需要注意的一点是，无论哪种类型的工厂，都只能生产 Product 类型的产品，也就是说产品范围有限
     */

    public static void main(String[] args) {
        Factory factory1 = new FactoryA();
        factory1.createProduct();
        Factory factory2 = new FactoryB();
        factory2.createProduct();
    }

    /**
     * 产品抽象接口
     */
    public interface Product {
    }

    public static class ProductA implements Product {
        public ProductA() {
            System.out.println("ProductA - 生产完成");
        }
    }

    public static class ProductB implements Product {
        public ProductB() {
            System.out.println("ProductB - 生产完成");
        }
    }

    /**
     * 工厂抽象接口
     */
    public interface Factory {
        /**
         * 工厂公共方法
         *
         * @return
         */
        public Product createProduct();
    }

    public static class FactoryA implements Factory {
        @Override
        public Product createProduct() {
            return new ProductA();
        }
    }

    public static class FactoryB implements Factory {
        @Override
        public Product createProduct() {
            return new ProductB();
        }
    }

}
