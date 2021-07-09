package mock_interview.i20210709;

import java.util.Arrays;

/**
 * LeetCode 1487
 *
 * @author qihaodong
 */
public class Q3n {

    /**
     * 动态规划 + 穷举
     *
     * @param houses
     * @param k
     * @return
     */
    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        Arrays.sort(houses);
        int[][] record = new int[n][n];
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                record[i][j] = record[i + 1][j - 1] + houses[j] - houses[i];
            }
        }
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; ++i) {
            dp[i][1] = record[0][i];
            for (int j = 2; j <= k && j <= i + 1; ++j) {
                for (int t = 0; t < i; ++t) {
                    dp[i][j] = Math.min(dp[i][j], dp[t][j - 1] + record[t + 1][i]);
                }
            }
        }
        return dp[n - 1][k];
    }

}
