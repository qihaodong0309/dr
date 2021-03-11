package creative.singleton;

/**
 * 饿汉式单例模式（单例类被加载时就初始化单例对象）
 *
 * @author qihaodong
 */
public class HungrySingleton {

    private static final HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getSingleton() {
        return singleton;
    }

}
