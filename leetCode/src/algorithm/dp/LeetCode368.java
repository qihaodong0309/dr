package algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qihaodong
 */
public class LeetCode368 {

    /**
     * DP
     *
     * @param nums
     * @return
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length, max = 1, maxValue = nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > max) {
                        maxValue = nums[i];
                        max = dp[i];
                    }
                }
            }
        }
        if (max == 1) {
            result.add(maxValue);
            return result;
        } else {
            for (int i = n - 1; i >= 0 && max > 0; i--) {
                if (dp[i] == max && maxValue % nums[i] == 0) {
                    result.add(nums[i]);
                    maxValue = nums[i];
                    max--;
                }
            }
        }
        return result;
    }

}
