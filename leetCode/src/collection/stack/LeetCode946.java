package collection.stack;

import java.util.Stack;

/**
 * 同 JzOffer 31
 *
 * @author qihaodong
 */
public class LeetCode946 {

    /**
     * 官方解法
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int index = 0, length = popped.length;
        Stack<Integer> stack = new Stack<>();
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                ++index;
            }
        }
        return index == length;
    }

}
