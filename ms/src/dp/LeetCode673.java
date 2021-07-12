package dp;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class LeetCode673 {

    public static void main(String[] args) {
        LeetCode673 test = new LeetCode673();
        System.out.println(test.findNumberOfLIS(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}));
    }

    /**
     * dp
     *
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1, maxL = 1;
        int[] dpL = new int[nums.length];
        int[] dpN = new int[nums.length];
        dpN[0] = 1;
        Arrays.fill(dpL, 1);
        for (int i = 1; i < nums.length; ++i) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dpL[i] = Math.max(dpL[i], dpL[j] + 1);
                }
            }
            for (int j = i - 1; j >= 0; --j) {
                if (dpL[i] == dpL[j] + 1 && nums[i] > nums[j]) {
                    dpN[i] += dpN[j];
                }
            }
            dpN[i] = dpN[i] == 0 ? 1 : dpN[i];
            if (dpL[i] > maxL) {
                result = dpN[i];
            } else if (dpL[i] == maxL) {
                result += dpN[i];
            }
            maxL = Math.max(maxL, dpL[i]);
        }
        return result;
    }


}
