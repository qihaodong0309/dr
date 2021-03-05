package jzoffer;

/**
 * 同 LeetCode 264
 *
 * @author qihaodong
 */
public class JzOffer49 {

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int x1 = dp[a] * 2, x2 = dp[b] * 3, x3 = dp[c] * 5;
            dp[i] = Math.min(Math.min(x1, x2), x3);
            if (dp[i] == x1) {
                a++;
            }
            if (dp[i] == x2) {
                b++;
            }
            if (dp[i] == x3) {
                c++;
            }
        }
        return dp[n - 1];
    }

}
