package creative.factory;

/**
 * 简单工厂模式（静态工厂模式）
 * 简单工厂模式不属于 23 种设计模式
 *
 * @author qihaodong
 */
public class SimpleFactory {

    public static void main(String[] args) {
        Factory.createProduct(1);
        Factory.createProduct(2);
    }

    /**
     * 产品模板
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

    static final class Const {
        static final int ProductA = 1;
        static final int ProductB = 2;
    }

    /**
     * 具体工厂类
     */
    public static class Factory {

        /**
         * 生成具体的对象（产品）
         *
         * @param type
         * @return
         */
        public static Product createProduct(int type) {
            switch (type) {
                case Const.ProductA:
                    return new ProductA();
                case Const.ProductB:
                    return new ProductB();
            }
            return null;
        }

    }

}
