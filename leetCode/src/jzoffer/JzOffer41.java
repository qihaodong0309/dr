package jzoffer;

import java.util.PriorityQueue;

/**
 * @author qihaodong
 */
public class JzOffer41 {

    public static void main(String[] args) {
        JzOffer41 test = new JzOffer41();
        test.addNum(1);
        test.addNum(2);
        test.addNum(3);
    }

    /*
    使用双堆法，最大堆和最小堆分别来保存数据的一半
    默认是最小堆
     */

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((x1, x2) -> {
        return x2 - x1;
    });
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((x1, x2) -> {
        return x1 - x2;
    });

    public void addNum(int num) {
        if (maxHeap.size() > minHeap.size()) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

}
