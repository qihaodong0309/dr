package map;

import java.util.*;

/**
 * @author qihaodong
 */
public class LeetCode146 {

    /**
     * 双向队列 + Map
     */
    class LRUCache {

        private int maxSize;
        private int currentSize = 0;
        Deque<Integer> deque = new ArrayDeque();
        Map<Integer, Integer> map = new HashMap();

        public LRUCache(int capacity) {
            maxSize = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                deque.remove(key);
                deque.add(key);
                return map.get(key);
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                currentSize++;
                if (currentSize > maxSize) {
                    int delKey = deque.poll();
                    map.remove(delKey);
                }
            } else {
                deque.remove(key);
            }
            deque.add(key);
            map.put(key, value);
        }
    }

    class LRUCache2 extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public LRUCache2(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

}
