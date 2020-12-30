package queue;

import model.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * @author qihaodong
 */
public class LeetCode341 {

    class NestedIterator implements Iterator<Integer> {

        Deque<Integer> deque = new ArrayDeque<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            echo(deque, nestedList);
        }

        private void echo(Deque<Integer> deque, List<NestedInteger> nestedList) {
            for (NestedInteger temp : nestedList) {
                if (temp.isInteger()) {
                    deque.addLast(temp.getInteger());
                } else {
                    echo(deque, temp.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return deque.removeFirst();
        }

        @Override
        public boolean hasNext() {
            return deque.size() > 0;
        }

    }

}
