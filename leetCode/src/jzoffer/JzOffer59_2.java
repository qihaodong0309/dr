package jzoffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qihaodong
 */
public class JzOffer59_2 {

    class MaxQueue {

        public MaxQueue() {

        }

        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        public int max_value() {
            return deque.isEmpty() ? -1 : deque.peekFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.addLast(value);
        }

        public int pop_front() {
            int value = queue.isEmpty() ? -1 : queue.poll();
            if (!deque.isEmpty() && value == deque.peekFirst()) {
                deque.pollFirst();
            }
            return value;
        }

    }

}
