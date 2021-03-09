package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer57 {

    /**
     * 数学方法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int start = 0, end = nums.length - 1, temp = nums[start] + nums[end];
        while (target != temp) {
            if (temp > target) {
                end--;
            } else {
                start++;
            }
            temp = nums[start] + nums[end];
        }
        return new int[]{nums[start], nums[end]};
    }

}
