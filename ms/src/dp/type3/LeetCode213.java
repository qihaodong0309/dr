package dp.type3;

/**
 * @author qihaodong
 */
public class LeetCode213 {

    public static void main(String[] args) {
        LeetCode213 test = new LeetCode213();
        System.out.println(test.rob(new int[]{1, 2, 3, 4, 5, 6}));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int result = Math.max(nums[0], nums[1]), n = nums.length;
        int[] dpT = new int[n];
        int[] dpN = new int[n];
        dpT[0] = nums[0];
        dpN[0] = 0;
        dpT[1] = nums[0];
        dpN[1] = nums[1];
        for (int i = 2; i < n; ++i) {
            int xt = i >= 3 ? dpT[i - 3] : 0;
            dpT[i] = Math.max(dpT[i - 2], xt) + nums[i];
            int xn = i >= 3 ? dpN[i - 3] : 0;
            dpN[i] = Math.max(dpN[i - 2], xn) + nums[i];
            if (i == n - 1) {
                result = Math.max(result, dpN[i]);
            } else {
                result = Math.max(result, Math.max(dpT[i], dpN[i]));
            }
        }
        return result;
    }

}
