package collection.array;

import java.util.TreeSet;

/**
 * @author qihaodong
 */
public class LeetCode363 {

    /**
     * 枚举法
     *
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int result = Integer.MIN_VALUE;
        int x = matrix.length, y = matrix[0].length;
        for (int i = 0; i < x; ++i) {
            int[] temp = new int[y];
            for (int j = i; j < x; ++j) {
                for (int c = 0; c < y; c++) {
                    temp[c] += matrix[j][c];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int judge = 0;
                for (int p : temp) {
                    judge += p;
                    Integer q = set.ceiling(judge - k);
                    if (q != null) {
                        result = Math.max(result, judge - q);
                    }
                    set.add(judge);
                }
            }
        }
        return result;
    }

}
