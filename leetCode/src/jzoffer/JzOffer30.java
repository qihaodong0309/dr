package jzoffer;

import java.util.Stack;

/**
 * @author qihaodong
 */
public class JzOffer30 {

    /**
     * 借助双栈
     */
    class MinStack {

        Stack<Integer> stack1 = null;
        Stack<Integer> stack2 = null;

        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            if (stack2.isEmpty() || x <= stack2.peek()) {
                stack2.push(x);
            }
        }

        public void pop() {
            int x = stack1.pop();
            if (x == stack2.peek()) {
                stack2.pop();
            }
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return stack2.peek();
        }
    }

    /**
     * 不使用额外内存空间
     */
    class MinStack2 {

        Integer min = null;
        Stack<Long> stack = new Stack<>();

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(0L);
                min = x;
            } else {
                stack.push(Long.valueOf(x) - min);
                min = Math.min(min, x);
            }
        }

        public void pop() {
            Long diff = stack.pop();
            if (diff < 0) {
                min = (int) (Long.valueOf(min) - diff);
            }
        }

        public int top() {
            Long diff = stack.peek();
            if (diff > 0) {
                return (int) (Long.valueOf(min) + diff);
            } else {
                return min;
            }
        }

        public int min() {
            return min;
        }
        
    }

}
