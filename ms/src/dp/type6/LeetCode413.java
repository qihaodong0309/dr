package dp.type6;

/**
 * @author qihaodong
 */
public class LeetCode413 {

    /**
     * 优化后的 dp
     *
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int result = 0, n = nums.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; ++i) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                result += dp[i];
            }
        }
        return result;
    }


    /**
     * dp 维护状态
     *
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int result = 0, n = nums.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; ++i) {
            dp[i] = (nums[i] + nums[i - 2] == 2 * nums[i - 1] ? 1 : 0);
            result += dp[i];
        }
        for (int i = 4; i <= n; ++i) {
            for (int j = n - 1; j >= i - 1; --j) {
                dp[j] = dp[j - 1] > 0 && nums[j] + nums[j - 2] == 2 * nums[j - 1] ? 1 : 0;
                result += dp[j];
            }
        }
        return result;
    }

}
