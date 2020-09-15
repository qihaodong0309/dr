package stack;

import java.util.Stack;

/**
 * @author qihaodong
 */
public class LeetCode84 {

    /**
     * 穷举法(穷举行)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int result = 0, length = heights.length;
        // 遍历长方体长的起始下标
        for (int left = 0; left < length; left++) {
            int maxHeight = Integer.MAX_VALUE;
            // 遍历长方体长的结束下标
            // 通过这两层遍历就可以遍历出所有情况长方体
            for (int right = left; right < length; right++) {
                // 计算起始下标left，结束下标right下的最低高度
                maxHeight = Math.min(maxHeight, heights[right]);
                result = Math.max(result, (right - left + 1) * maxHeight);
            }
        }
        return result;
    }

    /**
     * 穷举法(穷举列)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int result = 0, length = heights.length;
        // 遍历所有列的情况
        for (int temp = 0; temp < length; temp++) {
            int height = heights[temp], left = temp - 1, right = temp + 1;
            // 向左找出第一个小于它高度列的下标
            while (left >= 0 && heights[left] >= height) {
                left--;
            }
            // 向右找出第一个小于它高度列的下标
            while (right < length && heights[right] >= height) {
                right++;
            }
            result = Math.max(result, (right - left - 1) * height);
        }
        return result;
    }

    /**
     * 单调栈解法
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        int result = 0, length = heights.length;
        int[] leftIndex = new int[length];
        int[] rightIndex = new int[length];
        Stack<Integer> stack = new Stack<Integer>();
        // 从前往后遍历所有列，计算左边第一个低于当前列的下标
        for (int i = 0; i < length; i++) {
            // 栈不为空，并且当前遍历列小于栈顶元素列
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // 此时栈顶元素对应列一定是第一个低于当前列的
            // 如果栈为空，说明前面所有列都比它高，赋值-1
            leftIndex[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        // 清空栈
        while (!stack.isEmpty()) {
            stack.pop();
        }
        // 从后往前遍历，和上面相反，计算右边第一个低于当前列的下标
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            rightIndex[i] = stack.isEmpty() ? length : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < length; i++) {
            // 遍历所有列可能产生的情况，找出最大情况
            result = Math.max(result, (rightIndex[i] - leftIndex[i] - 1) * heights[i]);
        }
        return result;
    }

    /**
     * 单调栈解法优化
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea4(int[] heights) {
        int result = 0, length = heights.length;
        int[] leftIndex = new int[length];
        int[] rightIndex = new int[length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                // 出栈时说明当前列是一个小于它的列
                rightIndex[stack.peek()] = i;
                stack.pop();
            }
            leftIndex[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        // 没有出栈的说明右边所有列都比它高
        while (!stack.isEmpty()) {
            rightIndex[stack.peek()] = length;
            stack.pop();
        }
        for (int i = 0; i < length; i++) {
            result = Math.max(result, (rightIndex[i] - leftIndex[i] - 1) * heights[i]);
        }
        return result;
    }

}