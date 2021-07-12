package dp;

/**
 * @author qihaodong
 */
public class LeetCode53 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0], temp = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            temp = Math.max(nums[i], temp + nums[i]);
            result = Math.max(result, temp);
        }
        return result;
    }

}
