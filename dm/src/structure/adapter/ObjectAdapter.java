package structure.adapter;

/**
 * 对象适配器模式
 *
 * @author qihaodong
 */
public class ObjectAdapter {

    interface Target {
        void request();
    }

    /**
     * 被适配类
     */
    class Adaptee {
        public void specificRequest() {
            System.out.println("适配着业务方法被调用");
        }
    }

    class Adapter implements Target {
        private Adaptee adaptee;

        public Adapter(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void request() {
            adaptee.specificRequest();
        }
    }

}
