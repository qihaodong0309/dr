package dp.type3;

/**
 * 不相邻子序列最大和问题
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
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0], n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            int x1 = i - 2 >= 0 ? dp[i - 2] : 0;
            int x2 = i - 3 >= 0 ? dp[i - 3] : 0;
            dp[i] = Math.max(x1, x2) + nums[i];
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}
