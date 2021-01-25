package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer21 {

    /**
     * 前后双指针法
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] % 2 == 1) {
                start++;
            }
            while (start < end && nums[end] % 2 == 0) {
                end--;
            }
            if (start < end) {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
            }
        }
        return nums;
    }

    /**
     * 快慢指针法
     *
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        int quick = 0, slow = 0;
        while (quick < nums.length) {
            if (nums[quick] % 2 == 1) {
                swap(nums, slow++, quick);
            }
            quick++;
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
