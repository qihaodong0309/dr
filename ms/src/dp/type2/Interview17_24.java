package dp.type2;

/**
 * 子序列连续和最大，或者乘积最大问题
 *
 * @author qihaodong
 */
public class Interview17_24 {

    public static void main(String[] args) {
        Interview17_24 test = new Interview17_24();
        test.getMaxMatrix(new int[][]{{1}});
    }

    /**
     * 四重循环遍历法 dp
     *
     * @param matrix
     * @return
     */
    public int[] getMaxMatrix(int[][] matrix) {
        int[] result = null;
        int max = Integer.MIN_VALUE, m = matrix.length, n = matrix[0].length;
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= m - i; ++j) {
                int[] temp = new int[n];
                for (int q = 0; q < n; ++q) {
                    for (int w = j; w < j + i; ++w) {
                        temp[q] += matrix[w][q];
                    }
                }
                int judge = 0, start = 0, end = 0;
                for (int q = 0; q < n; ++q) {
                    if (judge > 0) {
                        judge = judge + temp[q];
                    } else {
                        start = q;
                        judge = temp[q];
                    }
                    end = q;
                    if (judge > max) {
                        max = judge;
                        result = new int[]{j, start, j + i - 1, end};
                    }
                }
            }
        }
        return result;
    }

}
