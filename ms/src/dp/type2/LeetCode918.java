package dp.type2;

/**
 * @author qihaodong
 */
public class LeetCode918 {

    /**
     * dp
     *
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0], temp = nums[0], n = nums.length;
        // 计算常规情况下最大值
        for (int i = 1; i < n; ++i) {
            temp = nums[i] + Math.max(temp, 0);
            result = Math.max(result, temp);
        }
        // 计算跨边界情况下最大值
        int[] sumR = new int[n];
        int[] dpR = new int[n];
        sumR[n - 1] = dpR[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            sumR[i] = sumR[i + 1] + nums[i];
            dpR[i] = Math.max(sumR[i], dpR[i + 1]);
        }
        temp = 0;
        // 比较
        for (int i = 0; i < n - 2; ++i) {
            temp += nums[i];
            result = Math.max(result, temp + dpR[i + 2]);
        }
        return result;
    }

}
