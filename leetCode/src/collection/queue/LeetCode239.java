package collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 同 JzOffer 59_1
 *
 * @author qihaodong
 */
public class LeetCode239 {

    public static void main(String[] args) {
        LeetCode239 test = new LeetCode239();
        test.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
    }

    /**
     * 基于队列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        result[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            result[i - k + 1] = deque.peekFirst();
        }
        return result;
    }

}
