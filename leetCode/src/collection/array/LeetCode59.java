package collection.array;

/**
 * @author qihaodong
 */
public class LeetCode59 {

    public static void main(String[] args) {
        LeetCode59 test = new LeetCode59();
        test.generateMatrix(5);
    }

    /**
     * 递归循环法
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int xL = 0, xR = n - 1, yL = 0, yR = n - 1;
        int start = 1, end = n * n;
        while (start <= end) {
            for (int i = yL; i <= yR && start <= end; i++) {
                result[xL][i] = start++;
            }
            xL++;
            for (int i = xL; i <= xR && start <= end; i++) {
                result[i][yR] = start++;
            }
            yR--;
            for (int i = yR; i >= yL && start <= end; i--) {
                result[xR][i] = start++;
            }
            xR--;
            for (int i = xR; i >= xL && start <= end; i--) {
                result[i][yL] = start++;
            }
            yL++;
        }
        return result;
    }

}
