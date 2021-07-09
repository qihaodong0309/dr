package mock_interview.i20210709_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qihaodong
 */
public class Q1 {

    class MyStack {

        Queue<Integer> queue1 = null;
        Queue<Integer> queue2 = null;

        public MyStack() {
            queue1 = new LinkedList<Integer>();
            queue2 = new LinkedList<Integer>();
        }

        public void push(int x) {
            Queue<Integer> temp = queue1.size() >= queue2.size() ? queue1 : queue2;
            temp.offer(x);
        }

        public int pop() {
            Queue<Integer> temp1 = queue1.size() >= queue2.size() ? queue1 : queue2;
            Queue<Integer> temp2 = temp1 == queue1 ? queue2 : queue1;
            while (temp1.size() > 1) {
                temp2.offer(temp1.poll());
            }
            return temp1.poll();
        }

        public int top() {
            Queue<Integer> temp1 = queue1.size() < queue2.size() ? queue1 : queue2;
            int result = pop();
            temp1.offer(result);
            return result;
        }

        public boolean empty() {
            return queue1.size() == 0 && queue2.size() == 0;
        }
    }

}
