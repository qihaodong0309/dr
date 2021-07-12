package dp;

/**
 * @author qihaodong
 */
public class LeetCode152 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        Integer max = nums[0] > 0 ? nums[0] : null;
        Integer min = nums[0] < 0 ? nums[0] : null;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > 0) {
                max = max == null ? nums[i] : max * nums[i];
                min = min == null ? null : min * nums[i];
                result = Math.max(result, max);
            } else if (nums[i] == 0) {
                max = min = null;
                result = Math.max(result, 0);
            } else {
                Integer temp = max;
                max = min == null ? null : min * nums[i];
                min = temp == null ? nums[i] : temp * nums[i];
                result = max == null ? result : Math.max(result, max);
            }
        }
        return result;
    }

}
