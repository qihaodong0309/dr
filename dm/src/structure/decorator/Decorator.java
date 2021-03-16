package structure.decorator;

/**
 * 装饰器模式
 *
 * @author qihaodong
 */
public class Decorator {

    public static void main(String[] args) {
        Decorator test = new Decorator();
        Component component = test.new ConcreteComponent();
        AbstractDecorator decorator = test.new ConcreteDecorator(component);
        decorator.operation();
    }

    /**
     * 抽象构件角色
     */
    interface Component {
        void operation();
    }

    class ConcreteComponent implements Component {

        public ConcreteComponent() {
            System.out.println("具体构件角色被创建");
        }

        @Override
        public void operation() {
            System.out.println("调用具体构件角色 operation() 方法");
        }
    }

    /**
     * 抽象装饰对象
     */
    class AbstractDecorator implements Component {

        private Component component;

        public AbstractDecorator(Component component) {
            this.component = component;
        }

        @Override
        public void operation() {
            component.operation();
        }
    }

    /**
     * 具体装饰类对象
     */
    class ConcreteDecorator extends AbstractDecorator {

        public ConcreteDecorator(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            super.operation();
            addedFunction();
        }

        /**
         * 装饰器新增的方法
         */
        public void addedFunction() {
            System.out.println("为具体构件角色额外增加的方法：addedFunction()");
        }

    }
}
