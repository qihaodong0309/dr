package array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author qihaodong
 */
public class LeetCode215 {

    /**
     * 基于排序
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 基于最大堆
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((x1, x2) -> {
            return x2 - x1;
        });
        for (int n : nums) {
            heap.offer(n);
        }
        while (k > 1) {
            heap.poll();
            k--;
        }
        return heap.peek();
    }

    /**
     * 基于快速排序做优化
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest3(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSort(int[] nums, int left, int right, int index) {
        int temp = echo(nums, left, right);
        if (temp == index) {
            return nums[temp];
        } else {
            return temp < index ? quickSort(nums, temp + 1, right, index) : quickSort(nums, left, temp - 1, index);
        }
    }

    private int echo(int[] nums, int left, int right) {
        int record = nums[right], index = left - 1;
        for (int i = left; i < right; i++) {
            if (nums[i] <= record) {
                swap(nums, ++index, i);
            }
        }
        swap(nums, ++index, right);
        return index;
    }

    private void swap(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
