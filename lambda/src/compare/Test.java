package compare;

/**
 * lambda 主要用来替换匿名内部类，这里我们主要看它和匿名内部类的区别
 * 编译如下类会产生两个 .class 文件
 * 其中一个表示 Test 类，另一个表示匿名内部类 Runnable
 *
 * @author qihaodong
 */
public class Test {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread start");
            }
        });
    }

}