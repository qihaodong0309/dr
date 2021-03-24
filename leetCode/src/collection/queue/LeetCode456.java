package collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author qihaodong
 */
public class LeetCode456 {

    /**
     * 单调栈
     *
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length, temp = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < temp) {
                return true;
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                temp = Math.max(temp, deque.pollLast());
            }
            deque.addLast(nums[i]);
        }
        return false;
    }

}
