package dp.type3;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class LeetCode1388 {

    public static void main(String[] args) {
        LeetCode1388 test = new LeetCode1388();
        System.out.println(test.maxSizeSlices(new int[]{1, 2, 3, 4, 5, 6}));
    }

    public int maxSizeSlices(int[] slices) {
        if (slices == null || slices.length == 0) {
            return 0;
        }
        int n = slices.length;
        int[] nF = Arrays.copyOfRange(slices, 1, n);
        int[] nL = Arrays.copyOfRange(slices, 0, n - 1);
        int val1 = getVal(nF);
        int val2 = getVal(nL);
        return Math.max(val1, val2);
    }

    private int getVal(int[] num) {
        int n = num.length, count = (n + 1) / 3;
        int[][] record = new int[n][count + 1];
        Arrays.fill(record[0], num[0]);
        record[0][0] = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= count; ++j) {
                int ns = record[i - 1][j];
                int ts = i >= 2 ? record[i - 2][j - 1] : 0;
                record[i][j] = Math.max(num[i] + ts, ns);
            }
        }
        return record[n - 1][count];
    }

}
