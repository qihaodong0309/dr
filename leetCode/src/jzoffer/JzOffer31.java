package jzoffer;

import java.util.Stack;

/**
 * @author qihaodong
 */
public class JzOffer31 {

    public static void main(String[] args) {
        JzOffer31 test = new JzOffer31();
        test.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
    }

    /**
     * 基于栈来实现
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int record = 0, index = 0, length = popped.length;
        Stack<Integer> stack = new Stack<>();
        while (index < length) {
            if (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
            } else {
                while (record < length && pushed[record] != popped[index]) {
                    stack.push(pushed[record]);
                    record++;
                }
                if (record++ == length) {
                    return false;
                }
            }
            ++index;
        }
        return true;
    }

    /**
     * 上述方法一优化
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

}
