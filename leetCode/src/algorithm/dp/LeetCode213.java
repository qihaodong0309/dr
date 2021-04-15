package algorithm.dp;

/**
 * @author qihaodong
 */
public class LeetCode213 {

    public static void main(String[] args) {
        LeetCode213 test = new LeetCode213();
        test.rob(new int[]{2, 2, 4, 3, 2, 5});
    }

    /**
     * dp，通过两次 dp，模拟满足题意的两种情况
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1));
        }
    }

    private int dp(int[] nums, int start, int end) {
        int left = nums[start], right = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = Math.max(right, left + nums[i]);
            left = right;
            right = temp;
        }
        return right;
    }


}
