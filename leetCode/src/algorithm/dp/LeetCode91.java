package algorithm.dp;

/**
 * @author qihaodong
 */
public class LeetCode91 {

    public static void main(String[] args) {
        LeetCode91 test = new LeetCode91();
        System.out.println(test.numDecodings("12"));
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0') {
                int p = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                if (p <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }
}
