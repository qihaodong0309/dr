package collection.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 同 JzOffer 29
 * JzOffer 返回数组，这里返回 List
 *
 * @author qihaodong
 */
public class LeetCode54 {

    /**
     * 模拟单个节点遍历，走到终点就换方向
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int m = matrix.length, n = matrix[0].length, index = 0, end = m * n;
        int staX = 0, staY = 0, dIndex = 0;
        boolean[][] visited = new boolean[m][n];
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (index < end) {
            result.add(matrix[staX][staY]);
            visited[staX][staY] = true;
            int newX = staX + direction[dIndex][0], newY = staY + direction[dIndex][1];
            if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY]) {
                dIndex = (dIndex + 1) % 4;
            }
            staX += direction[dIndex][0];
            staY += direction[dIndex][1];
            index++;
        }
        return result;
    }

}
