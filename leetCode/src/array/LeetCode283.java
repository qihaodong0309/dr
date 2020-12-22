package array;

/**
 * @author qihaodong
 */
public class LeetCode283 {

    /**
     * 简单遍历
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (end >= 0 && nums[end] == 0) {
                end--;
            }
            if (start < end && nums[start] == 0) {
                int temp = start + 1;
                while (temp <= end) {
                    nums[temp - 1] = nums[temp];
                    temp++;
                }
                nums[end] = 0;
            } else {
                start++;
            }
        }
    }

    /**
     * 快慢指针
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int slow = 0, quick = 0, n = nums.length;
        while (quick < n) {
            if (nums[quick] != 0) {
                nums[slow++] = nums[quick];
            }
            quick++;
        }
        for (int i = slow; i < n; i++) {
            nums[i] = 0;
        }
    }

}
