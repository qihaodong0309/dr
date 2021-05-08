package algorithm.dp;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class LeetCode403 {

    /**
     * dfs
     *
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        int n = stones.length;
        record = new Boolean[n][n];
        return dfs(stones, 0, 0);
    }

    private Boolean[][] record;

    private boolean dfs(int[] stones, int i, int lastDis) {
        if (i == stones.length - 1) {
            return true;
        }
        if (record[i][lastDis] != null) {
            return record[i][lastDis];
        }
        for (int cur = lastDis - 1; cur <= lastDis + 1; cur++) {
            if (cur > 0) {
                int index = Arrays.binarySearch(stones, i + 1, stones.length, cur + stones[i]);
                if (index >= 0 && dfs(stones, index, cur)) {
                    return record[i][lastDis] = true;
                }
            }
        }
        return record[i][lastDis] = false;
    }


    /**
     * dp
     *
     * @param stones
     * @return
     */
    public boolean canCross2(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }

}