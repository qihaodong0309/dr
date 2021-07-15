package dp.type6;

/**
 * @author qihaodong
 */
public class LeetCode91 {

    public static void main(String[] args) {
        LeetCode91 test = new LeetCode91();
        test.numDecodings("10");
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            int x1 = i > 1 ? s.charAt(i - 2) - '0' : 0;
            int x2 = s.charAt(i - 1) - '0';
            if (x1 == 0 && x2 == 0) {
                return 0;
            } else if (x2 == 0) {
                if (x1 > 2) {
                    return 0;
                }
                dp[i] = dp[i - 2];
            } else if (x1 == 0) {
                dp[i] = dp[i - 1];
            } else {
                int temp = x1 * 10 + x2;
                dp[i] = temp > 9 && temp < 27 ? dp[i - 1] + dp[i - 2] : dp[i - 1];
            }
        }
        return dp[n];
    }

}
