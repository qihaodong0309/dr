package compare;

/**
 * 使用 lambda 编译如下代码只会产生一个 .class 文件
 *
 * @author qihaodong
 */
public class Test2 {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Thread start");
        });
    }

}