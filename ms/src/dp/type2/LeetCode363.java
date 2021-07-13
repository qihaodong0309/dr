package dp.type2;

import java.util.TreeSet;

/**
 * @author qihaodong
 */
public class LeetCode363 {

    public static void main(String[] args) {
        LeetCode363 test = new LeetCode363();
        test.maxSumSubmatrix(new int[][]{{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}}, 8);
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int result = Integer.MIN_VALUE, m = matrix.length, n = matrix[0].length;
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= m - i; ++j) {
                int[] temp = new int[n];
                for (int q = 0; q < n; ++q) {
                    for (int w = j; w < j + i; ++w) {
                        temp[q] += matrix[w][q];
                    }
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int judge = 0;
                for (int q = 0; q < n; ++q) {
                    judge += temp[q];
                    Integer num = set.ceiling(judge - k);
                    if (num != null) {
                        result = Math.max(result, judge - num);
                    }
                    set.add(judge);
                }
            }
        }
        return result;
    }

}
