package algorithm.dichotomy;

/**
 * 同 LeetCode11
 *
 * @author qihaodong
 */
public class LeetCode154 {

    /**
     * 二分法
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = right - 1;
            }
        }
        return nums[left];
    }

}
