package jzoffer;

/**
 * 同 LeetCode 34
 *
 * @author qihaodong
 */
public class JzOffer53_1 {

    /**
     * 简单遍历法
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int result = 0;
        for (int n : nums) {
            if (n == target) {
                result++;
            } else if (n > target) {
                break;
            }
        }
        return result;
    }

    /**
     * K神解法：二分法（找左右边界）
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    private int helper(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

}
