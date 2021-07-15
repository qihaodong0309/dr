package dp.type5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * dp 与 二分，贪心，排序 相关
 *
 * @author qihaodong
 */
public class LeetCode368 {

    public static void main(String[] args) {
        LeetCode368 test = new LeetCode368();
        test.largestDivisibleSubset(new int[]{2, 3, 8, 9, 27});
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int max = 1, temp = nums[0], n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            temp = dp[i] > max ? nums[i] : temp;
            max = Math.max(max, dp[i]);
        }
        for (int i = n - 1; i >= 0; --i) {
            if (temp % nums[i] == 0 && dp[i] == max) {
                result.add(nums[i]);
                temp = nums[i];
                max--;
            }
        }
        return result;
    }

}
