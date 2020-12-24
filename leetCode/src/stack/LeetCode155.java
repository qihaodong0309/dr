package stack;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author qihaodong
 */
public class LeetCode155 {

    /*
    借助栈 + 最小堆
     */

    public LeetCode155() {
        stack = new Stack<>();
        heap = new PriorityQueue<Integer>((x1, x2) -> {
            return x1 >= x2 ? 1 : -1;
        });
    }

    Stack<Integer> stack = null;
    PriorityQueue<Integer> heap = null;

    public void push(int x) {
        stack.push(x);
        heap.offer(x);
    }

    public void pop() {
        int n = stack.pop();
        heap.remove(n);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return heap.peek();
    }

    /*
    借助双栈
     */

    class Method2 {

        public Method2() {

        }

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Integer min = null;

        public void push(int x) {
            stack1.push(x);
            min = stack2.isEmpty() ? x : Integer.min(stack2.peek(), x);
            stack2.push(min);
        }

        public void pop() {
            stack1.pop();
            stack2.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }

    }

    /*
    不借助额外空间
     */

    class Method3 {

        public Method3() {

        }

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

        public int getMin() {
            return min;
        }

    }

}
