package creative.singleton;

/**
 * 懒汉式的第二种实现方法（double check）
 *
 * @author qihaodong
 */
public class LazySingleton2 {

    private static volatile LazySingleton2 singleton = null;

    private LazySingleton2() {

    }

    public static LazySingleton2 getSingleton() {
        if (singleton == null) {
            synchronized (LazySingleton2.class) {
                if (singleton == null) {
                    singleton = new LazySingleton2();
                }
            }
        }
        return singleton;
    }

}
