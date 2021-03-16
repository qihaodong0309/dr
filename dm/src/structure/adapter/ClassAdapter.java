package structure.adapter;

/**
 * 类适配器模式
 *
 * @author qihaodong
 */
public class ClassAdapter {

    public static void main(String[] args) {
        ClassAdapter test = new ClassAdapter();
        Adapter adapter = test.new Adapter();
        adapter.request();
    }

    /**
     * 适配接口接口
     */
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

    /**
     * 适配器
     */
    class Adapter extends Adaptee implements Target {
        @Override
        public void request() {
            specificRequest();
        }
    }

}
