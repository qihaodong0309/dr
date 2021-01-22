package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer10_1 {

    /**
     * 递归（会超时，而且会超过 int 的范围）
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 基于 dp
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int[] record = new int[n + 1];
        record[0] = 0;
        record[1] = 1;
        for (int i = 2; i <= n; i++) {
            record[i] = (record[i - 1] + record[i - 2]) % 1000000007;
        }
        return record[n];
    }

    /**
     * dp 改进，不借助数组
     *
     * @param n
     * @return
     */
    public int fib3(int n) {
        int a = 0, b = 1, temp;
        for (int i = 1; i <= n; i++) {
            temp = (a + b) % 1000000007;
            a = b;
            b = temp;
        }
        return a;
    }

}
