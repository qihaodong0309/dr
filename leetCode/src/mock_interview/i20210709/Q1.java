package mock_interview.i20210709;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author qihaodong
 */
public class Q1 {

    class FrontMiddleBackQueue {

        Deque<Integer> queue1 = null;
        Deque<Integer> queue2 = null;
        int size = 0;

        public FrontMiddleBackQueue() {
            queue1 = new ArrayDeque<Integer>();
            queue2 = new ArrayDeque<Integer>();
        }

        public void pushFront(int val) {
            size++;
            if (queue1.size() > queue2.size()) {
                queue2.addFirst(queue1.pollLast());
            }
            queue1.addFirst(val);
        }

        public void pushMiddle(int val) {
            size++;
            if (queue1.size() > queue2.size()) {
                queue2.addFirst(queue1.pollLast());
            }
            queue1.addLast(val);
        }

        public void pushBack(int val) {
            if (size == 0) {
                queue1.addFirst(val);
                size++;
                return;
            }
            size++;
            if (queue1.size() == queue2.size()) {
                queue1.addLast(queue2.pollFirst());
            }
            queue2.addLast(val);
        }

        public int popFront() {
            if (size == 0) {
                return -1;
            }
            int result = queue1.pollFirst();
            if (queue1.size() < queue2.size()) {
                queue1.addLast(queue2.pollFirst());
            }
            size--;
            return result;
        }

        public int popMiddle() {
            if (size == 0) {
                return -1;
            }
            int result = queue1.pollLast();
            if (queue1.size() < queue2.size()) {
                queue1.addLast(queue2.pollFirst());
            }
            size--;
            return result;
        }

        public int popBack() {
            if (size == 0) {
                return -1;
            }
            if (size == 1) {
                size--;
                return queue1.poll();
            }
            if (queue1.size() > queue2.size()) {
                queue2.addFirst(queue1.pollLast());
            }
            size--;
            return queue2.pollLast();
        }
    }

}
