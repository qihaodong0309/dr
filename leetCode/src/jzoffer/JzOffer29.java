package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer29 {

    /**
     * 从四个方向遍历
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length, index = 0, i;
        int xl = 0, xr = m - 1, yl = 0, yr = n - 1;
        int[] result = new int[m * n];
        while (index < m * n) {
            for (i = yl; i <= yr && index < m * n; i++) {
                result[index++] = matrix[xl][i];
            }
            xl++;
            for (i = xl; i <= xr && index < m * n; i++) {
                result[index++] = matrix[i][yr];
            }
            yr--;
            for (i = yr; i >= yl && index < m * n; i--) {
                result[index++] = matrix[xr][i];
            }
            xr--;
            for (i = xr; i >= xl && index < m * n; i--) {
                result[index++] = matrix[i][yl];
            }
            yl++;
        }
        return result;
    }

}
