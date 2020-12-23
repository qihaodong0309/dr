package array;

/**
 * @author qihaodong
 */
public class LeetCode334 {

    /**
     * 满足题意做法
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int min = nums[0], mid = Integer.MIN_VALUE, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (mid == Integer.MIN_VALUE) {
                if (nums[i] > min) {
                    mid = nums[i];
                } else {
                    min = nums[i];
                }
            } else {
                if (nums[i] > mid) {
                    return true;
                } else if (nums[i] > min && nums[i] <= mid) {
                    mid = nums[i];
                } else {
                    min = nums[i];
                }
            }
        }
        return false;
    }

    /**
     * dp
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
