package dp.type3;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class LeetCode740 {

    public static void main(String[] args) {
        LeetCode740 test = new LeetCode740();
        test.deleteAndEarn2(new int[]{3, 4, 2});
    }

    /**
     * 运用边界处理
     *
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0, n = nums.length;
        int[] record = new int[10001];
        for (int i = 0; i < n; ++i) {
            record[nums[i]] += nums[i];
        }
        int[] dp = new int[10001];
        for (int i = 1; i <= 10000; ++i) {
            int x1 = i - 2 >= 1 ? dp[i - 2] : 0;
            int x2 = i - 3 >= 1 ? dp[i - 3] : 0;
            dp[i] = record[i] + Math.max(x1, x2);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    /**
     * 不运用边界处理
     *
     * @param nums
     * @return
     */
    public int deleteAndEarn2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 0, n = nums.length, index = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            int number = nums[i], num = 1;
            boolean judge = i > 0 && nums[i] == nums[i - 1] + 1;
            while (i < n - 1 && nums[i + 1] == number) {
                num++;
                i++;
            }
            int x1 = index >= 2 ? dp[index - 2] : 0;
            int x2 = judge ? (index >= 3 ? dp[index - 3] : 0) : (index >= 1 ? dp[index - 1] : 0);
            dp[index++] = number * num + Math.max(x1, x2);
            result = Math.max(result, dp[index - 1]);
        }
        return result;
    }

}
