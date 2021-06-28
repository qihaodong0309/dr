package thread;

/**
 * @author qihaodong
 */
public class ThreadLocalTest {

    ThreadLocal<Long> lLocal = new ThreadLocal<>();
    ThreadLocal<String> sLocal = new ThreadLocal<>();

    public void set() {
        lLocal.set(Thread.currentThread().getId());
        sLocal.set(Thread.currentThread().getName());
    }

    public void get() {
        lLocal.remove();
        System.out.println(lLocal.get());
        System.out.println(sLocal.get());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest test = new ThreadLocalTest();
        test.set();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.set();
                test.get();
            }
        });
        t1.start();
        t1.join();
        test.get();
    }

}
