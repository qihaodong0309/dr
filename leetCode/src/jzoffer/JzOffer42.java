package jzoffer;

/**
 * 同 LeetCode 53
 *
 * @author qihaodong
 */
public class JzOffer42 {

    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 1], nums[i]);
            result = nums[i] > result ? nums[i] : result;
        }
        return result;
    }

}
