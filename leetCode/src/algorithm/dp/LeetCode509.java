package algorithm.dp;

/**
 * @author qihaodong
 */
public class LeetCode509 {

    /**
     * 递归解法
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
     * dp
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int left = 0, right = 1;
        for (int i = 2; i <= n; i++) {
            int temp = left + right;
            left = right;
            right = temp;
        }
        return right;
    }

}
