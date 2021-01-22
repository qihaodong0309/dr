package jzoffer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author qihaodong
 */
public class JzOffer3 {

    /**
     * 基于哈希表
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int i : nums) {
            if (set.contains(i)) {
                return i;
            }
            set.add(i);
        }
        return -1;
    }

    /**
     * 基于排序
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 基于下标(时间复杂度，空间复杂度最低)
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int result = nums[i];
            while (result != i) {
                int temp = nums[result];
                if (result == temp) {
                    return result;
                }
                nums[result] = nums[i];
                result = temp;
            }
        }
        return -1;
    }

}
