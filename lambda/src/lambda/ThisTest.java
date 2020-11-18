package lambda;

/**
 * 本类主要探讨 this 关键字和 lambda 的关系
 *
 * @author qihaodong
 */
public class ThisTest {

    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = () -> System.out.println(toString());

    public static void main(String[] args) {
        ThisTest test = new ThisTest();
        test.r1.run();
        test.r2.run();
    }

    @Override
    public String toString() {
        return "Test this";
    }

}