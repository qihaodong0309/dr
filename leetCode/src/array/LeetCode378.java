package array;

import java.util.PriorityQueue;

/**
 * @author qihaodong
 */
public class LeetCode378 {

    public static void main(String[] args) {
        LeetCode378 test = new LeetCode378();
        int[][] num = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        test.kthSmallest(num, 8);
    }

    /**
     * 遍历法
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int result = matrix[0][0], n = matrix.length, start = 0, end = 1;
        int[] record = new int[n];
        record[0] = 1;
        while (k > 1) {
            int max = Integer.MAX_VALUE, index = -1;
            for (int i = start; i <= end; i++) {
                if (matrix[i][record[i]] < max) {
                    max = matrix[i][record[i]];
                    index = i;
                }
            }
            result = matrix[index][record[index]];
            record[index]++;
            if (record[index] == 1) {
                end = end == n - 1 ? end : end + 1;
            }
            if (record[index] == n) {
                start++;
            }
            k--;
        }
        return result;
    }

    /**
     * 归并排序
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((int[] n1, int[] n2) -> {
            return n1[0] - n2[0];
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            heap.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] temp = heap.poll();
            if (temp[2] != n - 1) {
                heap.add(new int[]{matrix[temp[1]][temp[2] + 1], temp[1], temp[2] + 1});
            }
        }
        return heap.poll()[0];
    }

    /**
     * 二分排序，根据任意值划分数组
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest3(int[][] matrix, int k) {
        int n = matrix.length, min = matrix[0][0], max = matrix[n - 1][n - 1];
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (check(matrix, mid, k, n)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1, j = 0, num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

}
