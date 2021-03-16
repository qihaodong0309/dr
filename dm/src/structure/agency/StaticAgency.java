package structure.agency;

/**
 * 代理模式
 *
 * @author qihaodong
 */
public class StaticAgency {

    /*
    代理模式分静态代理和动态代理，静态代理指系统启动时加载代理类，动态代理表示调用时通过反射初始化代理类
    这里我们只给出静态代理的代码，动态代理在 Spring AOP 中使用非常广泛
     */

    public static void main(String[] args) {
        StaticAgency test = new StaticAgency();
        Subject subject = test.new Proxy();
        subject.request();
    }

    /**
     * 抽象主题
     */
    interface Subject {
        void request();
    }

    /**
     * 真实实现类（被代理类）
     */
    class RealSubject implements Subject {
        @Override
        public void request() {
            System.out.println("真实方法被调用");
        }
    }

    /**
     * 代理类
     */
    class Proxy implements Subject {

        private RealSubject realSubject;

        @Override
        public void request() {
            if (realSubject == null) {
                realSubject = new RealSubject();
            }
            preRequest();
            realSubject.request();
            postRequest();
        }

        /*
        方法增强
         */
        private void preRequest() {
            System.out.println("真实方法调用前");
        }

        private void postRequest() {
            System.out.println("真实方法调用前");
        }
    }

}
