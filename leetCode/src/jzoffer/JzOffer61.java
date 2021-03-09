package jzoffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qihaodong
 */
public class JzOffer61 {

    /**
     * K神解法 (边界比较法)
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        int n = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                n++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[n] < 5;
    }

    /**
     * K神解法 (哈希表记录法)
     *
     * @param nums
     * @return
     */
    public boolean isStraight2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return max - min < 5;
    }

}
