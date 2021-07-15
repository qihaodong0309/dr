package dp.type6;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class LeetCode132 {

    public static void main(String[] args) {
        LeetCode132 test = new LeetCode132();
        test.minCut("cabababcbc");
    }

    /**
     * dp 两用
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        int n = s.length();
        boolean[][] record = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(record[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                record[i][j] = s.charAt(i) == s.charAt(j) && record[i + 1][j - 1];
            }
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            if (record[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1] + 1;
                for (int j = i - 1; j >= 0; --j) {
                    if (record[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * 递归判断 dp 解决
     *
     * @param s
     * @return
     */
    public int minCut2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i] = i > 1 ? dp[i - 1] + 1 : 0;
            int index = i - 1;
            while (index >= 1) {
                if (s.charAt(index - 1) == s.charAt(i - 1) && isEach(s.toCharArray(), index - 1, i - 1)) {
                    int newVal = index > 1 ? dp[index - 1] + 1 : 0;
                    dp[i] = Math.min(dp[i], newVal);
                }
                index--;
            }
        }
        return dp[n];
    }

    private boolean isEach(char[] num, int start, int end) {
        while (start <= end && num[start] == num[end]) {
            start++;
            end--;
        }
        return start >= end;
    }

}
