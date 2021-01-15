package algorithm.greedy;

import java.util.Stack;

/**
 * @author qihaodong
 */
public class LeetCode1081 {

    /**
     * 贪心算法
     *
     * @param s
     * @return
     */
    public String smallestSubsequence(String s) {
        char[] record = new char[26];
        for (char c : s.toCharArray()) {
            record[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (!stack.contains(c)) {
                    while (!stack.isEmpty() && stack.peek() > c && record[stack.peek() - 'a'] > 0) {
                        stack.pop();
                    }
                    stack.push(c);
                }
            }
            record[c - 'a']--;
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }

}