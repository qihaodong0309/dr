package structure.bridge;

/**
 * 桥接模式
 *
 * @author qihaodong
 */
public class Bridge {

    public static void main(String[] args) {
        Bridge test = new Bridge();
        Implementor implementor = test.new ImplementorA();
        Abstraction abstraction = test.new RefinedAbstraction(implementor);
        abstraction.operation();
    }

    /**
     * 抽象接口
     */
    interface Implementor {
        void operationImpl();
    }

    class ImplementorA implements Implementor {
        @Override
        public void operationImpl() {
            System.out.println("ImplementorA被访问");
        }
    }

    class ImplementorB implements Implementor {
        @Override
        public void operationImpl() {
            System.out.println("ImplementorB被访问");
        }
    }

    /**
     * 桥接抽象化对象
     */
    abstract class Abstraction {

        protected Implementor implementor;

        protected Abstraction(Implementor implementor) {
            this.implementor = implementor;
        }

        public abstract void operation();
    }

    /**
     * 具体对象
     */
    class RefinedAbstraction extends Abstraction {
        protected RefinedAbstraction(Implementor implementor) {
            super(implementor);
        }

        @Override
        public void operation() {

            implementor.operationImpl();
        }
    }

}
