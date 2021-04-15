package algorithm.dp;

/**
 * LeetCode 213的简单版
 *
 * @author qihaodong
 */
public class LeetCode198 {

    /**
     * dp
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int left = nums[0], right = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(nums[i] + left, right);
            left = right;
            right = temp;
        }
        return right;
    }

}
