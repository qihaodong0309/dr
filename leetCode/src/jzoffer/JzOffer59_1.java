package jzoffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 同 LeetCode 239
 *
 * @author qihaodong
 */
public class JzOffer59_1 {

    public static void main(String[] args) {
        JzOffer59_1 test = new JzOffer59_1();
        test.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
    }

    /**
     * K神解法
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length, resN = n - k + 1, index = 0;
        int[] result = new int[resN];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty() && i >= k && queue.peek() == nums[i - k]) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i] > queue.getLast()) {
                queue.removeLast();
            }
            queue.add(nums[i]);
            if (i >= k - 1) {
                result[index++] = queue.peek();
            }
        }
        return result;
    }

}
