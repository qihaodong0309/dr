package dichotomy;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class LeetCode169 {

    /**
     * 数学方法
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 分治算法
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        return echo(nums, 0, nums.length - 1);
    }

    private int echo(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (right - left) / 2 + left;
        // 分别计算左边和右边的众数
        int leftVal = echo(nums, left, mid);
        int rightVal = echo(nums, mid + 1, right);
        if (leftVal == rightVal) {
            return leftVal;
        }
        int leftCount = getCount(nums, leftVal, left, mid);
        int rightCount = getCount(nums, rightVal, mid + 1, right);
        return leftCount > rightCount ? leftVal : rightVal;
    }

    private int getCount(int[] nums, int val, int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == val) {
                result++;
            }
        }
        return result;
    }

}
