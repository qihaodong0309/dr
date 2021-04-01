package algorithm.math;

import java.util.Stack;

/**
 * @author qihaodong
 */
public class LeetCode1006 {

    public int clumsy(int N) {
        int result = 0;
        while (N > 0) {
            result += result == 0 ? getVal(N) : -1 * getVal(N);
            result += (N - 3) > 0 ? (N - 3) : 0;
            N -= 4;
        }
        return result;
    }

    private int getVal(int N) {
        if (N >= 3) {
            return N * (N - 1) / (N - 2);
        } else {
            return N;
        }
    }

    /**
     * 基于栈计算
     *
     * @param N
     * @return
     */
    public int clumsy2(int N) {
        Stack<Integer> stack = new Stack<>();
        stack.push(N--);
        int result = 0, index = 4;
        while (N > 0) {
            int type = index % 4;
            if (type == 0) {
                stack.push(stack.pop() * N);
            } else if (type == 1) {
                stack.push(stack.pop() / N);
            } else if (type == 2) {
                stack.push(N);
            } else {
                stack.push(-N);
            }
            index++;
            N--;
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

}
