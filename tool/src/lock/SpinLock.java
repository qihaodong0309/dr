package lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用 CAS 实现自旋锁
 *
 * @author qihaodong
 */
public class SpinLock {

    private AtomicReference<Thread> sign = new AtomicReference<>();

    private boolean lock() {
        int k = 0;
        Thread current = Thread.currentThread();
        while (k <= 50 && !sign.compareAndSet(null, current)) {
            k++;
        }
        return k < 50;
    }

    private boolean unLock() {
        Thread judge = sign.get();
        Thread current = Thread.currentThread();
        if (judge != current) {
            return false;
        }
        while (!sign.compareAndSet(current, null)) {
        }
        return true;
    }

}
