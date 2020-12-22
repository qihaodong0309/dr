package dp;

/**
 * @author qihaodong
 */
public class LeetCode152 {

    /**
     * dp
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE, n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0 || (dp1[i - 1] == 0 && dp2[i - 1] == 0)) {
                if (nums[i] != 0) {
                    dp1[i] = nums[i] > 0 ? nums[i] : 0;
                    dp2[i] = nums[i] < 0 ? nums[i] : 0;
                }
            } else {
                if (nums[i] != 0) {
                    if (nums[i] > 0) {
                        dp1[i] = Math.max(nums[i], nums[i] * dp1[i - 1]);
                        dp2[i] = Math.min(nums[i], nums[i] * dp2[i - 1]);
                    } else {
                        dp1[i] = Math.max(nums[i], nums[i] * dp2[i - 1]);
                        dp2[i] = Math.min(nums[i], nums[i] * dp1[i - 1]);
                    }
                }
            }
            result = dp1[i] > 0 ? Math.max(result, dp1[i]) : Math.max(result, nums[i]);
        }
        return result;
    }

}
