package jzoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qihaodong
 */
public class JzOffer13 {

    /**
     * 深度优先遍历
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        return dfs(0, 0, m, n, k, new int[m][n]);
    }

    private int dfs(int x, int y, int m, int n, int k, int[][] record) {
        if (x < 0 || y < 0 || x >= m || y >= n || record[x][y] == 1 || getValue(x) + getValue(y) > k) {
            return 0;
        }
        record[x][y] = 1;
        return 1 + dfs(x + 1, y, m, n, k, record)
                + dfs(x - 1, y, m, n, k, record)
                + dfs(x, y + 1, m, n, k, record)
                + dfs(x, y - 1, m, n, k, record);
    }

    int[] columnX = new int[]{1, 0};
    int[] columnY = new int[]{0, 1};

    /**
     * 队列 + 广度优先遍历
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount2(int m, int n, int k) {
        int result = 1;
        boolean[][] judge = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int x = queue.peek()[0], y = queue.poll()[1];
            judge[x][y] = true;
            for (int i = 0; i < 2; i++) {
                int newX = x + columnX[i], newY = y + columnY[i];
                if (newX == m || newY == n || judge[newX][newY] || getValue(newX) + getValue(newY) > k) {
                    continue;
                }
                queue.add(new int[]{newX, newY});
                judge[newX][newY] = true;
                result += 1;
            }
        }
        return result;
    }

    /**
     * 数学计算法
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount3(int m, int n, int k) {
        int result = 1;
        boolean[][] record = new boolean[m][n];
        record[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j == 0) || getValue(i) + getValue(j) > k) {
                    continue;
                }
                if (i >= 1) {
                    record[i][j] |= record[i - 1][j];
                }
                if (j >= 1) {
                    record[i][j] |= record[i][j - 1];
                }
                result += record[i][j] ? 1 : 0;
            }
        }
        return result;
    }

    private int getValue(int num) {
        int result = 0;
        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

}
