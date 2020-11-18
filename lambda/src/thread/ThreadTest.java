package thread;

/**
 * @author qihaodong
 */
public class ThreadTest {

    private void creatThread() {
        // JAVA8 之前创建线程对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread run()");
            }
        });

        // 使用 lambda 表达式
        new Thread(() -> {
            System.out.println("Thread run()");
        });

        // 当代码只有一行时可以不使用大括号
        new Thread(() -> System.out.println("Thread run()"));

        // 当方法体包含多行时必须使用大括号
        new Thread(() -> {
            System.out.print("Thread");
            System.out.println(" run()");
        });
    }

    private void createRunnable() {
        // JAVA8 之前创建 Runnable 对象
        Runnable x = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };

        // 使用 lambda 创建 Runnable 对象
        Runnable xx = () -> System.out.println("Hello World");
    }

}