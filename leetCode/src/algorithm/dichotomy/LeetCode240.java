package algorithm.dichotomy;

/**
 * 本题同 JzOffer4
 *
 * @author qihaodong
 */
public class LeetCode240 {

    /**
     * 数学方法
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int x = matrix.length, y = matrix[0].length;
        int tempX = x - 1, tempY = 0;
        while (tempX >= 0 && tempY < y) {
            if (matrix[tempX][tempY] > target) {
                tempX--;
            } else if (matrix[tempX][tempY] < target) {
                tempY++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int index = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < index; i++) {
            boolean column = echo(matrix, target, i, true);
            boolean row = echo(matrix, target, i, false);
            if (column || row) {
                return true;
            }
        }
        return false;
    }

    /**
     * i 表示对角线坐标，judge 记录是左边遍历还是前后遍历
     *
     * @param matrix
     * @param i
     * @param judge
     * @return
     */
    private boolean echo(int[][] matrix, int target, int i, boolean judge) {
        int left = i;
        int right = judge ? matrix.length - 1 : matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (judge) {
                if (matrix[mid][i] > target) {
                    right = mid - 1;
                } else if (matrix[mid][i] < target) {
                    left = mid + 1;
                } else {
                    return true;
                }
            } else {
                if (matrix[i][mid] > target) {
                    right = mid - 1;
                } else if (matrix[i][mid] < target) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

}
