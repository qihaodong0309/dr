package collection.heap;

import java.util.PriorityQueue;

/**
 * @author qihaodong
 */
public class LeetCode1046 {

    /**
     * 堆
     *
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((x1, x2) -> {
            return x2 - x1;
        });
        for (int i : stones) {
            heap.add(i);
        }
        while (heap.size() > 1) {
            int y = heap.poll();
            int x = heap.poll();
            if (y > x) {
                heap.add(y - x);
            }
        }
        return heap.size() == 0 ? 0 : heap.poll();
    }

}
