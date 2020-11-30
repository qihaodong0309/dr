package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qihaodong
 */
public class LeetCode1030 {

    /**
     * Arrays.sort() 辅助法
     *
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int length = R * C, k = 0;
        int[][] result = new int[length][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result[k++] = new int[]{i, j};
            }
        }
        Arrays.sort(result, (o1, o2) -> {
            int index1 = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
            int index2 = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
            return index1 - index2;
        });
        return result;
    }

    /**
     * 一次遍历法，需要更多的空间
     *
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        int maxLength = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0), k = 0;
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= maxLength; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int diff = Math.abs(i - r0) + Math.abs(j - c0);
                list.get(diff).add(new int[]{i, j});
            }
        }
        int[][] result = new int[R * C][];
        for (List<int[]> temp : list) {
            for (int[] ints : temp) {
                result[k++] = ints;
            }
        }
        return result;
    }

}
