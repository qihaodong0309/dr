package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author qihaodong
 */
public class LeetCode85 {

    /**
     * 暴力解法
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle1(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int result = 0, height = matrix.length, length = matrix[0].length;
        // 遍历左上横坐标
        for (int i = 0; i < height; i++) {
            // 遍历左上纵坐标
            for (int j = 0; j < length; j++) {
                // 左上起码得满足条件
                if (matrix[i][j] == '1') {
                    // 遍历右下横坐标
                    for (int z = i; z < height; z++) {
                        // 遍历右下纵坐标
                        for (int x = j; x < length; x++) {
                            // 右下起码得满足条件
                            if (matrix[z][x] == '1') {
                                boolean judge = true;
                                // 遍历左上到右下矩形中的所有节点
                                for (int q = i; q <= z; q++) {
                                    for (int w = j; w <= x; w++) {
                                        // 如果有一个节点不满足就跳出循环
                                        if (matrix[q][w] == '0') {
                                            judge = false;
                                            break;
                                        }
                                    }
                                    if (!judge) {
                                        break;
                                    }
                                }
                                if (judge) {
                                    // 计算满足条件的面积，找出最大值
                                    int temp = (z - i + 1) * (x - j + 1);
                                    result = Math.max(result, temp);
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * dp 解法 (遍历列)
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle2(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int result = 0, height = matrix.length, length = matrix[0].length;
        // dp用来记录的数组
        int[][] record = new int[height][length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (j == 0) {
                    // 第一列初始化
                    record[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    // 从第二列开始，如果当前节点是1，连续1的个数就是左侧节点值加一，否则为零
                    record[i][j] = matrix[i][j] == '1' ? record[i][j - 1] + 1 : 0;
                }
                int temp = record[i][j];
                // 控制行，依次向上遍历
                for (int k = i; k >= 0; k--) {
                    // 宽度根据题意取最小的
                    temp = Math.min(temp, record[k][j]);
                    result = Math.max(result, temp * (i - k + 1));
                }
            }
        }
        return result;
    }

    /**
     * 单调栈解法
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle3(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int result = 0, height = matrix.length, length = matrix[0].length;
        // 二维dp实际可以优化为一维dp，因为它的节点值总和上一轮循环值唯一值有关
        int[] record = new int[length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                record[j] = matrix[i][j] == '1' ? record[j] + 1 : 0;
            }
            // 每轮循环都遍历一次，找出其中的最大值
            result = Math.max(result, getMaxValue(record));
        }
        return result;
    }

    // LeetCode 84 解法，这里我们做了优化
    // leetCode 84 博客中，我们主要循环左右两边第一个小于当前列的下标
    // 这里我们不记录左、右边界值，直接计算
    private int getMaxValue(int[] record) {
        int result = 0, length = record.length;
        Stack<Integer> stack = new Stack<Integer>();
        // push -1 方便计算，判空也可以，不过比较麻烦
        stack.push(-1);
        for (int i = 0; i < length; i++) {
            // 维护单调递增栈，寻找每个节点的左边界
            while (stack.peek() != -1 && record[i] <= record[stack.peek()]) {
                // 出栈时说明，当前节点的右边已经找到
                result = Math.max(result, record[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        // 还在栈中的所有元素都没有右边界，左边界即栈中前一个元素位置
        while (stack.peek() != -1) {
            result = Math.max(result, record[stack.pop()] * (length - stack.peek() - 1));
        }
        return result;
    }

    /**
     * dp
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle4(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int result = 0;
        int lengthX = matrix.length;
        int lengthY = matrix[0].length;
        // 记录左边起始下标
        int[] left = new int[lengthY];
        // 记录右边结束下标
        int[] right = new int[lengthY];
        // 记录顶部结束下标
        int[] height = new int[lengthY];
        // 默认右边在数组最右边，因此赋值即参数数组长度
        Arrays.fill(right, lengthY);
        for (int i = 0; i < lengthX; i++) {
            int temp_left = 0, temp_right = lengthY;
            // 高度计算逻辑不变
            for (int j = 0; j < lengthY; j++) {
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
            }
            // 左边界取上层当前位置左边界和当前行较大的一个
            for (int j = 0; j < lengthY; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], temp_left);
                } else {
                    // 这里赋0没关系，因为该节点高度是0，不会影响结果
                    // 下一层计算时也不会影响值
                    left[j] = 0;
                    temp_left = j + 1;
                }
            }
            // 右边和左边类似
            for (int j = lengthY - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], temp_right);
                } else {
                    right[j] = lengthY;
                    temp_right = j;
                }
            }
            // 遍历所有情况，找出最大面积
            for (int j = 0; j < lengthY; j++) {
                result = Math.max(result, (right[j] - left[j]) * height[j]);
            }
        }
        return result;
    }

}