package collection.stack;

import java.util.Stack;

/**
 * @author qihaodong
 */
public class LeetCode42 {

    /**
     * 最简单传统解法
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int result = 0;
        int length = height.length;
        // 最左和最右的柱子一定不能储水，无需遍历
        for (int i = 1; i < length - 1; i++) {
            int val = height[i], left = val, right = val;
            // 寻找左边最高柱子
            for (int j = 0; j < i; j++) {
                if (height[j] > left) {
                    left = height[j];
                }
            }
            // 寻找右边最高柱子
            for (int j = i + 1; j < length; j++) {
                if (height[j] > right) {
                    right = height[j];
                }
            }
            result = result + (Math.min(left, right) - val);
        }
        return result;
    }

    /**
     * 传统方法改dp
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int result = 0, length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];
        // 计算第i列左边最高柱子高度
        for (int i = 1; i < length - 1; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        // 计算第i列右边最高柱子高度
        for (int i = length - 2; i > 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        // 遍历计算
        for (int i = 1; i < length - 1; i++) {
            int temp = Math.min(left[i], right[i]) - height[i];
            result += temp > 0 ? temp : 0;
        }
        return result;
    }

    /**
     * 使用栈
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int result = 0, temp = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (temp < height.length) {
            // 1.首先栈不能为空，其次栈顶元素对应列的高小于遍历列的高
            // 2.此时要遍历到栈为空或者栈顶元素比当前列高为止
            while (!stack.isEmpty() && height[temp] > height[stack.peek()]) {
                // 取出栈顶元素队列应的下标
                int top = stack.pop();
                // 如果出栈后栈为空，说明栈顶列要么是首列，要么比前面所有列都高，无法储水
                if (stack.isEmpty()) {
                    break;
                }
                // 计算当前列和栈顶元素列的距离
                int distance = temp - stack.peek() - 1;
                // 计算可以存储的高度，用当前高度和栈顶元素减去出栈列的高度
                int boundLength = Math.min(height[temp], height[stack.peek()]) - height[top];
                result += distance * boundLength;
            }
            // 遍历下标
            stack.push(temp++);
        }
        return result;
    }

    /**
     * 使用双指针解法
     *
     * @param height
     * @return
     */
    public int trap4(int[] height) {
        int result = 0, leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left++];
                } else {
                    result += leftMax - height[left++];
                }
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right--];
                } else {
                    result += rightMax - height[right--];
                }
            }
        }
        return result;
    }

}