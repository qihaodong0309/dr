package algorithm.dp;

/**
 * @author qihaodong
 */
public class LeetCode62 {

    /**
     * DFS（该方法会超时）
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        return dfs(1, 1, m, n);
    }

    private int dfs(int x, int y, int m, int n) {
        if (x == m && y == n) {
            return 1;
        }
        if (x > m || y > n) {
            return 0;
        }
        return dfs(x + 1, y, m, n) + dfs(x, y + 1, m, n);
    }

    /**
     * dp
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[] record = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            record[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                record[j] += record[j - 1];
            }
        }
        return record[m];
    }

}
