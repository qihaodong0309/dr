package dp.type6;

import java.util.Stack;

/**
 * 前五种类型要么线性，要么找规律，
 * 本类型无规律，凭经验实现单串类型
 *
 * @author qihaodong
 */
public class LeetCode32 {

    /**
     * 基于 dp 实现
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0, n = s.length();
        int[] dp = new int[n];
        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                } else if (i - dp[i - 1] > 0 && (s.charAt(i - dp[i - 1] - 1) == '(')) {
                    dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

    /**
     * 使用栈
     *
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }

    /**
     * 基于左右遍历实现
     *
     * @param s
     * @return
     */
    public int longestValidParentheses3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0, n = s.length(), left = 0, right = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (cs[i] == '(') {
                left++;
            } else {
                right++;
                if (left == right) {
                    result = Math.max(result, left + right);
                } else if (right > left) {
                    left = 0;
                    right = 0;
                }
            }
        }
        left = 0;
        right = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (cs[i] == ')') {
                right++;
            } else {
                left++;
                if (left == right) {
                    result = Math.max(result, left + right);
                } else if (left > right) {
                    left = 0;
                    right = 0;
                }
            }
        }
        return result;
    }

}
