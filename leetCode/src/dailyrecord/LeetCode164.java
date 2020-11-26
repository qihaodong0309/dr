package dailyrecord;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class LeetCode164 {

    /**
     * 排序后计算法(题目原则上不允许)
     *
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(result, nums[i] - nums[i - 1]);
        }
        return result;
    }



}
