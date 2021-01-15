package collection.array;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class LeetCode217 {

    /**
     * 排序计算
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

}
