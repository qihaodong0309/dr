package jzoffer;

import java.util.Stack;

/**
 * @author qihaodong
 */
public class JzOffer9 {

    class CQueue {

        Stack<Integer> stack1 = null;
        Stack<Integer> stack2 = null;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }

    }

}
