package creative.singleton;

/**
 * 静态内部类实现单例模型
 *
 * @author qihaodong
 */
public class InsideSingleton {

    private static class inner {

        private static final InsideSingleton singleton = new InsideSingleton();

    }

    private InsideSingleton() {

    }

    public static final InsideSingleton getInstance() {
        return inner.singleton;
    }

}
