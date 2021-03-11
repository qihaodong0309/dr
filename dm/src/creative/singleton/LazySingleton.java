package creative.singleton;

/**
 * 懒汉式单例模式（第一次访问单例实例时初始化）
 *
 * @author qihaodong
 */
public class LazySingleton {

    private static volatile LazySingleton singleton = null;

    /**
     * 单例模型不能对外提供构造方法，只能在单例类内部自己主动实例化
     */
    private LazySingleton() {
        // 防止单例类外部实例化新单例对象
    }

    /**
     * 获取单例类
     *
     * @return
     */
    public static synchronized LazySingleton getSingleton() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

}
