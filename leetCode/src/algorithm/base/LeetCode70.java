package algorithm.base;

/**
 * 同 JzOffer10_2，唯一区别不需要取模
 *
 * @author qihaodong
 */
public class LeetCode70 {

    public int numWays(int n) {
        int a = 1, b = 1, temp;
        for (int i = 1; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return a;
    }

}
