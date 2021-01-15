package collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author qihaodong
 */
public class LeetCode150 {

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                deque.addLast(deque.removeLast() + deque.removeLast());
            } else if (s.equals("-")) {
                deque.addLast(-1 * deque.removeLast() + deque.removeLast());
            } else if (s.equals("*")) {
                deque.addLast(deque.removeLast() * deque.removeLast());
            } else if (s.equals("/")) {
                int temp1 = deque.removeLast();
                int temp2 = deque.removeLast();
                deque.addLast(temp2 / temp1);
            } else {
                deque.addLast(Integer.parseInt(s));
            }
        }
        return deque.isEmpty() ? 0 : deque.poll();
    }

}
