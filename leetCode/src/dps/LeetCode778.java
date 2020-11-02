package dps;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author qihaodong
 */
public class LeetCode778 {

    public int swimInWater(int[][] grid) {
        int[][] record = null;
        for (int i = 0; ; i++) {
            record = new int[grid.length][grid[0].length];
            if (dfs(grid, 0, 0, record, i)) {
                return i;
            }
        }
    }

    private boolean dfs(int[][] grid, int i, int j, int[][] record, int key) {
        int x = grid.length, y = grid[0].length;
        if (i == x || j == y || i < 0 || j < 0) {
            return false;
        }
        if (i == x - 1 && j == y - 1 && grid[i][j] <= key) {
            return true;
        }
        if (record[i][j] == 0 && grid[i][j] <= key) {
            record[i][j] = 1;
            if (dfs(grid, i + 1, j, record, key)
                    || dfs(grid, i - 1, j, record, key)
                    || dfs(grid, i, j - 1, record, key)
                    || dfs(grid, i, j + 1, record, key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 队列法
     *
     * @param grid
     * @return
     */
    public int swimInWater2(int[][] grid) {
        int n = grid.length;
        HashSet<Integer> record = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>
                ((k1, k2) -> grid[k1 / n][k1 % n] - grid[k2 / n][k2 % n]);
        queue.offer(0);
        int result = 0;

        int[] temp1 = {1, -1, 0, 0};
        int[] temp2 = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int k = queue.poll();
            int x = k / n, y = k % n;
            result = Math.max(result, grid[x][y]);
            if (x == n - 1 && y == n - 1) {
                return result;
            }
            for (int i = 0; i < 4; i++) {
                int newX = x + temp1[i], newY = y + temp2[i];
                int temp = newX * n + newY;
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !record.contains(temp)) {
                    queue.offer(temp);
                    record.add(temp);
                }
            }
        }
        throw null;
    }

    /**
     * 二分查找 + dps
     *
     * @param grid
     * @return
     */
    public int swimInWater3(int[][] grid) {
        int n = grid.length;
        int min = grid[0][0], max = n * n;
        while (min < max) {
            int middle = min + (max - min) / 2;
            if (success(middle, grid)) {
                max = middle;
            } else {
                min = middle + 1;
            }
        }
        return min;
    }

    public boolean success(int key, int[][] grid) {
        int n = grid.length;
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        stack.push(0);
        int[] temp1 = {1, -1, 0, 0};
        int[] temp2 = {0, 0, 1, -1};
        while (!stack.isEmpty()) {
            int val = stack.pop();
            int x = val / n, y = val % n;
            if (x == n - 1 && y == n - 1) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int newX = x + temp1[i], newY = y + temp2[i];
                int temp = newX * n + newY;
                if (newX >= 0 && newY >= 0 && newX < n && newY < n
                        && !set.contains(temp) && grid[newX][newY] <= key) {
                    stack.push(temp);
                    set.add(temp);
                }
            }
        }
        return false;
    }

}